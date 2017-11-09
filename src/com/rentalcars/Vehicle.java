package com.rentalcars;

public class Vehicle {

    public String sipp;
    public String name;
    public Double price;
    public String supplier;
    public Double rating;
    public int vehicleScore;

    public Vehicle(String sipp, String name, Double price, String supplier, Double rating) {
        this.sipp = sipp;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
        this.rating = rating;
    }

    public String getSipp() {
        return sipp;
    }

    public void setSipp(String sipp) {
        this.sipp = sipp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getVehicleScore() {
        return vehicleScore;
    }

    public void setVehicleScore(int vehicleScore) {
        this.vehicleScore = vehicleScore;
    }

    public static String getCarType(Character c) {
        String carType;
        switch (c) {
            case 'M':
                carType = "Mini";
                break;
            case 'E':
                carType = "Economy";
                break;
            case 'C':
                carType = "Compact";
                break;
            case 'I':
                carType = "Intermediate";
                break;
            case 'S':
                carType = "Standard";
                break;
            case 'F':
                carType = "Full size";
                break;
            case 'P':
                carType = "Premium";
                break;
            case 'L':
                carType = "Luxury";
                break;
            case 'X':
                carType = "Special";
                break;
            default:
                carType = " ";
                break;
        }
        return carType;
    }

    public static String getCarDoors(Character c) {
        String doors;
        switch (c) {
            case 'B':
                doors = "2 doors";
                break;
            case 'C':
                doors = "4 doors";
                break;
            case 'D':
                doors = "5 doors";
                break;
            case 'W':
                doors = "Estate";
                break;
            case 'T':
                doors = "Convertible";
                break;
            case 'F':
                doors = "SUV";
                break;
            case 'P':
                doors = "Pick up";
                break;
            case 'V':
                doors = "Passenger Van";
                break;
            default:
                doors = " ";
                break;
        }
        return doors;
    }

    public static String getTransmission(Character c) {
        String transmission;
        switch (c) {
            case 'M':
                transmission = "Manual";
                break;
            case 'A':
                transmission = "Automatic";
                break;
            default:
                transmission = " ";
                break;
        }
        return transmission;
    }

    public static String getFuel(Character c) {
        String fuel;
        switch (c) {
            case 'N':
                fuel = "Petrol/no AC";
                break;
            case 'R':
                fuel = "Petrol/AC";
                break;
            default:
                fuel = " ";
                break;
        }
        return fuel;
    }
}