package com.Rajesh.SpringSecure.controller;
import com.Rajesh.SpringSecure.model.Book;
import com.Rajesh.SpringSecure.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Double minRating,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return bookService.searchBooks(title, author, genre, minRating, minPrice, maxPrice);
    }

    @GetMapping("/new-arrivals")
    public List<Book> getNewArrivals() {
        return bookService.getNewArrivals();
    }

    @GetMapping("/best-sellers")
    public List<Book> getBestSellers() {
        return bookService.getBestSellers();
    }

    @GetMapping("/{id}")
    public Book getBookDetails(@PathVariable Long id) {
        return bookService.getBookDetails(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
