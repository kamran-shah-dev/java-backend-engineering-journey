package OOP.Records;
interface users {

}

record user (String name, int age, float height)  {
    public void displayUser()
    {
        System.out.println("Name is: " + this.name);
        System.out.println("Age is: " + this.age);
        System.out.println("Height is: " + this.height);
    }
}

public class records {
    public static void main(String[] args) {
        user u = new user("Kamran", 23, 5.9f);
        u.displayUser();
        System.out.println(u.hashCode());
    }
}

