package com.london.tour.entity;

import com.london.tour.util.AttractionType;

/**
 * created by Diluni
 * on 12/7/2022
 */
public class Museum extends Attraction {
    public Museum() {
    }

    public Museum(String attractionName, Integer openingHours, Integer closingHours, Double price) {
        super(attractionName, openingHours, closingHours);
        this.price = price.equals(null) || price == null ? 0.0 : price;
        this.attractionType = AttractionType.MUSEUM;
    }
}
