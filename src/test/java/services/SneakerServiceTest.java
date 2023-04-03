package services;

import models.Sneaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SneakerServiceTest {


    @Test
    public void createTest(){

        // (1)
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        double expectedSize = 10.5;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (2)
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,
                expectedSport, expectedQty, expectedPrice, expectedSize);

        // (3)
        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        double actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQty();
        float actualPrice = testSneaker.getPrice();

        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedSport, actualSport);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void testFind() {
        SneakerService sneaky = new SneakerService();
        sneaky.create("sneaker1", "brand1",
                "sport1", 1, 10, 5);
        sneaky.create("sneaker2", "brand2",
                "sport2", 5, 15, 3);
        Sneaker expected = sneaky.create("sneaker3", "brand3",
                "sport3", 4, 3, 9);
        sneaky.create("sneaker4", "brand4",
                "sport4", 9, 12, 6);
        sneaky.create("sneaker3", "brand3",
                "sport3", 4, 3, 9);
        Sneaker actual = sneaky.findSneaker(7);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testFindAll() {
        SneakerService sneaky = new SneakerService();
        sneaky.create("sneaker1", "brand1",
                "sport1", 1, 10, 5);
        sneaky.create("sneaker2", "brand2",
                "sport2", 5, 15, 3);
        sneaky.create("sneaker3", "brand3",
                "sport3", 4, 3, 9);
        sneaky.create("sneaker4", "brand4",
                "sport4", 9, 12, 6);
        Integer expected = 4;
        Sneaker[] sneakerArray = sneaky.findAll();

        Assertions.assertEquals(expected, sneakerArray.length);
    }

    @Test
    public void testDelete() {
        SneakerService sneaky = new SneakerService();
        sneaky.create("sneaker1", "brand1",
                "sport1", 1, 10, 5);
        sneaky.create("sneaker2", "brand2",
                "sport2", 5, 15, 3);
        sneaky.create("sneaker3", "brand3",
                "sport3", 4, 3, 9);
        sneaky.create("sneaker4", "brand4",
                "sport4", 9, 12, 6);
        Integer expected = 3;
        sneaky.delete(11);
        Sneaker[] sneakerArray = sneaky.findAll();

        Assertions.assertEquals(expected, sneakerArray.length);
    }

}