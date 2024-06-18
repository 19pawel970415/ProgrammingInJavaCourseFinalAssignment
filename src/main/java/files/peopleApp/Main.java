package files.peopleApp;

import files.peopleApp.application.PeronSerializer;
import files.peopleApp.application.PersonSerializerInterface;
import files.peopleApp.application.ResultService;
import files.peopleApp.db.PeopleRepository;
import files.peopleApp.domain.Person;
import files.peopleApp.domain.Result;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {

    //1. Napisz aplikację konsolową w języku Java maven, która będzie wczytywać dane
    //osób z pliku CSV, analizować je, a następnie zapisywać wyniki analizy do pliku
    //wyjściowego. Przy tworzeniu funkcjonalności programu użyj odpowiednich
    //interfejsów. Pamiętaj o zasadzie pojedynczej odpowiedzialności.
    //Wczytywanie danych z pliku CSV:
    //• Plik CSV zawiera dane osób w formacie: imię,nazwisko,wiek,email.
    //• Program wczytuje dane z pliku i zapisuje je w kolekcji.
    //Analiza danych:
    //• Wyliczenie średniego wieku osób.
    //• Znalezienie osoby o najdłuższym nazwisku.
    //• Posortowanie listy osób według wieku malejąco.
    //Wypisz dane na ekranie.
    //Zapis wyników analizy do pliku wyjściowego:
    //• Wyniki analizy (średni wiek, najdłuższe nazwisko, posortowana lista)
    //zapisywane są do pliku tekstowego.
    //• Nazwa pliku powinna zostać wskazana przez użytkownika.
    //Do stworzenia pliku csv możesz użyć tej listy:
    //imię,nazwisko,wiek,email
    //Anna,Kowalska,28,anna.kowalska@example.com
    //Jan,Nowak,34,jan.nowak@example.com
    //Ewa,Wiśniewska,23,ewa.wisniewska@example.com
    //Marek,Wójcik,40,marek.wojcik@example.com
    //Katarzyna,Kowalczyk,29,katarzyna.kowalczyk@example.com
    //Piotr,Kozłowski,35,piotr.kozlowski@example.com
    //Agnieszka,Woźniak,31,agnieszka.wozniak@example.com
    //Tomasz,Kaczmarek,42,tomasz.kaczmarek@example.com
    //Małgorzata,Król,27,malgorzata.krol@example.com
    //Michał,Szymański,36,michal.szymanski@example.com
    //Joanna,Wiśniewski,30,joanna.wisniewski@example.com
    //Adam,Lewandowski,33,adam.lewandowski@example.com
    //Monika,Zielińska,25,monika.zielinska@example.com
    //Krzysztof,Nowakowski,38,krzysztof.nowakowski@example.com
    //Magdalena,Kaminska,32,magdalena.kaminska@example.com
    //Rafał,Sawicki,29,rafal.sawicki@example.com
    //Dorota,Ostrowska,26,dorota.ostrowska@example.com
    //Jakub,Czarnecki,31,jakub.czarnecki@example.com
    //Paulina,Pawłowska,28,paulina.pawlowska@example.com
    //Łukasz,Mazurek,34,lukasz.mazurek@example.com

    public static void main(String[] args) {

        final PeopleRepository peopleRepository = new PeopleRepository();
        final PersonSerializerInterface serializer = new PeronSerializer();
        final ResultService resultService = new ResultService();
        final Result result = new Result();

        try {
            List<Person> readPeople = serializer.readFromCSV();
            peopleRepository.setPeopleList(readPeople);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Double averageAge = resultService.findAverageAge(peopleRepository.getPeopleList());
        result.setAverageAge(averageAge);
        System.out.println("The average age: " + result.getAverageAge());

        Person thePersonWithTheLongestSurname = resultService.findThePersonWithTheLongestSurname(peopleRepository.getPeopleList());
        result.setThePersonWithTheLongestSurname(thePersonWithTheLongestSurname);
        System.out.println("The person with the longest surname is: " + result.getThePersonWithTheLongestSurname().getName() + "," + result.getThePersonWithTheLongestSurname().getSurname() + "," + result.getThePersonWithTheLongestSurname().getAge() + "," + result.getThePersonWithTheLongestSurname().getEmailAddress());

        List<Person> sortedPeopleByAge = resultService.findSortedPeopleByAge(peopleRepository.getPeopleList());
        result.setSortedPeopleByAge(sortedPeopleByAge);
        System.out.println("The list of people sorted by age DESC: ");
        for (Person person : result.getSortedPeopleByAge()) {
            System.out.println(person.getName() + "," + person.getSurname() + "," + person.getAge() + "," + person.getEmailAddress());
        }

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the file (no extension needed): ");
            String line = scanner.nextLine();
            String filePathString = line + ".csv";
            Path filePath = Path.of(filePathString);
            serializer.writeToCSV(result, filePath);
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

}
