package edu.kit.kastel;

import edu.kit.commands.MoveCommand;
import edu.kit.commands.FieldCommand;
import edu.kit.commands.PositionCommand;
import edu.kit.commands.PrintCommand;

import java.util.Scanner;

/**
 * A class containing the game play loop of the langton-ant.
 *
 * @author uijyl
 */
public class GamePlay {
    private static final String COMMA_CHARACTER = ",";
    private static final String MOVE_COMMAND_NAME = "move";
    private static final String PRINT_COMMAND_NAME = "print";
    private static final String POSITION_COMMAND_NAME = "position";
    private static final String FIELD_COMMAND_NAME = "field";
    private static final String QUIT_COMMAND_NAME = "quit";

    /**
     * Constructor for creating a game play instance that can use the methods of this class.
     */
    public GamePlay() {

    }
    /**
     * This method is used to initialize a game play with the commands.
     * @param gameBoard represents the game board where the game play will be started.
     */
    public void gamePlayStart(char[][] gameBoard) {
        char[][] currentGameBoard = gameBoard;
        GamePlay gamePlayStarter = new GamePlay();
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            userInput = scanner.nextLine();
            String[] inputParts = userInput.split(" ");
            gamePlayStarter.printCommandCheck(currentGameBoard, inputParts);
            gamePlayStarter.positionCommandCheck(currentGameBoard, inputParts);
            gamePlayStarter.fieldCommandCheck(currentGameBoard, inputParts);
            try {
                if (inputParts[0].equals(QUIT_COMMAND_NAME)) {
                    scanner.close();
                    return;
                } else if (inputParts[0].equals(MOVE_COMMAND_NAME)) {
                    if (inputParts.length > 1) {
                        MoveCommand mover = new MoveCommand();
                        int moveValue = Integer.parseInt(inputParts[1]);
                        currentGameBoard = mover.move(currentGameBoard, moveValue);
                        if (mover.getIsOutside()) {
                            scanner.close();
                            return;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid command arguments!");
            }
        }
    }

    /**
     * This method checks if the input matches the form of a position command.
     * @param currentGameBoard represents the game board that will be referenced in the position command.
     * @param inputParts represents the parts of the user input containing the information needed for this command.
     */
    private void positionCommandCheck(char[][] currentGameBoard, String[] inputParts) {
        try {
            if (inputParts[0].equals(POSITION_COMMAND_NAME)) {
                PositionCommand positionCheck = new PositionCommand();
                int rowIndex = positionCheck.position(currentGameBoard)[0];
                int colIndex = positionCheck.position(currentGameBoard)[1];
                System.out.println(rowIndex + COMMA_CHARACTER + colIndex);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid command arguments!");
        }
    }

    /**
     * This method checks if the input matches the form of a print command.
     * @param currentGameBoard represents the game board that will be printed out after executing the print command.
     * @param inputParts represents the parts of the user input containing the information needed for this command.
     */
    private void printCommandCheck(char[][] currentGameBoard, String[] inputParts) {
        try {
            if (inputParts[0].equals(PRINT_COMMAND_NAME)) {
                PrintCommand printer = new PrintCommand();
                printer.print(currentGameBoard);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid command arguments!");
        }
    }

    /**
     * This method checks if the input matches the form of a field command.
     * @param currentGameBoard represents the game board that will be referenced in the field command.
     * @param inputParts represents the parts of the user input containing the information needed for this command.
     */
    private void fieldCommandCheck(char[][] currentGameBoard, String[] inputParts) {
        try {
            if (inputParts[0].equals(FIELD_COMMAND_NAME)) {
                if (inputParts.length > 1) {
                    FieldCommand fieldCheck = new FieldCommand();
                    String[] coordinateValues = inputParts[1].split(COMMA_CHARACTER);
                    int xCoordinate = Integer.parseInt(coordinateValues[0]);
                    int yCoordinate = Integer.parseInt(coordinateValues[1]);
                    if (yCoordinate < currentGameBoard.length && xCoordinate < currentGameBoard[0].length) {
                        System.out.println(fieldCheck.field(currentGameBoard, xCoordinate, yCoordinate));
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid command arguments!");
        }
    }
}
