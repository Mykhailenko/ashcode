package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simulator {

    private int B;

    private int R;

    private int C;

    private int F;

    private int T;

    private int score = 0;

    private List<Car> cars = new ArrayList<Car>();

    private Set<Ride> nonAsignedRides = new HashSet<Ride>();


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
                if (k >= 0) {
                    ride.setPrice(B + ride.distanceD());
                } else {
                    int k2 = ride.getLatestFinish() - (t + free.getCord().dist(ride.getStart()) + ride.distanceD());
                    if (k2 >= 0) {
                        ride.setPrice(ride.distanceD());
                    } else {
                        ride.setPrice(0);
                    }
                }
            }
            Ride max = null;
            for (Ride r : nonAsignedRides) {
                if (max == null) {
                    max = r;
                } else {
                    if (max.getPrice() < r.getPrice()) {
                        max = r;
                    }
                }
            }
            nonAsignedRides.remove(max);
            score += max.getPrice();
            free.setRide(max, t);
            return true;
        } else {
            return false;
        }

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
