package test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Library {
    private final HashSet<Book> books;
//    private final HashMap<String, ArrayDeque<String>> bookLoans;
    private final int numCopies;
//    // if there is a need to distinguish who returns the loan
//    private final HashMap<String,HashSet<String>> bookLoansDist;
//    private final HashMap<String,ArrayDeque<String>> bookReservations;
//    // linked list
    private final HashMap<String, LinkedList<String>> bookLoansList;
    public Library(int numCopies){
        this.books = new HashSet<>();
//        this.bookLoans = new HashMap<>();
        this.numCopies = numCopies;
//        // if there is a need to distinguish who returns the loan
//        this.bookLoansDist=new HashMap<>();
//        this.bookReservations=new HashMap<>();
        // linked list
        this.bookLoansList=new HashMap<>();
    }
    public void addBook (Book book) {
        this.books.add(book);
//        this.bookLoans.put(book.getTitle(), new ArrayDeque<>());
//        // distinguish
//        this.bookLoansDist.put(book.getTitle(),new HashSet<>());
//        this.bookReservations.put(book.getTitle(),new ArrayDeque<>());
        // list
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
    /*
    public void removeBook (Book book) {
        this.books.remove(book);
        this.bookLoans.remove(book.getTitle());
    }
    */
    public void removeBook (String title) {
        Book book = this.getBookByTitle(title);
        if (book != null) {
            this.books.remove(book);
//            this.bookLoans.remove(title);
            this.bookLoansList.remove(title);
        } else {
            System.out.println("The book " + title + " does not exist");
        }
    }
    public void addLoanToBook (String title, String userName) {
//        boolean dist = true;
        this.bookLoansList.get(title).add(userName);
//        if (dist) {
//            // distinguish
//            if (this.bookLoansDist.get(title).size() >= numCopies) {
//                this.bookReservations.get(title).add(userName);
//            } else {
//                this.bookLoansDist.get(title).add(userName);
//            }
//        } else {
//            this.bookLoans.get(title).add(userName);
//        }

    }
    public void removeBookLoan (String title,String userName) {
//        boolean dist = true;
        if (this.bookLoansList.get(title).isEmpty()) {
            System.out.println("No one loaned this book");
        } else {
            this.bookLoansList.get(title).remove(userName);
        }
//        if (dist) {
//            this.bookLoansDist.get(title).remove(userName);
//        } else {
//            this.bookLoans.get(title).pop();
//        }
    }
    public int getNumOfLoansForBook (String title) {
//        boolean dist = true;
//        boolean linked = true;
//        if (linked) {
            return  this.bookLoansList.get(title).size();
//        }
//        if (dist) {
//            return this.bookReservations.get(title).size() + 2;
//        } else {
//            return this.bookLoans.get(title).size();
//        }
    }
    public String getNextUserToLoanTheBook (String title) {
//        boolean dist = true;
//        if (dist) {
//            if (this.bookReservations.get(title).isEmpty()) {
//                return null;
//            } else {
//                return this.bookReservations.get(title).pop();
//            }
//        }else {
//            ArrayDeque<String> temp = new ArrayDeque<>();
//            for (int i = 1; i < numCopies; i++) {
//                temp.add(this.bookLoans.get(title).pop());
//            }
//            String nextUser = this.bookLoans.get(title).pop();
//            temp.add(nextUser);
//            while (!this.bookLoans.get(title).isEmpty()) {
//                temp.add(this.bookLoans.get(title).pop());
//            }
//            while (!temp.isEmpty()) {
//                this.bookLoans.get(title).add(temp.pop());
//            }
//            return nextUser;
//        }
        return this.bookLoansList.get(title).get(numCopies -1);
    }
}