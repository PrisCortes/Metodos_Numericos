import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        int n;
        Scanner scanner = new Scanner(System.in);

        //Determinar el tamaño de la matriz
        System.out.print("Tamaño de la matriz: ");
        n = scanner.nextInt();

        GaussPivote gauss = new GaussPivote(n);
        
        //Llenar matriz
        gauss.LlenarMatriz();

        //Mostrar matriz
        gauss.MostrarMatriz();
    }
}
