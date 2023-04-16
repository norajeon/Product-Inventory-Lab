package services;

import models.Sneaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SneakerService {

    private static int nextId = 1;  // (1)

    private ArrayList<Sneaker> inventory = new ArrayList<>();  // (2)

    public Sneaker create(String expectedName, String expectedBrand, String expectedSport, int expectedQty, float expectedPrice, double expectedSize) {
        Sneaker createdSneaker = new Sneaker(nextId++, expectedName, expectedBrand, expectedSport, expectedQty, expectedPrice, expectedSize);

        inventory.add(createdSneaker);
        return createdSneaker;
    }

    //read
    public Sneaker findSneaker(int id) {
        // should take an int and return an object with that id, if exists
        for(Sneaker a : inventory) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    //read all
    public Sneaker[] findAll() {
        Sneaker[] all = new Sneaker[inventory.size()];
        for (int i = 0; i < inventory.size(); i++) {
            all[i] = inventory.get(i);


        }
//        int i = 0;
//        for (Sneaker a : inventory) {
//            all[i] = a;
//        }
        return all;
        // should return a basic array copy of the ArrayList
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        for(Sneaker a : inventory) {
            if (a.getId() == id) {
                inventory.remove(a);
                return true;
            }
        }
        return false;
    }


    public void saveFile() throws IOException {

        String csvFile = "Sneaker.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Sneaker s : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(s.getId()));
            list.add(s.getName());
            list.add(s.getBrand());
            list.add(s.getSport());
            list.add(String.valueOf(s.getQty()));
            list.add(String.valueOf(s.getPrice()));
            list.add(String.valueOf(s.getSize()));

            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();
    }


    private void loadData(){
        // (1)
        String csvFile = "Sneaker.csv";
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
                String sport = beer[3];
                int qty = Integer.parseInt(beer[4]);
                float price = Float.parseFloat(beer[5]);
                double size = Double.parseDouble(beer[6]);

                // (5)
                inventory.add(new Sneaker(id, name, brand, sport, qty, price, size));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}