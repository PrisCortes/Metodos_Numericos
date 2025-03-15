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
        matriz = new double [n][n];
        resultados = new double [n];
    }

    //Método para llenar la matriz
    public void llenarMatriz () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
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

    //Método de eliminación gaussiana hacia adelante
    public void metodoGauss () {
        
    }

    //Método para intercambiar filas
    public void inercambiarFilas (double [][] matriz, int fila1, int fila2) {
        double[] auxiliar = matriz[fila1];
        matriz[fila1] = matriz[fila2];
        matriz[fila2] = auxiliar;
    }
}
