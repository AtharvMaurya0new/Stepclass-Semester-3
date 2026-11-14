
abstract class Vehicle {
    String name;
    boolean available = true;

    Vehicle(String name) {
        this.name = name;
    }

    abstract double calculateCharge(int days);
}

class LuxuryCar extends Vehicle {
    LuxuryCar(String name) {
        super(name);
    }

    double calculateCharge(int days) {
        return days * 100;
    }
}

class StandardCar extends Vehicle {
    StandardCar(String name) {
        super(name);
    }

    double calculateCharge(int days) {
        return days * 50;
    }
}

class Rental {
    Vehicle vehicle;
    int days;

    Rental(Vehicle vehicle, int days) {
        this.vehicle = vehicle;
        this.days = days;
    }
}

class RentalService {

    void rent(Vehicle v, int days) {
        if (!v.available) {
            System.out.println(v.name + " is not available.");
            return;
        }

        v.available = false;

        Rental r = new Rental(v, days);

        System.out.printf("%s rented for %d days. Total charge: $%.2f%n",
                v.name, days, v.calculateCharge(days));
    }

    void returnVehicle(Vehicle v) {
        if (v.available) {
            System.out.println(v.name + " is already available.");
            return;
        }

        v.available = true;

        System.out.println(v.name + " returned. Now available.");
    }
}

public class question2 {
    public static void main(String[] args) {

        LuxuryCar l = new LuxuryCar("Luxury Car A");
        StandardCar s = new StandardCar("Standard Car B");

        RentalService service = new RentalService();

        service.rent(l, 3);
        service.rent(s, 5);

        service.returnVehicle(l);
    }
}
