package com.weltio.demo.controller;

import com.weltio.demo.dto.AuthenticationRequest;
import com.weltio.demo.dto.UserLoginRequest;
import com.weltio.demo.exception.DataAlreadyExistException;
import com.weltio.demo.exception.InvalidCredentialsException;
import com.weltio.demo.exception.NotFoundException;
import com.weltio.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping("/singup")
    public ResponseEntity<?> register(@Valid @RequestBody AuthenticationRequest userDto) throws DataAlreadyExistException {
        return new ResponseEntity<>(userService.save(userDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginRequest user) throws InvalidCredentialsException, NotFoundException {
        return new ResponseEntity<>(userService.authenticate(user),HttpStatus.OK);
    }
}
