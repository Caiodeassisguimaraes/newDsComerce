package com.devsuperior.newdscomerce.services;

import com.devsuperior.newdscomerce.dto.ProductDto;
import com.devsuperior.newdscomerce.entities.Product;
import com.devsuperior.newdscomerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public Page<ProductDto> findAll(Pageable pageable){
        Page<Product> result = repositoty.findAll(pageable);
        return result.map(registry -> new ProductDto(registry));
    }

    @Transactional
    public ProductDto insert(ProductDto dto){
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
        entity = repositoty.save(entity);
        return new ProductDto(entity);
    }

}
