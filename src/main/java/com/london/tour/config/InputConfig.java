package com.london.tour.config;

import com.london.tour.entity.Tour;
import com.london.tour.entity.attraction.Attraction;
import com.london.tour.entity.attraction.Museum;
import com.london.tour.entity.attraction.Park;
import com.london.tour.entity.attraction.Theatre;
import com.london.tour.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * created by Diluni
 * on 11/28/2022
 */
@Component
public class InputConfig {
    /**
     * This class allows user inputs and displays all the command line interface
     * System.out.println line blocks
     */

    @Autowired
    private AttractionService attractionService;

    private Scanner sc = new Scanner(System.in);

    public Integer displayMainMenu() {
        System.out.println("*****************************************************");
        System.out.println("************ Welcome to the London Tours ************");
        System.out.println("*****************************************************");
        System.out.println("\n****************** Admin Functions ******************");
        System.out.println("Select your choice: ");
        System.out.println("Enter 1 to Add An Attraction");
        System.out.println("Enter 2 to Update An Attraction");
        System.out.println("Enter 3 to Print The List Of Attractions");
        System.out.println("Enter 4 to Delete An Attraction");
        System.out.println("Enter 5 to Print The List Of Tours");
        System.out.println("Enter 6 to Delete A Tour");
        System.out.println("Enter 0 to Exit");
        System.out.println("*****************************************************");
        System.out.println("\n****************** User Functions ******************");
        System.out.println("Select your choice: ");
        System.out.println("Enter 3 to Print The List Of Attractions");
        System.out.println("Enter 7 to Add A Tour");
        System.out.println("Enter 8 to Update A Tour");
        System.out.println("Enter 5 to Print The List Of Tours");
        System.out.println("Enter 0 to Exit");
        System.out.println("*****************************************************");
        System.out.println("\nEnter your choice here >>>>");

        return sc.nextInt();
    }

    public Attraction createAttraction() {
        Integer type = displayAttractionSelect();
        System.out.println("*****************************************************");
        System.out.println("Enter the Name >>>>");
        String name = sc.next();
        System.out.println("Enter the Opening Hours >>>>");
        String open = sc.next();
        System.out.println("Enter the Closing Hours >>>>");
        String close = sc.next();
        System.out.println("Enter the Price Per Person >>>>");
        String price = sc.next();

        Attraction newAttraction = type.equals(1) ? new Park(name, Integer.parseInt(open), Integer.parseInt(close)) :
                type.equals(2) ? new Museum(name, Integer.parseInt(open), Integer.parseInt(close), Double.valueOf(price)) :
                        type.equals(3) ? new Theatre(name, Integer.parseInt(open), Integer.parseInt(close), Double.valueOf(price)) : null;
        return newAttraction;
    }

    private Integer displayAttractionSelect() {
        System.out.println("*****************************************************");
        System.out.println("Select the attraction type: ");
        System.out.println("Enter 1 for Park!");
        System.out.println("Enter 2 for Museum!");
        System.out.println("Enter 3 for Theatre!");
        System.out.println("*****************************************************");
        System.out.println("Enter your choice here >>>>");

        return sc.nextInt();
    }

    public Tour createTour() {
        System.out.println("*****************************************************");
        System.out.println("Enter the Date Of Tour (yyyy/mm/dd) >>>> ");
        String tempDate = sc.next();
        System.out.println("Enter the Number Of People >>>>");
        Integer noOfPeople = sc.nextInt();
        Tour newTour = new Tour(tempDate, noOfPeople);

        return setAttractions(newTour);
    }

    public Tour setAttractions(Tour tour) {
        System.out.println("Select the places you wish to visit: \n");

        List<Attraction> attractions = attractionService.viewAttractions();
        System.out.println("Attraction Id, Attraction Name, Entrance Price, Opening Hour, Closing Hour");
        attractions.forEach(attraction -> {
            System.out.println(attraction.getAttractionId() + " >>>> " + attraction.getAttractionName() + " >>>> " + attraction.getPrice() + " >>>> " + attraction.getOpeningHours() + " >>>> " + attraction.getClosingHours());
        });
        return tour;
    }
}
