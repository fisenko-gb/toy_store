import java.io.File;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        if (! new File(Toy.filename).isFile()) {
            Toy.testData();
        }

        System.out.println("Призы: ");
        Toy.getPrizeToy(10);

//        Toy toy1 = new Toy("Мягкая игрушка", 2, 17);
//        Toy toy2 = new Toy("Мягинькая игрушка", 2, 17);

        System.out.println("список: ");
        ArrayList<Toy> newToys= Toy.readFile();

        for(Toy t : newToys)
            System.out.println(t.toString());

        System.out.println("");
    }

}
