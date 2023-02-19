import java.io.*;
import java.util.ArrayList;

public class Toy implements Serializable{
    private int id;
    private String name;
    private int quantity;
    private int frequency;
    static int ch = 0;

    public Toy(String name, int quantity, int frequency) {
        ch += 1;
        this.id = ch;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "id - " + this.id + ", наименование - " + this.name + ", количество - " + this.quantity + ", частота - " + this.frequency;
    }

    public static void safeFile(ArrayList<Toy> toys, String filename){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(toys);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Toy> readFile(String filename){
        ArrayList<Toy> newToys= new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {

            newToys = ((ArrayList<Toy>)ois.readObject());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        return newToys;

    }

    public static void testData(String filename){
        ArrayList tous = new ArrayList<Toy>();
        Toy toy1 = new Toy("Мягкая игрушка", 25, 10);
        tous.add(toy1);
        Toy toy2 = new Toy("Жесткая игрушка", 10, 15);
        tous.add(toy2);
        safeFile(tous, filename);
    }
}
