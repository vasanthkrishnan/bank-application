package bank.entity;

public class User {

    private String username;
    private String password;
    private String contactNumber;
    private String role;
    private Double accountBalance;

    public User(String username, String password, String contactNumber, String role, Double accountBalance) {
        this.username = username;
        this.password = password;
        this.contactNumber = contactNumber;
        this.role = role;
        this.accountBalance = accountBalance;

    }
   
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getContactNumber() {
        return contactNumber;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public Double getAccountBalance() {
        return accountBalance;
    }

    public String toString() {
        return "Users{" + "Username: " + username + " " + 
                        "Password: " + password + " " +
                        "contactNumber: " + contactNumber + " " +
                        "Role: " + role + " " + 
                        "Account Balance: " + accountBalance + "}";
    }

    public boolean equals(Object o) {
        if(this == o) 
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        if(username != null ? !username.equals(user.username) : user.username != null)
            return false;
        if(password != null ? !password.equals(user.password) : user.password != null)
            return false;
        return contactNumber != null ? !contactNumber.equals(user.contactNumber) : user.contactNumber == null;
    }

}
