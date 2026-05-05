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
            char c = key.charAt(i);
            shiftIndex += (c - 'a' + 1);
        }
        return shiftIndex;
    }

    public static void encryptWord() {
        Scanner scanner = new Scanner(System.in);
        String word = getWord(false);
        String key = getEncryptionKey();
        int shiftIndex = determineShiftIndex(key);
        String encryptedWord = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int charIndex = c - 'a' + 1;
            int newCharIndex = ((charIndex - (shiftIndex % 26) - 1 + 26) % 26) + 1;
            encryptedWord += (char) (newCharIndex - 1 + 'a');
        }
        System.out.println("\nEncoded word: " + encryptedWord);
    }

    public static void decryptWord() {
        // TODO: fix
        Scanner scanner = new Scanner(System.in);
        String word = getWord(true);
        String key = getEncryptionKey();
        int shiftIndex = determineShiftIndex(key);
        String decryptedWord = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int charIndex = c - 'a' + 1;
            int newCharIndex = (charIndex + shiftIndex - 1) % 26 + 1;
            decryptedWord += (char) (newCharIndex - 1 + 'a');
        }
        System.out.println("\nDecoded word: " + decryptedWord);
    }

    public static String getEncryptionKey() {
        Scanner scanner = new Scanner(System.in);
        String key;
        do {
            System.out.println("Enter an encryption key: ");
            key = scanner.nextLine();
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (c < 'a' || c > 'z') {
                    System.out.println("Invalid string. Please enter only lowercase letters.");
                    key = null;
                    break;
                }
            }
        } while (key == null);
        return key;
    }

    public static String getWord(Boolean isEncrypted) {
        Scanner scanner = new Scanner(System.in);
        String word;
        do {
            if (isEncrypted) {
                System.out.println("Enter an encrypted word: ");
            } else {
                System.out.println("Enter an unencrypted word: ");
            }
            word = scanner.nextLine();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c < 'a' || c > 'z') {
                    System.out.println("Invalid string. Please enter only lowercase letters.");
                    word = null;
                    break;
                }
            }
        } while (word == null);
        return word;
    }
}