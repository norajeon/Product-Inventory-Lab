package services;

import models.Sneaker;

import java.util.ArrayList;

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
        } return null;
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
}