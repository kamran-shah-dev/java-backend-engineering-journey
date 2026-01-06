package Conditionals;

import java.util.Objects;
import java.util.Scanner;
import java.util.SimpleTimeZone;

class User {
    public String name;
    public String CMS;
    public double age;

    public void userInfo (String name, String CMS, double age) {
        this.name = name;
        this.CMS = CMS;
        this.age = age;
    }
}

class processUser {
    public void process(User u) {
        if (u == null) return;
        if (u.age < 18) return;

        System.out.println( "Mr. " + u.name + " You are eligible and your CMS is: " + u.CMS);

    }
}

public class JavaConditionals {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter you rname: ");
        String name = userInput.nextLine();

        System.out.println("Enter you CMS: ");
        String CMS = userInput.nextLine();

        System.out.println("Enter you Age: ");
        double age = userInput.nextDouble();

        User u = new User();
        u.userInfo(name, CMS, age);

        processUser p = new processUser();
        p.process(u);
    }
}
