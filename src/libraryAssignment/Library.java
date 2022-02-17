package libraryAssignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Library {
    private final HashSet<Book> books;
    private final int numCopies;
    private final HashMap<String, LinkedList<String>> bookLoansList;
    public Library  (int numCopies) {
        this.books = new HashSet<>();
        this.numCopies = numCopies;
        this.bookLoansList=new HashMap<>();
    }
    public void addBook (Book book) {
        this.books.add(book);
        this.bookLoansList.put(book.getTitle(),new LinkedList<>());
    }
    public Book getBookByTitle(String title) {
        for (Book book: this.books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    public void removeBook (String title) {
        Book book = this.getBookByTitle(title);
        if (book != null) {
            this.books.remove(book);
            this.bookLoansList.remove(title);
        } else {
            System.out.println("The book " + title + " does not exist");
        }
    }
    public void addLoanToBook (String title, String userName) {
        this.bookLoansList.get(title).add(userName);
    }
    public void removeBookLoan (String title,String userName) {
        if (this.bookLoansList.get(title).isEmpty()) {
            System.out.println("No one loaned this book");
        } else {
            this.bookLoansList.get(title).remove(userName);
        }
    }
    public int getNumOfLoansForBook (String title) {
        return this.bookLoansList.get(title).size();
    }
    public String getNextUserToLoanTheBook (String title) {
        return this.bookLoansList.get(title).get(numCopies -1);
    }
}
