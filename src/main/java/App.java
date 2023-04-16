import models.Sneaker;
import models.Whiskey;
import services.SneakerService;
import services.WhiskeyService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private SneakerService sneakerService = new SneakerService(); // (1)
    private WhiskeyService whiskeyService = new WhiskeyService();

    Scanner input = new Scanner(System.in);

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
                System.out.println("1. Sneaker");
                System.out.println("2. Whiskey");
                System.out.println("'exit' to Exit");
                String userInput = input.nextLine();
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
                System.out.println("\nInvalid.");
                input.next();
            }

        } //while loop

    } //init

    public void sneakerMenu() {
        boolean sneakerEnd = false;
        while (!sneakerEnd) {
            try {
                System.out.println("1. Create Sneaker");
                System.out.println("2. Find Sneaker by ID");
                System.out.println("3. Find All Sneakers");
                System.out.println("5. Delete Sneaker");
                System.out.println("'exit' to Exit");
                String choice = input.nextLine();
                switch (choice) {
                    case "1":
                        addSneaker();
                        break;
                    case "2":
                        System.out.println("Enter ID to check:");
                        int check = input.nextInt();
                        findSneaker(check);
                        break;
                    case "3":
                        findAllSneakers();
                        break;
                    case "4":
                        System.out.println("Enter ID to delete:");
                        int deletion = input.nextInt();
                        deleteSneaker(deletion);
                        break;
                    case "exit":
                        sneakerEnd = true;
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    public void whiskeyMenu() {
        boolean whiskeyEnd = false;
        while (!whiskeyEnd) {
            try {
                System.out.println("1. Create Whiskey");
                System.out.println("2. Find Whiskey by ID");
                System.out.println("3. Find All Whiskey");
                System.out.println("5. Delete Whiskey");
                System.out.println("'exit' to Exit");
                String choice = input.nextLine();
                switch (choice) {
                    case "1":
                        addWhiskey();
                        break;
                    case "2":
                        System.out.println("Enter ID to check:");
                        int check = input.nextInt();
                        findWhiskey(check);
                        break;
                    case "3":
                        findAllWhiskey();
                        break;
                    case "4":
                        System.out.println("Enter ID to delete:");
                        int deletion = input.nextInt();
                        deleteWhiskey(deletion);
                        break;
                    case "exit":
                        whiskeyEnd = true;
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }

    }
    public Sneaker addSneaker() {
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter brand:");
        String brand = input.nextLine();
        System.out.println("Enter sport");
        String sport = input.nextLine();
        System.out.println("Enter quantity:");
        int qty = input.nextInt();
        System.out.println("Enter price:");
        float price = (float) input.nextFloat();
        System.out.println("Enter size:");
        double size = (double) input.nextDouble();

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
        WhiskeyService whisk = new WhiskeyService();
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter brand:");
        String brand = input.nextLine();
        System.out.println("Enter price:");
        double price = (double) input.nextFloat();

        System.out.println("Whiskey created; name: " + name);
        return whisk.create(name, brand, price);
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