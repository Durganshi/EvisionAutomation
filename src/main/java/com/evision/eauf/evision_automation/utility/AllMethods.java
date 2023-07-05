package com.evision.eauf.evision_automation.utility;

import java.util.List;
import java.util.Random;

public class AllMethods {

    public String getRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000;
        return String.format("%05d", randomNumber);
    }

    public boolean prefixAndCharacterString() {
        String prefix = "Automation_";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder(prefix);
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            randomString.append(randomChar);
        }

        String generatedString = randomString.toString();
        // Modify the condition as per your desired logic
        return generatedString.length() > 10;
    }

    public  boolean compareLists(List<String> listA, List<String> listB) {
         if (listA == null || listB == null || listA.size() != listB.size()) {
            return false;
        }
        else {
            return listA.equals(listB);
        }
    }

    public boolean compareStrings(String stringA, String stringB) {
       if (stringA == null || stringB == null) {
            return false;
        }
        else {
            return stringA.equals(stringB);
        }
    }
}

