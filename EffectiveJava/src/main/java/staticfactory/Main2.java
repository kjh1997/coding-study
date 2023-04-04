package staticfactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class Main2 {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.now();
        LocalDateTime d2 = LocalDateTime.of(2024, 10, 2, 11, 54);
        LocalDateTime d3 = LocalDateTime.of(2024, 10, 2, 11, 34);
        System.out.println(d2.isBefore(d3));
        System.out.println(d1.isBefore(ChronoLocalDate.from(d2)));;


        Book book = new Book( 1234, "kjh");
//        book.serialize(book);
        Book b2 = book.deserialize();
        System.out.println(b2.toString());
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Book implements Serializable{
//    private static final long serialVersionUID = 2L;
//    private String title;
    private Integer isbn;
    private transient String author;
//
//    private static void hello() {
//        System.out.println(this.author + "testse");
//
//    }
    public void serialize(Book book) {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("book.obj"))) {
            out.writeObject(book);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Book deserialize(){
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("book.obj"))) {
            return (Book) in.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
