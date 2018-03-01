package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String in = "/home/hlib/activeeon/ashcode/a_example.in";

        String out = "/home/hlib/activeeon/ashcode/a_example.out";

        Simulator simulator = IOData.fromFile(in);

        simulator.simulate();

        System.out.println("Score " + simulator.score());

        IOData.writeToFile(out, simulator.getCars());


    }
}
