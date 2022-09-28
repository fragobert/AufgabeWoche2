import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRental cr1 = new CarRental(5);
        //endless while loop
        while (true) {
            //print menu
            System.out.print(ConsoleColors.CYAN);
            System.out.println("1. Alle existierenden Autos anzeigen");
            System.out.println("2. Alle bereits vermieteten Autos anzeigen");
            System.out.println("3. Auto ausleihen");
            System.out.println("4. Auto zurückgeben");
            System.out.println("5. Nachsehen ob Auto verfuegbar ist");
            System.out.println("6. Auto finden");
            System.out.println("7. Programm beenden");
            System.out.print(ConsoleColors.RESET);
            //get user input
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            //switch case for user input
            switch (input) {
                case 1 -> cr1.carsToString();
                case 2 -> cr1.rentedCarsToString();
                case 3 -> {
                    System.out.println("Bitte geben Sie den Index des Autos an welches sie ausleihen moechten:");
                    cr1.rentCar(scanner.nextInt());
                }
                case 4 -> {
                    System.out.println("Bitte geben Sie den Index des Autos an welches sie zurueckgeben moechten:");
                    cr1.returnCar(scanner.nextInt());
                }

                case 5 -> {
                    System.out.println("Geben Sie bitte den Index des Autos an:");
                    int index = scanner.nextInt();
                    cr1.isAvailable(cr1.getCar(index -1) );
                }
                case 6 -> {
                    System.out.println("Geben Sie die Marke des gesuchten Autos an:");
                    String brand =scanner.nextLine();
                    System.out.println("Geben Sie den Namen des gesuchten Autos an:");
                    String name = scanner.nextLine();
                    System.out.println("Geben Sie die Farbe des gesuchten Autos an:");
                    String color = scanner.nextLine();
                    ArrayList<Car> foundCars = cr1.findCar(brand, name, color);
                    if(foundCars.size() != 0) {
                        System.out.println("Es wurden " + foundCars.size() + " Autos gefunden:");
                        for (Car car : foundCars) {
                            System.out.println(car);
                        }
                    }
                }
                case 7 -> {
                    System.out.println("Programm wird beendet...");
                    System.exit(0);
                }
                default -> System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 7 ein!");
            }
        }
    }
}