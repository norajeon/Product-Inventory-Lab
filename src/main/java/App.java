import models.Sneaker;
import models.Whiskey;
import services.SneakerService;
import services.WhiskeyService;

import java.io.FileWriter;
import java.util.*;

public class App {
    private SneakerService sneakerService = new SneakerService(); // (1)
    private WhiskeyService whiskeyService = new WhiskeyService();

    private Console console = new Console();

    public static void main(String... args){
        Console.printWelcome();
        App application = new App(); // (2)
        application.init();  // (3)
    }

    public void init() {
        // (4)
        // application logic here
        // call methods to take user input and interface with services
        boolean end = false;
        while (!end) {
            try {
                String userInput = console.getStringInput("1. Sneaker\n" +
                        "2. Whiskey\n" +
                        "'exit to Exit");
                switch (userInput) {
                    case "1":
                        sneakerMenu();
                        break;
                    case "2":
                        whiskeyMenu();
                        break;
                    case "exit":
                        end = true;
                        break;
                }
            } catch (InputMismatchException e) {
                console.getStringInput("Invalid. Try Again. \n" +
                        "1. Sneaker\n" +
                        "2. Whiskey\n" +
                        "'exit to Exit");
            }

        } //while loop

    } //init

    public void sneakerMenu() {
        boolean sneakerEnd = false;
        while (!sneakerEnd) {
            try {
                String choice = console.getStringInput(
                        "1. Create Sneaker\n" +
                        "2. Find Sneaker by ID\n" +
                        "3. Find All Sneakers\n" +
                        "4. Delete Sneaker by ID\n" +
                        "5. Update Sneaker\n" +
                        "exit to Exit");
                switch (choice) {
                    case "1":
                        addSneaker();
                        break;
                    case "2":
                        Integer check = console.getIntegerInput("Enter ID to check:");
                        findSneaker(check);
                        break;
                    case "3":
                        findAllSneakers();
                        break;
                    case "4":
                        Integer deletion = console.getIntegerInput("Enter ID to delete:");
                        deleteSneaker(deletion);
                        break;
                    case "5":
                        updateSneaker();
                        break;
                    case "exit":
                        sneakerEnd = true;
                        break;
                }
            }
            catch (InputMismatchException e) {
                console.getStringInput("Invalid choice. \n1. Create Sneaker\n" +
                        "2. Find Sneaker by ID\n" +
                        "3. Find All Sneakers\n" +
                        "4. Delete Sneaker by ID\n" +
                        "exit to Exit");
            }
        }
    }

    public void whiskeyMenu() {
        boolean whiskeyEnd = false;
        while (!whiskeyEnd) {
            try {
                String choice = console.getStringInput("1. Create Whiskey\n" +
                        "2. Find Whiskey by ID\n" +
                        "3. Find All Whiskey\n" +
                        "4. Delete Whiskey by ID\n" +
                        "5. Update Whiskey\n" +
                        "exit to Exit");
                switch (choice) {
                    case "1":
                        addWhiskey();
                        break;
                    case "2":
                        Integer check = console.getIntegerInput("Enter ID to check:");
                        System.out.println(findWhiskey(check));
                        break;
                    case "3":
                        System.out.println(findAllWhiskey());
                        break;
                    case "4":
                        Integer deletion = console.getIntegerInput("Enter ID to delete:");
                        deleteWhiskey(deletion);
                        break;
                    case "5":
                        updateWhiskey();
                        break;
                    case "exit":
                        whiskeyEnd = true;
                        break;
                }
            }
            catch (InputMismatchException e) {
                console.getStringInput("Invalid choice. \n" +
                        "1. Create Whiskey\n" +
                        "2. Find Whiskey by ID\n" +
                        "3. Find All Whiskey\n" +
                        "4. Delete Whiskey by ID\n" +
                        "exit to Exit");
            }
        }

    }
    public Sneaker addSneaker() {
        String name = console.getStringInput("Enter name:");
        String brand = console.getStringInput("Enter brand:");
        String sport = console.getStringInput("Enter sport:");
        Integer qty = console.getIntegerInput("Enter quantity:");
        Float price = console.getFloatInput("Enter price:");
        Double size = console.getDoubleInput("Enter size:");

        System.out.println("Sneaker created; name: " + name);
        return sneakerService.create(name, brand, sport, qty, price, size);

    }

    public String findSneaker(int id) {
        Sneaker check = sneakerService.findSneaker(id);
        System.out.println("Whiskey name:"+ check.getName());
        return check.toString();

    }

    public String findAllSneakers() {
        return sneakerService.findAll().toString();

    }

    public String deleteSneaker(int id) {
        sneakerService.delete(id);
        return "Deleted sneaker id#:" + id;

    }

    public void updateSneaker() {
        boolean sneakerUpdate = false;
        while (!sneakerUpdate) {
            try {
                String choice = console.getStringInput(
                        "1. Update Sneaker Name\n" +
                                "2. Update Sneaker Brand\n" +
                                "3. Update Sneaker Sport\n" +
                                "4. Update Sneaker Quantity\n" +
                                "5. Update Sneaker Price\n" +
                                "6. Update Sneaker Size\n" +
                                "exit to Exit");
                switch (choice) {
                    case "1":
                        updateSneakerName();
                        break;
                    case "2":
                        updateSneakerBrand();
                        break;
                    case "3":
                        updateSneakerSport();
                        break;
                    case "4":
                        updateSneakerQty();
                        break;
                    case "5":
                        updateSneakerPrice();
                        break;
                    case "6":
                        updateSneakerSize();
                        break;
                    case "exit":
                        sneakerUpdate = true;
                        break;
                }
            }
            catch (InputMismatchException e) {
                console.getStringInput("Invalid choice.\n" +
                        "1. Update Sneaker Name\n" +
                        "2. Update Sneaker Brand\n" +
                        "3. Update Sneaker Sport\n" +
                        "4. Update Sneaker Quantity\n" +
                        "5. Update Sneaker Price\n" +
                        "6. Update Sneaker Size\n" +
                        "exit to Exit");
            }
        }
    } //


    public void updateSneakerName() {
        Integer idofSneaker = console.getIntegerInput("Enter ID of Sneaker to Update:");
        Sneaker toUpdate = sneakerService.findSneaker(idofSneaker);
        System.out.println("Current Sneaker Name: " + toUpdate.getName());
        String updatedName = console.getStringInput("Update to:");
        toUpdate.setName(updatedName);
        System.out.println("New Sneaker Name: " + toUpdate.getName());

    }

    public void updateSneakerBrand() {
        Integer idofSneaker = console.getIntegerInput("Enter ID of Sneaker to Update:");
        Sneaker toUpdate = sneakerService.findSneaker(idofSneaker);
        System.out.println("Current Sneaker Brand: " + toUpdate.getBrand());
        String updatedBrand = console.getStringInput("Update to:");
        toUpdate.setBrand(updatedBrand);
        System.out.println("New Sneaker Brand: " + toUpdate.getBrand());

    }

    public void updateSneakerSport() {
        Integer idofSneaker = console.getIntegerInput("Enter ID of Sneaker to Update:");
        Sneaker toUpdate = sneakerService.findSneaker(idofSneaker);
        System.out.println("Current Sneaker Sport: " + toUpdate.getSport());
        String updatedSport = console.getStringInput("Update to:");
        toUpdate.setSport(updatedSport);
        System.out.println("New Sneaker Price: " + toUpdate.getSport());
    }

    public void updateSneakerQty() {
        Integer idofSneaker = console.getIntegerInput("Enter ID of Sneaker to Update:");
        Sneaker toUpdate = sneakerService.findSneaker(idofSneaker);
        System.out.println("Current Sneaker Quantity: " + toUpdate.getQty());
        Integer updatedQuantity = console.getIntegerInput("Update to:");
        toUpdate.setQty(updatedQuantity);
        System.out.println("New Sneaker Quantity: " + toUpdate.getQty());
    }


    public void updateSneakerPrice() {
        Integer idofSneaker = console.getIntegerInput("Enter ID of Sneaker to Update:");
        Sneaker toUpdate = sneakerService.findSneaker(idofSneaker);
        System.out.println("Current Sneaker Price: " + toUpdate.getPrice());
        Float updatedPrice = console.getFloatInput("Update to:");
        toUpdate.setPrice(updatedPrice);
        System.out.println("New Sneaker Price: " + toUpdate.getPrice());
    }
    public void updateSneakerSize() {
        Integer idofSneaker = console.getIntegerInput("Enter ID of Sneaker to Update:");
        Sneaker toUpdate = sneakerService.findSneaker(idofSneaker);
        System.out.println("Current Sneaker Size: " + toUpdate.getSize());
        Double updatedSize = console.getDoubleInput("Update to:");
        toUpdate.setSize(updatedSize);
        System.out.println("New Sneaker Size: " + toUpdate.getSize());
    }




    public Whiskey addWhiskey() {
        String name = console.getStringInput(" Enter name:");
        String brand = console.getStringInput(" Enter brand:");
        Double price = console.getDoubleInput("Enter price:");

        System.out.println("Whiskey created; name: " + name);
        return whiskeyService.create(name, brand, price);
    }


    public String findWhiskey(int id) {
        Whiskey check = whiskeyService.findWhiskey(id);
        System.out.println("Whiskey name: "+ check.getName());
        return check.toString();

    }

    public String findAllWhiskey() {
        return whiskeyService.findAll().toString();

    }

    public String deleteWhiskey(int id) {
        whiskeyService.delete(id);
        return "Deleted sneaker id#: " + id;

    }

    public void updateWhiskey() {
        boolean whiskeyEnd = false;
        while (!whiskeyEnd) {
            try {
                String choice = console.getStringInput(
                        "1. Update Whiskey Name\n" +
                                "2. Update Whiskey Brand\n" +
                                "3. Update Whiskey Price\n" +
                                "exit to Exit");
                switch (choice) {
                    case "1":
                        updateName();
                        break;
                    case "2":
                        updateBrand();
                        break;
                    case "3":
                        updatePrice();
                        break;
                    case "exit":
                        whiskeyEnd = true;
                        break;
                }
            }
            catch (InputMismatchException e) {
                console.getStringInput("Invalid choice.\n" +
                        "1. Update Whiskey Name\n" +
                        "2. Update Whiskey Brand\n" +
                        "3. Update Whiskey Price\n" +
                        "exit to Exit");
            }
        }
    } //


    public void updateName() {
        Integer idofWhiskey = console.getIntegerInput("Enter ID of Whiskey to Update:");
        Whiskey toUpdate = whiskeyService.findWhiskey(idofWhiskey);
        System.out.println("Current Whiskey Name: " + toUpdate.getName());
        String updatedName = console.getStringInput("Update to:");
        toUpdate.setName(updatedName);
        System.out.println("New Whiskey Name: " + toUpdate.getName());

    }

    public void updateBrand() {
        Integer idofWhiskey = console.getIntegerInput("Enter ID of Whiskey to Update:");
        Whiskey toUpdate = whiskeyService.findWhiskey(idofWhiskey);
        System.out.println("Current Whiskey Brand: " + toUpdate.getBrand());
        String updatedBrand = console.getStringInput("Update to:");
        toUpdate.setBrand(updatedBrand);
        System.out.println("New Whiskey Brand: " + toUpdate.getBrand());

    }

    public void updatePrice() {
        Integer idofWhiskey = console.getIntegerInput("Enter ID of Whiskey to Update:");
        Whiskey toUpdate = whiskeyService.findWhiskey(idofWhiskey);
        System.out.println("Current Whiskey Price: " + toUpdate.getPrice());
        Double updatedPrice = console.getDoubleInput("Update to:");
        toUpdate.setPrice(updatedPrice);
        System.out.println("New Whiskey Price: " + toUpdate.getPrice());
    }



}