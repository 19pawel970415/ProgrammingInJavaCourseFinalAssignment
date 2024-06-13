package generics;

public class Singleton<T> {

    //Exercise 5
    //Czy następująca klasa zostanie skompilowana? Jeśli nie, to dlaczego? (Uruchom
    //poniższy kod żeby sprawdzić)

//    public static T getInstance() {
//        if (instance == null)
//            instance = new Singleton<T>();
//        return instance;
//    }
//    private static T instance = null;

    //java: non-static type variable T cannot be referenced from a static context
    //Nie. Powody? Brak Inicjalizacji Generyka w Static: Generyk T nie może być użyty w kontekście statycznym, takim
    //jak pole instance w klasie Singleton. Pole instance jest statyczne, co oznacza, że jest współdzielone między
    //wszystkimi instancjami tej klasy i nie może bezpośrednio przechowywać generycznego typu T.
    //Nieprawidłowe Użycie Generyka w Metodzie Statycznej: Metoda getInstance() jest statyczna, co oznacza, że
    //nie ma dostępu do generycznego typu T z kontekstu instancji klasy.
    //Ponadto, próba utworzenia nowej instancji Singleton<T> w tej metodzie jest niemożliwa, ponieważ
    //generyk T nie jest znany w kontekście statycznym.
    //Nieprawidłowe Użycie Pola instance: Statyczne pole instance powinno być zainicjalizowane jako Singleton<T>
    //bez określania typu generycznego T podczas inicjalizacji.

}
