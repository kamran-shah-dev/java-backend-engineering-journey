package Exceptions;

class ClassRoom {
    public int space;
    public ClassRoom (int space) {
        this.space = space;
    }

    public boolean hasSpace() {
        return this.space > 0;
    }
    public void bookASeat(int seatNo) throws notEnoughSpace {
        if(hasSpace()) {
            System.out.println("your  seat number is: " + seatNo);
            this.space --;
        } else {
            throw new notEnoughSpace();
        }
    }
}

public class CustomException {
    public static void main(String[] args) throws notEnoughSpace {
        ClassRoom class11 = new ClassRoom(5);
        try {
            class11.bookASeat(1);
            class11.bookASeat(2);
            class11.bookASeat(3);
            class11.bookASeat(4);
            class11.bookASeat(5);
            class11.bookASeat(6);
        } catch (notEnoughSpace e) {
            System.out.println(e);
        }

    }
}
