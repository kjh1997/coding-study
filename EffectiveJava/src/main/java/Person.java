import lombok.Data;

@Data
public class Person implements Comparable<Person> {
    private Integer age;
    private String name;
    @Override
    public int compareTo(Person o) {
        int compare = Integer.compare(o.getAge(), this.age);
        if (compare == 1) {
            return 1;
        }
        return 0;
    }
}
