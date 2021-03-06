package tech.android.tcmp13.recyclerviewdemo;

/**
 * Created by tcmp13-t on 11/9/2016.
 */
public class Book {

    private String title;
    private String content;
    int tmp = 0;
    int wer = -1;

    public Book(String title, String content) {
        this.title = title;
        this.content = content;
        tmp = 44444;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return title.equals(book.title);

    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
