import java.util.Random;

public class RandPrim {

    private Nodes[][] maze;
    private int startX, startY, endX, endY;

    public RandPrim(Nodes[][] maze, int startX, int startY, int endX, int endY) {
        this.maze = maze;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        makeMaze();
    }

    private void makeMaze() {
        System.out.println("Making maze");
        Nodes[] walls = new Nodes[6];
        Random rand = new Random();
        this.maze[this.startX][this.startY].setChar(' ');
        this.maze[this.endX][this.endY].setChar(' ');
        walls[0] = maze[this.startX - 1][this.startY];
        walls[1] = maze[this.startX + 1][this.startY];
        walls[2] = maze[this.startX][this.startY + 1];
        walls[3] = maze[this.endX - 1][this.endY];
        walls[4] = maze[this.endX + 1][this.endY];
        walls[5] = maze[this.endX][this.endY - 1];


        while (walls.length > 0) {
            int pass = rand.nextInt(walls.length);
            Nodes node = walls[pass];
            Nodes[] nodes = node.getNeighbors();
            if (getPassage(nodes)) { //if only one neighbor is passage we change this node to passage
                node.setChar('.'); // and add walls to the walls list and remove this node from the list
                walls = makeChanges(walls, nodes, node);
            } else {
                walls = removeWall(walls, node);
            }
        }
    }

    private boolean getPassage(Nodes[] neighbors) {
        int emptyNode = 0;
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i].getChar() == ' ' || neighbors[i].getChar() == '.') {
                emptyNode++;
            }
        }
        if (emptyNode == 1) return true;
        return false;
    }

    private Nodes[] makeChanges(Nodes[] walls, Nodes[] neighbors, Nodes node) {
        int neighboringWalls = 0;
        for(int i = 0; i < neighbors.length; i++) {
            boolean onTheList = false;
            if(neighbors[i].getChar() == '#') {
                for(int j = 0; j < walls.length; j++) { // we have to check if the wall already is on the array
                    if(neighbors[i].getX() == walls[j].getX() && neighbors[i].getY() == walls[j].getY()) {
                        onTheList = true;
                        break;
                    }
                }
                if(onTheList) continue;
                else neighboringWalls++;
            }
        }
        Nodes[] temp = new Nodes[walls.length + neighboringWalls - 1];
        boolean visitedNode = false;
        int j = 0;
        for(int i = 0; i < walls.length; i++) {
            if(walls[i].getX() == node.getX() && walls[i].getY() == node.getY()) {
                visitedNode = true;
                continue;
            }
            if(visitedNode) {
                temp[i - 1] = walls[i];
                j++;
            } else {
                temp[i] = walls[i];
                j++;
            }
        }
        for(int i = 0; i < neighbors.length; i++) {
            if(neighbors[i].getChar() == ' ' || neighbors[i].getChar() == '.') {
                j--;
            }
            if(neighbors[i].getChar() == '#') {
                boolean onTheList = false;
                for(int k = 0; k < walls.length; k++) {
                    if(neighbors[i].getX() == walls[k].getX() && neighbors[i].getY() == walls[k].getY()) {
                        onTheList = true;
                        break;
                    }
                }
                if(onTheList) {
                    j--;
                    continue;
                }
                else temp[i + j] = neighbors[i];
            }
        }
        return temp;
    }

    private Nodes[] removeWall(Nodes[] walls, Nodes node) {
        Nodes[] temp = new Nodes[walls.length - 1];
        boolean visitedNode = false;
        for(int i = 0; i < walls.length; i++) {
            if(walls[i].getX() == node.getX() && walls[i].getY() == node.getY()) {
                visitedNode = true;
                continue;
            }
            if(visitedNode) {
                temp[i - 1] = walls[i];
            } else {
                temp[i] = walls[i];
            }
        }
        return temp;
    }
}
