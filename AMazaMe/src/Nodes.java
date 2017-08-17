public class Nodes {

    private int x, y, maxX, maxY;
    private Nodes[] neighbors;
    private char mark;

    public Nodes(int x, int y, int maxX, int maxY) {
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
        this.mark = '#';
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Nodes getNode(int x, int y) {
        return this;
    }

    public Nodes[] getNeighbors() {
        return this.neighbors;
    }

    public void setChar(char mark) {
        this.mark = mark;
    }

    public char getChar() {
        return this.mark;
    }

    public void setNeighbors(Nodes[] nodes) {
        this.neighbors = nodes;
    }
}
