package test;


public class LibraryLogic {
    private final LibraryDB libraryDB;
    private final int numCopies = 2;
    public LibraryLogic(){
        this.libraryDB=new LibraryDB(numCopies);
    }
    public boolean addBook (String title,String author){
        libraryDB.addBook(new Book(title,author));
        return libraryDB.getBookByTitle(title) != null;
    }
    public void removeBook (String title){
        Book book=libraryDB.getBookByTitle(title);
        if (book!=null) {
            libraryDB.removeBook(book);
            System.out.println(title + " has been removed");
        } else {
            System.out.println(title + " is not in the library");
        }
    }
    public Book searchBookByTitle (String title) {
        return libraryDB.getBookByTitle(title);
    }
    public void loanBook (String userName,String title){
        libraryDB.addLoanToBook(title,userName);
        if (libraryDB.getNumOfLoansForBook(title) > numCopies) {
            System.out.println("the book "+ title + " is not available. You have been added to the waiting list. You are “" + (libraryDB.getNumOfLoansForBook(title) - numCopies) + "” in the line");
        }
    }
    public void returnBook (String title) {
        libraryDB.removeBookLoan(title);
        if (libraryDB.getNumOfLoansForBook(title) >= numCopies) {
            String nextUser=libraryDB.getNextUserToLoanTheBook(title);
            System.out.println(nextUser + " was the next in the line for the book “" + title + "”. Copy 1 loaned by " + nextUser);
        }
    }
}
