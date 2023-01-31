package com.devsuperior.newdscomerce.controllers;

import com.devsuperior.newdscomerce.dto.ProductDto;
import com.devsuperior.newdscomerce.entities.Product;
import com.devsuperior.newdscomerce.repositories.ProductRepository;
import com.devsuperior.newdscomerce.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService service;
    @GetMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Long id){
        /*ProductDto dto = service.findById(id)
        return dto;*/

        return service.findById(id);
    }

    @GetMapping
    public Page<ProductDto> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

}
