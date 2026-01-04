import java.util.UUID;

public class Staff {
    protected String id;
    protected String name;
    protected String position;
    protected double salary;

    // Конструктор с валидацией
    public Staff(String name, String position, double salary) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        setName(name);
        setPosition(position);
        setSalary(salary);
    }

    // Валидирующие сеттеры
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be empty");
        }
        this.position = position;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    // Геттеры
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    // Методы для переопределения
    public void work() {
        System.out.println(name + " is working as " + position);
    }

    public double calculateBonus() {
        return salary * 0.05; // 5% базовый бонус
    }

    public String getInfo() {
        return String.format("[Staff] %s (ID: %s) - %s - Salary: $%.2f",
                name, id, position, salary);
    }

    @Override
    public String toString() {
        return getInfo();
    }
}