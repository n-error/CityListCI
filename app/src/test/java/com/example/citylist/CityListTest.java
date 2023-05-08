package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1,cityList.getCities(1).size());

        City city = new City("Regina","SK");
        cityList.add(city);
        cityList.delete(city);

        assertEquals(1,cityList.getCities(1).size());
        assertTrue(!cityList.getCities(1).contains(city));
    }

    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);
        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    public void testCount(){
        CityList cityList = mockCityList();
        assertEquals(1,cityList.count());

        City city = new City("Regina","SK");
        cityList.add(city);
        assertTrue(2== cityList.count());
    }




    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    @Test
    public void testSort() {
        // 1 = sort by city, 0 = sort by province
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // 1 = sort by city, 0 = sort by province
        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));

        assertTrue(0==mockCity().compareTo(cityList.getCities(0).get(0)));
        assertTrue(0==city.compareTo(cityList.getCities(0).get(1)));
    }
}