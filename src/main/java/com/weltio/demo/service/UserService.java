package com.weltio.demo.service;

import com.weltio.demo.dto.AuthenticationRequest;
import com.weltio.demo.dto.JwtTokenDto;
import com.weltio.demo.dto.UserLoginRequest;
import com.weltio.demo.exception.DataAlreadyExistException;
import com.weltio.demo.exception.InvalidCredentialsException;
import com.weltio.demo.exception.NotFoundException;

public interface UserService {
    public AuthenticationRequest save(AuthenticationRequest user) throws DataAlreadyExistException;
    public JwtTokenDto authenticate(UserLoginRequest user) throws NotFoundException, InvalidCredentialsException;
}
