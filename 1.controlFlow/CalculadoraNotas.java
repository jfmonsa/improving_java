/**
 * Concepts:
 * + Primitives vs References
 * + conditional branching
 * + looping
 */

import java.util.Scanner;

public class CalculadoraNotas {

    public static void main(String[] args) {
        // Variables
        int[] calificaciones = new int[5];
        float promedio = 0;
        char calificacionFinal;

        // Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Ingreso de calificaciones
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese la calificación de la asignatura " + (i + 1) + ": ");
            calificaciones[i] = scanner.nextInt();
            promedio += calificaciones[i];
        }

        // Calculo del promedio
        promedio /= 5;

        // Determinación de la calificación final
        if (promedio >= 90) {
            calificacionFinal = 'A';
        } else if (promedio >= 80) {
            calificacionFinal = 'B';
        } else if (promedio >= 70) {
            calificacionFinal = 'C';
        } else if (promedio >= 60) {
            calificacionFinal = 'D';
        } else {
            calificacionFinal = 'F';
        }

        // Resultados
        System.out.println("Promedio de calificaciones: " + promedio);
        System.out.println("Calificación final: " + calificacionFinal);

        // Cerrar el scanner
        scanner.close();
    }
}
