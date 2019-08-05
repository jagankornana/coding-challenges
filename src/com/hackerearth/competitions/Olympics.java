package com.hackerearth.competitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Medals implements Comparable<Medals> {
    private String countryName;
    private int gold;
    private int silver;
    private int bronze;

    public String getCountryName() {
        return countryName;
    }

    void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    int getGold() {
        return gold;
    }

    void setGold(int gold) {
        this.gold = gold;
    }

    int getSilver() {
        return silver;
    }

    void setSilver(int silver) {
        this.silver = silver;
    }

    int getBronze() {
        return bronze;
    }

    void setBronze(int bronze) {
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Medals m) {
        if (this.gold != m.gold) {
            return m.gold - this.gold;
        } else if (this.silver != m.silver) {
            return m.silver - this.silver;
        } else if (this.bronze != m.bronze) {
            return m.bronze - this.bronze;
        } else {
            return this.countryName.compareTo(m.countryName);
        }
    }

    @Override
    public String toString() {
        return countryName + " " + gold + " " + silver + " " + bronze;
    }

}

public class Olympics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Medals> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] countries = br.readLine().split(" ");
            for (int j = 0; j < countries.length; j++) {
                storeMedal(map, countries[j], j);
            }
        }

        ArrayList<Medals> orderCountries = new ArrayList<>(map.values());
        Collections.sort(orderCountries);

        for (Medals medals : orderCountries) {
            System.out.println(medals);
        }
    }

    private static void storeMedal(Map<String, Medals> map, String country, int medalIndex) {

        Medals medals = map.get(country);

        if (medals != null) {
            switch (medalIndex) {
                case 0:
                    medals.setGold(medals.getGold() + 1);
                    break;
                case 1:
                    medals.setSilver(medals.getSilver() + 1);
                    break;
                case 2:
                    medals.setBronze(medals.getBronze() + 1);
                    break;
            }
            map.put(country, medals);
        } else {
            Medals firstMedal = new Medals();
            firstMedal.setCountryName(country);
            switch (medalIndex) {
                case 0:
                    firstMedal.setGold(1);
                    break;
                case 1:
                    firstMedal.setSilver(1);
                    break;
                case 2:
                    firstMedal.setBronze(1);
                    break;
            }
            map.put(country, firstMedal);
        }
    }
}
