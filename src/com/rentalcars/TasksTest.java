package com.rentalcars;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class TasksTest {

    @Test
    public void listCarsAscendingPriceTest() {
        Vehicle v1 = new Vehicle("", "Vehicle 1", 10.00, "", 0.0);
        Vehicle v2 = new Vehicle("", "Vehicle 2", 10.01, "", 0.0);
        Vehicle v3 = new Vehicle("", "Vehicle 3", 9.99, "", 0.0);
        Vehicle v4 = new Vehicle("", "Vehicle 4", 10.00, "", 0.0);

        List<Vehicle> listOfCars = new ArrayList<>();
        listOfCars.add(v1);
        listOfCars.add(v2);
        listOfCars.add(v3);
        listOfCars.add(v4);

        String result = Tasks.listCarsAscending(listOfCars);
        String expectedOutput = ("---------- Task 1 ----------\n" +
                String.format("%25s %2s %5s \n", "Vehicle Name", " ", "Price") +
                "  1.            Vehicle 3  - 9.99 \n" +
                "  2.            Vehicle 1  - 10.00 \n" +
                "  3.            Vehicle 4  - 10.00 \n" +
                "  4.            Vehicle 2  - 10.01 \n");

        assertEquals(expectedOutput, result);

    }

    @Test
    public void listSpecificationTest() {
        Vehicle v1 = new Vehicle("MBMN", "vehicle 1", 0.0, "", 0.0);
        Vehicle v2 = new Vehicle("ECAR", "vehicle 2", 0.0, "", 0.0);
        Vehicle v3 = new Vehicle("XVAR", "vehicle 3", 0.0, "", 0.0);

        List<Vehicle> listOfCars = new ArrayList<>();
        listOfCars.add(v1);
        listOfCars.add(v2);
        listOfCars.add(v3);

        String result = Tasks.listSpecification(listOfCars);
        String expectedOutput = ("---------- Task 2 ----------\n" +
                String.format("%3s %21s   %4s   %15s   %15s   %15s   %15s\n", " ", "Vehicle Name", "SSIP", "Car Type", "Doors/Car Type", "Transmission", "Fuel/Air Con") +
                "  1.            vehicle 1 - MBMN -            Mini -         2 doors -          Manual -    Petrol/no AC \n" +
                "  2.            vehicle 2 - ECAR -         Economy -         4 doors -       Automatic -       Petrol/AC \n" +
                "  3.            vehicle 3 - XVAR -         Special -   Passenger Van -       Automatic -       Petrol/AC \n");


        assertEquals(expectedOutput, result);
    }

    @Test
    public void bestSupplierPerTypeDescendingTest() {
        Vehicle v1 = new Vehicle("MBMN", "vehicle 1", 0.0, "", 1.0);
        Vehicle v2 = new Vehicle("ECAR", "vehicle 2", 0.0, "", 2.0);
        Vehicle v3 = new Vehicle("XVAR", "vehicle 3", 0.0, "", 1.0);
        Vehicle v4 = new Vehicle("XVAR", "vehicle 4", 0.0, "", 0.9);

        List<Vehicle> listOfCars = new ArrayList<>();
        listOfCars.add(v1);
        listOfCars.add(v2);
        listOfCars.add(v3);

        String result = Tasks.bestSupplierPerTypeDescending(listOfCars);
        String expectedOutput = ("---------- Task 3 ----------\n" +
                String.format("%3s %21s   %15s   %10s   %6s\n", "", "Vehicle Name", "Car Type", "Supplier", "Rating") +
                "  1.            vehicle 1 -            Mini -            - 1.0 \n" +
                "  2.            vehicle 2 -         Economy -            - 2.0 \n" +
                "  3.            vehicle 3 -         Special -            - 1.0 \n");

        assertEquals(expectedOutput, result);
    }

    @Test
    public void listScoresTest() {
        Vehicle v1 = new Vehicle("XXAX", "vehicle 1", 0.0, "", 1.0);
        Vehicle v2 = new Vehicle("XXXX", "vehicle 2", 0.0, "", 6.1);

        List<Vehicle> listOfCars = new ArrayList<>();
        listOfCars.add(v1);
        listOfCars.add(v2);

        String result = Tasks.listScores(listOfCars);
        String expectedOutput = ("---------- Task 4 ----------\n" +
                String.format("%3s %21s %10s %10s %10s\n", "", "Vehicle Name", "Vehicle Score", "Supplier Rating", "Sum of Scores") +
                "  1.            vehicle 2 -          0 -        6.1 -        6.1\n" +
                "  2.            vehicle 1 -          5 -        1.0 -        6.0\n");

        assertEquals(expectedOutput, result);
    }
}
