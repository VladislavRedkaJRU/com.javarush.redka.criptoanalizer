import java.util.Scanner;

public class Caesar {

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static String encrypt(String text, int key) {
        String encryptedText = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = findCharIndex(c);
            if (index != -1) {
                int newIndex = (index + key) % ALPHABET.length;
                encryptedText += ALPHABET[newIndex];
            } else {
                encryptedText += c;
            }
        }
        return encryptedText;
    }

    public static String decryptWithKey(String text, int key) {
        String decryptedText = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = findCharIndex(c);
            if (index != -1) {
                int newIndex = (index - key + ALPHABET.length) % ALPHABET.length;
                decryptedText += ALPHABET[newIndex];
            } else {
                decryptedText += c;
            }
        }
        return decryptedText;
    }

    public static void bruteForce(String text) {
        System.out.println("Перебор вариантов:");
        for (int key = 1; key < ALPHABET.length; key++) {
            System.out.println("Ключ " + key + ": " + decryptWithKey(text, key));
        }
    }

    private static int findCharIndex(char c) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Шифровать текст");
            System.out.println("2. Расшифровать текст");
            System.out.println("3. Перебор всех ключей");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Введите текст: ");
                String text = scanner.nextLine();
                System.out.print("Введите ключ: ");
                int key = scanner.nextInt();
                System.out.println("Зашифрованный текст: " + encrypt(text, key));
            } else if (choice == 2) {
                System.out.print("Введите зашифрованный текст: ");
                String text = scanner.nextLine();
                System.out.print("Введите ключ: ");
                int key = scanner.nextInt();
                System.out.println("Расшифрованный текст: " + decryptWithKey(text, key));
            } else if (choice == 3) {
                System.out.print("Введите зашифрованный текст: ");
                String text = scanner.nextLine();
                bruteForce(text);
            } else if (choice == 4) {
                System.out.println("Выход...");
                break;
            } else {
                System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
        scanner.close();
    }
}

