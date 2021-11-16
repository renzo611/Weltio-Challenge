package com.weltio.demo.service;

import com.weltio.demo.dto.AuthenticationRequest;
import com.weltio.demo.exception.DataAlreadyExistException;

public interface UserService {
    public AuthenticationRequest save(AuthenticationRequest user) throws DataAlreadyExistException;
}
