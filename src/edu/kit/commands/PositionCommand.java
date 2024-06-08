package edu.kit.commands;

/**
 * A class containing the functionality of the position-command for convenient usage.
 *
 * @author uijyl
 */
public class PositionCommand {
    public PositionCommand() {

    }

    private static final int TWO = 2;

    /**
     * This method returns the current position of the ant.
     * @param currentGameBoard represents the current game board that the position-
     * @return This method returns the position of the only non digit character on the game board which represents the ant.
     */
    public int[] position(char[][] currentGameBoard) {
        int[] coordinates = new int[TWO];
        int rows = currentGameBoard.length;
        int cols = currentGameBoard[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!Character.isDigit(currentGameBoard[i][j])) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        return coordinates;
    }
}
