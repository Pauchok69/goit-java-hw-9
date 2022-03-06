package goit.hw_9_1;

public class PhoneNumbersPrinterTests {
    private static final String PHONE_NUMBERS_FILE = "./src/main/java/goit/hw_9_1/file.txt";

    public static void main(String[] args) {
        new PhoneNumbersPrinter().print(PHONE_NUMBERS_FILE);
    }
}
