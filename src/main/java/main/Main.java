package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Simulator simulator = IOData.fromFile(args[0]);

        simulator.simulate();

        System.out.println("Score " + simulator.score());

        IOData.writeToFile(args[1], simulator.getCars());


    }
}
