package com.weltio.demo.service.impl;

import com.weltio.demo.dto.AuthenticationRequest;
import com.weltio.demo.exception.DataAlreadyExistException;
import com.weltio.demo.repository.UserRepository;
import com.weltio.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthenticationRequest save(AuthenticationRequest user) throws DataAlreadyExistException {
        if(userRepository.existsByEmail(user.getEmail()))
            throw new DataAlreadyExistException("Email already exist.");
        return AuthenticationRequest.mapToDto(userRepository.save(AuthenticationRequest.mapToEntity(user)));
    }
}
