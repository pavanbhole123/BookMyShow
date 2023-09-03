package com.BookMyShow.DTO;

import com.BookMyShow.Models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    private String Name;
    private  String Email;
    private  Long Id;
    private List<Ticket>tickets;
    private int responseCode;
    private  String responseMesseage;
}
