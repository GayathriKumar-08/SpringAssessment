package com.assessment.assessment.Service;

import java.util.ArrayList;
import java.util.List;

import com.assessment.assessment.Model.Book;
import com.assessment.assessment.Repository.Bookrepo;

import org.springframework.stereotype.Service;

@Service
public class BookServices
{
public Bookrepo booksRepository;

public List<Book> getAllBooks() 
{
List<Book> books = new ArrayList<Book>();
booksRepository.findAll().forEach(books1 -> books.add(books1));
return books;
}

public Book getBooksById(int bookid) 
{
return booksRepository.findById(bookid).get();
}

public void saveOrUpdate(Book books) 
{
booksRepository.save(books);
}

public void delete(int bookid) 
{
booksRepository.deleteById(bookid);
}

public void update(Book books, int bookid) 
{
booksRepository.save(books);
}

public Book getByAuthor(String author)
{
    Book b= booksRepository.getByAuthor(author);
    return b;
    
}
}