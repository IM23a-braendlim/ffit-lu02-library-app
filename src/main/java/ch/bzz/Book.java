package ch.bzz;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private int year;
}
