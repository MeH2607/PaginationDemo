package com.example.paginationdemo.ApiControllers;

    import com.example.paginationdemo.Entities.Book;
    import com.example.paginationdemo.Service.BookService;
    import lombok.Getter;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/books")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public class BookController {

        @Autowired
        private BookService bookService;

        @GetMapping
        public Page<Book> getAllBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author,Pageable pageable) {
            System.out.println("pageable = " + pageable); //Add a breakpoint here, and investigate the pageable instance
            return bookService.getAllBooks(title, author,pageable);
        }

    }

