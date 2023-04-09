package equalsNhashcode;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder()
                .age(26)
                .name("kjh1")
                .address("dobong").build();
        System.out.println(person.hashCode());
        Person person2 = Person.builder()
                .age(26)
                .name("kjh1")
                .address("nowon").build();
        System.out.println(person2.hashCode());

    }
}
