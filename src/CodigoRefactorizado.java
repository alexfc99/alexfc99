import java.util.Scanner;

public class CodigoRefactorizado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int dato = obtenerNumero(teclado);

        int[] vectorPrimos = generarPrimos(dato);

        System.out.println("Vector inicial de " + dato + ":");
        imprimirArray(dato);
        System.out.println("\nVector de primos hasta " + dato + ":");
        imprimirVector(vectorPrimos);
    }
    // Método para obtener el número del usuario
    public static int obtenerNumero(Scanner teclado) {
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        return teclado.nextInt();
    }
    // Generar números primos de 1 a max
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0]; // Vector vacío
        }
        boolean[] esPrimo = inicializarArrayPrimos(max);
        cribaErastotenes(esPrimo, max);
        return vectorPrimos(esPrimo);
    }
    // Iniciamos el array de primos
    public static boolean[] inicializarArrayPrimos(int dim) {
        boolean[] esPrimo = new boolean[dim + 1];
        // Iniciamos el array
        for (int i = 0; i < dim + 1; i++) {
            esPrimo[i] = true;
        }
        // Eliminamos el 0 y el 1 por que no son primos
        esPrimo[0] = esPrimo[1] = false;
        return esPrimo;
    }
    //Método para aplicar la criba de Eratóstenes
    public static void cribaErastotenes(boolean[] esPrimo, int dim) {
        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < dim + 1; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }
    //Método para obtener el vector de primos
    public static int[] vectorPrimos(boolean[] esPrimo) {
        int cuenta = contarPrimos(esPrimo);
        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }
    //Método para contar la cantidad de primos
    public static int contarPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (boolean b : esPrimo) {
            if (b) {
                cuenta++;
            }
        }
        return cuenta;
    }
    //Método para imprimir el vector
    public static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
    //Método para imprimir el array inicial
    public static void imprimirArray(int dato){
        for (int i = 0; i < dato; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
    }
}