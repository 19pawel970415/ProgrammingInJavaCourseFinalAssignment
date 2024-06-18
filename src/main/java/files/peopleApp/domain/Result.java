package files.peopleApp.domain;

import java.util.List;

public class Result {
    private Double averageAge;
    private Person thePersonWithTheLongestSurname;
    private List<Person> sortedPeopleByAge;

    public Double getAverageAge() {
        return averageAge;
    }

    public Person getThePersonWithTheLongestSurname() {
        return thePersonWithTheLongestSurname;
    }

    public List<Person> getSortedPeopleByAge() {
        return sortedPeopleByAge;
    }

    public void setAverageAge(Double averageAge) {
        this.averageAge = averageAge;
    }

    public void setThePersonWithTheLongestSurname(Person thePersonWithTheLongestSurname) {
        this.thePersonWithTheLongestSurname = thePersonWithTheLongestSurname;
    }

    public void setSortedPeopleByAge(List<Person> sortedPeopleByAge) {
        this.sortedPeopleByAge = sortedPeopleByAge;
    }
}
