package org.miniproject.model;

public class UserPhoneNumber {
    private String number;
    private String countryCode;

    // Constructor
    public UserPhoneNumber(String number, String countryCode) {
        this.number = number;
        this.countryCode = countryCode;
    }

    // Getters and setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "+" + countryCode + " " + number;
    }
}
