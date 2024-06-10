package edu.kit.commands;

/**
 * A class containing the functionality of the move-command for convenient usage.
 *
 * @author uijyl
 */
public class MoveCommand {
    public MoveCommand() {

    }
    public static boolean isOutside = false;
    public static final char BLACK_NORTH = 'N';
    public static final char BLACK_SOUTH = 'S';
    public static final char BLACK_EAST = 'O';
    public static final char BLACK_WEST = 'W';
    public static final char WHITE_NORTH = 'n';
    public static final char WHITE_SOUTH = 's';
    public static final char WHITE_EAST = 'o';
    public static final char WHITE_WEST = 'w';

    /**
     * This method is used to check if the ant is outside the game board.
     * @return True if the ant is outside the game board and false if it is not.
     */
    public boolean getIsOutside() {
        return isOutside;
    }

    /**
     * This method defines the steps the ant will make for each orientation possibility if the ant is on a white field.
     * @param currentGameBoard represents the current game board that the method will be referencing.
     * @param rowIndex represents the index of the row that is currently being viewed.
     * @param colIndex represents the index of the column that is currently being viewed.
     */
    private void nextDirectionWhite(char[][] currentGameBoard, int rowIndex, int colIndex) {
        switch (currentGameBoard[rowIndex][colIndex]) {
            case WHITE_NORTH -> {
                if (rowIndex - 1 >= 0) {
                    currentGameBoard[rowIndex][colIndex] = '0';
                    if (currentGameBoard[rowIndex - 1][colIndex] == '0') {
                        currentGameBoard[rowIndex - 1][colIndex] = BLACK_EAST;
                    } else if (currentGameBoard[rowIndex - 1][colIndex] == '1') {
                        currentGameBoard[rowIndex - 1][colIndex] = WHITE_WEST;
                    }
                } else {
                    isOutside = true;
                }
            }
            case WHITE_SOUTH -> {
                if (rowIndex + 1 < currentGameBoard.length) {
                    currentGameBoard[rowIndex][colIndex] = '0';
                    if (currentGameBoard[rowIndex + 1][colIndex] == '0') {
                        currentGameBoard[rowIndex + 1][colIndex] = BLACK_WEST;
                    } else if (currentGameBoard[rowIndex + 1][colIndex] == '1') {
                        currentGameBoard[rowIndex + 1][colIndex] = WHITE_EAST;
                    }
                } else {
                    isOutside = true;
                }
            }
            case WHITE_EAST -> {
                if  (colIndex + 1 < currentGameBoard[0].length) {
                    currentGameBoard[rowIndex][colIndex] = '0';
                    if (currentGameBoard[rowIndex][colIndex + 1] == '0') {
                        currentGameBoard[rowIndex][colIndex + 1] = BLACK_SOUTH;
                    } else if (currentGameBoard[rowIndex][colIndex + 1] == '1') {
                        currentGameBoard[rowIndex][colIndex + 1] = WHITE_NORTH;
                    }
                } else {
                    isOutside = true;
                }
            }
            case WHITE_WEST -> {
                if (colIndex - 1 >= 0) {
                    currentGameBoard[rowIndex][colIndex] = '0';
                    if (currentGameBoard[rowIndex][colIndex - 1] == '0') {
                        currentGameBoard[rowIndex][colIndex - 1] = BLACK_NORTH;
                    } else if (currentGameBoard[rowIndex][colIndex - 1] == '1') {
                        currentGameBoard[rowIndex][colIndex - 1] = WHITE_SOUTH;
                    }
                } else {
                    isOutside = true;
                }
            }
        }
    }

    /**
     * This method defines the steps the ant will make for each orientation possibility if the ant is on a black field.
     * @param currentGameBoard represents the current game board that the method will be referencing.
     * @param rowIndex represents the index of the row that is currently being viewed.
     * @param colIndex represents the index of the column that is currently being viewed.
     */
    private void nextDirectionBlack(char[][] currentGameBoard, int rowIndex, int colIndex) {
        switch (currentGameBoard[rowIndex][colIndex]) {
            case BLACK_NORTH -> {
                if (rowIndex - 1 >= 0) {
                    currentGameBoard[rowIndex][colIndex] = '1';
                    if (currentGameBoard[rowIndex - 1][colIndex] == '0') {
                        currentGameBoard[rowIndex - 1][colIndex] = BLACK_EAST;
                    } else if (currentGameBoard[rowIndex - 1][colIndex] == '1') {
                        currentGameBoard[rowIndex - 1][colIndex] = WHITE_WEST;
                    }
                } else {
                    isOutside = true;
                }
            }
            case BLACK_SOUTH -> {
                if (rowIndex + 1 < currentGameBoard.length) {
                    currentGameBoard[rowIndex][colIndex] = '1';
                    if (currentGameBoard[rowIndex + 1][colIndex] == '0') {
                        currentGameBoard[rowIndex + 1][colIndex] = BLACK_WEST;
                    } else if (currentGameBoard[rowIndex + 1][colIndex] == '1') {
                        currentGameBoard[rowIndex + 1][colIndex] = WHITE_EAST;
                    }
                } else {
                    isOutside = true;
                }
            }
            case BLACK_EAST -> {
                if  (colIndex + 1 < currentGameBoard[0].length) {
                    currentGameBoard[rowIndex][colIndex] = '1';
                    if (currentGameBoard[rowIndex][colIndex + 1] == '0') {
                        currentGameBoard[rowIndex][colIndex + 1] = BLACK_SOUTH;
                    } else if (currentGameBoard[rowIndex][colIndex + 1] == '1') {
                        currentGameBoard[rowIndex][colIndex + 1] = WHITE_NORTH;
                    }
                } else {
                    isOutside = true;
                }
            }
            case BLACK_WEST -> {
                if (colIndex - 1 >= 0) {
                    currentGameBoard[rowIndex][colIndex] = '1';
                    if (currentGameBoard[rowIndex][colIndex - 1] == '0') {
                        currentGameBoard[rowIndex][colIndex - 1] = BLACK_NORTH;
                    } else if (currentGameBoard[rowIndex][colIndex - 1] == '1') {
                        currentGameBoard[rowIndex][colIndex - 1] = WHITE_SOUTH;
                    }
                } else {
                    isOutside = true;
                }
            }
        }
    }

    /**
     * This method executes a single turn.
     * @param currentGameBoard represents the current game board where a turn will be made.
     * @return The game board after a turn was made.
     */
    public char[][] singleMove(char[][] currentGameBoard) {
        MoveCommand mover = new MoveCommand();
        char[][] newGameBoard;
        int rowIndex = HelperMethod.positionCheck(currentGameBoard)[0];
        int colIndex = HelperMethod.positionCheck(currentGameBoard)[1];
        if (Character.isUpperCase(HelperMethod.fieldCheck(currentGameBoard, rowIndex, colIndex))) {
            mover.nextDirectionBlack(currentGameBoard, rowIndex, colIndex);
        } else if (Character.isLowerCase(HelperMethod.fieldCheck(currentGameBoard, rowIndex, colIndex))) {
            mover.nextDirectionWhite(currentGameBoard, rowIndex, colIndex);
        }
        newGameBoard = currentGameBoard;
        return newGameBoard;
    }

    /**
     * This method makes a number of turns based on the value entered by the user.
     * @param currentGameBoard represents the current game board before a number of turns are made.
     * @param value represent the amount of turns that will be made.
     * @return The game board after the turns were made.
     */
    public char[][] move(char[][] currentGameBoard, int value) {
        MoveCommand mover = new MoveCommand();
        if (value == 0) {
            return currentGameBoard;
        } else if (value > 0) {
            char[][] newGameBoard = mover.singleMove(currentGameBoard);
            return move(newGameBoard, value - 1);
        } else {
            System.err.println("Error: Input-Value is negative!");
            return null;
        }
    }
}
