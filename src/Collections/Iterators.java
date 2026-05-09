package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {
    public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(3);
        newList.add(4);
        newList.add(5);

        Iterator<Integer> it = newList.iterator();
        while (it.hasNext()) {
            Integer value = it.next();
            if (value % 2 == 0) {
                it.remove();
            }
            else
                System.out.println(value);
        }

    }
}
