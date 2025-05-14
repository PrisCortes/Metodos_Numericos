import java.util.Scanner;

public class Trapecio_Compuesto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lectura de los coeficientes de la función cuadrática: ax^2 + bx + c
        System.out.print("Ingrese el coeficiente a (para ax^2): ");
        double coefA = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente b (para bx): ");
        double coefB = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente c: ");
        double coefC = scanner.nextDouble();
        
        // Ingreso de los límites de integración
        System.out.print("Ingrese el límite inferior de integración: ");
        double limInf = scanner.nextDouble();

        System.out.print("Ingrese el límite superior de integración: ");
        double limSup = scanner.nextDouble();

        // Ingreso del número de subintervalos
        System.out.print("Ingrese el número de subintervalos (n > 0): ");
        int n = scanner.nextInt();

        // Validación de entrada
        if (n <= 0 || limInf >= limSup) {
            System.out.println("Datos inválidos. Asegúrese de que n > 0 y que el límite inferior sea menor al superior.");
            return;
        }

        // Cálculo del ancho del subintervalo
        double h = (limSup - limInf) / n;
        double suma = 0.0;

        // Suma de los extremos
        suma += evaluarFuncion(coefA, coefB, coefC, limInf);
        suma += evaluarFuncion(coefA, coefB, coefC, limSup);

        // Sumar evaluaciones en los puntos intermedios (multiplicados por 2)
        for (int i = 1; i < n; i++) {
            double x = limInf + i * h;
            suma += 2 * evaluarFuncion(coefA, coefB, coefC, x);
        }

        // Aplicación de la fórmula del trapecio compuesto:
        // ∫ ≈ (h/2) [f(x0) + 2f(x1) + 2f(x2) + ... + 2f(xn-1) + f(xn)]
        double integral = (h / 2.0) * suma;
        System.out.printf("La aproximación de la integral es: %.6f\n", integral);
    }

    // Método que evalúa la función cuadrática para un valor dado de x
    private static double evaluarFuncion(double a, double b, double c, double x) {
        return a * x * x + b * x + c;
    }
}

