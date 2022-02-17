package test;

public interface LibraryService {
    boolean addBook (String title,String author);
    void removeBook (String title);
    Book searchBookByTitle (String title);
    void loanBook (String userName,String title);
    void returnBook (String title,String userName);
}
