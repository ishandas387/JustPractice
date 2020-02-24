package com.hashcode;

public class Book{
    
    private String bookNumber;
    private String bookScore;

    
    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookScore() {
        return bookScore;
    }

    public void setBookScore(String bookScore) {
        this.bookScore = bookScore;
    }

    public Book(String bookNumber, String bookScore) {
        this.bookNumber = bookNumber;
        this.bookScore = bookScore;
    }

    @Override
    public String toString() {
        return "Book [bookNumber=" + bookNumber + ", bookScore=" + bookScore + "]";
    }

    

}