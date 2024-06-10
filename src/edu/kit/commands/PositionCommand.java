package edu.kit.commands;

/**
 * A class containing the functionality of the position-command for convenient usage.
 *
 * @author uijyl
 */
public class PositionCommand {
    public PositionCommand() {

    }

    /**
     * This method returns the current position of the ant.
     * @param currentGameBoard represents the current game board that the position-
     * @return The x and y coordinate of the position of the ant.
     */
    public int[] position(char[][] currentGameBoard) {
        return HelperMethod.positionCheck(currentGameBoard);
    }
}
