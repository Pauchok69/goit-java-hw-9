package goit.hw_9_2;

import java.io.CharArrayReader;

public class UsersConverterTests {
    public static final String USERS_FILE_FROM = "./src/main/java/goit/hw_9_2/file.txt";
    public static final String USERS_FILE_TO = "./src/main/java/goit/hw_9_2/file.json";

    public static void main(String[] args) {
        new UsersConverter().convert(USERS_FILE_FROM, USERS_FILE_TO);
    }
}
