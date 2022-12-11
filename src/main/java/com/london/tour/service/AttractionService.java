package com.london.tour.service;

import com.london.tour.entity.attraction.Attraction;

import java.util.List;

/**
 * created by Diluni
 * on 11/28/2022
 */
public interface AttractionService {
    Boolean createAttraction(Attraction attraction);

    List<Attraction> viewAttractions();

    Attraction findByAttractionId(Integer attractionId);
}
