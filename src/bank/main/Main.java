package bank.main;

import java.util.Scanner;

import bank.entity.User;
import bank.service.UserService;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        UserService userService = new UserService();

        System.out.println("Enter your username: ");
        String username = input.nextLine();
        System.out.println("Enter your password");
        String password = input.nextLine();


        User user = userService.login(username, password);
        if(user != null) {
            System.out.println("You logged in successfully !");
        } else {
            System.out.println("Loggin failed");
        }

        // userService.printUsers();

    }
}
