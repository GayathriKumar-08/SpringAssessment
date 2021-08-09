package com.assessment.assessment.Controller;
import java.util.List;

import com.assessment.assessment.Model.Book;
import com.assessment.assessment.Repository.Bookrepo;
import com.assessment.assessment.Service.BookServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private Bookrepo brepo;
    @Autowired
    private BookServices bServices;
    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> submitData(@RequestBody Book book) {
        System.out.println("Insertion method!!!");
        System.out.println(book);
        brepo.save(book);
        System.out.println("Book Details:" + book);
        System.out.println("Successfully inserterd");
        return new ResponseEntity<Book>(book,HttpStatus.CREATED);
    }

    // @GetMapping(value="/book")
    // public String getBooks(@RequestParam String bookname) {
    //     return "Bookname:"+bookname;
    // }

    @GetMapping("/book")
    private List<Book> getAllBooks() 
    {
    return bServices.getAllBooks();
    }
    
    @GetMapping("/book/{bookid}")
    private Book getBooks(@PathVariable("bookid") int bookid) 
    {
    
    return bServices.getBooksById(bookid);
    }
    
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) 
    {
        bServices.delete(bookid);
    }
    
    @PostMapping("/books")
    private int saveBook(@RequestBody Book books) 
    {
        bServices.saveOrUpdate(books);
    return books.getBookid();
    }
    
    @PutMapping("/books")
    private Book update(@RequestBody Book books) 
    {
        bServices.saveOrUpdate(books);
    return books;
    }
    @GetMapping("/book/{author}")
    private Book getByAuthor(@PathVariable("author") String author) 
    {
    return bServices.getByAuthor(author);
    }
    
    
}
