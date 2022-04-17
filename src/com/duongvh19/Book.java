package com.duongvh19;

public class Book {

    private String name;
    private String author;
    private int count;

    public Book(String name, String author, int count) {
        this.name = name;
        this.author = author;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Book: " +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count ;
    }

    // equals - name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;

        if (this.name.equals((book.name))) {
            return true;
        }
        return false;
    }

    //hashCode - name
    @Override
    public int hashCode() {
        return this.name.hashCode() * 31;
    }
}
