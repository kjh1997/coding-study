package staticfactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    LocalDate birthday;

    public Person() {

    }
    public static int compareByAge(Person a, Person b) {
        System.out.println(a.birthday.compareTo(b.birthday));
        return a.birthday.compareTo(b.birthday);
    }

    public Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        List<LocalDate> list = new ArrayList<>();
        list.add(LocalDate.of(2011, 10, 20));
        list.add(LocalDate.of(2013, 10, 20));
        list.add(LocalDate.of(2015, 10, 20));
        List<Person> collect = list.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(collect);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(LocalDate.of(2011, 10, 20)));

        personList.add(new Person(LocalDate.of(2001, 7, 15)));

        personList.add(new Person(LocalDate.of(2021, 3, 11)));
        personList.sort((p1, p2) ->
                p1.birthday.compareTo(p2.birthday));
        System.out.println(Person.compareByAge(new Person(LocalDate.of(1981, 7, 15)), new Person(LocalDate.of(2001, 7, 15))));
        personList.forEach(v-> System.out.println(v.birthday));
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }
}
