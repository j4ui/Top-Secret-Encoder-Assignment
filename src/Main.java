import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        encryptionDecryptionMenu();
    }

    public static void encryptionDecryptionMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Top Secret Word Encrypt / Decrypt\nEnter an option:\n(1) Encrypt\n(2) Decrypt\n(0) Exit\nOption: ");
            option = scanner.nextInt();
            switch (option) {
                case 1: encryptWord(); break;
                case 2: decryptWord(); break;
                case 0: return;
            }
        } while (option != 0);
    }

    public static int determineShiftIndex(String key) {
        int shiftIndex = 0;
        for (int i = 0; i < key.length(); i++) {
            shiftIndex += key.charAt(i)-96;
        }
        return shiftIndex;
    }

    public static void encryptWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an unencrypted word: ");
        String word = scanner.nextLine();
        System.out.println("Enter an encryption key");
        String key = scanner.nextLine();
        int shiftIndex = determineShiftIndex(key);
        String encryptedWord = "";
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 96;
            int newCharIndex = charIndex + shiftIndex;
            if (newCharIndex > 26) {
                newCharIndex = newCharIndex % 26;
            }
            encryptedWord += (char) (newCharIndex + 96);
        }
        System.out.println("\nEncoded word: " + encryptedWord);

    }

    public static void decryptWord() {
        Scanner scanner = new Scanner(System.in);
        String word, key;
        String decryptedWord = "";
        System.out.println("Enter an encrypted word: ");
        word = scanner.nextLine();
        System.out.println("Enter an encryption key: ");
        key = scanner.nextLine();
        int shiftIndex = determineShiftIndex(key);
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 96;
            int newCharIndex = charIndex - shiftIndex;
            if (newCharIndex < 1) {
                newCharIndex = newCharIndex + 26;
            }
            decryptedWord += (char) (newCharIndex + 96);
        }
        System.out.println("\nDecoded word: " + decryptedWord);
    }
}
