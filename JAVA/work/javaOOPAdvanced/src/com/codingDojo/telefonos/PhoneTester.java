package com.codingDojo.telefonos;

public class PhoneTester {
    public static void main(String[] args) {
        IPhone iPhoneTen = new IPhone("X", 24, "AT&T", "Zing");
        Galaxy s9 = new Galaxy("S9", 99, "Verizon", "Ring Ring Ring!");


        s9.displayInfo();
        System.out.println(s9.ring());
        System.out.println(s9.unlock());
        System.out.println("------------------------------------");
        iPhoneTen.displayInfo();
        System.out.println(iPhoneTen.ring());
        System.out.println(iPhoneTen.unlock());
    }    
}
