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
    public char[][] moveOptions(char[][] currentGameBoard) {
        char[][] newGameBoard;
        for (int j = 0; j < currentGameBoard.length; j++) {
            for (int k = 0; k < currentGameBoard[0].length; k++) {
                switch (currentGameBoard[j][k]) {
                    case BLACK_NORTH -> {
                        if (j - 1 >= 0) {
                            currentGameBoard[j][k] = '0';
                            if (currentGameBoard[j - 1][k] == '0') {
                                currentGameBoard[j - 1][k] = BLACK_EAST;
                            } else if (currentGameBoard[j - 1][k] == '1') {
                                currentGameBoard[j - 1][k] = WHITE_WEST;
                            }
                        }
                    }
                    case BLACK_SOUTH -> {
                        if (j + 1 < currentGameBoard.length) {
                            currentGameBoard[j][k] = '0';
                            if (currentGameBoard[j + 1][k] == '0') {
                                currentGameBoard[j + 1][k] = BLACK_WEST;
                            } else if (currentGameBoard[j + 1][k] == '1') {
                                currentGameBoard[j + 1][k] = WHITE_EAST;
                            }
                        }
                    }
                    case BLACK_EAST -> {
                        if  (k + 1 < currentGameBoard[0].length) {
                            currentGameBoard[j][k] = '0';
                            if (currentGameBoard[j][k + 1] == '0') {
                                currentGameBoard[j][k + 1] = BLACK_SOUTH;
                            } else if (currentGameBoard[j][k + 1] == '1') {
                                currentGameBoard[j][k + 1] = WHITE_NORTH;
                            }
                        }
                    }
                    case BLACK_WEST -> {
                        if (k - 1 >= 0) {
                            currentGameBoard[j][k] = '0';
                            if (currentGameBoard[j][k - 1] == '0') {
                                currentGameBoard[j][k - 1] = BLACK_NORTH;
                            } else if (currentGameBoard[j][k - 1] == '1') {
                                currentGameBoard[j][k - 1] = WHITE_SOUTH;
                            }
                        }
                    }
                    case WHITE_NORTH -> {
                        if (j - 1 >= 0) {
                            currentGameBoard[j][k] = '1';
                            if (currentGameBoard[j - 1][k] == '0') {
                                currentGameBoard[j - 1][k] = BLACK_EAST;
                            } else if (currentGameBoard[j - 1][k] == '1') {
                                currentGameBoard[j - 1][k] = WHITE_WEST;
                            }
                        }
                    }
                    case WHITE_SOUTH -> {
                        if (j + 1 < currentGameBoard.length) {
                            currentGameBoard[j][k] = '1';
                            if (currentGameBoard[j + 1][k] == '0') {
                                currentGameBoard[j + 1][k] = BLACK_WEST;
                            } else if (currentGameBoard[j + 1][k] == '1') {
                                currentGameBoard[j + 1][k] = WHITE_EAST;
                            }
                        }
                    }
                    case WHITE_EAST -> {
                        if  (k + 1 < currentGameBoard[0].length) {
                            currentGameBoard[j][k] = '1';
                            if (currentGameBoard[j][k + 1] == '0') {
                                currentGameBoard[j][k + 1] = BLACK_SOUTH;
                            } else if (currentGameBoard[j][k + 1] == '1') {
                                currentGameBoard[j][k + 1] = WHITE_NORTH;
                            }
                        }
                    }
                    case WHITE_WEST -> {
                        if (k - 1 >= 0) {
                            currentGameBoard[j][k] = '1';
                            if (currentGameBoard[j][k - 1] == '0') {
                                currentGameBoard[j][k - 1] = BLACK_NORTH;
                            } else if (currentGameBoard[j][k - 1] == '1') {
                                currentGameBoard[j][k - 1] = WHITE_SOUTH;
                            }
                        }
                    }
                }
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
