package Conditionals.loops;

import java.util.List;

class order {
    public String orderId;
    public String orderStatus;
    order(String orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }
}
class payment {
    public boolean payment_status;
    payment(boolean payment_status) {this.payment_status = payment_status;}
}


public class Scenario_1_Loops_x_OOP {
    public static void main(String[] args) {
        List<order> orderList = List.of(
                new order("H001" , "ACTIVE"),
                new order("H002" , "ACTIVE"),
                new order("H003" , "ACTIVE"),
                new order("H004" , "CANCELLED"),
                new order("H005" , "ACTIVE")
        );
        List<payment> paymentList = List.of(
                new payment(true),
                new payment(true),
                new payment(false),
                new payment(false),
                new payment(true)
        );

        int successCount = 0;

        for (int i = 0; i < orderList.size(); i ++) {
            if(orderList.get(i).orderStatus.equals("ACTIVE") && paymentList.get(i).payment_status)
            {
                System.out.println("User with id = " + orderList.get(i).orderId + " , your payment is Successful.");
                successCount++;
            }
            if(orderList.get(i).orderStatus.equals("ACTIVE") && !paymentList.get(i).payment_status)
            {
                System.out.println("User with id = " + orderList.get(i).orderId + " , your payment is Pending.");
            }
            if(orderList.get(i).orderStatus.equals("CANCELLED"))
            {
                System.out.println("User with id = " + orderList.get(i).orderId + " , your payment is failed.");

            }
        }
        float count = successCount;
        System.out.println("Success Percentage = " + (count/orderList.size()) * 100.0);
    }
}
