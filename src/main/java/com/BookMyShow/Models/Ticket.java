package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends  BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToOne
    private User user;
    private  int amount;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> showSeat;
    @OneToMany
    private List<Payment>payments;
    private Date BookedAt;

}
