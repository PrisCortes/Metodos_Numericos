import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        int n;
        Scanner scanner = new Scanner(System.in);

        //Determinar el tamaño de la matriz
        System.out.print("\nTamaño de la matriz: ");
        n = scanner.nextInt();

        System.out.println("\nCoeficientes de la matriz: ");
        metodos metodos = new metodos(n);
        
        //Llenar matriz
        metodos.llenarMatriz();

        //Mostrar matriz dada
        System.out.println("\nLa matriz dada es: ");
        metodos.mostrarMatriz();

        //Resolver matriz
        //metodos.metodoGauss();
        //metodos.gaussJordan();
        metodos.gaussSeidel(100, 1e-6);

        //Mostrar matriz resultante
        System.out.println("\nLa matriz resultante es: ");
        metodos.mostrarMatriz();

        //Mostrar los resultados
        System.out.println("\nLos resultados son: ");
        metodos.mostrarResultados();
    }
}
