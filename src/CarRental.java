import java.util.ArrayList;

public class CarRental {
    private static final String[] brands = {"BMW", "Mercedes", "Audi", "VW", "Opel", "Ford", "Fiat", "Renault", "Peugeot", "Citroen"};
    private static final String[] names = {"M3", "A45", "RS6", "Golf GTI", "Astra", "Focus", "500", "Clio", "308", "C4"};
    private static final String[] colors = {"rot", "blau", "schwarz", "weiß", "grün", "gelb", "orange", "violett", "pink", "braun"};
    private final ArrayList<Car> cars = new ArrayList<>();
    private final ArrayList<Car> rentedCars = new ArrayList<>();

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

    public ArrayList<Car> findCar(String brand, String name, String color) {
        ArrayList<Car> foundCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equals(brand) && car.getName().equals(name) && car.getColor().equals(color)) {
                foundCars.add(car);
                return foundCars;
            }
        }
        return foundCars;
    }

    public boolean isAvailable(int index) {
        return !rentedCars.contains(cars.get(index - 1));
    }

    public boolean rentCar(int index) {
        if (index < cars.size() && index > 0) {
            if (isAvailable(index)) {
                rentedCars.add(cars.get(index - 1));
                return true;

            } else return false;
        } else return false;

    }

    public boolean returnCar(int index) {
        if (index > 0 && index <= cars.size()) {
            if (rentedCars.contains(cars.get(index - 1))) {
                rentedCars.remove(cars.get(index - 1));
                return true;
            } else return false;
        } else return false;
    }

    public String stringFormatter(String string) {
        return String.format("%1$" + 10 + "s", string);
    }

    public String carListToString(ArrayList<Car> cars){
        String string = ConsoleColors.BOXING + " Index" + " " + stringFormatter("Brand") + " " + stringFormatter("Name") + " " + stringFormatter("Color") + " " + stringFormatter("Model") + " ";
        for (Car car : CarRental.this.rentedCars) {
            string += (ConsoleColors.WHITE_BRIGHT + " " + car.getIndexCar() + "\t\t" + stringFormatter(car.getBrand()) + " " + stringFormatter(car.getName()) + " " + stringFormatter(car.getColor()) + " " + stringFormatter(Integer.toString(car.getModel())));
        }
        return string;
    }

    public String getCars(int temp) {
        if (cars.size() != 0) {
            if(temp == 0) {
                return carListToString(cars);
            } else if (temp == 1) {
                return carListToString(rentedCars);
            } else return null;
        } else {
            return null;
        }
    }
}