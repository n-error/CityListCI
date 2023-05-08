package com.example.citylist;

import java.util.Comparator;

public class SortByProvince implements Comparator<City> {

    @Override
    public int compare(City c1, City c2) {
        return c1.getProvinceName().compareTo(c2.getProvinceName());
    }
}
