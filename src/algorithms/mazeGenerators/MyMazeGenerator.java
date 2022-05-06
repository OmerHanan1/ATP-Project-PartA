package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MyMazeGenerator extends AMazeGenerator {
    /**
     * generates maze using DFS
     * //TODO: update the comments:
     * Algorithm steps:
     * (1)
     * (2)
     * (3)
     */
    @Override
    public Maze generate(int r, int c) {
        return DFSMazeGenerator(r, c);
    }

    private Maze DFSMazeGenerator(int rows, int columns) {
        // Arrange
        Random random = new Random();
        Maze maze = new Maze(rows, columns);
        Stack<Position> neighbours = new Stack<>();
        ArrayList<Position> neighbourWalls;
        maze.WallInitialize();

        // Pushing the first position into the stack
        Position currentPosition = maze.getStartPosition();
        maze.SetTransition(currentPosition);
        neighbours.push(currentPosition);

        while (!neighbours.isEmpty()) { // While the neighbours stack is not empty
            currentPosition = neighbours.pop();
            neighbourWalls = maze.wallsTwoStepsAway(currentPosition);

            if (neighbourWalls.size() != 0) {
                neighbours.push(currentPosition);
                Position randNeighbour = neighbourWalls.get(random.nextInt(neighbourWalls.size()));
                maze.SetTransition(randNeighbour);
                maze.connectNeighbours(currentPosition, randNeighbour);
                neighbours.push(randNeighbour);
            }
        }
        maze.SetTransition(new Position(rows - 1, columns - 2)); // Bug fix
        return maze;
    }
}