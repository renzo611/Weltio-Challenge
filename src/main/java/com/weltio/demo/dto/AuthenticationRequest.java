package com.weltio.demo.dto;

import com.weltio.demo.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6,message = "The password must be at least 6 characters long")
    private String password;
    @NotBlank(message = "Name is mandatory")
    private String name;

    public static AuthenticationRequest mapToDto(Users user){
        AuthenticationRequest userDto = new AuthenticationRequest();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
    public static Users mapToEntity(AuthenticationRequest userDto){
        Users users = new Users();
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        return users;
    }
}
