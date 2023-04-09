import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Person> personTreeSet = new TreeSet<Person>();

        Person person1 = new Person();
        Person person2 = new Person();
        person2.setName("kjh1");
        person2.setAge(12);
        person1.setAge(15);
        person1.setName("kjh2");
        personTreeSet.add(person1);
        personTreeSet.add(person2);
        System.out.println(personTreeSet);


    }
}
