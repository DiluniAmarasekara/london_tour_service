package com.london.tour;

import com.london.tour.config.InputConfig;
import com.london.tour.entity.Tour;
import com.london.tour.entity.attraction.Attraction;
import com.london.tour.service.AttractionService;
import com.london.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
@EntityScan( basePackages = {"com.london.tour"})
public class TourApplication implements CommandLineRunner {

	@Autowired
	private InputConfig inputConfig;

	@Autowired
	private AttractionService attractionService;

	@Autowired
	private TourService tourService;

	private Scanner sc = new Scanner(System.in);

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
					printAttractions();
					break;
				case 4:
					deleteAttraction();
					break;
				case 5:
					printTours();
					break;
				case 6:
					deleteTour();
					break;
				case 7:
					addTour();
					break;
				case 8:
					updateTour();
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
		Attraction attraction = inputConfig.createAttraction();
		Boolean status = attractionService.createAttraction(attraction);
	}

	private void updateAttraction() {
	}

	private void printAttractions() {
		List<Attraction> attractionList = attractionService.viewAttractions();
		System.out.println("Attraction Id, Attraction Name, Entrance Price, Opening Hour, Closing Hour");
		attractionList.forEach(attraction -> {
			System.out.println(attraction.getAttractionId() + " >>>> " + attraction.getAttractionName() + " >>>> " + attraction.getPrice() + " >>>> " + attraction.getOpeningHours() + " >>>> " + attraction.getClosingHours());
		});
	}

	private void deleteAttraction() {
	}

	private void printTours() {
		List<Tour> tourList = tourService.viewTours();
		tourList.forEach(tour -> {
			System.out.println("\nTour Id, Tour Date, No Of People, Total Price");
			System.out.println(tour.getTourId() + " >>>> " + tour.getTourDate() + " >>>> " + tour.getNoOfPeople() + " >>>> " + tour.getTotalPrice());
			System.out.println("Selected Places To Visit");
			System.out.println("Attraction Id, Attraction Name, Entrance Price, Opening Hour, Closing Hour");
			tour.getAssignedAttractions().forEach(attraction -> {
				System.out.println(attraction.getAttractionId() + " >>>> " + attraction.getAttractionName() + " >>>> " + attraction.getPrice() + " >>>> " + attraction.getOpeningHours() + " >>>> " + attraction.getClosingHours());
			});
		});
	}

	private void deleteTour() {
	}

	private void addTour() {
		Tour tour = inputConfig.createTour();
		System.out.println("Enter the Attraction Ids (1,2,3,4) >>>> ");
		String list= sc.nextLine();
		String input[] = list.trim().split(",");
		Set<Attraction> attractionList = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			Attraction attraction = new Attraction();
			attraction.setAttractionId(Integer.parseInt(input[i]));
			attractionList.add(attraction);
		}
		tour.setAssignedAttractions(attractionList);
		Boolean status = tourService.createTour(tour);
	}

	private void updateTour() {
	}

}
