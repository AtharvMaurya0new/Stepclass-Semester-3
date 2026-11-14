
import java.util.*;

class Customer {
    int id;
    String name;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object obj) {
        Customer c = (Customer) obj;

        return this.id == c.id && this.name.equals(c.name);
    }

    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class question2 {

    public static void main(String[] args) {

        HashSet<Customer> set = new HashSet<>();

        Customer c1 = new Customer(101, "Rahul");
        Customer c2 = new Customer(102, "Aman");
        Customer c3 = new Customer(101, "Rahul");

        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println("Customer exists: " + set.contains(c3));

        System.out.println("Total unique customers: " + set.size());
    }
}
