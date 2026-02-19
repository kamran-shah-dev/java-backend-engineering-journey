package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
// throws keyword after function identifier, which is responsible for handling the exception
// throw keyword inside the catch block to forcefully throw an exception to the caller class
public class checkedExceptions {
    public static void main(String[] args) {
        // method 1 (using try catch)
        try {
            FileReader file = new FileReader("Exceptions/requirements.txt");
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }
        // method 2 (using throw keyword)
        try {
            FileReader file = new FileReader("Exceptions/requirements.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void filereader() throws FileNotFoundException {
        FileReader file = new FileReader("Exceptions/requirements.txt");
        // where this function is called there as well we need to use the throws keyword
    }
}
