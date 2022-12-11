package com.london.tour.repository;

import com.london.tour.entity.attraction.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by Diluni
 * on 11/28/2022
 */
@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Integer> {
}
