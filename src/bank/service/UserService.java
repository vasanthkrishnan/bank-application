package bank.service;

import java.util.Map;

import bank.entity.User;
import bank.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public void printUsers() {
        userRepository.printUsers();
    }

    public User login(String username, String password) {
        return userRepository.login(username, password);
    }

    public boolean addNewCustomer(String username, String password, String contactNumber)
    {
        return userRepository.addNewCustomer(username, password, contactNumber);
    }

    public Double checkBankBalance(String userID) {
        return userRepository.checkBankBalance(userID);
    }

    public User getUser(String userId) {
        return userRepository.getUser(userId);
    }

    public boolean transferAmount(String userId, String payeeUserId, Double amount) {
        return userRepository.transferAmount(userId, payeeUserId, amount);
    }


    public void printTransactions(String userId) {
        userRepository.printTransactions(userId);
    }

    public void raiseChequeBookRequest(String userId) {
        userRepository.raiseChequeBookRequest(userId);
    }

    public Map<String, Boolean> getAllChequeBookRequest() {
        return userRepository.getAllChequeBookRequest();
    }
}
