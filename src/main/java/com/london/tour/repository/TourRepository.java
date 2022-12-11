package com.london.tour.repository;

import com.london.tour.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by Diluni
 * on 11/29/2022
 */
@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
}
