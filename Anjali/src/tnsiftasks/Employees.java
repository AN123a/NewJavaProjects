package tnsiftasks;

import tnsiftasks.Developer;
import tnsiftasks.Employees;
import tnsiftasks.Manager;

class Employees {

    protected String name;
    protected int employeeId;
    private double salary;

    public Employees(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10; 
    }

}

class Manager extends Employees {

    private int teamSize;

    public Manager(String name, int employeeId, double salary, int teamSize) {
        super(name, employeeId, salary);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + (50 * teamSize); 
    }

    public void reporting() {
        System.out.println("Manager " + name + " is generating reports.");
    }
}

class Developer extends Employees {

    private String programmingLanguage;

    public Developer(String name, int employeeId, double salary, String programmingLanguage) {
        super(name, employeeId, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + 200; 
    }

    public void code() {
        System.out.println("Developer " + name + " is coding in " + programmingLanguage + ".");
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Alice", 123, 80000, 5);
        Developer developer = new Developer("Bob", 456, 70000, "Java");

        System.out.println("Manager's bonus: $" + manager.calculateBonus());
        System.out.println("Developer's bonus: $" + developer.calculateBonus());

        manager.reporting();
        developer.code();
    }
}