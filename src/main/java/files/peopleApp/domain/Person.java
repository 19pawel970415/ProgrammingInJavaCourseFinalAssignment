package files.peopleApp.domain;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String emailAddress;

    public Person(String name, String surname, int age, String emailAddress) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
