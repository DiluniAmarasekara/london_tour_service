package com.london.tour.config;

import com.london.tour.entity.Attraction;
import com.london.tour.entity.Museum;
import com.london.tour.entity.Park;
import com.london.tour.entity.Theatre;
import com.london.tour.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

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
    private Scanner sc = new Scanner(System.in);

    public Integer displayMainMenu() {
        System.out.println("*****************************************************");
        System.out.println("************ Welcome to the London Tours ************");
        System.out.println("*****************************************************");
        System.out.println("Select your choice: ");
        System.out.println("Enter 1 to Add An Attraction");
        System.out.println("Enter 2 to Update An Attraction");
        System.out.println("Enter 3 to Print All The List Of Attractions");
        System.out.println("Enter 4 to Delete An Attraction");
        System.out.println("Enter 5 to Print All The Filtered Attractions");
        System.out.println("Enter 0 to Exit");
        System.out.println("*****************************************************");
        System.out.println("\nEnter your choice here >>>>");

        return sc.nextInt();
    }

    public Attraction inputCreateObj() {
        Integer type = displayAttractionSelect();
        System.out.println("*****************************************************");
        System.out.println("Enter the Name >>>>");
        String name = sc.next();
        System.out.println("Enter the Opening Hours (HH:mm) >>>>");
        String open = sc.next().replace(":", "");
        System.out.println("Enter the Closing Hours (HH:mm) >>>>");
        String close = sc.next().replace(":", "");
        System.out.println("Enter the Price Per Person in pounds (£, GBP) >>>>");
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

    public Attraction inputUpdateObj() {
        System.out.println("*****************************************************");
        System.out.println("Enter the Attraction ID >>>>");
        String id = sc.next();
        System.out.println("Enter the new Attraction Name (type - if not going to change) >>>>");
        String name = sc.next();
        System.out.println("Enter the new Opening Hours (HH:mm) (type - if not going to change) >>>>");
        String open = !sc.next().equals("-") ? sc.next().replace(":", "") : "-";
        System.out.println("Enter the Closing Hours (HH:mm) (type - if not going to change) >>>>");
        String close = !sc.next().equals("-") ? sc.next().replace(":", "") : "-";
        System.out.println("Enter the Price Per Person in pounds (£, GBP) (type - if not going to change) >>>>");
        String price = sc.next();

        Attraction attraction = new Attraction(Integer.parseInt(id), name, !open.equals("-") ? Integer.parseInt(open) : null,
                !close.equals("-") ? Integer.parseInt(close) : null, !price.equals("-") ? Double.valueOf(price) : null);
        return attraction;
    }

    public Integer inputDeleteObjId() {
        System.out.println("*****************************************************");
        System.out.println("Enter the Attraction ID >>>>");
        return sc.nextInt();
    }
}
