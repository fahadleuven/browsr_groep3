package view;

public class Position {

    private  int x;
    private  int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    public static Position sum(Position p1, Position p2) {
        return Position.of(p1.x + p2.x, p1.y + p2.y);
    }
}
