package test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class LibraryDB {
    private HashSet<Book> books;
    private HashMap<String, ArrayDeque<String>> bookLoans;
    private int numCopies;
    public LibraryDB(int numCopies){
        this.books = new HashSet<>();
        this.bookLoans = new HashMap<>();
        this.numCopies = numCopies;
    }
    public void addBook (Book book) {
        this.books.add(book);
        this.bookLoans.put(book.getTitle(), new ArrayDeque<>());
    }
    public Book getBookByTitle(String title) {
        for (Book book: this.books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    public void removeBook (Book book) {
        this.books.remove(book);
        this.bookLoans.remove(book.getTitle());
    }
    public void addLoanToBook (String title, String userName) {
        this.bookLoans.get(title).add(userName);
    }
    public void removeBookLoan (String title) {
        this.bookLoans.get(title).pop();
    }
    public int getNumOfLoansForBook (String title) {
        return this.bookLoans.get(title).size();
    }
    public String getNextUserToLoanTheBook (String title) {
        ArrayDeque<String> temp = new ArrayDeque<>();
        for (int i=1; i<numCopies; i++) {
            temp.add(this.bookLoans.get(title).pop());
        }
        String nextUser = this.bookLoans.get(title).pop();
        temp.add(nextUser);
        while (!this.bookLoans.get(title).isEmpty()) {
            temp.add(this.bookLoans.get(title).pop());
        }
        while (!temp.isEmpty()) {
            this.bookLoans.get(title).add(temp.pop());
        }
        return nextUser;
    }
}
