package main;

import org.apache.commons.cli.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        try {
            final CommandLine cmd = new DefaultParser().parse(getOptions(), args);


            Simulator simulator = IOData.fromFile(cmd.getOptionValue("in"));

            simulator.setAlgo(cmd.getOptionValue("alg"));
            simulator.simulate();

            System.out.println(simulator.score());

            IOData.writeToFile(cmd.getOptionValue("out"), simulator.getCars());
            return;
        } catch (Exception e) {
            e.printStackTrace();
            new HelpFormatter().printHelp("Main", getOptions());

        }

    }

    private static Options getOptions() {
        Options options = new Options();

        Option algo = new Option("alg", true, "algorithm to use ['closest', 'by-k', 'timest']");
        algo.setRequired(true);
        options.addOption(algo);

        Option in = new Option("in", true, "input file");
        in.setRequired(true);
        options.addOption(in);

        Option out = new Option("out", true, "output file");
        out.setRequired(true);
        options.addOption(out);

        return options;
    }
}
