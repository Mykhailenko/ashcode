package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simulator {

    private String algo;

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }

    private int B;

    private int R;

    private int C;

    private int F;

    private int T;

    private int score = 0;

    private List<Car> cars = new ArrayList<Car>();

    private Set<Ride> nonAsignedRides = new HashSet<Ride>();

    private int lostRide = 0;

    int allProstoy = 0;

    int k_threshold = Integer.MAX_VALUE;

    double alpha = 0.0001;

    public String fileName ;

    private boolean tryToAssign(int t) {
        Car free = null;
        for (Car car : cars) {
            if (car.isFree()) {
                free = car;
                break;
            }
        }

        if (free != null) {
            if (nonAsignedRides.isEmpty()) {
                return false;
            }
            for (Ride ride : nonAsignedRides) {

                int k = koef(t, free, ride);
                double newk = B + ride.distanceD() - alpha * k;
                if (k >= 0 && k < k_threshold) {
                    ride.setProstoy(k);
                    ride.setPrice2(newk);
                    ride.setPrice(B + ride.distanceD());
                } else {
                    double k2 = ride.getLatestFinish() - (t + free.getCord().dist(ride.getStart()) + ride.distanceD());
                    if (k2 >= 0) {
                        ride.setPrice2(ride.distanceD());
                        ride.setPrice(ride.distanceD());
                    } else {
                        ride.setPrice(0);
                        ride.setPrice2(0);
                    }
                }
            }

            Ride max = null;
            for (Ride r : nonAsignedRides) {
                if (max == null) {
                    max = r;
                } else {
                    if (max.getPrice2() < r.getPrice2()) {
                        max = r;
                    }
                }
            }
            Ride closest = null;
            for (Ride nonAsignedRide : nonAsignedRides) {
                if(closest == null){
                    closest = nonAsignedRide;
                } else {
                    if( free.getCord().dist(closest.getStart()) > free.getCord().dist(nonAsignedRide.getStart())){
                        closest = nonAsignedRide;
                    }
                }
            }

            Ride timest = null;
            for (Ride nonAsignedRide : nonAsignedRides) {
                if(timest == null){
                    timest = nonAsignedRide;
                } else {
                    if( nonAsignedRide.getEarliestStart() < timest.getEarliestStart()){
                        timest = nonAsignedRide;
                    }
                }
            }
            Ride choosen;
            if(fileName.contains("no_hurry")){
                choosen = closest;
            }else{
                choosen = timest;
            }

            allProstoy += choosen.getProstoy();
            nonAsignedRides.remove(choosen);
            score += choosen.getPrice();
            free.setRide(choosen, t);
            return true;
        } else {
            return false;
        }

    }

    public int getAllProstoy() {
        return allProstoy;
    }

    private int koef(int t, Car free, Ride ride) {
        return ride.getEarliestStart() - (t + free.getCord().dist(ride.getStart()));
    }

    public int score() {
        return score;
    }

    public void simulate() {
        for (int t = 0; t < T; ++t) {
            while (tryToAssign(t)) ;

            for (Car car : cars) {
                car.move();
            }

        }
    }

    private void move(Car car, int t) {
        if (car.isFree()) {
            return;
        } else {
            Ride ride = car.getRide();

        }
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int getF() {
        return F;
    }

    public void setF(int f) {
        F = f;
    }

    public int getT() {
        return T;
    }

    public void setT(int t) {
        T = t;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Set<Ride> getNonAsignedRides() {
        return nonAsignedRides;
    }

    public void setNonAsignedRides(Set<Ride> nonAsignedRides) {
        this.nonAsignedRides = nonAsignedRides;
    }
}
