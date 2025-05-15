import java.util.Scanner;

//Clase que proporciona un método para realizar interpolación lineal entre dos puntos.
class InterpolacionLineal {
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        double m = (y1 - y0) / (x1 - x0); // Cálculo de la pendiente
        return y0 + m * (x - x0); // Ecuación de la recta secante
    }
}

//Clase principal que solicita datos al usuario y utiliza interpolación lineal.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaración de variables
        double x0, x1, y0, y1,x;

        // Solicitud de entradas de los valores al usuario
        System.out.print("Valor de x0: ");
        x0 = scanner.nextDouble();
        System.out.print("Valor de x1: ");
        x1 = scanner.nextDouble();
        System.out.print("Valor de y0: ");
        y0 = scanner.nextDouble();
        System.out.print("Valor de y1: ");
        y1 = scanner.nextDouble();
        System.out.print("Valor de x: ");
        x = scanner.nextDouble();

        // Cálculo del valor interpolado
        double resultado = InterpolacionLineal.interpolar(x0, y0, x1, y1, x);

        // Muestra del resultado con seis cifras decimales
        System.out.printf("Valor interpolado: %.3f\n", resultado);
    }
}

//Código desarrollado en equipo: Corea del Sur