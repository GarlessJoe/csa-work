package libary;

import java.io.Serializable;

public class Book implements Serializable {
    private String name ;
    private String author;
    private String kind;
    private String year;
    public Book() {
    }

    public Book(String name, String author, String kind,String year) {
        this.name = name;
        this.author = author;
        this.kind = kind;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", kind='" + kind + '\'' +
                ", year=" + year +
                '}';
    }
}
