package org.example;

public class Book extends Product {


    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    private String Author;

    private String name;

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.Author = author;
    }
}
