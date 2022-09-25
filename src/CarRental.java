import java.util.ArrayList;

public class CarRental {
    private static final String[] brands = {"BMW", "Mercedes", "Audi", "VW", "Opel", "Ford", "Fiat", "Renault", "Peugeot", "Citroen"};
    private static final String[] names = {"M3", "A45", "RS6", "Golf GTI", "Astra", "Focus", "500", "Clio", "308", "C4"};
    private static final String[] colors = {"rot", "blau", "schwarz", "weiß", "grün", "gelb", "orange", "violett", "pink", "braun"};
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Car> rentedCars = new ArrayList<>();

    public CarRental(int arraySize) {
        if (arraySize < 0) {
            System.out.println(ConsoleColors.RED + "Fehler: Die Anzahl der Autos darf nicht kleiner als 0 sein!" + ConsoleColors.RESET);
            System.exit(0);
        }
        for (int i = 0; i < arraySize; i++) {
            cars.add(new Car((int) (Math.random() * 1000), (int) (Math.random() * 10), (int) (Math.random() * 100), getRandom(names), getRandom(colors), getRandom(brands)));
        }
    }

    private String getRandom(String[] array) {
        return array[(int) (Math.random() * array.length)];
    }

    public boolean findCar(String brands, String names, String colors) {
        return false;
    }

    public boolean isAvailable(Car car) {
        return !rentedCars.contains(car);
    }

    public void rentCar(int index) {
        if (index < cars.size() && index >= 0) {
            if (isAvailable(cars.get(index-1))) {
                rentedCars.add(cars.get(index-1));
                System.out.println("Das Auto wurde erfolgreich ausgeliehen!");

            } else System.out.println("Der " + cars.get(index-1).getColor() + "e " + cars.get(index-1).getName() + " ist leider nicht verfügbar!");

        } else System.out.println("Das Auto existiert nicht!");

    }

    public boolean returnCar(Car car) {
        if (rentedCars.contains(car)) {
            rentedCars.remove(car);
            return true;
        } else return false;
    }

    private static String stringFormatter(String string) {
        return String.format("%1$" + 10 + "s", string);
    }

    private static String stringFormatter(String string, int length) {
        return String.format("%1$" + 10 + "s", string);
    }

    public void getCars() {
        if (cars.size() == 0) {
            System.out.println("Es sind keine Autos vorhanden!");
        } else {
            System.out.println("Alle existierenden Autos:");
            System.out.println(ConsoleColors.BOXING + " Index" + " " + stringFormatter("Brand") + " " + stringFormatter("Name") + " " + stringFormatter("Color") + " " + stringFormatter("Model") + " ");
            for (Car car : CarRental.this.cars) {
                System.out.println(ConsoleColors.WHITE_BRIGHT + " " + car.getIndexCar() + "\t   " + stringFormatter(car.getBrand()) + " " + stringFormatter(car.getName()) + " " + stringFormatter(car.getColor()) + " " + stringFormatter(Integer.toString(car.getModel())));
            }
        }

    }

    public void getRentedCars() {
        if (rentedCars.size() == 0) {
            System.out.println("Es sind zurzeit keine Autos vermietet!");
        } else {
            System.out.println("Alle zurzeit vermieteten Autos:");
            System.out.println(ConsoleColors.BOXING + " Index" + " " + stringFormatter("Brand") + " " + stringFormatter("Name") + " " + stringFormatter("Color") + " " + stringFormatter("Model") + " ");
            for (Car car : CarRental.this.rentedCars) {
                System.out.println(ConsoleColors.WHITE_BRIGHT + " " + car.getIndexCar() + "\t\t" + stringFormatter(car.getBrand()) + " " + stringFormatter(car.getName()) + " " + stringFormatter(car.getColor()) + " " + stringFormatter(Integer.toString(car.getModel())));
            }
        }
    }
}