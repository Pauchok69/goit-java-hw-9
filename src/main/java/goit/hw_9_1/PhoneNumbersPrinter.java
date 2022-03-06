package goit.hw_9_1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumbersPrinter {
    public void print(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File: " + fileName + " doesn't exist! Please chose another file.");

            return;
        }
        getValidPhoneNumbersFrom(file).forEach(System.out::println);
    }

    private ArrayList<String> getValidPhoneNumbersFrom(File file) {
        ArrayList<String> validPhoneNumbersList = new ArrayList<>();

        try (FileReader reader = new FileReader(file)) {
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (isValidPhoneNumber(line)) {
                    validPhoneNumbersList.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return validPhoneNumbersList;
    }

    private boolean isValidPhoneNumber(String string) {
        return string.matches("^(([0-9]{3}-)|(\\([0-9]{3}\\) ))[0-9]{3}-[0-9]{4}$");
    }
}
