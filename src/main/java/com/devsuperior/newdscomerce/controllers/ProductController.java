package com.devsuperior.newdscomerce.controllers;

import com.devsuperior.newdscomerce.dto.ProductDto;
import com.devsuperior.newdscomerce.entities.Product;
import com.devsuperior.newdscomerce.repositories.ProductRepository;
import com.devsuperior.newdscomerce.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<ProductDto> findById(@PathVariable Long id){
        /*ProductDto dto = service.findById(id)
        return dto;*/
        /*return service.findById(id);*/
        ProductDto dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> findAll(Pageable pageable){
        /*return service.findAll(pageable);*/
        Page<ProductDto> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> insert(@RequestBody ProductDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
