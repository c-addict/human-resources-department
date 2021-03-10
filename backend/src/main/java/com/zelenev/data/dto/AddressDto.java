package com.zelenev.data.dto;

public class AddressDto {

    private String country;

    private String city;

    private String street;

    private Integer building;

    private String postcode;

    public AddressDto(String country,
                      String city,
                      String street,
                      Integer building,
                      String postcode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
