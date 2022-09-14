public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(1337, 2, 100, "Delorean - DMC 12", "grau", "Delorean-Motor-Company");
        c1.printDescription();
        System.out.println("c1.getMaxKilometers() = " + c1.getMaxKilometers());
        System.out.println("c1.isReachable(30) = " + c1.isReachable(30));
        System.out.println("c1.getMaxKilometers() = " + c1.getMaxKilometers());
        System.out.println("c1.isReachable(10) = " + c1.isReachable(10));
        c1.drive(10);
        System.out.println("c1.getMaxKilometers() = " + c1.getMaxKilometers());

        Car c2 = new Car(187, 3, 100, "5er", "mattschwarz", "BMW");
        c2.printDescription();
    }
}