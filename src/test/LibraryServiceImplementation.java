package test;


public class LibraryServiceImplementation implements LibraryService {
    private final Library library;
    private final int numCopies = 2;
    public LibraryServiceImplementation(){
        this.library =new Library(numCopies);
    }
    public boolean addBook (String title,String author){
        library.addBook(new Book(title,author));
        return library.getBookByTitle(title) != null;
    }
    public void removeBook (String title){
        Book book= library.getBookByTitle(title);
        if (book!=null) {
            library.removeBook(title);
            System.out.println(title + " has been removed");
        } else {
            System.out.println(title + " is not in the library");
        }
    }
    public Book searchBookByTitle (String title) {
        return library.getBookByTitle(title);
    }
    public void loanBook (String userName,String title){
        library.addLoanToBook(title,userName);
        if (library.getNumOfLoansForBook(title) > numCopies) {
            System.out.println("the book "+ title + " is not available. You have been added to the waiting list. You are “" + (library.getNumOfLoansForBook(title) - numCopies) + "” in the line");
        }

    }
    public void returnBook (String title,String userName) {
        library.removeBookLoan(title,userName);
        if (library.getNumOfLoansForBook(title) >= numCopies) {
            String nextUser= library.getNextUserToLoanTheBook(title);
//            library.addLoanToBook(title,nextUser);
            System.out.println(nextUser + " was the next in the line for the book “" + title + "”. Copy 1 loaned by " + nextUser);
        }
    }
}
