package Hw8;

import java.io.*;
import java.util.ArrayList;

public class Toy implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    public String name;
    public double price;
    public int minAge;
    public int maxAge;

    public Toy(String name, double price, int minAge, int maxAge) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return name + ": " + price + " - (" + minAge + " to " + maxAge + ")";
    }

    public static void write(Toy[] array, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
        	for (int i = 0; i < array.length; i++) {
        	    out.writeObject(array[i]);
        	}
        } catch (IOException e) {e.printStackTrace();}
    }

    public static Toy[] read(String filename) {
        ArrayList<Toy> list = new ArrayList<>();
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    list.add((Toy) in.readObject());
                } catch (EOFException e) {break;}
                catch (ClassNotFoundException e) {e.printStackTrace();}
            }
        } catch (IOException e) {e.printStackTrace();}
        
        return list.toArray(new Toy[0]);
    }
}

