package Paquete_tarea_6_7;

public class CopiaArrays {
    
    public static void ejecutar() {

        int[] arrayOriginal = {1, 2, 3};
        int[] arrayCopia = arrayOriginal.clone();

        arrayCopia[0] = 99;

        System.out.println("Array original: ");
        for (int n : arrayOriginal) {
            System.out.print(n + " ");
        }

        System.out.println("\nArray copiado: ");
        for (int n : arrayCopia) {
            System.out.print(n + " ");
        }
    }
}
