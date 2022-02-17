package test;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String userDan = "Dan";
        String userJack = "Jack";
        String userRob = "Rob";
        String userJoe = "Joe";
        LibraryLogic libraryLogic=new LibraryLogic();
        addAllRequiredBooks(libraryLogic);
        Book book=libraryLogic.searchBookByTitle("Oliver twist");
        libraryLogic.loanBook(userDan, book.getTitle());
        libraryLogic.loanBook(userJack, book.getTitle());
        libraryLogic.loanBook(userRob, book.getTitle());
        libraryLogic.loanBook(userJoe, book.getTitle());
        libraryLogic.returnBook(book.getTitle(),userJack);
    }
    public static void addAllRequiredBooks(LibraryLogic libraryLogic){
        libraryLogic.addBook("Moby Dick", "AuthorA");
        libraryLogic.addBook("Ulysses", "AuthorB");
        libraryLogic.addBook("Oliver twist", "AuthorC");
        libraryLogic.addBook("Hamlet", "AuthorD");
        libraryLogic.addBook("Catch-22", "AuthorE");
    }
}
