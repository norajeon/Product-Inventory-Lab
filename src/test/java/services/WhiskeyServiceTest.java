package services;

import models.Sneaker;
import models.Whiskey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiskeyServiceTest {
    @Test
    public void createTest(){

        // (1)
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        double expectedPrice = 30.00;

        // (2)
        WhiskeyService test = new WhiskeyService();
        Whiskey testWhiskey = test.create(expectedName, expectedBrand, expectedPrice);

        // (3)
        int actualId = testWhiskey.getId();
        String actualName = testWhiskey.getName();
        String actualBrand = testWhiskey.getBrand();
        double actualPrice = testWhiskey.getPrice();

        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void testFind() {
        WhiskeyService test = new WhiskeyService();
        test.create("", "", 50.00);
        test.create("", "", 50.00);
        Whiskey expected = test.create("", "", 50.00);
        test.create("", "", 50.00);
        Whiskey actual = test.findWhiskey(7);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testFindAll() {
        WhiskeyService test = new WhiskeyService();
        test.create("", "", 50.00);
        test.create("", "", 50.00);
        test.create("", "", 50.00);
        test.create("", "", 50.00);
        Integer actual = 4;
        Whiskey[] whiskeyArray = test.findAll();

        Assertions.assertEquals(actual, whiskeyArray.length);
    }

    @Test
    public void testDelete() {
        WhiskeyService test = new WhiskeyService();
        test.create("", "", 50.00);
        test.create("", "", 50.00);
        test.create("", "", 50.00);
        test.create("", "", 50.00);
        Integer actual = 3;
        test.delete(11);
        Whiskey[] whiskeyArray = test.findAll();

        Assertions.assertEquals(actual, whiskeyArray.length);

    }

}