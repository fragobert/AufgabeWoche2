import java.util.ArrayList;

public class CarRental {
    private static String[] brands = {"BMW", "Mercedes", "Audi", "VW", "Opel", "Ford", "Fiat", "Renault", "Peugeot", "Citroen"};
    private static String[] names = {"M3", "A45", "RS6", "Golf GTI", "Astra", "Focus", "500", "Clio", "308", "C4"};
    private static String[] colors = {"rot", "blau", "schwarz", "weiß", "grün", "gelb", "orange", "lila", "pink", "braun"};
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Car> rentedCars = new ArrayList<>();

    public CarRental(int arraySize){
        cars.add(new Car(2019, 10, 100, "M3", "rot", "BMW"));
    }
    public ArrayList<Car> findCars(String brands, String names, String colors){
        return null;
    }

    public boolean isAvailable(Car car){
        return !rentedCars.contains(car);
    }
    public boolean rent(Car car){
        if(isAvailable(car)){
            rentedCars.add(car);
            return true;
        }else return false;
    }

}