import java.util.Scanner;
import javax.script.ScriptEngine; 
import javax.script.ScriptEngineManager;
import javax.script.ScriptException; 
 
public class MetodoEulerDinamico { 
 
    // Evalúa la expresión con los valores actuales de x e y 
    public static double evaluarFuncion(String funcion, double x, double y) throws ScriptException { 
        ScriptEngine engine = new 
        ScriptEngineManager().getEngineByName("JavaScript"); 

        // Reemplaza x e y en la expresión 
        String expr = funcion.replace("x", "(" + x + ")").replace("y", "(" + y + ")"); 
        return ((Number) engine.eval(expr)).doubleValue(); 
    } 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.println("Método de Euler dinámico para EDO de primer orden y' = f(x, y)"); 
 
        System.out.print("Ingresa la función f(x, y): "); 
        String funcion = sc.nextLine(); // ejemplo: x + y 
 
        System.out.print("Ingresa el valor inicial de x (x0): "); 
        double x0 = sc.nextDouble(); 
 
        System.out.print("Ingresa el valor inicial de y (y0): "); 
        double y0 = sc.nextDouble(); 
 
        System.out.print("Ingresa el tamaño de paso h: "); 
        double h = sc.nextDouble(); 
 
        System.out.print("Ingresa el número de pasos n: "); 
        double n = sc.nextInt(); 
 
        System.out.println("\nIteración\t x\t\t y"); 
 
        for (int i = 0; i <= n; i++) { 
            System.out.printf("%d\t\t %.5f\t %.5f\n", i, x0, y0); 
 
            try { 
                double f = evaluarFuncion(funcion, x0, y0); 
                y0 = y0 + h * f; 
                x0 = x0 + h; 
            } catch (ScriptException e) { 
                System.out.println("Error al evaluar la función: " + e.getMessage()); 
                break; 
            } 
        }
        System.out.println("");
        System.out.printf("\nAproximación final de y en x = %.2f: %.2f%n", n, y0);
    } 
}

//Código realizado por el equipo de los renegados y adaptado por el equipo de Corea del Sur