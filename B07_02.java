package Hw8;

import java.util.ArrayList;

public class B07_02 {
	
    public static void main(String[] args) {
        String inputFile = "src\\Hw8\\Toy_input.int32";
        String outputFile = "src\\Hw8\\Toy_output.out32";

        Toy[] toys = {
            new Toy("Car", 400.0, 3, 6),
            new Toy("Ball", 150.0, 5, 9),
            new Toy("Doll", 300.0, 2, 5)
        };
        
        Toy.write(toys, inputFile);
        toys = Toy.read(inputFile);
        
        int childAge = 5;

        ArrayList<Toy> suitableToys = new ArrayList<>();
        for (int i = 0; i < toys.length; i++) {
            Toy toy = toys[i];
            if (childAge >= toy.minAge && childAge <= toy.maxAge) {
                suitableToys.add(toy);
            }
        }

        Toy.write(suitableToys.toArray(new Toy[0]), outputFile);
        System.out.println("Result file: " + outputFile);
    }
}
