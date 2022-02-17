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
        if (book != null) {
            libraryService.loanBook(userDan, book.getTitle());
            libraryService.loanBook(userJack, book.getTitle());
            libraryService.loanBook(userRob, book.getTitle());
            libraryService.loanBook(userJoe, book.getTitle());
            libraryService.returnBook(book.getTitle(), userJack);
        }
    }
    public static void addAllRequiredBooks(LibraryService libraryService){
        if (!libraryService.addBook("Moby Dick", "AuthorA")) {
            System.out.println("there was a problem adding Moby Dick");
        }
        if (!libraryService.addBook("Ulysses", "AuthorB")) {
            System.out.println("There was a problem adding Ulysses");
        }
        if (!libraryService.addBook("Oliver twist", "AuthorC")) {
            System.out.println("There was a problem adding Oliver Twist");
        }
        if (!libraryService.addBook("Hamlet", "AuthorD")) {
            System.out.println("There was a problem adding Hamlet");
        }
        if (!libraryService.addBook("Catch-22", "AuthorE")) {
            System.out.println("There was a problem adding Catch-22");
        }
    }
}
