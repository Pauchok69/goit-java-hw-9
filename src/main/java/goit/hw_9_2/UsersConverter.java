package goit.hw_9_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UsersConverter {
    public void convert(String fileFrom, String fileTo) {
        File usersFileFrom = new File(fileFrom);

        if (!usersFileFrom.exists()) {
            System.out.println("File: " + fileFrom + " doesn't exist!!!");

            return;
        }

        ArrayList<User> users = getUsersFrom(usersFileFrom);
        writeUsersToJsonFile(users, fileTo);
    }

    private ArrayList<User> getUsersFrom(File usersFileFrom) {
        ArrayList<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(usersFileFrom))) {
            boolean isHead = true;

            while (scanner.hasNext()) {
                if (isHead) {
                    scanner.nextLine();
                    isHead = false;

                    continue;
                }

                users.add(createUserFromLine(scanner.nextLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    private User createUserFromLine(String nextLine) {
        String[] strings = nextLine.split(" ");

        return new User(strings[0], Integer.parseInt(strings[1]));
    }

    private void writeUsersToJsonFile(ArrayList<User> users, String fileTo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);


        try (FileWriter fileWriter = new FileWriter(fileTo);) {
            fileWriter.write(json);
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
