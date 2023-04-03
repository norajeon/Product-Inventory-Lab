package services;


import models.Whiskey;

import java.util.ArrayList;

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
}
