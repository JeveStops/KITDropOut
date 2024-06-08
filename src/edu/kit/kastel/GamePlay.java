package edu.kit.kastel;

import edu.kit.commands.*;

import java.util.Scanner;

/**
 * A class containing the game play loop of the langton-ant.
 *
 * @author uijyl
 */
public class GamePlay {
    private static final String MOVE_COMMAND_NAME = "move";
    private static final String PRINT_COMMAND_NAME = "print";
    private static final String POSITION_COMMAND_NAME = "position";
    private static final String FIELD_COMMAND_NAME = "field";
    private static final String QUIT_COMMAND_NAME = "quit";

    /**
     * This constructor is used to initialize a game play instance with the commands.
     * @param gameBoard is the game board where the game play will be started.
     */
    public GamePlay(char[][] gameBoard) {
        char[][] currentGameBoard = gameBoard;
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            userInput = scanner.nextLine();
            String[] inputParts = userInput.split(" ");
            try {
                switch (inputParts[0]) {
                    case PRINT_COMMAND_NAME -> {
                        PrintCommand printer = new PrintCommand();
                        printer.print(currentGameBoard);
                    }
                    case POSITION_COMMAND_NAME -> {
                        PositionCommand positionCheck = new PositionCommand();
                        int rowIndex = positionCheck.position(currentGameBoard)[0];
                        int colIndex = positionCheck.position(currentGameBoard)[1];
                        System.out.println(rowIndex + "," + colIndex);
                    }
                    case MOVE_COMMAND_NAME -> {
                        if (inputParts.length > 1) {
                            MoveCommand mover = new MoveCommand();
                            PrintCommand printer = new PrintCommand();
                            int moveValue = Integer.parseInt(inputParts[1]);
                            currentGameBoard = mover.move(currentGameBoard, moveValue);
                            if (mover.getIsOutside()) {
                                return;
                            }
                        } else {
                            System.err.println("Error: Missing Argument for the move-command!");
                        }
                    }
                    case FIELD_COMMAND_NAME -> {
                        if (inputParts.length > 1) {
                            FieldCommand fieldCheck = new FieldCommand();
                            String[] coordinateValues = inputParts[1].split(",");
                            int xCoordinate = Integer.parseInt(coordinateValues[0]);
                            int yCoordinate = Integer.parseInt(coordinateValues[1]);
                            if (yCoordinate < currentGameBoard.length && xCoordinate < currentGameBoard[0].length) {
                                System.out.println(fieldCheck.field(currentGameBoard, xCoordinate, yCoordinate));
                            } else {
                                System.err.println("Error: Index is out of bounds!");
                            }
                        } else {
                            System.err.println("Error: Missing Argument for the move-command!");
                        }
                    }
                    case QUIT_COMMAND_NAME -> {
                        scanner.close();
                        return;
                    }
                    default -> System.err.println("Error: Invalid command!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid command arguments!");
            }
        }
    }
}