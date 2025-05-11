import java.util.Scanner;

public class Trapecio_Simple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coeficientes de la función cuadrática ax^2 + bx + c
        System.out.print("Ingrese el coeficiente a (para ax^2): ");
        double coefA = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente b (para bx): ");
        double coefB = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente c: ");
        double coefC = scanner.nextDouble();

        // Límites de integración
        System.out.print("Ingrese el límite inferior de integración: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior de integración: ");
        double b = scanner.nextDouble();

        if (a >= b) {
            System.out.println("Error: El límite inferior debe ser menor que el límite superior.");
            return;
        }

        // Evaluar la función en los extremos
        double fa = evaluarFuncion(coefA, coefB, coefC, a);
        double fb = evaluarFuncion(coefA, coefB, coefC, b);

        // Aplicar la fórmula del trapecio simple
        double integral = (b - a) / 2.0 * (fa + fb);

        System.out.printf("La aproximación de la integral es: %.3f\n", integral);
    }

    // Método que evalúa la función ax^2 + bx + c en un valor dado de x
    private static double evaluarFuncion(double a, double b, double c, double x) {
        return a * x * x + b * x + c;
    }
}
