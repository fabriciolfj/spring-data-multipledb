package com.github.fabriciolfj.multipledb.api;

import com.github.fabriciolfj.multipledb.domain.entity.product.Product;
import com.github.fabriciolfj.multipledb.domain.entity.user.User;
import com.github.fabriciolfj.multipledb.domain.repository.product.ProductRepository;
import com.github.fabriciolfj.multipledb.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gen")
public class GenericController {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional("productTransactionManager")
    public void create(@RequestBody final Product product) {
        repository.save(product);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional("transactionManager")
    public void create(@RequestBody final User user) {
        userRepository.save(user);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllProducts() {
        return repository.findAll();
    }
}
