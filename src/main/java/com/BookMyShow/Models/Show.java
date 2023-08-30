package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity(name = "MShow")
public class Show extends  BaseModel{
    private Date StartTime;
    private Date EndTime;
    @ManyToOne
    private Movie movie;
    @OneToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature>features;
    @ManyToMany
    private List<ShowSeat>showSeats;
}
