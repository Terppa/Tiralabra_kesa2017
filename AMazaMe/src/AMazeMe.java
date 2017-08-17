public class AMazeMe {

    public static void main(String[] args) {
        Nodes[][] maze = new Nodes[20][30];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 30; j++) {
                maze[i][j] = new Nodes(i, j, 19, 29);
            }
        } // All nodes have been set-up, so let's get them neighbors
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 30; j++) {
                Nodes node = maze[i][j];
                if(i == 0) {
                    if(j == 0) {
                        Nodes[] nodes = new Nodes[2];
                        nodes[0] = maze[i + 1][j];
                        nodes[1] = maze[i][j + 1];
                        node.setNeighbors(nodes);
                    } else if(j == 29) {
                        Nodes[] nodes = new Nodes[2];
                        nodes[0] = maze[i][j - 1];
                        nodes[1] = maze[i + 1][j];
                        node.setNeighbors(nodes);
                    } else {
                        Nodes[] nodes = new Nodes[3];
                        nodes[0] = maze[i][j - 1];
                        nodes[1] = maze[i][j + 1];
                        nodes[2] = maze[i + 1][j];
                        node.setNeighbors(nodes);
                    }
                } else if(i == 19) {
                    if(j == 0) {
                        Nodes[] nodes = new Nodes[2];
                        nodes[0] = maze[i - 1][j];
                        nodes[1] = maze[i][j + 1];
                        node.setNeighbors(nodes);
                    } else if(j == 29) {
                        Nodes[] nodes = new Nodes[2];
                        nodes[0] = maze[i - 1][j];
                        nodes[1] = maze[i][j - 1];
                        node.setNeighbors(nodes);
                    } else {
                        Nodes[] nodes = new Nodes[3];
                        nodes[0] = maze[i - 1][j];
                        nodes[1] = maze[i][j + 1];
                        nodes[2] = maze[i][j - 1];
                        node.setNeighbors(nodes);
                    }
                } else if(j == 0) {
                    Nodes[] nodes = new Nodes[3];
                    nodes[0] = maze[i - 1][j];
                    nodes[1] = maze[i + 1][j];
                    nodes[2] = maze[i][j + 1];
                    node.setNeighbors(nodes);
                } else if(j == 29) {
                    Nodes[] nodes = new Nodes[3];
                    nodes[0] = maze[i - 1][j];
                    nodes[1] = maze[i + 1][j];
                    nodes[2] = maze[i][j - 1];
                    node.setNeighbors(nodes);
                } else {
                    Nodes[] nodes = new Nodes[4];
                    nodes[0] = maze[i][j - 1];
                    nodes[1] = maze[i][j + 1];
                    nodes[2] = maze[i - 1][j];
                    nodes[3] = maze[i + 1][j];
                    node.setNeighbors(nodes);
                }
            }
        }
        new RandPrim(maze, 10, 0 , 10, 29);
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 30; j++) {
                System.out.print(maze[i][j].getChar());
            }
            System.out.println(" ");
        }
    }
}
