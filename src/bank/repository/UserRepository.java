package bank.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import bank.entity.Transaction;
import bank.entity.User;

public class UserRepository {

    private static Set<User> users = new HashSet<>();
    private static List<Transaction> transactions = new ArrayList<>();
    Map<String, Boolean> chequeBookRequest = new HashMap<>();
    
    static {
        User user1 = new User("admin", "admin", "9638527415", "admin", 0.0);
        User user2 = new User("user1", "user1", "9638548536", "user", 10000.0);
        User user3 = new User("user2", "user2", "9638512548", "user", 25100.0);

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public Map<String, Boolean> getAllChequeBookRequest() {
        return chequeBookRequest;
    }


    public void raiseChequeBookRequest(String userId) {
        chequeBookRequest.put(userId, false);
    }

    public boolean transferAmount(String userId, String payeeUserId, Double amount) {

        boolean isDebit = debit(userId, amount, payeeUserId);
        boolean isCredit = credit(payeeUserId, amount, userId);

        return isDebit && isCredit;
    }


    private boolean credit(String payeeUserId, Double amount, String userId) {
        User user = getUser(payeeUserId);
        Double accountBalance = user.getAccountBalance();

        users.remove(user);
        Double finalBalance = accountBalance + amount;
        user.setAccountBalance(finalBalance);

        Transaction transaction = new Transaction(
            LocalDate.now(), 
            userId, 
            amount, 
            "Credit",
            accountBalance, 
            finalBalance,
            payeeUserId);

            System.out.println(transaction);

            transactions.add(transaction);

        return users.add(user);
    }

    private boolean debit(String userId, Double amount, String payeeUserId) {
        User user = getUser(userId);
        Double accountBalance = user.getAccountBalance();
        users.remove(user);

        Double finalBalance = accountBalance - amount;
        user.setAccountBalance(finalBalance);

        Transaction transaction = new Transaction(
            LocalDate.now(), 
            payeeUserId, 
            amount, 
            "Debit",
            accountBalance, 
            finalBalance,
            userId);

            System.out.println(transaction);

            transactions.add(transaction);
        return users.add(user);
    }

    public void printTransactions(String userId) {
        List<Transaction> filteredTransactions = transactions.stream().filter(transaction -> transaction.getTransactionPerformedBy().equals(userId)).collect(Collectors.toList());

        System.out.println("Date \t\t User Id \t Amount \t Type \t Initial Balance \t Final Balance");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for(Transaction t : filteredTransactions) {
            System.out.println(t.getTransactionDate()
                + "\t" + t.getTransactionUserId()
                + "\t\t" + t.getTransactionAmount()
                + "\t\t" + t.getTransactionType()
                + "\t\t" + t.getInitialBalance()
                + "\t\t" + t.getFinlaBalance()
            );
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }


    public User getUser(String userId) {
        List<User> result = users.stream().filter(user -> user.getUsername().equals(userId)).collect(Collectors.toList());
        if(!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public Double checkBankBalance(String userID)
    {
        List<User> result = users.stream().filter(user -> user.getUsername().equals(userID)).collect(Collectors.toList());
        if(!result.isEmpty())
        {
            return result.get(0).getAccountBalance();
        } else {
            return null;
        }
    }

    public User login(String username, String password) {
        List<User> finalList = users.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).collect(Collectors.toList());
        if(!finalList.isEmpty()) {
            return finalList.get(0);
        } else {
            return null;
        }
    }


    public void printUsers() {
        System.out.println(users);
    }

    public boolean addNewCustomer(String username, String password, String contactNumber)
    {
        User user = new User(username, password, contactNumber, "user", 500.0);
        return users.add(user);
    }

}
