package com.devsuperior.newdscomerce.controllers;

import com.devsuperior.newdscomerce.dto.UserDto;
import com.devsuperior.newdscomerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDto> getMe(){
        UserDto dto = service.getMe();
        return ResponseEntity.ok(dto);
    }
}
