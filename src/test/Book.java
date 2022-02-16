package test;

public class Book {
    private String title;
    private String author;
    public Book(String title,String author){
        this.setTitle(title);
        this.setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o){
        Book book=(Book) o;
        if (book.getTitle().equals(this.getTitle()) && (book.getAuthor().equals(this.author))){
            return true;
        }else{
            return false;
        }
    }
}
