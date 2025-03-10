import java.util.*;
public class GaussPivote {
    Scanner scanner = new Scanner(System.in);

    //Declaración de variables
    public int N;
    public int [][] matriz;

    //Constructor
    public GaussPivote (int n) {
        N = n;
        matriz = new int [n][n];
    }

    //Método para llenar la matriz
    public void LlenarMatriz () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("["+i+"] ["+j+"] = ");
                matriz[i][j]= scanner.nextInt();
            }
        }
    }

    //Método para mostrar la matriz
    public void MostrarMatriz () {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }
    }
}
