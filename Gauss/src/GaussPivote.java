import java.util.Scanner;
public class GaussPivote {
    Scanner scanner = new Scanner(System.in);
    public int [][] LlenarMatriz (int n) {
        int [][] matriz = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("["+i+"] ["+j+"] = ");
                matriz[i][j]= scanner.nextInt();
            }
        }
        return matriz;
    }
}
