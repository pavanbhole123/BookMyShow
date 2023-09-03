package com.BookMyShow.Service;

import com.BookMyShow.Models.User;
import com.BookMyShow.Repository.Exception.UserEmailNotFoundException;
import com.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;
    @Override
    public User login(String email, String paswword) {
        Optional<User>UserOptional = userRepository.finfByEmail(email);
        if(UserOptional.isEmpty()){
            throw new UserEmailNotFoundException("Given Email Not FOund");
        }
        User user = UserOptional.get();
        if(paswword.equals(user.getPassword())){
            return user;
        }
        else{
            throw new UserEmailNotFoundException("Password is incorrect");
        }
    }

    @Override
    public User signup(String Name, String Email, String Password) {
        Optional<User>userOptional = userRepository.finfByEmail(Email);
        if(!userOptional.isEmpty()){
            throw new UserEmailNotFoundException("Email is Already Exist");
        }
        User user = userOptional.get();
        user.setEmail(Email);
        user.setName(Name);
        user.setPassword(Password);
        return userRepository.save(user);
    }

}
