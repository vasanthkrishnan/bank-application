package bank.service;

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
}
