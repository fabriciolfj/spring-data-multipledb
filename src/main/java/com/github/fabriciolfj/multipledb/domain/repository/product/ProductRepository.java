package com.github.fabriciolfj.multipledb.domain.repository.product;

import com.github.fabriciolfj.multipledb.domain.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
