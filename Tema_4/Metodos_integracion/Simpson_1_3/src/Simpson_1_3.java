import java.util.Scanner;

public class Simpson_1_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar los coeficientes de la función cuadrática: ax^2 + bx + c
        System.out.print("Ingrese el coeficiente a (para ax^2): ");
        double coefA = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente b (para bx): ");
        double coefB = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente c: ");
        double coefC = scanner.nextDouble();

        // Solicita los límites inferior y superior del intervalo de integración
        System.out.print("Ingrese el límite inferior de integración: ");
        double limInf = scanner.nextDouble();

        System.out.print("Ingrese el límite superior de integración: ");
        double limSup = scanner.nextDouble();

        // Solicita el número de subintervalos (n) - debe ser par para el método de Simpson 1/3
        System.out.print("Ingrese el número de subintervalos (n, número par): ");
        int n = scanner.nextInt();

        // Validación: n debe ser positivo y par, y los límites deben estar en orden correcto
        if (n <= 0 || limInf >= limSup) {
            System.out.println("Datos inválidos. Asegúrese de que n > 0 y que el límite inferior sea menor al superior.");
            return;
        }
        if (n % 2 != 0) {
            System.out.println("El número de subintervalos debe ser un número par para utilizar Simpson 1/3.");
            return;
        }

        // Cálculo del ancho de cada subintervalo
        double h = (limSup - limInf) / n;

        // Evaluación de los extremos f(x0) y f(xn)
        double suma = evaluarFuncion(coefA, coefB, coefC, limInf) + evaluarFuncion(coefA, coefB, coefC, limSup);
        
        // Variables para acumular las sumas de los valores intermedios
        double suma4 = 0.0; // Suma de los valores f(x_i) para índices impares
        double suma2 = 0.0; // Suma de los valores f(x_i) para índices pares (excluyendo los extremos)

        // Se recorren los puntos intermedios
        for (int i = 1; i < n; i++) {
            double x = limInf + i * h;
            if (i % 2 == 0) {
                suma2 += evaluarFuncion(coefA, coefB, coefC, x);
            } else {
                suma4 += evaluarFuncion(coefA, coefB, coefC, x);
            }
        }

        // Aplicación de la fórmula de Simpson 1/3:
        // Integral ≈ (h/3)[f(x0) + f(xn) + 4Σ f(xi) con i impares + 2Σ f(xi) con i pares]
        double integral = (h / 3.0) * (suma + 4 * suma4 + 2 * suma2);
        System.out.printf("La aproximación de la integral es: %.6f\n", integral);
    }

    // Método que evalúa la función cuadrática ax^2 + bx + c en un punto x
    private static double evaluarFuncion(double a, double b, double c, double x) {
        return a * x * x + b * x + c;
    }
}

