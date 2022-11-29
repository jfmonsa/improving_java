import java.util.Scanner;

public class App {
    int matrix[][];
    Scanner sc = new Scanner(System.in);
    int rows, cols;

    // set rows & cols for a matrix
    public void setMatrixSize() {
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        cols = sc.nextInt();
        matrix = new int[rows][cols];
        System.out.println("");
    }

    // print the data of a matrix
    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    // input the matrix's elements
    public void setMatrixElements() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("Enter the element of the position: [" + i + "][" + j + "] = ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("");
    }

    // fill randomly a matrix
    public void setMatrixRandomElements() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 1 + (int) (Math.random() * 10);
            }
        }
        System.out.println("");
    }

    // Lineal search in a matrix
    public void searchElementInMatrix() {
        int valorBuscar;
        boolean existe = false;
        System.out.println("Enter the value of the element to search: ");
        valorBuscar = sc.nextInt();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == valorBuscar) {
                    existe = true;
                    System.out.println("The element " + valorBuscar + " Is in the position["
                            + i + "][" + j + "] = " + matrix[i][j]);
                    i = matrix.length;
                    break;
                }
            }
        }
        if (!existe) {
            System.out.println("the element " + valorBuscar + " doesn't exist in the matrix: ");
        }
        System.out.println("");
    }

    // Know the frecuency of an element in the matrix;
    public void frecuency() {
        int elementToSearch, counter = 0;
        System.out.println("Enter the value to search: ");
        elementToSearch = sc.nextInt();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == elementToSearch) {
                    counter++;
                }
            }
        }
        System.out.println("The value: " + elementToSearch + " is " + counter + " times in the matrix");
        System.out.println("");
    }

    // Recorrer Una Fila de la matrix:
    public void iterateARow() {
        int rowToIterate;
        System.out.println("Enter the index of the matrix's row which you want to iterate");
        rowToIterate = sc.nextInt();
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(" matrix[" + rowToIterate + "][" + i + "] = " + matrix[rowToIterate][i]);
        }
        System.out.println("");
    }

    // add two matrices

    // matrix multiplication

    // multiply a matrix with a scalar

    // Recorrer Una Columna De La matrix:
    public void iterateAColumn() {
        int columnToIterate;
        System.out.println("Enter the index of the matrix's column which you want to iterate");
        columnToIterate = sc.nextInt();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(" matrix[" + columnToIterate + "][" + i + "] = " + matrix[i][columnToIterate]);
        }
        System.out.println("");
    }

    public void menu() {
        System.out.println("This program allow you to ");
        int opc;
        do {
            System.out.println("MENU");
            System.out.println("1) Set the matrix size (Create a matrix):");
            System.out.println("2) Input elements to fill the matrix");
            System.out.println("3) Print the matrix");
            System.out.println("4) Fill randomly a matrix");
            System.out.println("5) Search an element in the matrix");
            System.out.println("6) Frecuency of an element int he matrix");
            System.out.println("7) print a matrix's row");
            System.out.println("8) print a matrix's column");
            System.out.println("0) exit");
            System.out.print("Select an option:");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    setMatrixSize();
                    break;
                case 2:
                    setMatrixElements();
                    break;
                case 3:
                    printMatrix();
                    break;
                case 4:
                    setMatrixRandomElements();
                    break;
                case 5:
                    searchElementInMatrix();
                    break;
                case 6:
                    frecuency();
                    break;
                case 7:
                    iterateARow();
                    break;
                case 8:
                    iterateAColumn();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion incorrecta: \n\n");
            }
        } while (opc != 0);
    }

    public static void main(String[] args) {
        App obj = new App();
        obj.menu();
    }
}