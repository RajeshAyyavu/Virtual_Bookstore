package com.Rajesh.SpringSecure.repository;
import com.Rajesh.SpringSecure.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByGenre(String genre);
    List<Book> findByRatingGreaterThanEqual(Double rating);
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Book> findByPublicationDateBetween(Date startDate, Date endDate);
}
