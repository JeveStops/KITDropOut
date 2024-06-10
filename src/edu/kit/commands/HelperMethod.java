package edu.kit.commands;

/**
 * A helper class for methods that are helpful for other classes.
 *
 * @author uijyl
 */
public class HelperMethod {
    private HelperMethod() {

    }
    private static final char ERROR_SYMBOL = '!';
    private static final int TWO = 2;

    /**
     * This method checks what character is present on the given coordinates on the game board.
     * @param currentGameBoard represents the current game board that will be referenced.
     * @param rowIndex tells which row will be addressed.
     * @param colIndex tells which column will be addressed.
     * @return The character that is present on the given coordinates.
     */
    public static char fieldCheck(char[][] currentGameBoard, int rowIndex, int colIndex) {
        if (rowIndex < currentGameBoard.length && colIndex < currentGameBoard[0].length) {
            return currentGameBoard[rowIndex][colIndex];
        } else {
            return ERROR_SYMBOL;
        }
    }

    /**
     * This method checks on which coordinates the ant is located.
     * @param currentGameBoard represents the current game board that will be referenced.
     * @return This method returns the position of the only non digit character on the game board which represents the ant.
     */
    public static int[] positionCheck(char[][] currentGameBoard) {
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
