import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HelperMethods {
    public static String get_sanitized_input(String filePath) {
        File file = new File(filePath);
        String sanitized_input = "";
        try {
            Scanner sc = new Scanner(file);
            StringBuilder raw_input = new StringBuilder();
            while (sc.hasNextLine()) {
                raw_input.append(sc.nextLine().trim());
            }
            sanitized_input = raw_input.toString();
            sanitized_input = sanitized_input.replace("\r", "").replace("\n", "").replace("\0", "");
            sc.close();
        } catch (IOException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return sanitized_input;
    }
}

/*
to do:
readme
cleanup
repo
email
 */