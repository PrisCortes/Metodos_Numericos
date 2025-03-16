import java.util.*;
public class GaussPivote {
    Scanner scanner = new Scanner(System.in);

    //Declaración de variables
    public int N;
    public double  [][] matriz;
    public double  [] resultados;

    //Constructor
    public GaussPivote (int n) {
        N = n;
        matriz = new double [n][n+1];
        resultados = new double [n];
    }

    //Método para llenar la matriz
    public void llenarMatriz () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print("["+i+"] ["+j+"] = ");
                matriz[i][j]= scanner.nextDouble();
            }
        }
    }

    //Método para mostrar la matriz
    public void mostrarMatriz () {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }
    }

    //Método para mostrar el vector reultante
    public void mostrarResultados () {
        for (int i = 0; i < N; i++) {
            System.out.printf("%.2f\t", resultados[i]);
        }
    }

    //Método de eliminación gaussiana hacia adelante con normalización
    public void metodoGauss () {
        for (int i = 0; i < N; i++) {
            //Obtener el pivote
            double pivote = matriz[i][i];
            for (int j = 0; j <= N; j++) {
                matriz[i][j] /= pivote;
            }
            //Eliminar los elementos debajo del pivote
            for (int j = i + 1; j < N; j++) {
                double factor = matriz[j][i];
                for (int k = i; k <= N; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }

        // Sustitución hacia atrás para obtener la solución
        for (int i = N - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < N; j++) {
                suma += matriz[i][j] * resultados[j];
            }
            resultados[i] = matriz[i][N] - suma;
        }
    }
}
