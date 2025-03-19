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
        gauss.llenarMatriz();

        //Mostrar matriz dada
        System.out.println("\nLa matriz dada es: ");
        gauss.mostrarMatriz();

        //Resolver matriz
        gauss.metodoGauss();

        //Mostrar matriz resultante
        System.out.println("\nLa matriz resultante es: ");
        gauss.mostrarMatriz();

        //Mostrar los resultados
        System.out.println("\nLos resultados son: ");
        gauss.mostrarResultados();
    }
}
