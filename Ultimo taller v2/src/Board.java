import java.util.Random;
import java.util.Arrays;

public class Board {
    private int numberOfFigures;
    private int secondsToAppear;
    private int secondsToDisappear;
    private int typeOfFigures;
    private static int numberOfBoardsCreated = 0;
    private static Boolean[][] matrixBoard;

    // ======================= Constructor =====================
    public Board(int numberOfFigures, int secondsToAppear, int secondsToDisappear, int typeOfFigures) {
        this.numberOfFigures = numberOfFigures;
        this.secondsToAppear = secondsToAppear;
        this.secondsToDisappear = secondsToDisappear;
        this.typeOfFigures = typeOfFigures;
        Board.numberOfBoardsCreated++;
        Board.matrixBoard = GenMatrixBoard(numberOfFigures);
    }
    // ======================= Constructor =====================

    // ########################### Generate Matrix ##########################
    /*
     * Inner functions to generate the matrix that represents the 3x3 Board,
     * each element of the matrix represents a position in the board. true
     * represents
     * that a figure must be represnted in the board false is no figure.
     * 
     * Note: Originally this junk of code was a inner class :'(
     */

    // ======================== Constructor ==============
    public Boolean[][] GenMatrixBoard(int opc) {
        // The matrix represents a 3x3 board
        Boolean[][] matrix = new Boolean[3][3];

        switch (opc) {
            case 1:
                matrix = fillWithFalseMatrix(matrix);
                matrix = fillingFiguresInMatrixInRandCoord(matrix, 2);
                // insertFiguresInDB(matrixBoard);
                break;
            case 2:
                matrix = fillWithFalseMatrix(matrix);
                matrix = fillingFiguresInMatrixInRandCoord(matrix, 4);
                // insertFiguresInDB(matrixBoard);
                break;
            case 3:
                // Filling all fields of the board with true
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = true;
                    }
                }
                // insertFiguresInDB(matrixBoard);
                break;
        }
        return matrix;
    }
    // ======================== Constructor ==============

    // ======================== Auxiliary methods for the constructor ==============
    /*
     * Set the matrix for default with all elements in false
     */
    public Boolean[][] fillWithFalseMatrix(Boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = false;
            }
        }
        return matrix;
    }

    /*
     * Gen random i,j coordinate element for the matrix
     */
    public int[] randomCoordinate() {
        // int rand = new Random().nextInt(3); other way is: r.nextInt(high-low)
        int x1 = new Random().nextInt(3);
        int y1 = new Random().nextInt(3);
        int[] cord = { x1, y1 };
        return cord;
    }

    /*
     * fillingFiguresInMatrixInRandCoord():
     * The below method fill the matrix with true in random coordinates
     */
    public Boolean[][] fillingFiguresInMatrixInRandCoord(Boolean[][] matrix, int numOfcoordinates) {
        // Initializing the array of matrix coordinates
        int[][] arrCoordinates = new int[1][numOfcoordinates];

        // Filling with random coordinates for the number of figures
        for (int i = 0; i < arrCoordinates.length; i++) {
            arrCoordinates[i] = randomCoordinate();
        }

        // Change coordinates if are repeated
        for (int actualCoordIndex = 0; actualCoordIndex < arrCoordinates.length; actualCoordIndex++) {
            for (int i = 0; i < arrCoordinates.length; i++) {
                while (actualCoordIndex != i
                        && Arrays.equals(arrCoordinates[actualCoordIndex], arrCoordinates[i])) {
                    arrCoordinates[i] = randomCoordinate();
                }
            }
        }

        // Filling the matrix with true in the coordinates of the arrCoordinates
        for (int[] coord : arrCoordinates) {
            matrix[coord[0]][coord[1]] = true;
        }
        return matrix;
    }
    // ======================== Auxiliary methods for the constructor ==============
    // ########################### Generate Matrix ##########################

    // ======================= Setters & getters =====================
    public int getNumberOfFigures() {
        return numberOfFigures;
    }

    public void setNumberOfFigures(int numberOfFigures) {
        this.numberOfFigures = numberOfFigures;
    }

    public int getSecondsToAppear() {
        return secondsToAppear;
    }

    public void setSecondsToAppear(int secondsToAppear) {
        this.secondsToAppear = secondsToAppear;
    }

    public int getSecondsToDisappear() {
        return secondsToDisappear;
    }

    public void setSecondsToDisappear(int secondsToDisappear) {
        this.secondsToDisappear = secondsToDisappear;
    }

    public int getTypeOfFigures() {
        return typeOfFigures;
    }

    public void setTypeOfFigures(int typeOfFigures) {
        this.typeOfFigures = typeOfFigures;
    }

    public static int getNumberOfBoardsCreated() {
        return numberOfBoardsCreated;
    }

    public static void setNumberOfBoardsCreated(int numberOfBoardsCreated) {
        Board.numberOfBoardsCreated = numberOfBoardsCreated;
    }

    public static Boolean[][] getMatrixBoard() {
        return matrixBoard;
    }

    public static void setMatrixBoard(Boolean[][] matrixBoard) {
        Board.matrixBoard = matrixBoard;
    }
    // ======================= Setters & getters =====================

}