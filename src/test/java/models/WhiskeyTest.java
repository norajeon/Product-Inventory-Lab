package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiskeyTest {

    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Whiskey test = new Whiskey();
        test.setName(expected);

        // then (3)
        Assertions.assertEquals(expected, test.getName());
    }

    @Test
    public void setIdTest() {
        // given (1)
        int expected = 3;

        // when (2)
        Whiskey test = new Whiskey();
        test.setId(expected);

        // then (3)
        Assertions.assertEquals(expected, test.getId());
    }

    @Test
    public void setBrandTest() {
        // given (1)
        String expected = "brand";

        // when (2)
        Whiskey test = new Whiskey();
        test.setBrand(expected);

        // then (3)
        Assertions.assertEquals(expected, test.getBrand());
    }

    @Test
    public void setPriceTest() {
        // given (1)
        double expected = 30.0;

        // when (2)
        Whiskey test = new Whiskey();
        test.setPrice(expected);

        // then (3)
        Assertions.assertEquals(expected, test.getPrice());
    }

    @Test // (1)
    public void constructorTest(){

        // (2)
        int expectedId = 6;
        String expectedName = "whiskey";
        String expectedBrand = "brand";
        double expectedPrice = 50.00;

        // (3)
        Whiskey test = new Whiskey(expectedId, expectedName, expectedBrand, expectedPrice);

        // (4)
        Assertions.assertEquals(expectedId, test.getId());
        Assertions.assertEquals(expectedName, test.getName());
        Assertions.assertEquals(expectedBrand, test.getBrand());
        Assertions.assertEquals(expectedPrice, test.getPrice());
    }
}