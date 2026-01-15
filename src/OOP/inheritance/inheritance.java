package OOP.inheritance;

class User {
    public String name;
    public String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void login() {
        System.out.println("You are logged in with: " + this.email);
    }
    public void showDashboard() {
        System.out.println("Welcome to your dashboard");
    }
}

class Admin extends User {

    public Admin(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome Admin");
    }

    public void manageUser() {
        System.out.println("You can manage Users");
    }
}

class Manager extends User {

    public Manager(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome Manager");
    }

    public void approveIntern() {
        System.out.println("You can approve new interns letters");
    }
}

class Employee extends User {

    public Employee(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Your are logged in as Admin");
    }
}
public class inheritance {
    public static void main(String[] args) {
        Employee e = new Employee("Abdullah", "ab@ab.com");
        e.login();

        Manager m = new Manager("Ahmed", "ad@ad.com");
        m.login();

        Admin a = new Admin("Haifa", "ha@ha.com");
        a.login();
    }
}
