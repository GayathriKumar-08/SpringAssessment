package com.assessment.assessment.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
  @Id
    @Column(name="id")
    private int bookid;
    @Column(name="bookname")
    private String bookname;
    @Column(name="author")
    private String author;
    public int getBookid() {
        return bookid;
    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Book(int bookid, String bookname, String author) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
    }
    public Book() {
    }
    @Override
    public String toString() {
        return "Book [author=" + author + ", bookid=" + bookid + ", bookname=" + bookname + "]";
    }

    
}
