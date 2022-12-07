package com.london.tour.util;

/**
 * created by Diluni
 * on 12/7/2022
 */
public enum AttractionType {
    PARK("Park"),
    MUSEUM("Museum"),
    THEATRE("Theatre");

    String value;

    AttractionType(String value) {
        this.value = value;
    }
}
