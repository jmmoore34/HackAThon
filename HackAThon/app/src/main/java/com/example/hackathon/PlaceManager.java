package com.example.hackathon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlaceManager {

    ArrayList<Place> places;

    public PlaceManager(){
        //placesToFile();
    }
//    /**
//     * Reads users from a file and adds them to userAccounts list.
//     * Format of: username, password
//     */
//    public void placesToFile() {
//        try {
//            BufferedWriter file = new BufferedWriter(new FileWriter("./places.txt"));
//            for (User userAccount : userAccounts) {
//                String password = userAccount.getPassword();
//                String username = userAccount.getUsername();
//                file.write(username + "," + password);
//                file.newLine();
//            }
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    /**
//     * Reads in the list of user accounts from a file.
//     * Format of: email, password
//     */
//    private void userFromFile() {
//        if (new File("./places.txt").exists()) {
//            try {
//                String line;
//                BufferedReader file = new BufferedReader(new FileReader("./users.txt"));
//                while ((line = file.readLine()) != null) {
//                    String[] info = line.split(",");
//                    addUserAccount(new User(info[0], info[1]));
//                }
//                file.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
