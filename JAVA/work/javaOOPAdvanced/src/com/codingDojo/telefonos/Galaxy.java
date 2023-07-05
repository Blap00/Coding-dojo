package com.codingDojo.telefonos;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return "Galaxy says"+getRingTone();
    }

    @Override
    public String unlock() {
        return "Unlocking via Finger print";
    }

    @Override
    public void displayInfo() {
        System.out.println("Galaxy Version: " + getVersionNumber());
        System.out.println("Battery Percentage: " + getBatteryPercentage());
        System.out.println("Carrier: " + getCarrier());
    }
}
