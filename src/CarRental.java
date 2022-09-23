import java.util.ArrayList;

public class CarRental {
    private static String[] brands = {"BMW", "Mercedes", "Audi", "VW", "Opel", "Ford", "Fiat", "Renault", "Peugeot", "Citroen"};
    private static String[] names = {"M3", "A45", "RS6", "Golf GTI", "Astra", "Focus", "500", "Clio", "308", "C4"};
    private static String[] colors = {"rot", "blau", "schwarz", "weiß", "grün", "gelb", "orange", "lila", "pink", "braun"};
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Car> rentedCars = new ArrayList<>();

    public CarRental(int arraySize){
        for(int i = 0; i < arraySize; i++){
            cars.add(new Car((int) (Math.random() * 1000), (int) (Math.random() * 10), (int) (Math.random() * 100), getRandom(names), getRandom(colors),getRandom(brands)));
        }
        for (Car car: cars
             ) {
            car.printDescription();
        };
    }
    private String getRandom(String[] array){
        return array[(int) (Math.random() * array.length)];
    }
    public boolean findCar(String brands, String names, String colors){
        return false;
    }

    public boolean isAvailable(Car car){
        return !rentedCars.contains(car);
    }
    public boolean rentCar(Car car){
        if(isAvailable(car)){
            rentedCars.add(car);
            return true;
        }else return false;
    }
    public boolean returnCar(Car car){
        if(rentedCars.contains(car)){
            rentedCars.remove(car);
            return true;
        }else return false;
    }

}