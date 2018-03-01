package main;

public class Cord {

    public int x = 0;

    public int y = 0;

    public Cord() {
        this.x = 0;
        this.y = 0;
    }

    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int dist(Cord cord){
        return Math.abs(this.x - cord.x) + Math.abs(this.y - cord.y);
    }
}
