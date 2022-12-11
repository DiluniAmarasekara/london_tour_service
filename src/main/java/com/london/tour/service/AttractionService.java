package com.london.tour.service;

import com.london.tour.entity.Attraction;

import java.util.List;

/**
 * created by Diluni
 * on 11/28/2022
 */
public interface AttractionService {
    Boolean createAttraction(Attraction attraction);

    List<Attraction> viewAttractions();

    Boolean updateAttraction(Attraction attraction);

    Boolean deleteAttraction(Integer attractionId);

    List<Attraction> viewFilteredAttractions();
}
