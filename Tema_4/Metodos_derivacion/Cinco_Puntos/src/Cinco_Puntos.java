import java.util.Scanner;

public class Cinco_Puntos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         // Solicitar los coeficientes de la función cuadrática: ax^2 + bx + c
         System.out.println("Ingrese el coeficiente a (para ax^2):");
         double coefA = scanner.nextDouble();
 
         System.out.println("Ingrese el coeficiente b (para bx):");
         double coefB = scanner.nextDouble();
 
         System.out.println("Ingrese el coeficiente c:");
         double coefC = scanner.nextDouble();
 
         // Solicitar el punto donde se quiere calcular la derivada
         System.out.println("Ingrese el punto x en donde desea calcular la derivada:");
         double x = scanner.nextDouble();
 
         // Solicitar el valor de h 
         System.out.println("Ingrese el valor de h (por ejemplo, 0.001):");
         double h = scanner.nextDouble();
 
         if (h <= 0) {
             System.out.println("El valor de h debe ser mayor que 0.");
             return;
         }
 
         // Aplicación del método de 5 puntos
         double fxMenos2h = evaluarFuncion(coefA, coefB, coefC, x - 2 * h);
         double fxMenosh = evaluarFuncion(coefA, coefB, coefC, x - h);
         double fxMash = evaluarFuncion(coefA, coefB, coefC, x + h);
         double fxMa2h = evaluarFuncion(coefA, coefB, coefC, x + 2 * h);
 
         double derivada = (-fxMa2h + 8 * fxMash - 8 * fxMenosh + fxMenos2h) / (12 * h);
 
         System.out.printf("La aproximación de la derivada es: %.3f\n", derivada);
     }
 
     // Método que evalúa la función cuadrática ax^2 + bx + c en un punto x
     private static double evaluarFuncion(double a, double b, double c, double x) {
         return a * x * x + b * x + c;
     }
 }
