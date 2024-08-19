package com.Rajesh.SpringSecure.services;

import com.Rajesh.SpringSecure.model.Book;
import com.Rajesh.SpringSecure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String title, String author, String genre, Double minRating, Double minPrice, Double maxPrice) {
        return bookRepository.findByTitleContaining(title);
    }

    public List<Book> getNewArrivals() {
        // Logic to fetch new arrivals (e.g., books added in the last 30 days)
        Date currentDate = new Date();
        Date thirtyDaysAgo = new Date(currentDate.getTime() - (30L * 24 * 60 * 60 * 1000));
        return bookRepository.findByPublicationDateBetween(thirtyDaysAgo, currentDate);
    }

    public List<Book> getBestSellers() {
        // Logic to fetch bestsellers (e.g., books with high ratings or high sales)
        return bookRepository.findByRatingGreaterThanEqual(4.5);
    }

    public Book getBookDetails(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
