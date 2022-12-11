package com.london.tour.entity;

import com.london.tour.util.AttractionType;

/**
 * created by Diluni
 * on 12/7/2022
 */
public class Park extends Attraction {
    public Park() {
    }

    public Park(String attractionName, Integer openingHours, Integer closingHours) {
        super(attractionName, openingHours, closingHours);
        this.price = 0.0;
        this.attractionType = AttractionType.PARK;
    }
}
