package com.BookMyShow.Service;

import com.BookMyShow.Models.User;

public interface UserService {
    User login(String email,String paswword);
    User signup(String Name,String Email,String Password);
}
