package generics;

public class MainExercise6 {

    //Exercise 6
    //Czy następujący kod zostanie skompilowany? Jeśli nie, to dlaczego? (Uruchom kod
    //żeby sprawdzić)

//    public static void main(String[] args) {
//        Node<Circle> nc = new Node<>();
//        Node<Shape> ns = nc;
//    }

    //java: incompatible types: generics.Node<generics.Circle> cannot be converted to generics.Node<generics.Shape>
    //Nie, bo typy generyczne są nierelacyjne w Javie, co oznacza, że Node<Circle> nie jest podtypem Node<Shape>,
    //nawet jeśli Circle jest podtypem Shape.
}
