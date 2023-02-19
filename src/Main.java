import java.io.File;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        String filename = "toys.dat";

        if (! new File(filename).isFile()) {
            Toy.testData(filename);
        }

        ArrayList<Toy> newToys= Toy.readFile(filename);

        for(Toy t : newToys)
            System.out.println(t.toString());

        System.out.println("");

        Toy toy3 = new Toy("конструктор", 25, 10);
        newToys.add(toy3);
        Toy.safeFile(newToys, filename);
        ArrayList<Toy> newToys2= Toy.readFile(filename);
        for(Toy t : newToys2)
            System.out.println(t.toString());
    }

}
