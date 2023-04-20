package com.zipcodewilmington.lambdas;

import java.util.List;

public class PersonService {
    public List<Person> people;

    public PersonService(List<Person> people) {
        this.people = people;
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
