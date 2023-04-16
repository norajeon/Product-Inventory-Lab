import models.Sneaker;
import models.Whiskey;
import services.SneakerService;
import services.WhiskeyService;

import java.util.InputMismatchException;
import java.util.Scanner;

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
                String userInput = console.getStringInput("1. Sneaker\n2.Whiskey\n'exit to Exit");
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
                console.getStringInput("Invalid. Try Again. \n1. Sneaker\n2.Whiskey\n'exit to Exit");
            }

        } //while loop

    } //init

    public void sneakerMenu() {
        boolean sneakerEnd = false;
        while (!sneakerEnd) {
            try {
                String choice = console.getStringInput("1. Create Sneaker\n" +
                        "2. Find Sneaker by ID\n" +
                        "3. Find All Sneakers\n" +
                        "4. Delete Sneaker by ID\n" +
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
                        "exit to Exit");
                switch (choice) {
                    case "1":
                        addWhiskey();
                        break;
                    case "2":
                        Integer check = console.getIntegerInput("Enter ID to check:");
                        findWhiskey(check);
                        break;
                    case "3":
                        findAllWhiskey();
                        break;
                    case "4":
                        Integer deletion = console.getIntegerInput("Enter ID to delete:");
                        deleteWhiskey(deletion);
                        break;
                    case "exit":
                        whiskeyEnd = true;
                        break;
                }
            }
            catch (InputMismatchException e) {
                console.getStringInput("Invalid choice. \n1. Create Whiskey\n" +
                        "2. Find Whiskey by ID\n" +
                        "3. Find All Whiskey\n" +
                        "4. Delete Whiskey by ID\n" +
                        "exit to Exit");
            }
        }

    }
    public Sneaker addSneaker() {
        String name = console.getStringInput(" Enter name:");
        String brand = console.getStringInput(" Enter brand:");
        String sport = console.getStringInput(" Enter sport:");
        Integer qty = console.getIntegerInput("Enter quantity:");
        Float price = console.getFloatInput("Enter price:");
        Double size = console.getDoubleInput("Enter size:");

        System.out.println("Sneaker created; name: " + name);
        return sneakerService.create(name, brand, sport, qty, price, size);

    }

    public String findSneaker(int id) {
        Sneaker check = sneakerService.findSneaker(id);
        return check.toString();

    }

    public String findAllSneakers() {
        return sneakerService.findAll().toString();

    }

    public String deleteSneaker(int id) {
        sneakerService.delete(id);
        return "Deleted sneaker id#:" + id;

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
        return check.toString();

    }

    public String findAllWhiskey() {
        return whiskeyService.findAll().toString();

    }

    public String deleteWhiskey(int id) {
        whiskeyService.delete(id);
        return "Deleted sneaker id#:" + id;

    }

}