package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city to the list if that city does exist
     * @param city
     *      This is the city to delete
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This counts city from the list
     */
    public int count() {
        return cities.size();
    }


    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(int sort) {
        // sort ==1 means sort by city
        List<City> cityList = cities;
        if(sort==1){
            //sort by city name
            Collections.sort(cityList);
        }
        else{
            // sort by province
            Collections.sort(cityList,new SortByProvince());
        }


        return cityList;
    }


}

