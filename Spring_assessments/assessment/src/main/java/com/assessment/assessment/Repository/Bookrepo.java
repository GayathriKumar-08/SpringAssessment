package com.assessment.assessment.Repository;

import java.util.Optional;

import com.assessment.assessment.Model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepo extends JpaRepository<Book,Long> {

    Optional<Book> findById(int bookid);

    void deleteById(int bookid);

    Book getByAuthor(String author);

    // void deleteById(int bookid);
}
