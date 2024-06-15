package GuessGame;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Gra w zgadywanie liczby:Stwórz prostą grę, w której program losuje
        //liczbęcałkowitąz zakresu od 1 do 100, a użytkownik musi zgadywać tę liczbę.
        //Program powinien dawać podpowiedzi (większa/mniejsza), aż użytkownik zgadnie wylosowaną liczbę.

        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

        int guess;
        int attempts = 0;

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            }
        } while (guess != secretNumber);

        System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
        scanner.close();

    }

}
