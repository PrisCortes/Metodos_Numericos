/*Clase que implementa el método de Regla Falsa (Interpolación Lineal)
para encontrar una raíz de una función continua en un intervalo dado.*/
public class ReglaFalsa {

    /*Función objetivo: f(x) = x^3 - 4x + 1
        x valor en el cual se evalúa la función
        return resultado de f(x)
    */
    public static double f(double x) {
        return Math.pow(x, 3) - 4 * x + 1;
    }

    /*Método que implementa la Regla Falsa para encontrar una raíz aproximada 
    de la función f(x) en el intervalo [a, b]. 
        a Límite inferior del intervalo
        b Límite superior del intervalo
        tolerancia Error máximo permitido para la raíz aproximada
        maxIteraciones Número máximo de iteraciones permitidas
    */
    public static void encontrarRaiz(double a, double b, double tolerancia, int maxIteraciones) {
        // Verifica que haya un cambio de signo en el intervalo
        if (f(a) * f(b) >= 0) {
            System.out.println("La función no cambia de signo en el intervalo. No se puede aplicar Regla Falsa.");
            return;
        }

        double c = a; // Inicialización de la raíz aproximada

        // Iteraciones del método
        for (int i = 1; i <= maxIteraciones; i++) {
            // Cálculo de la intersección lineal entre los puntos (a, f(a)) y (b, f(b))
            c = (a * f(b) - b * f(a)) / (f(b) - f(a));
            double fc = f(c);

            // Mostrar detalles de la iteración actual
            System.out.printf("Iteración %d: a = %.3f, b = %.3f, c = %.3f, f(c) = %.3f\n", i, a, b, c, fc);

            // Verificar si se ha alcanzado una raíz aproximada con la tolerancia deseada
            if (Math.abs(fc) < tolerancia) {
                System.out.printf("\nRaíz aproximada: %.3f en %d iteraciones\n", c, i);
                return;
            }

            // Ajustar el intervalo dependiendo del signo de f(c)
            if (f(a) * fc < 0) {
                b = c;
            } else {
                a = c;
            }
        }

        // Si no se encuentra la raíz dentro del número máximo de iteraciones
        System.out.printf("\nNo se alcanzó la tolerancia deseada después de %d iteraciones. Último valor: %.3f\n", maxIteraciones, c);
    }

    //Método principal que inicializa los valores y llama al método encontrarRaiz()
    public static void main(String[] args) {
        double a = 0;                  // Límite inferior del intervalo
        double b = 1;                  // Límite superior del intervalo
        double tolerancia = 0.0001;    // Tolerancia de error
        int maxIteraciones = 100;      // Número máximo de iteraciones

        // Llamar al método de Regla Falsa para encontrar la raíz
        encontrarRaiz(a, b, tolerancia, maxIteraciones);
    }
}

