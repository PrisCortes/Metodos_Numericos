import java.util.Scanner;

public class Tres_Puntos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar los coeficientes de la función cuadrática: ax^2 + bx + c
        System.out.print("Ingrese el coeficiente a (para ax^2): ");
        double coefA = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente b (para bx): ");
        double coefB = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente c: ");
        double coefC = scanner.nextDouble();

        // Solicita el punto x en el que se desea calcular la derivada de la función
        System.out.print("Ingrese el punto x en donde desea calcular la derivada: ");
        double x = scanner.nextDouble();

        // Solicita el valor de h, que define la precisión de la aproximación
        System.out.print("Ingrese el valor de h (por ejemplo, 0.001): ");
        double h = scanner.nextDouble();

        // Validación: h debe ser positivo para evitar errores de cálculo
        if (h <= 0) {
            System.out.println("El valor de h debe ser mayor que 0.");
            return;
        }

        // Se evalúa la función en los puntos f(x - h) y f(x + h)
        double fxMenos = evaluarFuncion(coefA, coefB, coefC, x - h);
        double fxMas = evaluarFuncion(coefA, coefB, coefC, x + h);

        // Método de 3 puntos (centrado) para la derivada:
        // f'(x) ≈ (f(x + h) - f(x - h)) / (2h)
        double derivada = (fxMas - fxMenos) / (2 * h);

        // Muestra el resultado de la derivada aproximada en el punto x
        System.out.printf("La aproximación de la derivada es: %.3f\n",derivada);
    }

    // Método que evalúa la función cuadrática ax^2 + bx + c en un punto x
    private static double evaluarFuncion(double a, double b, double c, double x) {
        return a * x * x + b * x + c;
    }
}

//Código realizado en equipo