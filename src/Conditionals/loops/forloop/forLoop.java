package Conditionals.loops.forloop;

public class forLoop {
    public static void main(String[] args) {
        int[] arr = new int[6];
        for(int i = 0; i < 6; i++) {
            arr[i] = i;
        }

        // ehnanced for loop
        for(int i: arr) {
            if(i < 5)
                System.out.print("[" + i + "]" + " , ");
            else
                System.out.print("[" + i + "]");
        }
    }
}
