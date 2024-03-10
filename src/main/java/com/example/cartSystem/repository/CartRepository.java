package com.example.cartSystem.repository;

import com.example.cartSystem.domain.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Carts, Long> {
}
