package files.peopleApp.application;

import files.peopleApp.domain.Person;
import files.peopleApp.domain.Result;

import java.nio.file.Path;
import java.util.List;

public interface PersonSerializerInterface {
    List<Person> readFromCSV() throws Exception;
    void writeToCSV(Result result, Path path) throws Exception;
}
