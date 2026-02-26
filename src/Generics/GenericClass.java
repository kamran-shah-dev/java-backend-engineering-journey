package Generics;

class weight <T> {
    private T we;

    public weight(T t)
    {
        this.we = t;
    }

    public T getWe() {
        return we;
    }
}

class weightKG <T , S> {
    private T we;
    private S kg;
    public weightKG(T we, S kg)
    {
        this.we = we;
        this.kg = kg;
    }

    public T getWe() {
        return we;
    }
    public S getKg() {
        return kg;
    }

}

public class GenericClass {
    public static void main(String[] args) {
        weightKG<Double , String> w = new weightKG<>(67.8, "KG");
        System.out.println(w.getWe() + w.getKg());
    }
}
