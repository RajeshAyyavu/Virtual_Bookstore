package com.Rajesh.SpringSecure.services;
import com.Rajesh.SpringSecure.model.Book;
import com.Rajesh.SpringSecure.model.Cart;
import com.Rajesh.SpringSecure.model.User;
import com.Rajesh.SpringSecure.repository.BookRepository;
import com.Rajesh.SpringSecure.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;

    public Cart getCartByUser(User user) {
        return cartRepository.findByUser(user);
    }

    public Cart addToCart(User user, Long bookId) {
        Cart cart = cartRepository.findByUser(user);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
        }
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            cart.getBooks().add(book);
            cart.setTotalPrice(cart.getBooks().stream().mapToDouble(Book::getPrice).sum());
        }
        return cartRepository.save(cart);
    }

    public Cart removeFromCart(User user, Long bookId) {
        Cart cart = cartRepository.findByUser(user);
        if (cart != null) {
            cart.getBooks().removeIf(book -> book.getId().equals(bookId));
            cart.setTotalPrice(cart.getBooks().stream().mapToDouble(Book::getPrice).sum());
            return cartRepository.save(cart);
        }
        return null;
    }

    public Cart updateCartQuantity(User user, Long bookId, int quantity) {
        Cart cart = cartRepository.findByUser(user);
        if (cart != null) {
            Book book = bookRepository.findById(bookId).orElse(null);
            if (book != null && quantity > 0) {
                // Implement logic to update quantity
            }
            cart.setTotalPrice(cart.getBooks().stream().mapToDouble(Book::getPrice).sum());
            return cartRepository.save(cart);
        }
        return null;
    }
}
