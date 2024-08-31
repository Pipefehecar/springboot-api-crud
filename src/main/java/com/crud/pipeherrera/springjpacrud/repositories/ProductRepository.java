package com.crud.pipeherrera.springjpacrud.repositories;

import com.crud.pipeherrera.springjpacrud.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long>{
    
}
