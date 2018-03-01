package main;

public class Main {
    public static void main(String[] args) {
        Simulator simulator = IOData.fromFile(args[0]);

        simulator.simulate();

        System.out.println("Score " + simulator.score());

        IOData.writeToFile(args[1], simulator.getCars());


    }
}
