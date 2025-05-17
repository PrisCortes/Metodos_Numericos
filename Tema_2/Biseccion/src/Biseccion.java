//Clase que implementa el método de bisección para encontrar raíces de una función.
public class Biseccion {

    //Función objetivo: f(x) = x^3 - 4x + 1
    public static double f(double x) {
        return Math.pow(x, 3) - 4 * x + 1;
    }

    /*Método de Bisección para encontrar una raíz de f(x) en el intervalo [a, b]
        a extremo izquierdo del intervalo
        b extremo derecho del intervalo
        tolerancia margen de error aceptable
        maxIteraciones número máximo de iteraciones permitidas*/
        
    public static void encontrarRaiz(double a, double b, double tolerancia, int maxIteraciones) {
        // Verifica que haya un cambio de signo en el intervalo
        if (f(a) * f(b) >= 0) {
            System.out.println("La función no cambia de signo en el intervalo. No se puede aplicar Bisección.");
            return;
        }

        double c = a; // Inicialización del punto medio

        // Iteraciones del método
        for (int i = 1; i <= maxIteraciones; i++) {
            c = (a + b) / 2;          // Calcular punto medio
            double fc = f(c);         // Evaluar la función en c

            // Imprimir detalles de la iteración actual
            System.out.printf("Iteración %d: a = %.3f, b = %.3f, c = %.3f, f(c) = %.3f\n", i, a, b, c, fc);

            // Verificar si se ha alcanzado la raíz con suficiente precisión
            if (Math.abs(fc) < tolerancia || (b - a) / 2 < tolerancia) {
                System.out.printf("\nRaíz aproximada: %.3f en %d iteraciones\n", c, i);
                return;
            }

            // Determinar nuevo intervalo [a, c] o [c, b] dependiendo del signo
            if (f(a) * fc < 0) {
                b = c;
            } else {
                a = c;
            }
        }

        // Si no se alcanza la tolerancia deseada en el número máximo de iteraciones
        System.out.printf("\nNo se alcanzó la tolerancia deseada después de %d iteraciones. Último valor: %.3f\n", maxIteraciones, c);
    }

    /**
     * Método principal para probar el método de bisección
     */
    public static void main(String[] args) {
        double a = 0;                  // Límite inferior del intervalo
        double b = 1;                  // Límite superior del intervalo
        double tolerancia = 0.001;     // Error aceptable
        int maxIteraciones = 100;      // Límite de iteraciones

        // Llamar al método de bisección
        encontrarRaiz(a, b, tolerancia, maxIteraciones);
    }
}
