/*Clase que implementa el método de la Secante para encontrar una raíz de la función f(x) = e^(-x) - x.
Este método es una técnica iterativa que utiliza una aproximación numérica de la derivada para encontrar la raíz.*/
public class Secante {

    /*Función objetivo: f(x) = e^(-x) - x 
        x Valor en el cual se evalúa la función
        return Resultado de f(x)
    */
    public static double f(double x) {
        return Math.exp(-x) - x;
    }

    /*Método de la Secante para encontrar una raíz aproximada de la función f(x).
    Utiliza dos estimaciones iniciales x₀ y x₁ y la fórmula de la secante para iterar.
        Fórmula usada: x₂ = x₁ - f(x₁) * (x₁ - x₀) / [f(x₁) - f(x₀)]
        x0 Primera estimación inicial
        x1 Segunda estimación inicial
        tolerancia Error absoluto mínimo aceptado para detener el método
        maxIteraciones Número máximo de iteraciones permitidas
    */
    public static void encontrarRaiz(double x0, double x1, double tolerancia, int maxIteraciones) {
        double x2;

        for (int i = 1; i <= maxIteraciones; i++) {
            double f0 = f(x0);
            double f1 = f(x1);

            // Verifica que no ocurra una división por cero
            if (f1 - f0 == 0) {
                System.out.println("División por cero en iteración " + i);
                return;
            }

            // Aplicación de la fórmula de la secante
            x2 = x1 - f1 * (x1 - x0) / (f1 - f0);

            // Cálculo de errores
            double errorA = Math.abs(x2 - x1);        // Error absoluto
            double errorR = errorA / Math.abs(x2);    // Error relativo

            // Mostrar resultados de la iteración
            System.out.printf("Iteración %d: x0 = %.3f, x1 = %.3f, x2 = %.3f, Error A = %.3f, Error R = %.3f\n",
                              i, x0, x1, x2, errorA, errorR);

            // Verifica si la tolerancia ha sido alcanzada
            if (errorA < tolerancia) {
                System.out.printf("\nRaíz aproximada: %.3f en %d iteraciones\n", x2, i);
                return;
            }

            // Actualizar valores para la siguiente iteración
            x0 = x1;
            x1 = x2;
        }

        // Mensaje si no se alcanza la tolerancia deseada
        System.out.printf("\nNo se alcanzó la tolerancia deseada después de %d iteraciones. Último valor: %.3f\n", maxIteraciones, x1);
    }

    //Método principal para ejecutar el método de la secante con valores iniciales.
    public static void main(String[] args) {
        double x0 = 0.0;              // Primer valor inicial
        double x1 = 1.0;              // Segundo valor inicial
        double tolerancia = 0.0001;   // Tolerancia aceptada
        int maxIteraciones = 100;     // Límite de iteraciones

        encontrarRaiz(x0, x1, tolerancia, maxIteraciones);
    }
}