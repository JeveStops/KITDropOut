package edu.kit.kastel;

import java.util.List;

/**
 * A class for processing the game file.
 *
 * @author uijyl
 */
public class GameFileReader {
    /**
     * This method reads a game file by using the FileHelper class and converts the game file into a usable game board.
     * @param args represents the data structure where the game file is located.
     * @return This method returns the game file depicted as a game board by converting it to a matrix.
     * @throws IllegalArgumentException if an invalid path has been passed.
     */
    public char[][] gameBoardInitiator(String[] args) {
        List<String> fileLines = FileHelper.readAllLines(args[0]);
        int rows = fileLines.size();
        int cols = fileLines.get(0).length();
        char[][] gameBoard = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] lineCharacters = fileLines.get(i).toCharArray();
            for (int j = 0; j < cols; j++) {
                if (j < lineCharacters.length) {
                    gameBoard[i][j] = lineCharacters[j];
                } else {
                    throw new IllegalArgumentException("Error: Invalid game file!");
                }
            }
        }
        return gameBoard;
    }
}
