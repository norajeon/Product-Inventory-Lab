//import models.Sneaker;
//import services.SneakerService;
//import services.WhiskeyService;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class App {
//    private SneakerService sneakerService = new SneakerService(); // (1)
//    private WhiskeyService whiskeyService = new WhiskeyService();
//
//    Scanner input = new Scanner(System.in);
//
//    public static void main(String... args){
//        App application = new App(); // (2)
//        application.init();  // (3)
//    }
//
//    public void init() {
//        // (4)
//        // application logic here
//        // call methods to take user input and interface with services
//        io.Console.printWelcome();
//        boolean running = true;
//
//
//        while (running) {
//            try {
//                String userInput = input.nextLine();
//                System.out.println("Options:");
//                switch (userInput) {
//                    case "1":
//                        addSneaker();
//                        break;
//                    case "2":
//                        addWhiskey();
//                        break;
//                    case "exit":
//                        running = false;
//                        return;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("\nInvalid.");
//                input.next();
//            }
//
//        } //while loop
//
//    } //init
//
//    public Sneaker addSneaker() {
//        SneakerService sneak = new SneakerService();
//        System.out.println("Options:");
//        String userInput = input.nextLine();
//
//        return sneak.create();
//
//    }
//
//
//}