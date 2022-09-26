import java.sql.SQLOutput;
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
            System.out.println("6. Auto Auto suchen");
            System.out.println("7. Programm beenden");
            System.out.print(ConsoleColors.RESET);
            //get user input
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            //switch case for user input
            switch (input) {
                case 1 -> {
                    if(cr1.getCars(0) != null) {
                        System.out.println("Alle existierenden Autos:");
                        System.out.println(cr1.getCars(0));
                    }else {
                        System.out.println(ConsoleColors.RED + "Fehler: Es sind keine Autos vorhanden!" + ConsoleColors.RESET);
                    }
                }
                case 2 -> {
                    if(cr1.getCars(1) != null) {
                        System.out.println("Alle ausgeliehenen Autos:");
                        System.out.println(cr1.getCars(1));
                    }else {
                        System.out.println(ConsoleColors.RED + "Fehler: Es sind keine Autos ausgeliehen!" + ConsoleColors.RESET);
                    }
                }
                case 3 -> {
                    System.out.println("Bitte geben Sie den Index des Autos an welches sie ausleihen moechten:");
                    if(cr1.rentCar(scanner.nextInt())) {
                        System.out.println("Das Auto wurde erfolgreich ausgeliehen!");
                    } else {
                        System.out.println(ConsoleColors.RED + "Fehler: Das Auto ist nicht verfuegbar!" + ConsoleColors.RESET);
                    }
                }
                case 4 -> {
                    System.out.println("Bitte geben Sie den Index des Autos an welches sie zurueckgeben moechten:");
                    if(cr1.returnCar(scanner.nextInt())) {
                        System.out.println("Das Auto wurde erfolgreich zurueckgegeben!");
                    } else {
                        System.out.println(ConsoleColors.RED + "Fehler: Das Auto wurde nicht ausgeliehen!" + ConsoleColors.RESET);
                    }
                }

                case 5 -> {
                    System.out.println("Geben Sie bitte den Index des Autos an:");
                    if(cr1.isAvailable(scanner.nextInt())) {
                        System.out.println("Das Auto ist verfuegbar!");
                    } else {
                        System.out.println("Das Auto ist leider nicht verfuegbar!");
                    }
                }
                case 6 -> {
                    String brand, name, color;
                    System.out.println("Geben Sie die Marke des Autos an:");
                    brand = scanner.nextLine();
                    System.out.println("Geben Sie den Namen des Autos an:");
                    name = scanner.nextLine();
                    System.out.println("Geben Sie die Farbe des Autos an:");
                    color = scanner.nextLine();

                    ArrayList<Car> foundCars = cr1.findCar(brand, name, color);
                    if(foundCars.size() != 0) {
                        System.out.println("Diese(s) Auto(s) wurde gefunden:");
                        System.out.println(cr1.carListToString(foundCars));
                    } else {
                        System.out.println("Es wurden keine Autos gefunden die den Kriterien entsprechen.");
                    }
                }
                case 7 -> {
                    System.out.println("Programm wird beendet...");
                    System.exit(0);
                }
                default -> System.out.println(ConsoleColors.RED + "Fehler: Ungueltige Eingabe!" + ConsoleColors.RESET);
            }
        }
    }
}