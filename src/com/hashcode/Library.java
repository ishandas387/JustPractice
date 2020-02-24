package com.hashcode;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String libName;
    private int numberOfDaysForSignUp;
    private int numberOfBooksPerDay;
    private List<Book> bookList ;

    public Library() {
    }
    
    public int getNumberOfDaysForSignUp() {
        return numberOfDaysForSignUp;
    }

    public void setNumberOfDaysForSignUp(int numberOfDaysForSignUp) {
        this.numberOfDaysForSignUp = numberOfDaysForSignUp;
    }

    public int getNumberOfBooksPerDay() {
        return numberOfBooksPerDay;
    }

    public void setNumberOfBooksPerDay(int numberOfBooksPerDay) {
        this.numberOfBooksPerDay = numberOfBooksPerDay;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Library(int numberOfDaysForSignUp, int numberOfBooksPerDay) {
        this.numberOfDaysForSignUp = numberOfDaysForSignUp;
        this.numberOfBooksPerDay = numberOfBooksPerDay;
    }

    public List<Book> initializeBasedOnNumberOfBooks(int num){
            return new ArrayList<>();
    }

 

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }

    @Override
    public String toString() {
        return "Library [bookList=" + bookList + ", libName=" + libName + ", numberOfBooksPerDay=" + numberOfBooksPerDay
                + ", numberOfDaysForSignUp=" + numberOfDaysForSignUp + "]";
    }




    
}