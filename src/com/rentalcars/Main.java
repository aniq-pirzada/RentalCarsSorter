package com.rentalcars;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Vehicle> listOfCars = ReadJSON.read();
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter task number: ");
            int task = in.nextInt();

            switch (task) {
                case 1:
                    System.out.println(Tasks.listCarsAscending(listOfCars));
                    break;

                case 2:
                    System.out.println(Tasks.listSpecification(listOfCars));
                    break;

                case 3:
                    System.out.println(Tasks.bestSupplierPerTypeDescending(listOfCars));
                    break;

                case 4:
                    System.out.println(Tasks.listScores(listOfCars));
                    break;

                default:
                    System.out.println("Invalid Selection. (Please choose a number between 1-4)");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
