package services;


import models.Sneaker;
import models.Whiskey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhiskeyService {

    private static int nextId = 1;  // (1)

    private ArrayList<Whiskey> inventory = new ArrayList<>();  // (2)

    public Whiskey create(String expectedName, String expectedBrand, double expectedPrice) {
        Whiskey createdWhiskey = new Whiskey(nextId++, expectedName, expectedBrand, expectedPrice);

        inventory.add(createdWhiskey);
        return createdWhiskey;
    }

    //read
    public Whiskey findWhiskey(int id) {
        // should take an int and return an object with that id, if exists
        for(Whiskey a : inventory) {
            if (a.getId() == id) {
                return a;
            }
        } return null;
    }

    //read all
    public Whiskey[] findAll() {
        Whiskey[] all = new Whiskey[inventory.size()];
        for (int i = 0; i < inventory.size(); i++) {
            all[i] = inventory.get(i);

        }
        return all;
        // should return a basic array copy of the ArrayList
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        for(Whiskey a : inventory) {
            if (a.getId() == id) {
                inventory.remove(a);
                return true;
            }
        }
        return false;
    }

    public void saveFile() throws IOException {

        String csvFile = "Whiskey.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Whiskey s : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(s.getId()));
            list.add(s.getName());
            list.add(s.getBrand());
            list.add(String.valueOf(s.getPrice()));

            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();
    }

    public void loadData(){
        // (1)
        String csvFile = "Whiskey.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(beer[0]);
                String name = beer[1];
                String brand = beer[2];
                double price = Double.parseDouble(beer[3]);

                // (5)
                inventory.add(new Whiskey(id, name, brand, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
