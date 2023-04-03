package services;

import models.Sneaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SneakerServiceTest {
    SneakerService sneaky = new SneakerService();
    Sneaker sneaker1 = sneaky.create("sneaker1", "brand1",
            "sport1", 1, 10, 5);
    Sneaker sneaker2 = sneaky.create("sneaker2", "brand2",
            "sport2", 5, 15, 3);
    Sneaker sneaker3 = sneaky.create("sneaker3", "brand3",
            "sport3", 4, 3, 9);
    Sneaker sneaker4 = sneaky.create("sneaker4", "brand4",
            "sport4", 9, 12, 6);

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
//        SneakerService sneakerService = new SneakerService();
//        Sneaker sneaker1 = sneakerService.create("sneaker1", "brand1",
//                "sport1", 1, 10, 5);
//        Sneaker sneaker2 = sneakerService.create("sneaker2", "brand2",
//                "sport2", 5, 15, 3);
//        Sneaker sneaker3 = sneakerService.create("sneaker3", "brand3",
//                "sport3", 4, 3, 9);
//        Sneaker sneaker4 = sneakerService.create("sneaker4", "brand4",
//                "sport4", 9, 12, 6);

        Sneaker expected = sneaky.findSneaker(3);

        Assertions.assertEquals(expected, sneaker3);
    }

    @Test
    public void testFindAll() {
//        SneakerService sneaker = new SneakerService();
//        Sneaker sneaker5 = sneaker.create("sneaker1", "brand1",
//                "sport1", 1, 10, 5);
//        Sneaker sneaker6 = sneaker.create("sneaker2", "brand2",
//                "sport2", 5, 15, 3);
//        Sneaker sneaker7 = sneaker.create("sneaker3", "brand3",
//                "sport3", 4, 3, 9);
//        Sneaker sneaker8 = sneaker.create("sneaker4", "brand4",
//                "sport4", 9, 12, 6);

        ArrayList<Sneaker> expected = new ArrayList<>();
        expected.add(sneaker1);
        expected.add(sneaker2);
        expected.add(sneaker3);
        expected.add(sneaker4);

        Assertions.assertEquals(expected, sneaky.findAll());
    }

}