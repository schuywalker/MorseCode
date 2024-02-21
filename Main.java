import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            interactive_mode();
        } else if (args[0].equalsIgnoreCase("encode")) {
            try {
                encode_mode(args[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please include filepath as second command line argument.\n"+e.getMessage());
            }
        } else if (args[0].equalsIgnoreCase("decode")) {
            try {
                decode_mode(args[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please include filepath as second command line argument.\n"+e.getMessage());
            }
        } else if (args[0].equalsIgnoreCase("test")) {
            try {
                test_mode(args[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please include filepath as second command line argument.\n"+e.getMessage());
            }
        }

    }

    public static void interactive_mode() {
        Scanner sc = new Scanner(System.in);
        String mode = "";
        String userInput = "";
        System.out.println("Welcome to the interactive mode MorseCode.java. Please see the readme for instructions.");
        System.out.println("\nMODE SELECTION: please choose from the following 5 options. \nEnter 'ENCODE' to encode an input, \n'DECODE' to decode an input, \n'QUIT' to quit the program");
        while (!(mode = sc.nextLine()).equalsIgnoreCase("QUIT")) {
            switch (mode.toUpperCase().trim()) {
                case "ENCODE":
                    System.out.println("Enter text to be encoded: ");
                    userInput = sc.nextLine();
                    String morseCode = MorseCodeLibrary.encode(userInput);
                    System.out.println(morseCode);
                    System.out.println("\nMODE SELECTION: please choose from the following 3 options. \nEnter 'ENCODE' to encode an input, \n'DECODE' to decode an input, \n'QUIT' to quit the program");
                    break;
                case "DECODE":
                    System.out.println("Enter text to be decoded: ");
                    userInput = sc.nextLine();
                    String plainText = MorseCodeLibrary.decode(userInput);
                    System.out.println(plainText);
                    System.out.println(plainText);
                    if (!MorseCodeLibrary.decode(plainText).equals(userInput)) {
                        System.out.println("decoder has been broken");
                    }
                    System.out.println("\nMODE SELECTION: please choose from the following 3 options. \nEnter 'ENCODE' to encode an input, \n'DECODE' to decode an input, \n'QUIT' to quit the program");
                    break;
                default:
                    sc.close();
                    System.exit(0);
            }
        }
    }

    public static void encode_mode(String filePath) {
        String sanitized_input = HelperMethods.get_sanitized_input(filePath);
        System.out.println(MorseCodeLibrary.encode(sanitized_input));
    }

    public static void decode_mode(String filePath) {
        String morseCodeInput = HelperMethods.get_sanitized_input(filePath);
        System.out.println(MorseCodeLibrary.decode(morseCodeInput));
    }

    public static void test_mode(String filePath) {
        String sanitized_input = HelperMethods.get_sanitized_input(filePath);
        String morseCode = MorseCodeLibrary.encode(sanitized_input);
        System.out.println(morseCode);
        String decodedText = MorseCodeLibrary.decode(morseCode);
        System.out.println("\noutput   :"+sanitized_input.toUpperCase());
        System.out.println("\noriginal :"+decodedText);
        if (morseCode.contains("%")) {
            System.out.println("\nValidity of encoding cannot be verified due to non-alphanumeric characters in file\n");
        } else if (!decodedText.equalsIgnoreCase(sanitized_input)) {
            System.out.println("\nProgram may have been broken. Decoded text was not equal to input\n");
            System.out.println("\ninput length "+sanitized_input.length() + ", decoded message length " + decodedText.length());
        } else {
            System.out.println("\nTranslation is believed to be successful\n");
        }
    }
}