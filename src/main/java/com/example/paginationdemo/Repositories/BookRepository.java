package com.example.paginationdemo.Repositories;

import com.example.paginationdemo.Entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByAuthorContainingIgnoreCase(String author, Pageable pageable);

    @Query("SELECT b FROM Book b WHERE " +
            "(LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')) OR :title IS NULL) AND " +
            "(LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%')) OR :author IS NULL)")
    Page<Book> findByTitleAndAuthorContainingIgnoreCase(@Param("title") String title, @Param("author") String author, Pageable pageable);

}
