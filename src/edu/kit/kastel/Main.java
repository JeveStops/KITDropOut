package edu.kit.kastel;

/**
 * The Main class with the main method is where the program will be started.
 *
 * @author uijyl
 */
public class Main {
    public static void main(String[] args) {
        GameFileReader gameFileReader = new GameFileReader();
        char[][] currentGameBoard = gameFileReader.gameBoardInitiator(args);
        GamePlay gamePlay = new GamePlay(currentGameBoard);
    }
}
