package com.london.tour;

import com.london.tour.config.InputConfig;
import com.london.tour.entity.Attraction;
import com.london.tour.service.AttractionService;
import com.london.tour.util.AttractionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@SpringBootApplication
public class TourApplication implements CommandLineRunner {

    @Autowired
    private InputConfig inputConfig;

    @Autowired
    private AttractionService attractionService;

    public static void main(String[] args) {
        SpringApplication.run(TourApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mainLoop:
        while (true) {
            Integer menu = inputConfig.displayMainMenu();
            switch (menu) {
                case 1:
                    addAttraction();
                    break;
                case 2:
                    updateAttraction();
                    break;
                case 3:
                    printAllAttractions();
                    break;
                case 4:
                    deleteAttraction();
                    break;
                case 5:
                    printFilteredAttractions();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice again >>>>");
            }
        }
    }

    private void addAttraction() {
        Attraction attraction = inputConfig.inputCreateObj();
        Boolean status = attractionService.createAttraction(attraction);
        System.out.println(status ? "Attraction has been added!" : "Attraction adding has been failed!");
    }

    private void updateAttraction() {
        Attraction attraction = inputConfig.inputUpdateObj();
        Boolean status = attractionService.updateAttraction(attraction);
        System.out.println(status ? "Attraction has been updated!" : "Attraction updating has been failed!");
    }

    private void deleteAttraction() {
        Integer attractionId = inputConfig.inputDeleteObjId();
        Boolean status = attractionService.deleteAttraction(attractionId);
        System.out.println(status ? "Attraction has been deleted!" : "Attraction deleting has been failed!");
    }

    private void printAllAttractions() {
        List<Attraction> attractionList = attractionService.viewAttractions();
        System.out.println("Attraction Id, Attraction Type, Attraction Name, Entrance Price, Opening Hour, Closing Hour");
        attractionList.forEach(attraction -> {
            System.out.println(attraction.getAttractionId() + " >>>> " + attraction.getAttractionType().name() + " >>>> " + attraction.getAttractionName() + " >>>> " + attraction.getPrice() + " >>>> " + attraction.getOpeningHours() + " >>>> " + attraction.getClosingHours());
        });
    }

    private void printFilteredAttractions() {
        System.out.println("*****************************************************");
        System.out.println("Attractions which open after 7PM and price less than 5£");
        List<Attraction> attractionList = attractionService.viewFilteredAttractions();
        Map<AttractionType, List<Attraction>> attractionMap = attractionList.stream().collect(groupingBy(Attraction::getAttractionType));
        attractionMap.forEach((attractionType, attractions) -> {
            System.out.println("*****************************************************");
            System.out.println("Attraction Type: " + attractionType.name());
            System.out.println("Attraction Id, Attraction Name, Entrance Price, Opening Hour, Closing Hour");
            attractions.forEach(attraction -> {
                System.out.println(attraction.getAttractionId() + " >>>> " + attraction.getAttractionName() + " >>>> " + attraction.getPrice() + " >>>> " + attraction.getOpeningHours() + " >>>> " + attraction.getClosingHours());
            });
        });
    }
}
