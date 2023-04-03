package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SneakerTest {
    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setName(expected);

        // then (3)
        Assertions.assertEquals(expected, testSneaker.getName());
    }

    @Test
    public void setIdTest() {
        // given (1)
        int expected = 5;

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setId(expected);

        // then (3)
        Assertions.assertEquals(expected, testSneaker.getId());
    }

    @Test
    public void setBrandTest() {
        // given (1)
        String expected = "brand";

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setBrand(expected);

        // then (3)
        Assertions.assertEquals(expected, testSneaker.getBrand());
    }


    @Test
    public void setSportTest() {
        // given (1)
        String expected = "soccer";

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setBrand(expected);

        // then (3)
        Assertions.assertEquals(expected, testSneaker.getBrand());
    }

    @Test
    public void setSizeTest() {
        // given (1)
        int expected = 5;

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setSize(expected);

        // then (3)
        Assertions.assertEquals(expected, testSneaker.getSize());
    }

    @Test
    public void setQuantityTest() {
        // given (1)
        int expected = 3;

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setQty(expected);

        // then (3)
        Assertions.assertEquals(expected, testSneaker.getQty());
    }

    @Test
    public void setPriceTest() {
        // given (1)
        float expected = 50;

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setPrice(expected);

        // then (3)
        Assertions.assertEquals(expected, testSneaker.getPrice());
    }

}