package com.BookMyShow.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private Long Id;
    private String Name;
    private  String Email;
    private String Password;
}
