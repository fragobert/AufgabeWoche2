public class Car {
    final private int model, fuelConsumption;
    private int fuelLevel;
    final private String name, color, brand;

    public Car(int model, int fuelConsumption, int fuelLevel, String name, String color, String brand) {
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        this.name = name;
        this.color = color;
        this.brand = brand;
    }

    public void printDescription() {
        System.out.println("Ich bin ein " + color + "er " + name + ", Modell " + model + " von der Marke " + brand + ".");
        System.out.println("Ich verbrauche " + fuelConsumption + " liter Benzin pro Kilometer und habe noch " + fuelLevel + " Liter im Tank!");
    }

    public int getMaxKilometers() {
        return fuelLevel / fuelConsumption;
    }

    public boolean isReachable(int km) {
        return fuelLevel / fuelConsumption >= km;
    }

    public void drive(int km) {
        if(isReachable(km)) fuelLevel -= fuelConsumption*km;
    }
}
