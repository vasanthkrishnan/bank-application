package bank.main;

import java.util.Map;
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
        String userId;

        while (flag) {
            System.out.println("1. Exit/Logout");
            System.out.println("2. Add Customer");
            System.out.println("3. Customer Transactions");
            System.out.println("Check Bank Balance");

            int selectedOption = input.nextInt();
            switch (selectedOption) {
                case 1:
                    flag = false;
                    System.out.println("Logged out successfully...");
                    break;
                case 2:
                    main.addNewCustomer();
                    break;
                case 3:
                    System.out.println("Enter user ID: ");
                    userId = input.next();
                    main.printTransactions(userId);
                    break;
                case 4:
                    System.out.println("Enter user ID: ");
                    userId = input.next();
                    Double balance = main.checkBankBalance(userId);
                    System.out.println("Bank Balance : " + balance);
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
            System.out.println("3. Fund Transfer");
            System.out.println("4. Transaction History");
            System.out.println("5. Raise Cheque Book Request");

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
                case 3:
                    main.fundTransfer(user);
                    break;
                case 4:
                    main.printTransactions(user.getUsername());
                    break;
                case 5:
                    String userId = user.getUsername();
                    Map<String, Boolean> map = main.getAllChequeBookRequest();
                    if(map.containsKey(userId) && map.get(userId)) {
                        System.out.println("You have already raised a request and it is already approved");
                    } else if(map.containsKey(userId) && !map.get(userId)) {
                        System.out.println("You have already raised a request and it is pending for approval");
                    } else {
                        raiseChequeBookRequest(userId);
                        System.out.println("Request raised successfully...");
                    }
                    break;
                default:
                    System.out.println("Default");
                    break;
            }
        }
    }

    private  Map<String, Boolean> getAllChequeBookRequest() {
        return userService.getAllChequeBookRequest();
    }
    private void raiseChequeBookRequest(String userId) {
        userService.raiseChequeBookRequest(userId);
    }


    private void printTransactions(String userId) {
        userService.printTransactions(userId);
    }

    private void fundTransfer(User userDetails) {

        System.out.println("Enter payee Account userId");
        String payeeAccountId = input.next();

        User user = getUser(payeeAccountId);

        if(user != null) {
            System.out.println("Enter amount to transfer");
            Double amount = input.nextDouble();

            Double userAccountBalance = checkBankBalance(userDetails.getUsername());

            if(userAccountBalance >= amount) {
                boolean result = userService.transferAmount(userDetails.getUsername(), payeeAccountId, amount);
                if(result) {
                    System.out.println("Amount transfered successfully...");
                } else {
                    System.out.println("Transaction failed...");
                }


            } else {
                System.out.println("Your balance is insufficient " + userAccountBalance);
            }
        
        
        } else {
            System.out.println("Please enter valid username...");
        }
    }

    private User getUser( String userId) {
        return userService.getUser(userId);
    }

    public Double checkBankBalance(String userID)
    {
        return userService.checkBankBalance(userID);
    }

}
