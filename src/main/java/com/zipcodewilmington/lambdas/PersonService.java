package com.zipcodewilmington.lambdas;

import java.util.List;

public class PersonService {
    static class Anonymous implements CheckPerson{
        @Override
        public boolean test(Person p) {
            return p.getAge() > 30;
        }
        // check older than 30

    }
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

    public static String printPersons(List<Person> roster){
        return printPersons(roster, new Anonymous());
    }
}
