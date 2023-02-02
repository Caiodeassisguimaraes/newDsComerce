package com.devsuperior.newdscomerce.controllers;

import com.devsuperior.newdscomerce.dto.ProductDto;
import com.devsuperior.newdscomerce.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
