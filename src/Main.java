import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an unencrypted word; ");
        String unencryptedWord = scanner.nextLine();
        System.out.println("Enter an encryption key; ");
        String encryptionKey = scanner.nextLine();
        int shiftIndex = determineShiftIndex(encryptionKey);
        System.out.println(shiftIndex);
        System.out.println(encryptWord(unencryptedWord, shiftIndex));
    }
    public static int determineShiftIndex(String key) {
        int shiftIndex = 0;
        for (int i = 0; i < key.length(); i++) {
            shiftIndex += key.charAt(i)-96;
        }
        return shiftIndex;
    }

    public static String encryptWord(String word, int shiftIndex) {
        String encryptedWord = "";
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 96;
            int newCharIndex = charIndex + shiftIndex;
            if (newCharIndex > 26) {
                newCharIndex = newCharIndex % 26;
            }
            encryptedWord += (char) (newCharIndex + 96);
        }
        return encryptedWord;
    }
}
