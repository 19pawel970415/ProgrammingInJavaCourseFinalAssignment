package generics;

import java.util.ArrayList;
import java.util.List;

public class MainExercise4 {

    //Czy następująca metoda zostanie skompilowana? Jeśli nie, to dlaczego? (Uruchom
    //poniższy kod żeby sprawdzić).

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<Number>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        print(numbers);
    }

    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    //Tak, zostanie skompilowana.
}
