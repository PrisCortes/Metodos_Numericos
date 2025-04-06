import java.util.*;
public class metodos {
    Scanner scanner = new Scanner(System.in);

    //Declaración de variables
    public int N;
    public double  [][] matriz;
    public double  [] resultados;

    //Constructor
    public metodos (int n) {
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
    public void mostrarMatriz() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%.4f ", matriz[i][j]);
            }
            System.out.println();
        }
    }       
    

    //Método para mostrar el vector reultante
    public void mostrarResultados () {
        for (int i = 0; i < N; i++) {
            System.out.printf("%.4f\t", resultados[i]);
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
            matriz[i][N] -= suma;
            resultados[i] = matriz[i][N];
        }
    }

    //Método de Gauss-Jordan
    public void gaussJordan(){
        for(int i = 0; i < N; i++){
            // Si el pivote es 0, intercambiar filas
            if(matriz[i][i] == 0){
                for(int k = 0; k < N; k++){
                    if(matriz[k][i] != 0){
                        double[] filaTemp = new double[N+1]; // Arreglo temporal para intercambio
                        for(int j = 0; j <= N; j++){
                            filaTemp[j] = matriz[i][j]; // Guardar fila actual
                            matriz[i][j] = matriz[k][j]; // Intercambiar con otra fila
                            matriz[k][j] = filaTemp[j]; // Completar intercambio
                        }
                        break;
                    }
                }
            }
            // Hacer el pivote igual a 1
            double pivote = matriz[i][i];
            if (pivote != 0){
                for(int j = 0; j <= N; j++){
                    matriz[i][j] /= pivote; // Se divide toda la fila por el pivote
                }
            }
            
            // Hacer ceros en la columna del pivote
            for(int k = 0; k < N; k++){
                if(k != i){
                    double factor = matriz[k][i]; // Se toma el factor para hacer el 0
                    for(int j = 0; j <= N; j++){
                        matriz[k][j] -= factor * matriz[i][j]; // Se resta la fila pivote multiplicada por el factor
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            resultados[i] = matriz[i][N];
        }
    }

    //Métodos desarrollados en equipo
}
