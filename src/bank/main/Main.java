package bank.main;

import java.util.Scanner;

import bank.entity.User;
import bank.service.UserService;

public class Main {

    private static Scanner input = new Scanner(System.in);
    static Main main = new Main();
    static UserService userService = new UserService();

    public static void main(String[] args) {
        

        while (true) {
            System.out.println("Enter your username: ");
            String username = input.next();
            System.out.println("Enter your password");
            String password = input.next();
    
            User user = userService.login(username, password);
            if(user != null && user.getRole().equals("admin")) {
                    main.initAdmin();
            } else if(user != null && user.getRole().equals("user")) {
                    main.initCustomer(user);
            } else {
                System.out.println("Loggin failed");
            }
        }


        // userService.printUsers();
    }
    private void initAdmin() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Exit/Logout");
            System.out.println("2. Add Customer");

            int selectedOption = input.nextInt();
            switch (selectedOption) {
                case 1:
                    flag = false;
                    System.out.println("Logged out successfully...");
                    break;
                case 2:
                    main.addNewCustomer();
                    break;
            
                default:
                    System.out.println("Default");
                    break;
            }
        }
    }

    private void addNewCustomer() {
        System.out.println("Enter username: ");
        String username = input.next();

        System.out.println("Enter password: ");
        String password = input.next();

        System.out.println("Enter Contact Number");
        String contactNumber = input.next();

        boolean result = userService.addNewCustomer(username, password, contactNumber);

        if(result) {
            System.out.println("Customer Account is Created...");
        } else {
            System.out.println("Customer Account Creation Failed...");
        }

    }

    private void initCustomer(User user) {
        boolean flag = true;
        
        while (flag) {
            System.out.println("1. Exit/Logout");
            System.out.println("2. Check Bank Balance");

            int selectedOption = input.nextInt();

            switch (selectedOption) {
                case 1:
                    flag = false;
                    System.out.println("Logged out Succesfully...");
                    break;
                case 2:
                    Double balance = main.checkBankBalance(user.getUsername());
                    if(balance != null) {
                        System.out.println("Your Bank balance is : " + balance);
                    } else {
                        System.out.println("Check your username");
                    }
                    break;
                default:
                    System.out.println("Default");
                    break;
            }
        }
    }
    public Double checkBankBalance(String userID)
    {
        return userService.checkBankBalance(userID);
    }

}
