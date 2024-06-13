package collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Zadanie 1:
        //Napisz program, który będzie pobierał od użytkownika imiona. Program powinien pozwolić
        //użytkownikowi na wprowadzenie dowolnej liczby imion (wprowadzenie „-” jako imienia przerwie
        //wprowadzanie). Na zakończenie wypisz imiona.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Exercise I");

        ArrayList<String> names = new ArrayList<>();

        String name = "";
        do {

            System.out.println("Enter a name or \"-\" if you want to exit the program:");
            name = scanner.nextLine();
            if (name.equals("-")) {
                break;
            } else {
                names.add(name);
            }
        } while (true);

        System.out.println("The names you entered are:");
        for (String n : names) {
            System.out.println(n);
        }


        //Zadanie 2:
        //Napisz program, który będzie pobierał od użytkownika imiona. Program powinien pozwolić
        //użytkownikowi na wprowadzenie dowolnej liczby imion (wprowadzenie „-” jako imienia przerwie
        //wprowadzanie). Imiona powinny być unikatowe i zostać wypisane w kolejności alfabetycznej.

        System.out.println("");
        System.out.println("Exercise II");

        TreeSet<String> uniqueNamesInAlphabeticalOrder = new TreeSet<>();

        do {

            System.out.println("Enter a name or \"-\" if you want to exit the program:");
            name = scanner.nextLine();
            if (name.equals("-")) {
                break;
            } else {
                uniqueNamesInAlphabeticalOrder.add(name);
            }
        } while (true);

        System.out.println("The unique names you entered are:");
        for (String n : uniqueNamesInAlphabeticalOrder) {
            System.out.println(n);
        }

        //Zadanie 3:
        //Lotto. Pobierz od użytkownika 6 liczb unikatowych z przedziału <1, 49>. Następnie zapytaj ile gier
        //użytkownik chce rozegrać. Dla każdej gry wylosuj 6 unikatowych liczb z przedziału <1, 49>. Wypisz
        //listę wygrywających gier wraz z liczbami i określeniem stopnia wygranej (3-6).

        System.out.println("");
        System.out.println("Exercise III");

        LinkedHashSet<Integer> playersNumbers = new LinkedHashSet<>();

        while (playersNumbers.size() < 6) {

            System.out.println("Enter a unique number between 1 and 49:");
            if (scanner.hasNextInt()) {
                Integer enteredNumber = scanner.nextInt();
                scanner.nextLine();
                if (playersNumbers.contains(enteredNumber)) {
                    System.out.println("Enter a unique number!!!");
                } else {
                    if (!(enteredNumber < 1 || enteredNumber > 49)) {
                        playersNumbers.add(enteredNumber);
                    } else {
                        System.out.println("The number is out of range!!!");
                    }
                }
            } else {
                System.out.println("Enter a number!!!");
                scanner.nextLine();
            }
        }

        int theNumberOfGames = 0;
        while (true) {
            System.out.println("How many games do you want to take part in?");
            if (scanner.hasNextInt()) {
                theNumberOfGames = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Enter a number!!!");
                scanner.nextLine();
            }
        }

        LinkedHashSet<Integer> randomNumbers = new LinkedHashSet<>();

        while (randomNumbers.size() != (theNumberOfGames * 6)) {
            int random = (int) (Math.random() * 49 + 1);
            randomNumbers.add(random);
        }

        System.out.println("Your numbers: ");
        for (Integer playersNumber : playersNumbers) {
            System.out.print(playersNumber + " ");
        }

        System.out.println();
        int counter = 0;
        int theWinning = 0;
        HashSet<Integer> theGamesNumbers = new HashSet<>();
        System.out.println("The drawn numbers: ");
        for (Integer randomNumber : randomNumbers) {
            System.out.print(randomNumber + " ");
            theGamesNumbers.add(randomNumber);
            counter++;
            if (counter % 6 == 0) {
                for (Integer theGamesNumber : theGamesNumbers) {
                    if (playersNumbers.contains(theGamesNumber)) {
                        theWinning++;
                    }
                }
                System.out.print("You win " + theWinning);
                theWinning = 0;
                theGamesNumbers.clear();
                System.out.println();
            }
        }

        scanner.close();
    }
}
