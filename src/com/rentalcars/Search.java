package com.rentalcars;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {
    @SerializedName("VehicleList")
    private List<Vehicle> vehicleList = null;

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
