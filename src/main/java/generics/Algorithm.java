package generics;

public final class Algorithm {

    //Czy następująca klasa zostanie skompilowana? Jeśli nie, to dlaczego? (Uruchom
    //poniższy kod żeby sprawdzić):

//    public static <T> T max(T x, T y) {
//        return x > y ? x : y;
//    }

    //java: bad operand types for binary operator '>'
    //  first type:  T
    //  second type: T

    //Nie. Operator > nie może być bezpośrednio użyty z generycznymi parametrami typu T, ponieważ generyki w Javie
    //nie wspierają operatorów porównania (> lub <), chyba że są one ograniczone przez interfejsy takie jak Comparable.
    //Java nie potrafi wywnioskować, jak porównać dwa generyczne obiekty x i y bez dodatkowych informacji lub ograniczeń na typie T.
}
