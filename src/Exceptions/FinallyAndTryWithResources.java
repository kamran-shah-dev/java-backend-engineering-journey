package Exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinallyAndTryWithResources {
    public static void main(String[] args) {

        // using finally keyword
        BufferedReader object = null;
        try {
            object = new BufferedReader(new FileReader("Exceptions/requirements.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("OOPs");
        } finally {
            try {
                if (object != null) {
                    object.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        // if the object's class implements a class that implement autoclosable, then we will
        // try with resources

        try (BufferedReader object2 = new BufferedReader(new FileReader("Exceptions/requirements.txt"))) {
            System.out.println("Reading the file");
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
