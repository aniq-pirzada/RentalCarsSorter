package com.rentalcars;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadJSON {

    private final static String urlString = "https://www.rentalcars.com/js/vehicles.json";

    public static List<Vehicle> read() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        List<Vehicle> listOfCars = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            Result result = gson.fromJson(bufferedReader, Result.class);

            if (result != null) {
                for (Vehicle vehicle : result.getSearch().getVehicleList()) {
                    listOfCars.add(vehicle);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return listOfCars;
    }
}
