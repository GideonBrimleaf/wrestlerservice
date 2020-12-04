package com.codeclan.example.wrestlerservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="wrestlers")
public class Wrestler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="is_injured")
    private Boolean isInjured;

    @ManyToOne
    @JsonIgnoreProperties({"wrestlers"})
    @JoinColumn(name="promotion_id", nullable = false)
    private Promotion promotion;

    public Wrestler(String firstName, String lastName, int age, Boolean isInjured, Promotion promotion) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isInjured = isInjured;
        this.promotion = promotion;
    }

    public Wrestler() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getInjured() {
        return isInjured;
    }

    public void setInjured(Boolean injured) {
        isInjured = injured;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
