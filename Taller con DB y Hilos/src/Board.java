import java.util.ArrayList;
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
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = false;
                }
            }
            return matrix;
        }

        /*
         * genRandomMatrixCoordinates():
         * The below method no repeated random coordinates for the matrix, for located
         * the figures in the board randomly
         */
        public Boolean equalCoordinates(ArrayList<int[]> coordinatesArr) {
            boolean areEqual = false;
            int arrSize = coordinatesArr.size();

            for (int k = 0; k < arrSize; k++) {
                for (int i = 0; i < arrSize; i++) {
                    if (Arrays.equals(coordinatesArr.get(i), coordinatesArr.get(k)) && i != k) {
                        areEqual = true;
                    }
                }
            }
            return areEqual;
        }

        public int[] randomCoordinate() {
            int x1 = new Random().nextInt(3);
            int y1 = new Random().nextInt(3);
            int[] cord = { x1, y1 };
            return cord;
        }

        public ArrayList<int[]> genRandomMatrixCoordinates() {
            ArrayList<int[]> coordinatesArr = new ArrayList<>();

            coordinatesArr.add(this.randomCoordinate()); // Setting the first point
            if(!this.equalCoordinates())
        }

        public void insertFigures(int numberOfFigures) {
            // The matrix represents a 3x3 board
            Boolean[][] matrixBoard = new Boolean[3][3];

            switch (numberOfFigures) {
                case 1:
                    fillWithFalseMatrix(matrixBoard);
                    // Coordinated represents an element (i,j) of the matrixBoard
                    int[][] arrCoordinates = new int[2][2];
                    // Array that stored the coordinates
                    int[] coordinate = new int[2];

                    break;
                case 2:

            }

            int pos1 = new Random().nextInt(3); // int rand = new Random().nextInt(3); other way is: r.nextInt(high-low)
                                                // +
                                                // low;
            int pos2 = rand.nextInt(9 - 1) + 1;
            while (pos1 == pos2) {
                pos2 = rand.nextInt(9 - 1) + 1;
            }

        }
    }

}
/*
 * Valor 1: 2 Figuras
 * ii. Valor 2: 4 Figuras
 * iii. Valor 3: 9 Figuras
 * 
 */
