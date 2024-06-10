package edu.kit.commands;

/**
 * A class containing the functionality of the print-command for convenient usage.
 *
 * @author uijyl
 */
public class PrintCommand {
    public PrintCommand() {

    }

    /**
     * This method prints out a given character matrix.
     * @param currentGameBoard represents the game board that will be printed by this method.
     */
    public void print(char[][] currentGameBoard) {
        int cols = currentGameBoard[0].length;
        for (char[] chars : currentGameBoard) {
            for (int j = 0; j < cols; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}
