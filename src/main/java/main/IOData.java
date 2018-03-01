package main;

import java.io.*;
import java.util.*;

public class IOData {
    public static Simulator fromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        Set<Ride> rides = new HashSet<Ride>();
        Simulator simulator = new Simulator();
        simulator.fileName = path;
        String line = null;
        int rideId = 0;
        for(int i = 0; (line = br.readLine()) != null; ++i){
            String[] ar = line.split(" ");
            if(i == 0){
                int R = Integer.parseInt(ar[0]);
                int C = Integer.parseInt(ar[1]);
                int F = Integer.parseInt(ar[2]);
                int N = Integer.parseInt(ar[3]);
                int B = Integer.parseInt(ar[4]);
                int T = Integer.parseInt(ar[5]);
                simulator.setR(R);
                simulator.setC(C);
                simulator.setF(F);
                simulator.setB(B);
                simulator.setT(T);
            } else {
                int startR = Integer.parseInt(ar[0]);
                int startC = Integer.parseInt(ar[1]);
                int finishR = Integer.parseInt(ar[2]);
                int finsihC = Integer.parseInt(ar[3]);
                int earliestStart = Integer.parseInt(ar[4]);
                int latestFinish = Integer.parseInt(ar[5]);
                Ride ride = new Ride(rideId++, new Cord(startR, startC), new Cord(finishR, finsihC), earliestStart, latestFinish);
                simulator.getNonAsignedRides().add(ride);
            }
        }

        for(int i = 0; i < simulator.getF(); ++i){
            simulator.getCars().add(new Car(i));
        }

        br.close();
        return simulator;
    }

    public static void writeToFile(String path, List<Car> cars) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (Car car : cars) {
            StringBuffer sb = new StringBuffer(Integer.toString(car.getCompleted().size()));
            for (Ride ride : car.getCompleted()) {
                sb.append(" " + ride.getId());
            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
