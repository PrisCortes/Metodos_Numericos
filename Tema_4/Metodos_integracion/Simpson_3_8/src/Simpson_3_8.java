import java.util.Scanner;

public class Simpson_3_8 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar los coeficientes de la función cuadrática: ax^2 + bx + c
        System.out.println("Ingrese el coeficiente a (para ax^2):");
        double coefA = scanner.nextDouble();

        System.out.println("Ingrese el coeficiente b (para bx):");
        double coefB = scanner.nextDouble();

        System.out.println("Ingrese el coeficiente c:");
        double coefC = scanner.nextDouble();

        // Solicitar los límites de integración
        System.out.println("Ingrese el límite inferior de integración:");
        double limInf = scanner.nextDouble();

        System.out.println("Ingrese el límite superior de integración:");
        double limSup = scanner.nextDouble();

        // Solicitar el número de subintervalos (n debe ser múltiplo de 3)
        System.out.println("Ingrese el número de subintervalos (n, múltiplo de 3):");
        int n = scanner.nextInt();

        if (n <= 0 || limInf >= limSup) {
            System.out.println("Datos inválidos. Asegúrese que n > 0 y que el límite inferior sea menor al superior.");
            return;
        }
        if (n % 3 != 0) {
            System.out.println("El número de subintervalos debe ser múltiplo de 3 para utilizar Simpson 3/8.");
            return;
        }

        double h = (limSup - limInf) / n;
        double suma = evaluarFuncion(coefA, coefB, coefC, limInf) + evaluarFuncion(coefA, coefB, coefC, limSup);

        double suma3 = 0.0;  // Suma de los términos donde el índice no es múltiplo de 3
        double suma2 = 0.0;  // Suma de los términos donde el índice es múltiplo de 3 (excluyendo los extremos)

        // Se recorren los puntos intermedios
        for (int i = 1; i < n; i++) {
            double x = limInf + i * h;
            if (i % 3 == 0)
                suma2 += evaluarFuncion(coefA, coefB, coefC, x);
            else
                suma3 += evaluarFuncion(coefA, coefB, coefC, x);
        }

        // La fórmula de Simpson 3/8 es:
        // Integral ≈ (3h/8)[f(x0) + f(xn) + 3Σ f(xi) (i no múltiplo de 3) + 2Σ f(xi) (i múltiplo de 3, excluyendo extremos)]
        double integral = (3 * h / 8.0) * (suma + 3 * suma3 + 2 * suma2);
        System.out.printf("La aproximación de la integral es: %.3f\n", integral);
    }

    // Método que evalúa la función cuadrática: ax^2 + bx + c
    private static double evaluarFuncion(double a, double b, double c, double x) {
        return a * x * x + b * x + c; 
    }
}