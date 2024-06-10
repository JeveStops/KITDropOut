package edu.kit.commands;

/**
 * A class containing the functionality of the field-command for convenient usage.
 *
 * @author uijyl
 */
public class FieldCommand {
    public FieldCommand() {

    }

    /**
     * This method returns the colour of the field or the orientation of the ant (with the correct casing)
     * on the given coordinates.
     * @param currentGameBoard represents the current game board that the field-command will be referencing.
     * @param rowIndex represents the x-coordinate inside the matrix.
     * @param colIndex represents the y-coordinate inside the matrix.
     * @return This method returns the character on the specified position of the matrix.
     */
    public char field(char[][] currentGameBoard, int rowIndex, int colIndex) {
        return HelperMethod.fieldCheck(currentGameBoard, rowIndex, colIndex);
    }
}
