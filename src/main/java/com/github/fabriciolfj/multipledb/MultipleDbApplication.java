package com.github.fabriciolfj.multipledb;

import com.github.fabriciolfj.multipledb.domain.entity.product.Product;
import com.github.fabriciolfj.multipledb.domain.entity.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackageClasses = {User.class, Product.class})
public class MultipleDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDbApplication.class, args);
	}

}
