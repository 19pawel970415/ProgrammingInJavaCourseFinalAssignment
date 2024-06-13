package generics;

public class Main<T> {

    public static void main(String[] args) {

        //1. Napisz metodę generyczną wymiany pozycji dwóch różnych elementów w dowolnej
        //tablicy (dla podanych pozycji).

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

        String[] strings1 = swapElements(strings, 2, 3);
        Integer[] int1 = swapElements(ints, 1, 5);
        Double[] doubles1 = swapElements(doubles, 4, 6);

        for (String s : strings1) {
            System.out.println(s);
        }

        for (Integer integer : int1) {
            System.out.println(integer);
        }

        for (Double aDouble : doubles1) {
            System.out.println(aDouble);
        }
    }

    static <T> T[] swapElements(T[] elements, int elementOneToSwapPosition, int elementTwoToSwapPosition) {

        if (elementOneToSwapPosition >= 0 && elementTwoToSwapPosition >= 0 && elementOneToSwapPosition < elements.length && elementTwoToSwapPosition < elements.length) {
            T temp = elements[elementOneToSwapPosition];
            elements[elementOneToSwapPosition] = elements[elementTwoToSwapPosition];
            elements[elementTwoToSwapPosition] = temp;
        } else {
            System.out.println("One of the given positions is incorrect");
        }
        return elements;
    }
}
