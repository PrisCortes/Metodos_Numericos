import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*Clase que implementa el método de mínimos cuadrados para encontrar
la recta de regresión lineal (ajuste lineal) a partir de un conjunto de puntos (x, y).*/
public class Minimos_Cuadrados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Formato para redondear a 4 cifras decimales
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println("Método de mínimos cuadrados - Ajuste lineal");

        // Solicitar la cantidad de datos al usuario
        System.out.print("Cantidad de datos que vas a ingresar: ");
        int n = scanner.nextInt();

        // Listas para almacenar los valores de x e y
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        // Ingreso de los pares de datos (x, y)
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese x[" + (i + 1) + "]: ");
            double xi = scanner.nextDouble();

            System.out.print("Ingrese y[" + (i + 1) + "]: ");
            double yi = scanner.nextDouble();

            x.add(xi);
            y.add(yi);
        }

        // Inicialización de las sumatorias necesarias
        double sum_x = 0, sum_y = 0, sum_x2 = 0, sum_xy = 0;

        // Cálculo de sumatorias: Σx, Σy, Σx² y Σxy
        for (int i = 0; i < n; i++) {
            double xi = x.get(i);
            double yi = y.get(i);
            sum_x += xi;
            sum_y += yi;
            sum_x2 += xi * xi;
            sum_xy += xi * yi;
        }

        // Cálculo de los coeficientes b (pendiente) y a (intercepto) de la recta de regresión
        double b = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x * sum_x);
        double a = (sum_y - b * sum_x) / n;

        // Redondeo de los coeficientes a 4 cifras decimales
        String a_str = df.format(a);
        String b_str = df.format(b);

        // Mostrar la ecuación de la recta de regresión resultante
        System.out.println("\nResultado:");
        System.out.println("La recta de regresión es: y = " + a_str + " + " + b_str + "x");

        scanner.close(); // Cierre del escáner
    }
}

//Código desarrollado en equipo: Corea del Sur