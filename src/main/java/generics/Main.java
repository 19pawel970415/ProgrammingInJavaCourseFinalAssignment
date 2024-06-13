package generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main<T> {

    public static void main(String[] args) {

        //1. Napisz metodę generyczną wymiany pozycji dwóch różnych elementów w dowolnej
        //tablicy (dla podanych pozycji).

        System.out.println("Exercise I");

        String[] strings = new String[5];
        Integer[] ints = new Integer[6];
        Double[] doubles = new Double[7];

        strings[0] = "Alice";
        strings[1] = "Bob";
        strings[2] = "Charlie";
        strings[3] = "Diana";
        strings[4] = "Eve";

        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        ints[3] = 4;
        ints[4] = 5;
        ints[5] = 6;

        doubles[0] = 1.1;
        doubles[1] = 2.2;
        doubles[2] = 3.3;
        doubles[3] = 4.4;
        doubles[4] = 5.5;
        doubles[5] = 6.6;
        doubles[6] = 7.7;

        try {
            String[] strings1 = swapElementsPositions(strings, 2, 3);
            Integer[] int1 = swapElementsPositions(ints, 1, 5);
            Double[] doubles1 = swapElementsPositions(doubles, 4, 6);
            for (String s : strings1) {
                System.out.println(s);
            }

            for (Integer integer : int1) {
                System.out.println(integer);
            }

            for (Double aDouble : doubles1) {
                System.out.println(aDouble);
            }
        } catch (IndexOutOfBoundsException ioobe) {
            System.err.println(ioobe);
        }

        //2. Napisz metodę generyczną, aby znaleźć maksymalny element w zakresie listy
        //numerycznej

        System.out.println();
        System.out.println("Exercise II");

        List<Integer> integersList = new ArrayList<>();
        integersList.add(1);
        integersList.add(-1);
        integersList.add(-50);
        integersList.add(30);
        integersList.add(142);
        integersList.add(44);

        List<Long> longsList = new ArrayList<>();
        longsList.add(100L);
        longsList.add(200L);
        longsList.add(300L);
        longsList.add(400L);
        longsList.add(500L);
        longsList.add(600L);

        List<Double> doublesList = new ArrayList<>();
        doublesList.add(1.1);
        doublesList.add(2.2);
        doublesList.add(3.3);
        doublesList.add(4.4);
        doublesList.add(5.5);
        doublesList.add(6.6);

        List<Float> floatsList = new ArrayList<>();
        floatsList.add(1.0f);
        floatsList.add(2.0f);
        floatsList.add(3.0f);
        floatsList.add(4.0f);
        floatsList.add(5.0f);
        floatsList.add(6.0f);

        List<Short> shortsList = new ArrayList<Short>();

        Integer maxInt = findMaxElement(integersList);
        System.out.println("Max integer: " + maxInt);

        Long maxLong = findMaxElement(longsList);
        System.out.println("Max long: " + maxLong);

        Double maxDouble = findMaxElement(doublesList);
        System.out.println("Max double: " + maxDouble);

        Float maxFloat = findMaxElement(floatsList);
        System.out.println("Max float: " + maxFloat);

        Short maxShort = findMaxElement(shortsList);
        System.out.println(maxShort);
    }

    static <T> T[] swapElementsPositions(T[] elements, int elementOneToSwapPosition, int elementTwoToSwapPosition) throws IndexOutOfBoundsException {

        if (elementOneToSwapPosition >= 0 && elementTwoToSwapPosition >= 0 && elementOneToSwapPosition < elements.length && elementTwoToSwapPosition < elements.length) {
            T temp = elements[elementOneToSwapPosition];
            elements[elementOneToSwapPosition] = elements[elementTwoToSwapPosition];
            elements[elementTwoToSwapPosition] = temp;
        } else {
            System.out.println("One of the given positions is incorrect");
            throw new IndexOutOfBoundsException();
        }
        return elements;
    }

    static <T extends Comparable<? super T>> T findMaxElement(List<T> elements) {
        Optional<T> max = elements.stream().max(Comparator.<T>naturalOrder());
        if (max.isEmpty()) {
            System.out.println("It is an empty list");
            return null;
        } else {
            T t = max.get();
            return t;
        }
    }
}
