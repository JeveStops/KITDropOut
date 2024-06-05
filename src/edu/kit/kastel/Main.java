package edu.kit.kastel;

public class Main {
    public static void main(String[] args) {
        char[][] currentGameBoard = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', 'N', '0'}
        };
        Commands.position(currentGameBoard);
        Commands.field(currentGameBoard, 2, 1);
    }
}
