//Library contains books
package com.thoughtworks.biblioteca;

import com.thoughtworks.users.LibrarianUser;
import com.thoughtworks.users.SimpleUser;
import com.thoughtworks.users.User;

import java.util.*;

public class Library {

    private List<Book> listOfBooks = new ArrayList<>(Arrays.asList(new Book("scjp", "kathy sierra", 1990),
                                                                   new Book("head first java", "someone", 2014)));
    private List<Book> checkedOutBooks = new ArrayList<>();
    private List<Movie> listOfMovies = new ArrayList<>(Arrays.asList(new Movie("sholay", 1981, "Shakti kapoor", 10),
                                                                     new Movie("sehansha", 1990, "Sunny deol", 9),
                                                                     new Movie("3 idiots", 2010, "Amandeep Singh", 10)));
    private List<Movie> checkedOutMovies = new ArrayList<>(Arrays.asList(new Movie("Aashiqi", 1947, "Dharmendra", 3)));
    private List<User> listOfUsers = new ArrayList<>(Arrays.asList(new SimpleUser("111-2222", "abcd"), new LibrarianUser("222-1111", "dcba")));

    private HashMap<Book, User> bookCheckOutDetails = new HashMap<>();
    private User currentUser;

    public Library(User currentUser) {
        this.currentUser = currentUser;
    }

    public String listBooks() {
        String bookList = "List of books we have is: \n";
        bookList += printBookHeaders();
        for(Book book : listOfBooks) {
            bookList += book.toString();
        }
        return bookList;
    }

    public String listMovies() {
        String movieList = "List of movies we have is: \n";
        movieList += printMovieHeaders();
        for(Movie movie : listOfMovies) {
            movieList += movie.toString();
        }
        return movieList;
    }

    private String printMovieHeaders() {
        String movieList = String.format("%-40s %-40s %-40s %-40s\n", "Name", "Year", "Director", "Rating");
        for (int i = 0; i < 129; i++) {
            movieList += "-";
        }
        movieList += "\n";
        return movieList;
    }

    private String printBookHeaders() {
        String bookList = String.format("%-40s %-40s %-40s\n", "Name", "Author", "Year Published");
        for (int i = 0; i < 96; i++) {
            bookList += "-";
        }
        bookList += "\n";
        return bookList;
    }

    public String checkOutBook(String bookName) {
        for(Book book : listOfBooks) {
            if(book.compareBookNameWith(bookName)) {
                checkOutBook(book);
                bookCheckOutDetails.put(book, currentUser);
                return "Thank You! Enjoy the book";
            }
        }
        return "That book is not available";
    }

    private void checkOutBook(Book book) {
        listOfBooks.remove(book);
        checkedOutBooks.add(book);
    }

    public String returnBook(String bookName) {
        for(Book book : checkedOutBooks) {
            if(book.compareBookNameWith(bookName)) {
                returnBook(book);
                bookCheckOutDetails.remove(book);
                return "Thank you for returning the book";
            }
        }
        return "This is not a valid book to return";
    }

    private void returnBook(Book book) {
        checkedOutBooks.remove(book);
        listOfBooks.add(book);
    }

    public boolean checkOutMovie(String movieName) {
        for(Movie movie : listOfMovies) {
            if(movie.compareMovieNameWith(movieName)) {
                checkOutMovie(movie);
                return true;
            }
        }
        return false;
    }

    private void checkOutMovie(Movie movie) {
        listOfMovies.remove(movie);
        checkedOutMovies.add(movie);
    }

    public User logInUser(String userName, String password) {
        for(User user : listOfUsers) {
            if(user.logIn(userName, password)) {
                return user;
            }
        }
        return null;
    }

    public String checkedOutBooksStatus() {
        return "";
    }
}
