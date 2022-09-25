import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CarRental cr1 = new CarRental(5);
        //endless while loop
        while (true) {
            //print menu
            System.out.print(ConsoleColors.CYAN);
            System.out.println("1. Alle existierenden Autos anzeigen");
            System.out.println("2. Alle bereits vermieteten Autos anzeigen");
            System.out.println("3. Auto ausleihen");
            System.out.println("4. Auto zurückgeben");
            System.out.println("5. Programm beenden");
            System.out.print(ConsoleColors.RESET);
            //get user input
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            //switch case for user input
            switch (input) {
                case 1 -> cr1.getCars();
                case 2 -> cr1.getRentedCars();
                case 3 -> {
                    System.out.println("Bitte geben Sie den Index des Autos an welches sie ausleihen moechten:");
                    cr1.rentCar(scanner.nextInt());
                }
                case 4 -> System.out.println("Welches Auto möchten Sie zurückgeben?");
                case 5 -> {
                    System.out.println("Programm wird beendet...");
                    System.exit(0);
                }
                default -> System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 5 ein!");
            }
        }
    }
}