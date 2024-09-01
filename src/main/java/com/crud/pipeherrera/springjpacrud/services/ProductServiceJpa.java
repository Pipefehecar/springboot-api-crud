package com.crud.pipeherrera.springjpacrud.services;

import com.crud.pipeherrera.springjpacrud.entities.Product;
import com.crud.pipeherrera.springjpacrud.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceJpa implements ProductService{


    @Autowired
    private ProductRepository repository;

    @Transactional
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }
    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = repository.findById(id);
        if (productOptional.isEmpty()) {
            return Optional.empty();
        }
        Product productDb = productOptional.get();
        productDb.setName(product.getName());
        productDb.setPrice(product.getPrice());
        productDb.setDescription(product.getDescription());
        return Optional.of(repository.save(productDb));
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productOptional = repository.findById(id);
        productOptional.ifPresent(repository::delete);
        return productOptional;
    }

}
