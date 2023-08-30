package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TShowSeat")
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    @ManyToOne
    private Seat seat;
    private Double price;

}
