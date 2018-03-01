package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String in = args[0];
        String out = args[1];

        Simulator simulator = IOData.fromFile(in);

        simulator.simulate();

        System.out.println(simulator.score());

        IOData.writeToFile(out, simulator.getCars());


    }
}
