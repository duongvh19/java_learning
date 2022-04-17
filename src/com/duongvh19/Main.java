package com.duongvh19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book("The Wind in the Willows", "Kenneth Grahame", 150);
        Book b2 = new Book("Lord of the Flies", "William Golding", 200);
        Book b3 = new Book("The Old Man and the Sea", "Ernest Hemingway", 250);
        Book b4 = new Book("Animal Farm", "George Orwell", 100);
        Book b5 = new Book("The Wind in the Willows", "Kenneth Grahame", 155);

        // add list
        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);

        System.out.println("=======================");
        System.out.println("List of books: ");
        int count = 0;
        for (Book b : books) {
            count ++;
            System.out.println(count + "-" + b.toString());
        }

        /* contains thuc chat la goi den equals.
        khi kiem tra trung name thi se contains se return true.
         */

        System.out.println("=======================");
        System.out.println("Check book in the books list");
        Book b6 = new Book("Animal Farm", "George Orwell", 120);
        if (books.contains(b6)) {
            System.out.println("The book is existing in the books list");
        }

        /* HashSet chi chua danh sach cac phan tu duy nhat
        su dung equals va hashcode de check dieu nay
        khi add tu dong check phan tu trung
        neu trung thi ko them
        neu ko su dung hashcode, cac gia tri trung van dc them.
         */

        System.out.println("=======================");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(b1);
        bookSet.add(b2);
        bookSet.add(b3);
        bookSet.add(b4);
        bookSet.add(b5);
        bookSet.add(b6);

        System.out.println(bookSet.size() + " book in the bookSet");
        for (Book b : bookSet) {
            System.out.println(b.toString());
        }
    }
}
