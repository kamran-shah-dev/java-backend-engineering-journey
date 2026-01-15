package OOP.abstraction;

import java.util.Scanner;

abstract class paymentProcessor {
    public final void processPayments(double amount) {
        validate(amount);
        executePayments(amount);
        log(amount);
        notifyUser(amount);
    }

    abstract void executePayments(double amount);
    public void validate(double amount) {
        System.out.println("Validated amount: " + amount);
    }

    public void log(double amount) {
        System.out.println("Adding to logs the validated amount: " + amount);
    }

    public void notifyUser(double amount) {
        System.out.println("You paid " + amount);
    }
}

class payoneerPaymentMethod extends paymentProcessor {
    @Override
    public void executePayments(double amount) {
        System.out.println("Payment is being done with payoneer");
    }
}
class wisePaymentMethod extends paymentProcessor {
    @Override
    public void executePayments(double amount) {
        System.out.println("Payment is being done with Wise");
    }
}
public class abstract_classes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String paymentMethod = "";

        System.out.println("Enter your payment method Wise or Payoneer: ");
        paymentMethod = input.nextLine();

        if(paymentMethod.equals("Wise") || paymentMethod.equals("wise")) {
            wisePaymentMethod pay = new wisePaymentMethod();
            pay.processPayments(50000);
        } else  {
            payoneerPaymentMethod pay = new payoneerPaymentMethod();
            pay.processPayments(50000);
        }
    }
}
