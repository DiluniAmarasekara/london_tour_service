package com.london.tour.entity.attraction;

import com.london.tour.util.AttractionType;

/**
 * created by Diluni
 * on 12/7/2022
 */
public class Theatre extends Attraction {
    public Theatre() {
    }

    public Theatre(String attractionName, Integer openingHours, Integer closingHours, Double price) {
        super(attractionName, openingHours, closingHours, price);
        this.attractionType = AttractionType.THEATRE;
    }
}
