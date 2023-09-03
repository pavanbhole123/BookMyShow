package com.BookMyShow.Controllers;

import com.BookMyShow.DTO.UserRequestDTO;
import com.BookMyShow.DTO.UserResponseDTO;
import com.BookMyShow.Models.User;
import com.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    public UserService userService;
    public UserResponseDTO signUp(UserRequestDTO userRequestDTO){
        User user;
        UserResponseDTO responseDTO = new UserResponseDTO();
        try {
            user = userService.signup(userRequestDTO.getName(),userRequestDTO.getEmail(),userRequestDTO.getPassword());
            responseDTO.setId(user.getId());
            responseDTO.setName(user.getName());
            responseDTO.setEmail(user.getEmail());
            responseDTO.setTickets(user.getTickets());
            responseDTO.setResponseCode(200);
            responseDTO.setResponseMesseage("Successful");
            return responseDTO;
        }
        catch (Exception e){
            responseDTO.setResponseCode(500);
            responseDTO.setResponseMesseage("Internal server Error");
            return responseDTO;
        }
    }
}
