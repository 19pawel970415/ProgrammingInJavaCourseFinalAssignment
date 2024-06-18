package files.peopleApp.application;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import files.peopleApp.domain.Person;
import files.peopleApp.domain.Result;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PeronSerializer implements PersonSerializerInterface {

    private final Path filePath = Path.of("dane.csv");

    @Override
    public List<Person> readFromCSV() throws Exception {
        List<Person> readPeople = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                List<String[]> strings = csvReader.readAll();
                for (String[] string : strings) {
                    Person person = new Person(string[0], string[1], Integer.valueOf(string[2]), string[3]);
                    readPeople.add(person);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return readPeople;
    }

    @Override
    public void writeToCSV(Result result, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            String[] averageAgeToSave = new String[1];
            averageAgeToSave[0] = result.getAverageAge().toString();
            writer.writeNext(averageAgeToSave);

            String[] thePersonWithTheLongestSurnameToSave = new String[1];
            thePersonWithTheLongestSurnameToSave[0] = result.getThePersonWithTheLongestSurname().getName() + "," + result.getThePersonWithTheLongestSurname().getSurname() + "," + result.getThePersonWithTheLongestSurname().getAge() + "," + result.getThePersonWithTheLongestSurname().getEmailAddress();
            writer.writeNext(thePersonWithTheLongestSurnameToSave);

            for (Person person : result.getSortedPeopleByAge()) {
                writer.writeNext(new String[]{person.getName() + "," + person.getSurname() + "," + person.getAge() + "," + person.getEmailAddress()});
            }
        }
    }
}
