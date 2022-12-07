package com.london.tour.entity;
import com.london.tour.entity.attraction.Attraction;

import javax.persistence.*;
import java.util.Set;

/**
 * created by Diluni
 * on 12/7/2022
 */
@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tourId;

    private String tourDate;

    private Integer noOfPeople;

    private Double totalPrice;

    public Tour() {
    }

    public Tour(String tourDate, Integer noOfPeople) {
        this.tourDate = tourDate;
        this.noOfPeople = noOfPeople;
    }

    /**
     * Many-to-many relationship
     */
    @ManyToMany
    @JoinTable(name = "tour_attraction", joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "attraction_id"))
    private Set<Attraction> assignedAttractions;

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public String getTourDate() {
        return tourDate;
    }

    public void setTourDate(String tourDate) {
        this.tourDate = tourDate;
    }

    public Integer getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Attraction> getAssignedAttractions() {
        return assignedAttractions;
    }

    public void setAssignedAttractions(Set<Attraction> assignedAttractions) {
        this.assignedAttractions = assignedAttractions;
    }
}
