package OOP.Interface;

interface payments {
    public void pay(double amount);
    public int number = 55;
}

class paypal implements payments {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of: " + amount + " through PaPal");
    }
}

class Wise implements payments {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of: " + amount + " through Wise");
    }
}

public class Interface_Implementation {
    public static void main(String[] args) {
        Wise pay = new Wise();
        pay.pay(5000);
    }
}
