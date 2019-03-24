package com.example.hackathon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserManager {

    public static ArrayList<User> userAccounts;

    public UserManager(){
        userAccounts = new ArrayList<>();
        userFromFile();
        addManager();
    }

    public static void addManager(){
        addUserAccount(new User("admin", "admin", "admin@admin"));
    }
    /**
     * Reads users from a file and adds them to userAccounts list.
     * Format of: username, password
     */
    public static void userToFile() {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("./users.txt"));
            for (User userAccount : userAccounts) {
                String password = userAccount.getPassword();
                String username = userAccount.getUsername();
                String email = userAccount.getEmail();
                file.write(username + "," + password + "," + email);
                file.newLine();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads in the list of user accounts from a file.
     * Format of: email, password
     */
    public static void userFromFile() {
        userAccounts = new ArrayList<>();
        addManager();
        if (new File("./users.txt").exists()) {
            try {
                String line;
                BufferedReader file = new BufferedReader(new FileReader("./users.txt"));
                while ((line = file.readLine()) != null) {
                    String[] info = line.split(",");
                    addUserAccount(new User(info[0], info[1], info[2]));
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addUserAccount(User user){
        userAccounts.add(user);
        userToFile();
    }

    public static boolean signUp(String username, String password, String email){
        for(User user : userAccounts){
            if(email.equals(user.getUsername())){
                return false;
            }
        }
        userAccounts.add(new User(username, password, email));
        userToFile();
        return true;
    }

    public static User login(String username, String password){
        for(User us : userAccounts){
            if(us.getUsername().equals(username) && us.getPassword().equals(password)){
                return us;
            }
        }
        return null;
    }

    public static boolean usernameAvailable(String username){
        for(User user : userAccounts){
            if(user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }

    public static boolean emailAvailable(String email){
        for(User user : userAccounts){
            if(user.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }
}
