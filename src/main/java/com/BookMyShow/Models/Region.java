package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Region extends BaseModel {
    private String name;
    @OneToMany
    private List<Theater>theaters;
}
