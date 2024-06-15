package files;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Napisz program w Javie, który umożliwi zarządzanie listą użytkowników.
        Program powinien spełniać następujące wymagania:
        1.Program powinien być napisany w pełni obiektowo z uwzględnieniem zasady pojedynczej odpowiedzialnościdla obiektów.
        2.Odpowiednie obiekty powinny implementować interfejs UserSerializerInterface,w którym zdefiniowane powinny być metody serializacji i deserializacji.
        3.Użytkownik powinien mieć następujące pola:•Imię•Nazwisko•Wiek•Adres e-mail
        4.Program powinien umożliwiać dodawanie nowych użytkowników do listy, usuwanie istniejących użytkowników oraz wyświetlanie całej listy.
        5.Użytkownik powinien mieć możliwość zapisu bieżącej listy użytkowników do pliku tekstowego csv rozdzielanego średnikami.
        6.Program powinien obsługiwać serializację i deserializację listy użytkowników do/z pliku binarnego.
        7.Program powinien obsługiwać serializację i deserializację listy użytkowników do/z pliku json.
        8.Program powinien obsługiwać serializację i deserializację listy użytkowników do/z pliku xml.
        9.Użytkownik powinien mieć możliwość wczytania listy użytkowników z pliku podczas uruchomienia programu, jeśli taka lista istnieje.
        10.Zapewnij walidację danych podczas dodawania użytkowników (np. nieprawidłowy wiek lub format adresu e-mail).
        */


        UsersRepository repository = new UsersRepository();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter JSON file name to load users (press Enter to skip): ");
        String fileName = scanner.nextLine();
        if (!fileName.isEmpty()) {
            repository.loadUsersFromFile(fileName);
        }

        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Remove user");
            System.out.println("3. Show all users");
            System.out.println("4. Serialize users");
            System.out.println("5. Deserialize users");
            System.out.println("6. Save users to CSV");
            System.out.println("7. Serialize users to binary file");
            System.out.println("8. Deserialize users from binary file");
            System.out.println("9. Serialize users to JSON file");
            System.out.println("10. Deserialize users from JSON file");
            System.out.println("11. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser(scanner, repository);
                    break;
                case 2:
                    removeUser(scanner, repository);
                    break;
                case 3:
                    repository.showAllUsers();
                    break;
                case 4:
                    serializeUsers(repository);
                    break;
                case 5:
                    deserializeUsers(scanner, repository);
                    break;
                case 6:
                    saveUsersToCSV(scanner, repository);
                    break;
                case 7:
                    serializeUsersToBinaryFile(scanner, repository);
                    break;
                case 8:
                    deserializeUsersFromBinaryFile(scanner, repository);
                    break;
                case 9:
                    serializeUsersToJsonFile(scanner, repository);
                    break;
                case 10:
                    deserializeUsersFromJsonFile(scanner, repository);
                    break;
                case 11:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addUser(Scanner scanner, UsersRepository repository) {
        while (true) {
            try {
                User newUser = new User();

                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                if (!isValidName(name)) {
                    throw new IllegalArgumentException("Invalid name format. Name must start with a capital letter and contain only letters (at least 3 characters).");
                }
                newUser.setName(name);

                System.out.print("Enter surname: ");
                String surname = scanner.nextLine();
                if (!isValidName(surname)) {
                    throw new IllegalArgumentException("Invalid surname format. Surname must start with a capital letter and contain only letters (at least 3 characters).");
                }
                newUser.setSurname(surname);

                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                if (age < 0 || age > 150) {
                    throw new IllegalArgumentException("Invalid age: Age must be between 0 and 150.");
                }
                newUser.setAge(age);
                scanner.nextLine();

                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                if (!isValidEmail(email)) {
                    throw new IllegalArgumentException("Invalid email address format.");
                }
                newUser.setEmailAddress(email);

                repository.addUser(newUser);
                System.out.println("User added successfully.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid value.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
    }

    private static boolean isValidName(String name) {
        return name.matches("[A-Z][a-zA-Z]{2,}");
    }

    private static boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }


    private static void removeUser(Scanner scanner, UsersRepository repository) {
        System.out.print("Enter email of user to remove: ");
        String email = scanner.nextLine();
        User userToRemove = repository.getUsers().stream()
                .filter(user -> user.getEmailAddress().equals(email))
                .findFirst()
                .orElse(null);
        if (userToRemove != null) {
            repository.removeUser(userToRemove);
            System.out.println("User removed.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void serializeUsers(UsersRepository repository) {
        String serializedData = repository.serializeUsers();
        System.out.println("Serialized data: " + serializedData);
    }

    private static void deserializeUsers(Scanner scanner, UsersRepository repository) {
        System.out.print("Enter serialized data: ");
        String data = scanner.nextLine();
        repository.deserializeUsers(data);
        System.out.println("Users deserialized.");
    }

    private static void saveUsersToCSV(Scanner scanner, UsersRepository repository) {
        System.out.print("Enter file name to save users (with .csv extension): ");
        String fileName = scanner.nextLine();
        repository.saveUsersToCSV(fileName);
        System.out.println("Users saved to file: " + fileName);
    }

    private static void serializeUsersToBinaryFile(Scanner scanner, UsersRepository repository) {
        System.out.print("Enter binary file name to save users: ");
        String fileName = scanner.nextLine();
        repository.serializeUsersToBinaryFile(fileName);
        System.out.println("Users serialized to binary file: " + fileName);
    }

    private static void deserializeUsersFromBinaryFile(Scanner scanner, UsersRepository repository) {
        System.out.print("Enter binary file name to load users: ");
        String fileName = scanner.nextLine();
        repository.deserializeUsersFromBinaryFile(fileName);
        System.out.println("Users deserialized from binary file: " + fileName);
    }

    private static void serializeUsersToJsonFile(Scanner scanner, UsersRepository repository) {
        System.out.print("Enter JSON file name to save users: ");
        String fileName = scanner.nextLine();
        repository.serializeUsersToJsonFile(fileName);
        System.out.println("Users serialized to JSON file: " + fileName);
    }

    private static void deserializeUsersFromJsonFile(Scanner scanner, UsersRepository repository) {
        System.out.print("Enter JSON file name to load users: ");
        String fileName = scanner.nextLine();
        repository.deserializeUsersFromJsonFile(fileName);
        System.out.println("Users deserialized from JSON file: " + fileName);
    }
}
