package com.codingDojo.telefonos;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return "iPhone says "+getRingTone();
    }

    @Override
    public String unlock() {
        return "Unlocking via Facial recognition";
    }

    @Override
    public void displayInfo() {
        System.out.println("iPhone Version: " + getVersionNumber());
        System.out.println("Battery Percentage: " + getBatteryPercentage());
        System.out.println("Carrier: " + getCarrier());
    }
}
