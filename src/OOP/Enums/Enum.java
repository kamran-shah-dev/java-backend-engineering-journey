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
            case Paid:
                System.out.println("Your payment is completed");
                break;
            case Pending:
                System.out.println("Your order is pending");
                break;
            case Cancelled:
                System.out.println("Your order is cancelled");
                break;
            case Shipped:
                System.out.println("Your order is shipped");
                break;
            default:
                System.out.println("Error");
        }
    }
    public static void main(String[] args) {
        paymentStatus(orderStatus.Paid);
    }
}
