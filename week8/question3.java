
import java.time.*;
import java.util.*;

abstract class Room {
    String name;
    double price;

    Room(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract double calculatePrice(long days);
}

class Deluxe extends Room {
    Deluxe(String name) {
        super(name, 200);
    }

    double calculatePrice(long days) {
        return price * days;
    }
}

class Standard extends Room {
    Standard(String name) {
        super(name, 150);
    }

    double calculatePrice(long days) {
        return price * days;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Room room;
    Customer customer;
    LocalDate start;
    LocalDate end;
    boolean active = true;

    Reservation(Room room, Customer customer,
                LocalDate start, LocalDate end) {
        this.room = room;
        this.customer = customer;
        this.start = start;
        this.end = end;
    }
}

class Hotel {
    ArrayList<Reservation> list = new ArrayList<>();

    void book(Room room, Customer customer,
              LocalDate start, LocalDate end) {

        for (Reservation r : list) {

            if (r.room == room && r.active &&
                start.isBefore(r.end) && end.isAfter(r.start)) {

                System.out.println("Booking failed: " + room.name
                        + " is not available.");
                return;
            }
        }

        Reservation r = new Reservation(room, customer, start, end);
        list.add(r);

        long days = java.time.temporal.ChronoUnit.DAYS
                .between(start, end);

        System.out.printf("%s booked. Total price: $%.2f%n",
                room.name, room.calculatePrice(days));
    }

    void cancel(Reservation r, LocalDate today) {

        if (today.isBefore(r.start)) {
            r.active = false;
            System.out.println("Reservation for " + r.room.name
                    + " cancelled successfully.");
        } else {
            System.out.println("Cancellation not allowed.");
        }
    }
}

public class question3 {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        Customer c = new Customer("Rahul");

        Room r1 = new Deluxe("Deluxe Room 101");
        Room r2 = new Standard("Standard Room 205");

        LocalDate d1 = LocalDate.of(2024, 12, 1);
        LocalDate d2 = LocalDate.of(2024, 12, 5);
        LocalDate d3 = LocalDate.of(2024, 12, 3);
        LocalDate d4 = LocalDate.of(2024, 12, 7);

        hotel.book(r1, c, d1, d2);
        hotel.book(r2, c, d3, d4);
        hotel.book(r1, c, d3, d4);

        Reservation booking = hotel.list.get(0);

        hotel.cancel(booking, LocalDate.of(2024, 11, 20));
    }
}
