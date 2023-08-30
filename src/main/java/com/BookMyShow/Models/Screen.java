package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @OneToOne
    private Show show;
    @ManyToOne
    private Theater theater;
    @OneToMany
    private List<Seat>seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private  List<Feature>features;
}
