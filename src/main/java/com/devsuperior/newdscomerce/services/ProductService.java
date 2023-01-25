package com.devsuperior.newdscomerce.services;

import com.devsuperior.newdscomerce.dto.ProductDto;
import com.devsuperior.newdscomerce.entities.Product;
import com.devsuperior.newdscomerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repositoty;
    @Transactional(readOnly = true)
    public ProductDto findById(Long id){
        /*Optional <Product> result = repositoty.findById(id);
        Product product = result.get();
        ProductDto dto = new ProductDto(product);
        return dto;*/

        Product product = repositoty.findById(id).get();
        return new ProductDto(product);

    }

}
