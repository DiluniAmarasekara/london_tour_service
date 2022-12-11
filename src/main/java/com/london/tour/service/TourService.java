package com.london.tour.service;

import com.london.tour.entity.Tour;

import java.util.List;

/**
 * created by Diluni
 * on 11/28/2022
 */
public interface TourService {
    Boolean createTour(Tour tour);

    List<Tour> viewTours();
}
