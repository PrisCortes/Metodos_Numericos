import java.util.Scanner;

/*Clase que calcula la ecuación de regresión lineal simple y el coeficiente de correlación de Pearson (r)
a partir de un conjunto de pares de datos (x, y).*/
public class Correlacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaración de variables para almacenamiento de datos y sumatorias
        int n;
        double xi, yi;
        double sumaX = 0, sumaY = 0, sumaXY = 0, sumaX2 = 0, sumaY2 = 0;
        double coefPendiente, coefIntercepto, r;

        // Solicitar al usuario el número de datos a ingresar
        System.out.print("Ingrese el número de datos: ");
        n = scanner.nextInt();

        // Crear arreglos para almacenar los valores de X y Y
        double[] datosX = new double[n];
        double[] datosY = new double[n];

        // Ingreso de datos y cálculo de sumatorias necesarias
        for (int i = 0; i < n; i++) {
            System.out.println("Dato " + (i + 1));
            System.out.print("Ingrese X[" + (i + 1) + "]: ");
            xi = scanner.nextDouble();
            System.out.print("Ingrese Y[" + (i + 1) + "]: ");
            yi = scanner.nextDouble();

            // Almacenar valores en los arreglos
            datosX[i] = xi;
            datosY[i] = yi;

            // Calcular sumatorias
            sumaX += xi;
            sumaY += yi;
            sumaXY += xi * yi;
            sumaX2 += xi * xi;
            sumaY2 += yi * yi;
        }

        // Cálculo de la pendiente (coeficiente angular) de la recta de regresión
        coefPendiente = (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX * sumaX);

        // Cálculo del intercepto (ordenada al origen) de la recta de regresión
        coefIntercepto = (sumaY - coefPendiente * sumaX) / n;

        // Cálculo del coeficiente de correlación de Pearson
        r = (n * sumaXY - sumaX * sumaY) / Math.sqrt((n * sumaX2 - sumaX * sumaX) * (n * sumaY2 - sumaY * sumaY));

        // Mostrar la ecuación de la regresión y el coeficiente de correlación
        System.out.println("-----------------------------------------");
        System.out.printf("Ecuación de regresión: Y = %.3f + %.3f * X%n", coefIntercepto, coefPendiente);
        System.out.printf("Coeficiente de correlación r = %.3f%n", r);

        // Interpretación del valor del coeficiente de correlación
        System.out.println("Interpretación:");
        if (r > 0) {
            System.out.println("Relación positiva.");
        } else if (r < 0) {
            System.out.println("Relación negativa.");
        } else {
            System.out.println("La correlación es nula.");
        }

        scanner.close(); // Cerrar el escáner
    }
}

//Código desarrollado en equipo: Corea del Sur