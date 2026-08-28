class Employee {
    private int empId;
    private String empName;
    private double salary;

    Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }
}

class ManagerEmployee extends Employee {
    private double teamBonus;

    ManagerEmployee(int empId, String empName, double salary, double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}

class InternEmployee extends Employee {
    private double stipendCap;

    InternEmployee(int empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    double effectiveSalary() {
        return Math.min(getSalary(), stipendCap);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {

        Employee plain = new Employee(1, "A", 40000);
        ManagerEmployee manager = new ManagerEmployee(2, "B", 70000, 8000);
        InternEmployee intern = new InternEmployee(3, "C", 12000, 10000);

        System.out.println("Plain employee pay: Rs " + plain.getSalary());
        System.out.println("Manager effective pay: Rs " + manager.effectiveSalary());
        System.out.println("Intern effective pay: Rs " + intern.effectiveSalary());
    }
}