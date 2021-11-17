package com.weltio.demo.service;

import com.weltio.demo.dto.AuthenticationRequest;
import com.weltio.demo.dto.AuthenticationResponse;
import com.weltio.demo.dto.JwtTokenDto;
import com.weltio.demo.dto.UserLoginRequest;
import com.weltio.demo.exception.DataAlreadyExistException;
import com.weltio.demo.exception.InvalidCredentialsException;
import com.weltio.demo.exception.NotFoundException;
import org.springframework.security.core.Authentication;

public interface UserService {
    public AuthenticationResponse save(AuthenticationRequest user) throws DataAlreadyExistException;
    public JwtTokenDto authenticate(UserLoginRequest user) throws NotFoundException, InvalidCredentialsException;
    public JwtTokenDto generateToken(Authentication auth);
}
