package files.peopleApp.db;

import files.peopleApp.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PeopleRepository {
    private List<Person> peopleList = new ArrayList<>();

    public List<Person> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Person> peopleList) {
        this.peopleList = peopleList;
    }
}
