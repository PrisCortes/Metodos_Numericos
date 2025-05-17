/*Clase que implementa el método de Newton-Raphson para encontrar una raíz
de una función f(x) a partir de una estimación inicial.*/
public class NewtonRaphson {

    /*Función objetivo: f(x) = x³ - 27
        x valor en el cual se evalúa la función
        return resultado de f(x)
    */
    public static double f(double x) {
        return Math.pow(x, 3) - 27;
    }

    /*Derivada de la función: f'(x) = 3x²
        x valor en el cual se evalúa la derivada
        return resultado de f'(x)
    */
    public static double df(double x) {
        return 3 * Math.pow(x, 2);
    }

    /*Método de Newton-Raphson para encontrar una raíz aproximada de f(x) 
        Fórmula utilizada: x₁ = x₀ - f(x₀) / f'(x₀)
        x0 Estimación inicial
        tolerancia Tolerancia del error absoluto para detener el método
        maxIteraciones Número máximo de iteraciones permitidas
    */
    public static void encontrarRaiz(double x0, double tolerancia, int maxIteraciones) {
        double x1; // Nueva estimación

        // Bucle de iteraciones
        for (int i = 1; i <= maxIteraciones; i++) {
            double fx = f(x0);   // Valor de la función en x0
            double dfx = df(x0); // Valor de la derivada en x0

            // Verifica si la derivada es cero (no se puede dividir)
            if (dfx == 0) {
                System.out.println("Derivada cero. Método no puede continuar.");
                return;
            }

            // Aplicación de la fórmula de Newton-Raphson
            x1 = x0 - fx / dfx;

            // Cálculo de errores
            double errorA = Math.abs(x1 - x0);        // Error absoluto
            double errorR = errorA / Math.abs(x1);    // Error relativo

            // Mostrar resultados de la iteración
            System.out.printf(
                "Iteración %d: x0 = %.3f, f(x0) = %.3f, f'(x0) = %.3f, x1 = %.3f, Error A = %.3f, Error R = %.3f\n",
                i, x0, fx, dfx, x1, errorA, errorR
            );

            // Condición de parada si el error absoluto es menor a la tolerancia
            if (errorA < tolerancia) {
                System.out.printf("\nRaíz aproximada: %.3f en %d iteraciones\n", x1, i);
                return;
            }

            // Actualiza x0 para la siguiente iteración
            x0 = x1;
        }

        // Si no se encuentra una raíz dentro del número máximo de iteraciones
        System.out.printf("\nNo se alcanzó la tolerancia deseada después de %d iteraciones. Último valor: %.3f\n", maxIteraciones, x0);
    }

    /**
     * Método principal que define los parámetros iniciales y llama al método encontrarRaiz().
     */
    public static void main(String[] args) {
        double x0 = 3.5;              // Estimación inicial
        double tolerancia = 0.0001;   // Tolerancia del error
        int maxIteraciones = 100;     // Número máximo de iteraciones

        // Llama al método de Newton-Raphson
        encontrarRaiz(x0, tolerancia, maxIteraciones);
    }
}
