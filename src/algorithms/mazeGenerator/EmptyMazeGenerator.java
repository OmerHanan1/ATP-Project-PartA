package algorithms.mazeGenerator;

public class EmptyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int r, int c) {
        Maze maze = new Maze(r, c);
        maze.initialize();
        // Can be improved by generating a
        // randomize start/goal position setter.
        return maze;
    }
}
