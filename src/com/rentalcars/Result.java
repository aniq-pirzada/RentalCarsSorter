package com.rentalcars;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("Search")
    private Search search;

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}