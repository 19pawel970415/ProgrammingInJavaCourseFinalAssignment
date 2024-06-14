package generics;

public class MainExercise7 {
    public static void main(String[] args) {

        //Exercise 7
        //Czy następujący kod zostanie skompilowany? Jeśli nie, to dlaczego? (Uruchom kod
        //żeby sprawdzić):

//        Node<String> node = new Node<>();
//        Comparable<String> comp = node;

        //java: incompatible types: generics.Node<java.lang.String> cannot be converted to java.lang.Comparable<java.lang.String>
        //Nie. Zgodnie z zasadami generyków i interfejsów, bez jawnego upewnienia kompilatora o tym, że Node<String>
        //faktycznie implementuje Comparable<String>, kompilacja generuje błąd. Czsami może go nie wygenerować, ze wględu na
        //Raw Types: Jeśli kompilator Javy traktuje Node<T> jako typ surowy (raw type), to kompilacja
        //może się udać, ale wystąpią ostrzeżenia dotyczące raw types.
        //Upcasting w Generykach: Jeśli kompilator jest w stanie uprzystępnić typ Node<String> do
        //Comparable<String> poprzez pewne przypuszczenia w mechanizmach typów generycznych, to może się skompilować.
        //Niejawne Upcasting: Jeśli kompilator jest wystarczająco elastyczny, aby dokonać niejawnej konwersji typu
        //Node<String> na Comparable<String>, to również może dopuścić tę kompilację.
    }
}
