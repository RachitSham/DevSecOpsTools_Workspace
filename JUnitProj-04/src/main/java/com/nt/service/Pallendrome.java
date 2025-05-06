package com.nt.service;

public class Pallendrome {

    public boolean isPallendrome(String str) {
        System.out.println("Pallendrome.isPallendrome()");
        if (str == null || str.length() == 0 || str.equalsIgnoreCase(""))
            throw new IllegalArgumentException("Invalid Input");

        String reserveStr = new StringBuilder(str).reverse().toString();
        // Corrected here
        if (str.equalsIgnoreCase(reserveStr))
            return true;
        else
            return false;
    }
}
