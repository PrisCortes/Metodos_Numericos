import java.util.Scanner;

public class Cuadratura_Gaussiana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lectura de los coeficientes de la función cuadrática: ax^2 + bx + c
        System.out.print("Ingrese el coeficiente a (para ax^2): ");
        double coefA = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente b (para bx): ");
        double coefB = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente c: ");
        double coefC = scanner.nextDouble();

        // Lectura de los límites de integración
        System.out.print("Ingrese el límite inferior de integración: ");
        double limInf = scanner.nextDouble();

        System.out.print("Ingrese el límite superior de integración: ");
        double limSup = scanner.nextDouble();

        // Verifica que los límites sean válidos
        if (limInf >= limSup) {
            System.out.println("Error: El límite inferior debe ser menor que el límite superior.");
            return;
        }

        // Puntos y pesos para la cuadratura gaussiana de 2 puntos en el intervalo estándar [-1, 1]
        double t1 = -1.0 / Math.sqrt(3.0);
        double t2 =  1.0 / Math.sqrt(3.0);
        double w1 = 1.0;
        double w2 = 1.0;

        // Transformación de los puntos t1 y t2 al intervalo [limInf, limSup]
        // x = ((b - a)/2) * t + (a + b)/2
        double x1 = (limSup - limInf) / 2.0 * t1 + (limSup + limInf) / 2.0;
        double x2 = (limSup - limInf) / 2.0 * t2 + (limSup + limInf) / 2.0;

        // Evaluación de la función f(x) en los puntos transformados
        double f1 = evaluarFuncion(coefA, coefB, coefC, x1);
        double f2 = evaluarFuncion(coefA, coefB, coefC, x2);

        // Cálculo de la integral aproximada:
        // I ≈ ((b - a)/2) * [w1*f(x1) + w2*f(x2)]
        double integral = (limSup - limInf) / 2.0 * (w1 * f1 + w2 * f2);

        System.out.printf("La aproximación de la integral usando cuadratura gaussiana es: %.6f\n", integral);
    }

    // Método que evalúa la función cuadrática ax^2 + bx + c en un punto x
    private static double evaluarFuncion(double a, double b, double c, double x) {
        return a * x * x + b * x + c;
    }
}
