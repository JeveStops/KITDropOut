package edu.kit.kastel;

import java.util.List;

public class GameFileReader {
    public char[][] gameBoardInitiator(String[] args) {
        List<String> fileLines = FileHelper.readAllLines(args[0]);
        int rows = fileLines.size();
        int cols = fileLines.get(0).length();
        char[][] gameBoard = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] lineCharacters = fileLines.get(i).toCharArray();
            for (int j = 0; j < cols; j++) {
                // Überprüfen, ob die aktuelle Zeile lang genug ist, um auf das j-te Element zuzugreifen
                if (j < lineCharacters.length) {
                    gameBoard[i][j] = lineCharacters[j];
                } else {
                    System.err.println("Error: Invalid GameFile!");
                    return null;
                }
            }
        }
        return gameBoard;
    }
}
