package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    public String weapon(){
        Random rand = new Random();
        List<String> shapes = new ArrayList<>();
        shapes.add("rock");
        shapes.add("paper");
        shapes.add("scissors");
        System.out.print(shapes.get(rand.nextInt(shapes.size())));
        return shapes.get(rand.nextInt(shapes.size()));
    }
}
