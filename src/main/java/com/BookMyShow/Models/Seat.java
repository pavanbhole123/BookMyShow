package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private int row;
    private int col;
    private int seatNumber;
    @ManyToOne
    private SeatType seatType;
}
