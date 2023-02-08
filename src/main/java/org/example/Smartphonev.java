package org.example;

public class Smartphonev extends Product {


    private String name;

    public String getManufacturer() {
        return manufacturer;
    }


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private String manufacturer;

    public Smartphonev(int id, String name, int cost, String manufacturer) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }
}
