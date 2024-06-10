package edu.kit.kastel;

/**
 * The Main class with the main method is where the program will be started.
 *
 * @author uijyl
 */
public final class Main {
    private Main() {

    }

    /**
     * The main method is the method that will start the program.
     * @param args represents the command line arguments where the game file is located.
     */
    public static void main(String[] args) {
        GameFileReader gameFileReader = new GameFileReader();
        char[][] currentGameBoard = gameFileReader.gameBoardInitiator(args);
        GamePlay gamePlay = new GamePlay();
        gamePlay.gamePlayStart(currentGameBoard);
    }
}
