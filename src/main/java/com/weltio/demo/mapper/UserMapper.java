package com.weltio.demo.mapper;

import com.weltio.demo.dto.AuthenticationResponse;
import com.weltio.demo.model.Users;

public class UserMapper {
    public static AuthenticationResponse mapToDto(Users user){
        AuthenticationResponse u = new AuthenticationResponse();
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        return u;
    }
}
