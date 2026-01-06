package Strings;

import java.util.Locale;

public class JavaStrings {
    public static void main(String[] args) {

        // Strings are immutable so in any case we change anything in string it will create a new literl in string pool
        // Declaration and Initialization
        String message = "Hello";
        String message2 = new String("Hello");

        // String Methods
        String message3 = "Hello I am a student!";

        // length of string
        System.out.println(message3.length());

        // fetch any character (0 based indexes)
        System.out.println(message3.charAt(6)); // 'I'

        // Substring
        String message3_sub = message3.substring(0,5); // (start index, end index)
        System.out.println(message3_sub);

        // replace a word in string (will create a new string)
        String message3_replace = message3.replace("student", "Developer");
        System.out.println(message3_replace);

        // contains, startsWith, endsWidth methods
        System.out.println(message3.contains("am"));

        // uppercase and lowercase
        String uppercase_m3 = message3.toUpperCase();
        String lowercase_m3 = message3.toLowerCase();

        System.out.println(uppercase_m3);
        System.out.println(lowercase_m3);
    }
}
