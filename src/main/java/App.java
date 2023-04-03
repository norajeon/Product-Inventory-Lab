import services.SneakerService;

public class App {
    private SneakerService sneakerService = new SneakerService(); // (1)

    public static void main(String... args){
        App application = new App(); // (2)
        application.init();  // (3)
    }

    public void init(){
        // (4)
        // application logic here
        // call methods to take user input and interface with services
        io.Console.printWelcome();
    }
}