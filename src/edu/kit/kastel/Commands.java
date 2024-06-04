package edu.kit.kastel;

public class Commands {
    public static final char BLACK_NORTH = 'N';
    public static final char BLACK_SOUTH = 'S';
    public static final char BLACK_EAST = 'O';
    public static final char BLACK_WEST = 'W';
    public static final char WHITE_NORTH = 'n';
    public static final char WHITE_SOUTH = 's';
    public static final char WHITE_EAST = 'o';
    public static final char WHITE_WEST = 'w';
    private void nextDirectionWhite(char[][] currentGameBoard, int rowIndex, int colIndex) {
        switch (currentGameBoard[rowIndex][colIndex]) {
            case WHITE_NORTH -> {
                if (rowIndex - 1 >= 0) {
                    currentGameBoard[rowIndex][colIndex] = '1';
                    if (currentGameBoard[rowIndex - 1][colIndex] == '0') {
                        currentGameBoard[rowIndex - 1][colIndex] = BLACK_EAST;
                    } else if (currentGameBoard[rowIndex - 1][colIndex] == '1') {
                        currentGameBoard[rowIndex - 1][colIndex] = WHITE_WEST;
                    }
                }
            }
            case WHITE_SOUTH -> {
                if (rowIndex + 1 < currentGameBoard.length) {
                    currentGameBoard[rowIndex][colIndex] = '1';
                    if (currentGameBoard[rowIndex + 1][colIndex] == '0') {
                        currentGameBoard[rowIndex + 1][colIndex] = BLACK_WEST;
                    } else if (currentGameBoard[rowIndex + 1][colIndex] == '1') {
                        currentGameBoard[rowIndex + 1][colIndex] = WHITE_EAST;
                    }
                }
            }
            case WHITE_EAST -> {
                if  (colIndex + 1 < currentGameBoard[0].length) {
                    currentGameBoard[rowIndex][colIndex] = '1';
                    if (currentGameBoard[rowIndex][colIndex + 1] == '0') {
                        currentGameBoard[rowIndex][colIndex + 1] = BLACK_SOUTH;
                    } else if (currentGameBoard[rowIndex][colIndex + 1] == '1') {
                        currentGameBoard[rowIndex][colIndex + 1] = WHITE_NORTH;
                    }
                }
            }
            case WHITE_WEST -> {
                if (colIndex - 1 >= 0) {
                    currentGameBoard[rowIndex][colIndex] = '1';
                    if (currentGameBoard[rowIndex][colIndex - 1] == '0') {
                        currentGameBoard[rowIndex][colIndex - 1] = BLACK_NORTH;
                    } else if (currentGameBoard[rowIndex][colIndex - 1] == '1') {
                        currentGameBoard[rowIndex][colIndex - 1] = WHITE_SOUTH;
                    }
                }
            }
        }
    }
    private void nextDirectionBLack(char[][] currentGameBoard, int rowIndex, int colIndex) {
        switch (currentGameBoard[rowIndex][colIndex]) {
            case BLACK_NORTH -> {
                if (rowIndex - 1 >= 0) {
                    currentGameBoard[rowIndex][colIndex] = '0';
                    if (currentGameBoard[rowIndex - 1][colIndex] == '0') {
                        currentGameBoard[rowIndex - 1][colIndex] = BLACK_EAST;
                    } else if (currentGameBoard[rowIndex - 1][colIndex] == '1') {
                        currentGameBoard[rowIndex - 1][colIndex] = WHITE_WEST;
                    }
                }
            }
            case BLACK_SOUTH -> {
                if (rowIndex + 1 < currentGameBoard.length) {
                    currentGameBoard[rowIndex][colIndex] = '0';
                    if (currentGameBoard[rowIndex + 1][colIndex] == '0') {
                        currentGameBoard[rowIndex + 1][colIndex] = BLACK_WEST;
                    } else if (currentGameBoard[rowIndex + 1][colIndex] == '1') {
                        currentGameBoard[rowIndex + 1][colIndex] = WHITE_EAST;
                    }
                }
            }
            case BLACK_EAST -> {
                if  (colIndex + 1 < currentGameBoard[0].length) {
                    currentGameBoard[rowIndex][colIndex] = '0';
                    if (currentGameBoard[rowIndex][colIndex + 1] == '0') {
                        currentGameBoard[rowIndex][colIndex + 1] = BLACK_SOUTH;
                    } else if (currentGameBoard[rowIndex][colIndex + 1] == '1') {
                        currentGameBoard[rowIndex][colIndex + 1] = WHITE_NORTH;
                    }
                }
            }
            case BLACK_WEST -> {
                if (colIndex - 1 >= 0) {
                    currentGameBoard[rowIndex][colIndex] = '0';
                    if (currentGameBoard[rowIndex][colIndex - 1] == '0') {
                        currentGameBoard[rowIndex][colIndex - 1] = BLACK_NORTH;
                    } else if (currentGameBoard[rowIndex][colIndex - 1] == '1') {
                        currentGameBoard[rowIndex][colIndex - 1] = WHITE_SOUTH;
                    }
                }
            }
        }
    }
    public char[][] moveOptions(char[][] currentGameBoard) {
        char[][] newGameBoard;
        for (int j = 0; j < currentGameBoard.length; j++) {
            for (int k = 0; k < currentGameBoard[0].length; k++) {
                nextDirectionBLack(currentGameBoard, j, k);
                nextDirectionWhite(currentGameBoard, j, k);
            }
        }
        newGameBoard = currentGameBoard;
        return newGameBoard;
    }
    public char[][] move(char[][] currentGameBoard, int value) {
        if (value == 0) {
            return currentGameBoard;
        } else if (value > 0){
            char[][] newGameBoard = moveOptions(currentGameBoard);
            return move(newGameBoard, value - 1);
        } else {
            System.err.println("Error: Input-Value is negative!");
            return null;
        }
    }
}
