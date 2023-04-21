package com.zipcodewilington.lambdas;

import com.zipcodewilmington.lambdas.CheckPerson;
import com.zipcodewilmington.lambdas.Person;
import com.zipcodewilmington.lambdas.PersonChecker;
import com.zipcodewilmington.lambdas.PersonService;
import org.junit.Assert;
import org.junit.Before;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    List<Person> list;

    @Before
    public void setUp(){
        list = new ArrayList<>();
        list.add(new Person("1",LocalDate.of(1998,12,12), Person.Sex.FEMALE,"1@gmail.com"));
        list.add(new Person("2",LocalDate.of(1996,7,20), Person.Sex.MALE,"2@icloud.com"));
        list.add(new Person("3",LocalDate.of(1994,9,2), Person.Sex.FEMALE,"3@hotmail.com"));
        list.add(new Person("4",LocalDate.of(1992,2,16), Person.Sex.MALE,"4@gmail.com"));
        list.add(new Person("5",LocalDate.of(1988,8,21), Person.Sex.FEMALE,"5@email.com"));
        list.add(new Person("6",LocalDate.of(1986,5,30), Person.Sex.MALE,"6@gmail.com"));

    }
    @org.junit.Test
    public void testLocalClass(){
        // filter female
        String actual = "Person{name='1', birthday=1998-12-12, gender=FEMALE, emailAddress='1@gmail.com'}\n" +
                "Person{name='3', birthday=1994-09-02, gender=FEMALE, emailAddress='3@hotmail.com'}\n" +
                "Person{name='5', birthday=1988-08-21, gender=FEMALE, emailAddress='5@email.com'}\n";
        String expected = PersonService.printPersons(list, new PersonChecker());
        Assert.assertEquals(actual,expected);
    }


    @org.junit.Test
    public void testAnonymousClass(){
        // filter people older > 30
        String actual = "Person{name='4', birthday=1992-02-16, gender=MALE, emailAddress='4@gmail.com'}\n" +
                "Person{name='5', birthday=1988-08-21, gender=FEMALE, emailAddress='5@email.com'}\n" +
                "Person{name='6', birthday=1986-05-30, gender=MALE, emailAddress='6@gmail.com'}\n";
        String expected = PersonService.printPersons(list,new CheckPerson(){
            @Override
            public boolean test(Person p) {
                return p.getAge() > 30;
            }
        });
        Assert.assertEquals(actual,expected);
    }

    @org.junit.Test
    public void testPredicate(){
        // filter people have gmail
        String actual = "Person{name='1', birthday=1998-12-12, gender=FEMALE, emailAddress='1@gmail.com'}\n" +
                "Person{name='4', birthday=1992-02-16, gender=MALE, emailAddress='4@gmail.com'}\n" +
                "Person{name='6', birthday=1986-05-30, gender=MALE, emailAddress='6@gmail.com'}\n";
        String expected = PersonService.printPersons(list,(p)->p.getEmailAddress().contains("gmail"));
        Assert.assertEquals(actual,expected);
    }
}
