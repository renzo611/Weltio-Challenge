package com.weltio.demo.service.impl;

import com.weltio.demo.dto.AuthenticationRequest;
import com.weltio.demo.dto.AuthenticationResponse;
import com.weltio.demo.dto.JwtTokenDto;
import com.weltio.demo.dto.UserLoginRequest;
import com.weltio.demo.exception.DataAlreadyExistException;
import com.weltio.demo.exception.InvalidCredentialsException;
import com.weltio.demo.exception.NotFoundException;
import com.weltio.demo.mapper.UserMapper;
import com.weltio.demo.model.Users;
import com.weltio.demo.repository.UserRepository;
import com.weltio.demo.security.filter.JwtTokenUtil;
import com.weltio.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public AuthenticationResponse save(AuthenticationRequest userDto) throws DataAlreadyExistException {
        if(userRepository.existsByEmail(userDto.getEmail())){
            throw new DataAlreadyExistException("Email already exist.");}
        Users user = AuthenticationRequest.mapToEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return UserMapper.mapToDto(userRepository.save(user));
    }

    @Override
    public JwtTokenDto authenticate(UserLoginRequest userDto) throws NotFoundException, InvalidCredentialsException {
        Users user = userRepository.findByEmail(userDto.getEmail());
        if(user == null) {
            throw new NotFoundException("The user doesn't exist");
        }else if(!passwordEncoder.matches(userDto.getPassword(),user.getPassword())){
            throw new InvalidCredentialsException("The data entered is invalid.");
        }
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), userDto.getPassword()));
       return generateToken(auth);
    }

    @Override
    public JwtTokenDto generateToken(Authentication auth) {
        UserDetails userDetails;
        userDetails = (UserDetails) auth.getPrincipal();
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return new JwtTokenDto(jwt);
    }


}
