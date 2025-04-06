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
                        // Arreglo temporal para intercambio
                        double[] filaTemp = new double[N+1]; 
                        for(int j = 0; j <= N; j++){
                            // Guardar fila actual
                            filaTemp[j] = matriz[i][j]; 
                            // Intercambiar con otra fila
                            matriz[i][j] = matriz[k][j]; 
                            // Completar intercambio
                            matriz[k][j] = filaTemp[j]; 
                        }
                        break;
                    }
                }
            }
            // Hacer el pivote igual a 1
            double pivote = matriz[i][i];
            if (pivote != 0){
                for(int j = 0; j <= N; j++){
                    // Se divide toda la fila por el pivote
                    matriz[i][j] /= pivote; 
                }
            }
            
            // Hacer ceros en la columna del pivote
            for(int k = 0; k < N; k++){
                if(k != i){
                    // Se toma el factor para hacer el 0
                    double factor = matriz[k][i]; 
                    for(int j = 0; j <= N; j++){
                        // Se resta la fila pivote multiplicada por el factor
                        matriz[k][j] -= factor * matriz[i][j]; 
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            resultados[i] = matriz[i][N];
        }
    }

        //Método Gauss-Seidel
        public void gaussSeidel(int maxIter, double tol){

            //Arreglo para guardar los resultados de la iteración anterior
            double[] resultadosAnt = new double[N];
            for (int i = 0; i < maxIter; i++) {
                // Copia el vector actual de resultados al vector de resultados anteriores
                System.arraycopy(resultados, 0, resultadosAnt, 0, N); 
                
                for (int j = 0; j < N; j++) {
                    double sum = 0.0;
                    // Calcula la suma de los términos de la fila j, excepto el elemento diagonal
                    for (int k = 0; k < N; k++) {
                        if (k != j) {
                            sum += matriz[j][k] * resultados[k];
                        }
                    }
                    // Actualiza el valor de la variable j usando la fórmula de Gauss-Seidel
                    resultados[j] = (matriz[j][N] - sum) / matriz[j][j];
                }
    
                // Verificación de la tolerancia
                double maxDiff = 0.0;
                for (int j = 0; j < N; j++) {
                    maxDiff = Math.max(maxDiff, Math.abs(resultados[j] - resultadosAnt[j]));
                }
                if (maxDiff < tol) {
                    System.out.println("Convergencia alcanzada en " + (i + 1) + " iteraciones.");
                    break;
                }
            }
        }

    //Métodos desarrollados en equipo
}
