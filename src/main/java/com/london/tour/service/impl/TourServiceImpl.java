package com.london.tour.service.impl;

import com.london.tour.entity.Tour;
import com.london.tour.entity.attraction.Attraction;
import com.london.tour.repository.TourRepository;
import com.london.tour.service.AttractionService;
import com.london.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * created by Diluni
 * on 11/28/2022
 */
@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private AttractionService attractionService;

    @Override
    public Boolean createTour(Tour tour) {
        AtomicReference<Double> price = new AtomicReference<>(0.0);
        tour.getAssignedAttractions().forEach(attraction -> {
            Attraction detailAttraction = attractionService.findByAttractionId(attraction.getAttractionId());
            attraction.setAttractionName(detailAttraction.getAttractionName());
            attraction.setPrice(detailAttraction.getPrice());
            attraction.setOpeningHours(detailAttraction.getOpeningHours());
            attraction.setClosingHours(detailAttraction.getClosingHours());
            attraction.setAttractionType(detailAttraction.getAttractionType());
            price.set(price.get() + attraction.getPrice());
        });
        tour.setTotalPrice(tour.getNoOfPeople() * price.get());
        tourRepository.saveAndFlush(tour);

        return Boolean.TRUE;
    }

    @Override
    public List<Tour> viewTours() {
        return tourRepository.findAll();
    }
}
