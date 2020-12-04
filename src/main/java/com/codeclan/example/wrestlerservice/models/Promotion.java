package com.codeclan.example.wrestlerservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="year_founded")
    private int yearFounded;

    @JsonIgnoreProperties({"promotion"})
    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Wrestler> wrestlers;

    public Promotion(String name, int yearFounded) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.wrestlers = new ArrayList<>();
    }

    public Promotion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public List<Wrestler> getWrestlers() {
        return wrestlers;
    }

    public void setWrestlers(List<Wrestler> wrestlers) {
        this.wrestlers = wrestlers;
    }
}
