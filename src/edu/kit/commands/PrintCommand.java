package edu.kit.commands;

/**
 * A class containing the functionality of the print-command for convenient usage.
 *
 * @author uijyl
 */
public class PrintCommand {
    public PrintCommand() {

    }
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
