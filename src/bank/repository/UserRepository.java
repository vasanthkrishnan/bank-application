package bank.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bank.entity.User;

public class UserRepository {

    private static Set<User> users = new HashSet<>();
    
    static {
        User user1 = new User("admin", "admin", "9638527415", "admin", 0.0);
        User user2 = new User("user1", "user1", "9638548536", "user", 10000.0);
        User user3 = new User("user2", "user2", "9638512548", "user", 25100.0);

        users.add(user1);
        users.add(user2);
        users.add(user3);
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

}
