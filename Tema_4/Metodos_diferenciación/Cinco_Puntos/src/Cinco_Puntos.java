import java.util.Scanner;

public class Cinco_Puntos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         // Solicitar los coeficientes de la función cuadrática: ax^2 + bx + c
         System.out.print("Ingrese el coeficiente a (para ax^2): ");
         double coefA = scanner.nextDouble();
 
         System.out.print("Ingrese el coeficiente b (para bx): ");
         double coefB = scanner.nextDouble();
 
         System.out.print("Ingrese el coeficiente c: ");
         double coefC = scanner.nextDouble();
 
         // Solicitar el punto donde se quiere calcular la derivada
         System.out.print("Ingrese el punto x en donde desea calcular la derivada: ");
         double x = scanner.nextDouble();
 
         // Solicita el valor de h, que define la precisión de la aproximación
         System.out.print("Ingrese el valor de h (por ejemplo, 0.001): ");
         double h = scanner.nextDouble();
 
         // Validación: h debe ser positivo para evitar división por cero
         if (h <= 0) {
             System.out.println("El valor de h debe ser mayor que 0.");
             return;
         }
 
         // Se evalúa la función en los puntos necesarios para el método de 5 puntos:
        // f(x-2h), f(x-h), f(x+h), f(x+2h)
         double fxMenos2h = evaluarFuncion(coefA, coefB, coefC, x - 2 * h);
         double fxMenosh = evaluarFuncion(coefA, coefB, coefC, x - h);
         double fxMash = evaluarFuncion(coefA, coefB, coefC, x + h);
         double fxMa2h = evaluarFuncion(coefA, coefB, coefC, x + 2 * h);
 
         // Fórmula de derivación numérica con 5 puntos (precisión de orden h^4):
        // f'(x) ≈ (-f(x+2h) + 8f(x+h) - 8f(x-h) + f(x-2h)) / (12h)
         double derivada = (-fxMa2h + 8 * fxMash - 8 * fxMenosh + fxMenos2h) / (12 * h);
 
         // Se muestra el resultado de la derivada aproximada en el punto x
         System.out.printf("La aproximación de la derivada es: %.3f\n", derivada);
     }
 
     // Método que evalúa la función cuadrática ax^2 + bx + c en un punto x
     private static double evaluarFuncion(double a, double b, double c, double x) {
         return a * x * x + b * x + c;
     }
 }
