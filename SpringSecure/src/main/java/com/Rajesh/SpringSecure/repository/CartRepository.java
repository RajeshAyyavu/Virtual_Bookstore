package com.Rajesh.SpringSecure.repository;

import com.Rajesh.SpringSecure.model.Cart;
import com.Rajesh.SpringSecure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
