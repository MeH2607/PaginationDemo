package com.example.paginationdemo.Service;

import com.example.paginationdemo.Entities.Book;
import com.example.paginationdemo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getAllBooks(String title, String author, Pageable pageable) {

       return bookRepository.findByTitleAndAuthorContainingIgnoreCase(title,author,pageable);
    }
}
