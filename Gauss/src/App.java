import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        int n;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Determine el tamaño de la matriz");
        n = scanner.nextInt();
        int [][] matriz = new int [n][n];

        GaussPivote gauss = new GaussPivote();
        
        //Llenar matriz
        gauss.LlenarMatriz(n);
    }
}
