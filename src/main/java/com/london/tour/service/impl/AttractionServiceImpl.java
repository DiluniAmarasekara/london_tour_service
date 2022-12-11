package com.london.tour.service.impl;

import com.london.tour.entity.Attraction;
import com.london.tour.repository.AttractionRepository;
import com.london.tour.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * created by Diluni
 * on 11/28/2022
 */
@Service
public class AttractionServiceImpl implements AttractionService {
    @Autowired
    private AttractionRepository attractionRepository;

    @Override
    @Transactional
    public Boolean createAttraction(Attraction attraction) {
        Attraction newAttraction = new Attraction(attraction.getAttractionName(), attraction.getAttractionType(),
                attraction.getOpeningHours(), attraction.getClosingHours(), attraction.getPrice());
        attractionRepository.saveAndFlush(newAttraction);
        return Boolean.TRUE;
    }

    @Override
    public List<Attraction> viewAttractions() {
        return attractionRepository.findAll();
    }

    @Override
    @Transactional
    public Boolean updateAttraction(Attraction attraction) {
        Optional<Attraction> attractionObj = attractionRepository.findById(attraction.getAttractionId());
        if (attractionObj.isPresent()) {
            if (attraction.getAttractionName() != null) {
                attractionObj.get().setAttractionName(attraction.getAttractionName());
            }
            if (attraction.getOpeningHours() != null) {
                attractionObj.get().setOpeningHours(attraction.getOpeningHours());
            }
            if (attraction.getClosingHours() != null) {
                attractionObj.get().setClosingHours(attraction.getClosingHours());
            }
            if (attraction.getPrice() != null) {
                attractionObj.get().setPrice(attraction.getPrice());
            }
            attractionRepository.saveAndFlush(attractionObj.get());
            return true;
        } else return false;
    }

    @Override
    @Transactional
    public Boolean deleteAttraction(Integer attractionId) {
        Optional<Attraction> attractionObj = attractionRepository.findById(attractionId);
        if (attractionObj.isPresent()) {
            attractionRepository.delete(attractionObj.get());
            return true;
        } else return false;
    }

    @Override
    public List<Attraction> viewFilteredAttractions() {
        List<Attraction> attractions = attractionRepository.findAllByOpeningHoursGreaterThanEqualAndPriceLessThan(1900, 5.00);
        return attractions;
    }
}