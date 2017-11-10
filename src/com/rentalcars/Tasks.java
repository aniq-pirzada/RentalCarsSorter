package com.rentalcars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tasks {

    public static String listCarsAscending(List<Vehicle> listOfCars) {
        ArrayList<String> response = new ArrayList<>();
        response.add("---------- Task 1 ----------\n");

        Comparator<Vehicle> priceComparator = new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle firstVehicle, Vehicle secondVehicle) {
                return Double.compare(firstVehicle.getPrice(), secondVehicle.getPrice());
            }
        };

        listOfCars.sort(priceComparator);
        response.add(String.format("%24s %2s %5s \n", "Vehicle Name", " ", "Price"));

        for (int i = 0; i < listOfCars.size(); i++) {
            response.add(String.format("%2d. %20s %2s %.2f \n", i + 1, listOfCars.get(i).getName(), "-", listOfCars.get(i).getPrice()));
        }

        return response.toString()
                .replace(",", "")                   //remove the commas
                .replace("[", "")                   //remove the right bracket
                .replace("]", "");                  //remove the left bracket;
    }

    public static String listSpecification(List<Vehicle> listOfCars) {
        ArrayList<String> response = new ArrayList<>();
        response.add("---------- Task 2 ----------\n");
        response.add(String.format("%3s %20s   %4s   %15s   %15s   %15s   %15s\n", " ", "Vehicle Name", "SSIP", "Car Type", "Doors/Car Type", "Transmission", "Fuel/Air Con"));

        for (int i = 0; i < listOfCars.size(); i++) {
            String sipp = listOfCars.get(i).getSipp();
            String carType = listOfCars.get(i).getCarType(sipp.charAt(0));
            String doors = listOfCars.get(i).getCarDoors(sipp.charAt(1));
            String transmission = listOfCars.get(i).getTransmission(sipp.charAt(2));
            String fuel = listOfCars.get(i).getFuel(sipp.charAt(3));

            response.add(String.format("%2d. %20s - %4s - %15s - %15s - %15s - %15s \n", i + 1, listOfCars.get(i).getName(), sipp, carType, doors, transmission, fuel));
        }

        return response.toString()
                .replace(",", "")                   //remove the commas
                .replace("[", "")                   //remove the right bracket
                .replace("]", "");                  //remove the left bracket;
    }

    public static String bestSupplierPerTypeDescending(List<Vehicle> listOfCars) {
        ArrayList<String> response = new ArrayList<>();
        response.add("---------- Task 3 ----------\n");

        Comparator<Vehicle> ratingComparator = new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle firstVehicle, Vehicle secondVehicle) {
                return Double.compare(firstVehicle.getRating(), secondVehicle.getRating());
            }
        };
        listOfCars.sort(ratingComparator.reversed());

        char[] carTypes = {'M', 'E', 'C', 'I', 'S', 'F', 'P', 'L', 'X'};
        response.add(String.format("%3s %20s   %15s   %10s   %6s\n", "", "Vehicle Name", "Car Type", "Supplier", "Rating"));

        int counter = 1;
        for (char carTypeIndex : carTypes) {
            for (int car = 0; car < listOfCars.size(); car++) {
                if (carTypeIndex == listOfCars.get(car).getSipp().charAt(0)) {
                    response.add(String.format("%2d. %20s - %15s - %10s - %.1f \n", counter, listOfCars.get(car).getName(),
                            Vehicle.getCarType(carTypeIndex), listOfCars.get(car).getSupplier(), listOfCars.get(car).getRating()));
                    counter++;
                    break;
                }
            }
        }
        return response.toString()
                .replace(",", "")                   //remove the commas
                .replace("[", "")                   //remove the right bracket
                .replace("]", "");                  //remove the left bracket;
    }

    public static String listScores(List<Vehicle> listOfCars) {
        ArrayList<String> response = new ArrayList<>();
        response.add("---------- Task 4 ----------\n");

        for (Vehicle vehicle : listOfCars) {
            int score = 0;

            String sipp = vehicle.getSipp();
            if (sipp.charAt(2) == 'M') {
                score += 1;
            } else if (sipp.charAt(2) == 'A') {
                score += 5;
            }

            if (sipp.charAt(3) == 'R') {
                score += 2;
            }
            vehicle.setVehicleScore(score);
        }

        Comparator<Vehicle> scoreRatingComparator = new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle firstVehicle, Vehicle secondVehicle) {
                return Double.compare(firstVehicle.getRating() + firstVehicle.getVehicleScore(), secondVehicle.getRating() + secondVehicle.getVehicleScore());
            }
        };
        listOfCars.sort(scoreRatingComparator.reversed());

        response.add(String.format("%3s %20s %10s %10s %10s\n", "", "Vehicle Name", "Vehicle Score", "Supplier Rating", "Sum of Scores"));
        for (int i = 0; i < listOfCars.size(); i++) {
            double total = listOfCars.get(i).getVehicleScore() + listOfCars.get(i).getRating();
            response.add(String.format("%2d. %20s - %10d - %10.1f - %10.1f\n", i + 1, listOfCars.get(i).getName(), listOfCars.get(i).getVehicleScore(), listOfCars.get(i).getRating(), total));
        }

        return response.toString()
                .replace(",", "")                   //remove the commas
                .replace("[", "")                   //remove the right bracket
                .replace("]", "");                  //remove the left bracket;
    }


}
