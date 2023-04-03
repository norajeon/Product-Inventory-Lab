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
}