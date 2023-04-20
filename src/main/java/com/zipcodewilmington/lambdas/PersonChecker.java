package com.zipcodewilmington.lambdas;

public class PersonChecker implements CheckPerson{
    @Override
    public boolean test(Person p) {
        return p.getGender().equals(Person.Sex.FEMALE);
    }



}
