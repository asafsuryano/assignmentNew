package test;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String userDan = "Dan";
        String userJack = "Jack";
        String userRob = "Rob";
        String userJoe = "Joe";
        LibraryService libraryService =new LibraryServiceImplementation();
        addAllRequiredBooks(libraryService);
        Book book= libraryService.searchBookByTitle("Oliver twist");
        libraryService.loanBook(userDan, book.getTitle());
        libraryService.loanBook(userJack, book.getTitle());
        libraryService.loanBook(userRob, book.getTitle());
        libraryService.loanBook(userJoe, book.getTitle());
        libraryService.returnBook(book.getTitle(),userJack);
    }
    public static void addAllRequiredBooks(LibraryService libraryService){
        libraryService.addBook("Moby Dick", "AuthorA");
        libraryService.addBook("Ulysses", "AuthorB");
        libraryService.addBook("Oliver twist", "AuthorC");
        libraryService.addBook("Hamlet", "AuthorD");
        libraryService.addBook("Catch-22", "AuthorE");
    }
}
