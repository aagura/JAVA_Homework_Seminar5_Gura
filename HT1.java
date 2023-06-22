
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HT1 {
//     Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, 
//что во входной структуре будут повторяющиеся имена с разными телефонами, 
//их необходимо считать, как одного человека с разными телефонами. 
//Вывод должен быть отсортирован по убыванию числа телефонов.
// Пример ввода:
// Иванов 234234
// Иванов 32523
// Иванов 5687
// Иванов: 234234, 32523, 5687

// Варианты Map:
// Map<String, ArrayList>
// Map<String, String>

// Пример меню:
// 1. Добавить контакт
// 2. Вывести всех
// 3. Выход
    private static Map<String, ArrayList<String>> contacts = new HashMap<>();

    private static void addContact(Scanner scanner) {
        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();

        if (contacts.containsKey(lastName)) {
            ArrayList<String> phoneNumbers = contacts.get(lastName);
            if (!phoneNumbers.contains(phoneNumber)) {
                phoneNumbers.add(phoneNumber);
                System.out.println("Номер телефона добавлен для существующей фамилии.");
            } else {
                System.out.println("Данный номер телефона уже существует в базе.");
            }
        } else {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            contacts.put(lastName, phoneNumbers);
            System.out.println("Контакт успешно добавлен.");
        }
    }

    private static void displayContacts() {
           contacts.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.print(entry.getKey() + ":");
                    ArrayList<String> phoneNumbers = entry.getValue();
                    for (int i = 0; i < phoneNumbers.size(); i++) {
                         System.out.print(phoneNumbers.get(i));
                        if (i < phoneNumbers.size() - 1) {
                        System.out.print(", ");
                    }
                        } 
                    System.out.println ();
                });
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in, "cp866");
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Вывести всех");
            System.out.println("3. Выход");
            System.out.print("Введите ваш выбор: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        } while (choice != 3);
    }

   
}

