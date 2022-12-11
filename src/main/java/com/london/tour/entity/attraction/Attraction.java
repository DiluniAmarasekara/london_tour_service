package com.london.tour.entity.attraction;
import com.london.tour.entity.Tour;
import com.london.tour.util.AttractionType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * created by Diluni
 * on 12/7/2022
 */
@Entity
public class Attraction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attractionId;

    protected String attractionName;

    @Enumerated(EnumType.ORDINAL)
    protected AttractionType attractionType;

    protected Integer openingHours;

    protected Integer closingHours;

    protected Double price;

    /**
     * Many-to-many relationship
     */
    @ManyToMany(mappedBy = "assignedAttractions")
    private Set<Tour> assignedTours = null;

    public Attraction() {
    }

    public Attraction(String attractionName, Integer openingHours, Integer closingHours) {
        this.attractionName = attractionName;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
    }

    public Attraction(String attractionName, Integer openingHours, Integer closingHours, Double price) {
        this.attractionName = attractionName;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.price = price;
    }

    public Integer getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(Integer attractionId) {
        this.attractionId = attractionId;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public AttractionType getAttractionType() {
        return attractionType;
    }

    public void setAttractionType(AttractionType attractionType) {
        this.attractionType = attractionType;
    }

    public Integer getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Integer openingHours) {
        this.openingHours = openingHours;
    }

    public Integer getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(Integer closingHours) {
        this.closingHours = closingHours;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Tour> getAssignedTours() {
        return assignedTours;
    }

    public void setAssignedTours(Set<Tour> assignedTours) {
        this.assignedTours = assignedTours;
    }
}
