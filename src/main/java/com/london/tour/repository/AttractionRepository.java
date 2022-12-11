package com.london.tour.repository;

import com.london.tour.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by Diluni
 * on 11/28/2022
 */
@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Integer> {
    List<Attraction> findAllByOpeningHoursGreaterThanAndPriceLessThan(Integer openingHours, Double price);
}
