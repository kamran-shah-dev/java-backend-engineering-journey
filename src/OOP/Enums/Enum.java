package OOP.Enums;

enum orderStatus{
    Paid,
    Pending,
    Cancelled,
    Shipped
}
public class Enum {

    static void paymentStatus(orderStatus order) {
        switch (order) {
            case Paid -> System.out.println("Your payment is completed");
            case Pending -> System.out.println("Your order is pending");
            case Cancelled -> System.out.println("Your order is cancelled");
            case Shipped -> System.out.println("Your order is shipped");
        }
    }
    public static void main(String[] args) {
        paymentStatus(orderStatus.Paid);
    }
}
