package com.Rajesh.SpringSecure.controller;
import com.Rajesh.SpringSecure.model.Cart;
import com.Rajesh.SpringSecure.model.User;
import com.Rajesh.SpringSecure.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public Cart getCart(Principal principal) {
        // Assuming Principal is used for authentication, fetch user by username
        // User user = userService.findByUsername(principal.getName());
        User user = new User(); // Placeholder for actual user fetching logic
        return cartService.getCartByUser(user);
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long bookId, Principal principal) {
        User user = new User(); // Placeholder for actual user fetching logic
        return cartService.addToCart(user, bookId);
    }

    @PostMapping("/remove")
    public Cart removeFromCart(@RequestParam Long bookId, Principal principal) {
        User user = new User(); // Placeholder for actual user fetching logic
        return cartService.removeFromCart(user, bookId);
    }

    @PostMapping("/update")
    public Cart updateCartQuantity(@RequestParam Long bookId, @RequestParam int quantity, Principal principal) {
        User user = new User(); // Placeholder for actual user fetching logic
        return cartService.updateCartQuantity(user, bookId, quantity);
    }
}
