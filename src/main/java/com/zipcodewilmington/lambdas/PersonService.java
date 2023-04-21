package com.zipcodewilmington.lambdas;

import java.util.List;

public class PersonService {
    public List<Person> people;

    public PersonService(List<Person> people) {
        this.people = people;
    }

    public static String printPersons(List<Person> roster, CheckPerson tester) {
        StringBuilder sb = new StringBuilder();
        for (Person p : roster) {
            if (tester.test(p)) {
                sb.append(p.printPerson()+"\n");
            }
        }
        return sb.toString();
    }
}
