import java.util.Random;
import java.util.Arrays;

public class Board extends DataBase {
    private int numberOfFigures;
    private int secondsToAppear;
    private int secondsToDisappear;
    private int typeOfFigures;

    // --------------------- Constructors --------------------
    public Board(int numberOfFigures, int secondsToAppear, int secondsToDisappear, int typeOfFigures) {
        this.numberOfFigures = numberOfFigures;
        this.secondsToAppear = secondsToAppear;
        this.secondsToDisappear = secondsToDisappear;
        this.typeOfFigures = typeOfFigures;
    }
    // --------------------- Constructors --------------------

    // --------------------- Setters and Getters --------------------
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
    // --------------------- Setters and Getters --------------------

    // --------------------- #1 First excercise's requeriment ---------------

    /*
     * Class for filling the board with a number of figure (excercise's option 1)
     * 
     * We're working with a matrix representing the board positions, this matrix is
     * typed boolean.
     */

    private abstract class insertFiguresInBoard {

        /*
         * fillWithFalseMatrix():
         * The below method initializes the matrix with a value of false in each matrix
         * element
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
         * The below method generates a random coordinate
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

        public void insertFigures(int opc) {
            // The matrix represents a 3x3 board
            Boolean[][] matrixBoard = new Boolean[3][3];

            switch (opc) {
                case 1:
                    matrixBoard = fillWithFalseMatrix(matrixBoard);
                    matrixBoard = fillingFiguresInMatrixInRandCoord(matrixBoard, 2);
                    insertFiguresInDB(matrixBoard);
                    break;
                case 2:
                    fillWithFalseMatrix(matrixBoard);
                    matrixBoard = fillWithFalseMatrix(matrixBoard);
                    matrixBoard = fillingFiguresInMatrixInRandCoord(matrixBoard, 4);
                    insertFiguresInDB(matrixBoard);
                    break;
                case 3:
                    // Filling all fields of the board with true
                    for (int i = 0; i < matrixBoard.length; i++) {
                        for (int j = 0; j < matrixBoard[i].length; j++) {
                            matrixBoard[i][j] = true;
                        }
                    }
                    insertFiguresInDB(matrixBoard);
                    break;
            }

        }
    }

}