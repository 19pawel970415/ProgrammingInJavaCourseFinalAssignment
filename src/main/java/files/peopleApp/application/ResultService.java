package files.peopleApp.application;

import files.peopleApp.domain.Person;

import java.util.*;
import java.util.stream.Collectors;

public class ResultService {


    public Double findAverageAge(List<Person> people) {
        OptionalDouble average = people.stream()
                .mapToDouble(p -> p.getAge())
                .average();
        if (average.isPresent()) {
            return average.getAsDouble();
        } else {
            System.out.println("No data, average set to 0");
            return 0.0;
        }
    }

    public Person findThePersonWithTheLongestSurname(List<Person> people) {
        Optional<String> theLongestSurname = people.stream()
                .map(p -> p.getSurname())
                .max(Comparator.comparing(s -> s.length()));


        if (theLongestSurname.isPresent()) {
            Person personWithTheLongestSurname = new Person();
            for (Person person : people) {
                if (person.getSurname().equals(theLongestSurname.get())) {
                    personWithTheLongestSurname = person;
                }
            }
            return personWithTheLongestSurname;
        } else {
            System.out.println("No data, empty object of Person returned");
            return new Person();
        }
    }

    public List<Person> findSortedPeopleByAge(List<Person> people) {
        List<Person> peopleSortedByAge = people.stream()
                .sorted(Comparator.comparingInt(p -> p.getAge()))
                .collect(Collectors.toList());

        Collections.reverse(peopleSortedByAge);
        return peopleSortedByAge;
    }
}
