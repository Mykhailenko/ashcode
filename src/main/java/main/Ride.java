package main;

public class Ride {
    private final int id;

    private final Cord start;

    private final Cord finish;

    private final int earliestStart;

    private final int latestFinish;


    public Ride(int id, Cord start, Cord finish, int earliestStart, int latestFinish) {
        this.id = id;
        this.start = start;
        this.finish = finish;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        return id == ride.id;
    }


    public int getId() {
        return id;
    }

    public Cord getStart() {
        return start;
    }

    public Cord getFinish() {
        return finish;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
