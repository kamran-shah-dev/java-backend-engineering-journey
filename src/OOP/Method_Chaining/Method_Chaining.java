package OOP.Method_Chaining;

class user_status {
    public String profile_status;
    public boolean profile_completed;
    public String subscription_plan;
    public String payment_status;

    public user_status setPayment_status(String payment_status) {
        this.payment_status = payment_status;
        return this;
    }

    public user_status setProfile_status(String profile_status) {
        this.profile_status = profile_status;
        return this;
    }

    public user_status setProfile_completed(boolean profile_completed) {
        this.profile_completed = profile_completed;
        return this;
    }

    public user_status setSubscription_plan(String subscription_plan) {
        this.subscription_plan = subscription_plan;
        return this;
    }

    public void printUserInfo() {
        System.out.println("Profile Status: " + profile_status);
        System.out.println("Profile Completed: " + profile_completed);
        System.out.println("Subscription Plan: " + subscription_plan);
        System.out.println("Payment Status: " + payment_status);
    }



}


public class Method_Chaining {
    public static void main(String[] args) {
        user_status u = new user_status().setProfile_status("Verified").setProfile_completed(true).setSubscription_plan("Pro").setPayment_status("Paid");
        u.printUserInfo();
    }
}
