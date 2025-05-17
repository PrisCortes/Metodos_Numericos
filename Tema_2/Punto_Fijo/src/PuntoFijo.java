/*Clase que implementa el método de Punto Fijo para encontrar la raíz de una función
utilizando una transformación g(x) tal que x = g(x).*/
public class PuntoFijo {

    /*Función original: f(x) = x³ - 4x + 1
        Nota: No se utiliza directamente en el método, se incluye como referencia. 
        x Valor en el cual se evalúa la función f
        return Resultado de f(x)
    */
    public static double f(double x) {
        return Math.pow(x, 3) - 4 * x + 1;
    }

    /*Función transformada g(x) = (x³ + 1)/4
        Esta transformación se deriva de despejar x en la ecuación f(x) = 0 para usarla en el método de punto fijo.
        x Valor en el cual se evalúa g
        return Resultado de g(x)
    */
    public static double g(double x) {
        return (Math.pow(x, 3) + 1) / 4;
    }

    /*Método de Punto Fijo para encontrar una raíz aproximada de f(x). 
    Se basa en iterar la relación x = g(x), esperando que la sucesión {x₀, x₁, x₂, ...} converja a una raíz.
        x0 Valor inicial (estimación inicial de la raíz)
        tolerancia Error absoluto mínimo aceptado para detener el método
        maxIteraciones Número máximo de iteraciones permitidas
    */
    public static void encontrarRaiz(double x0, double tolerancia, int maxIteraciones) {
        double x1; // Nueva estimación

        for (int i = 1; i <= maxIteraciones; i++) {
            x1 = g(x0); // Aplicación de la transformación

            // Cálculo de errores
            double errorA = Math.abs(x1 - x0);        // Error absoluto
            double errorR = errorA / Math.abs(x1);    // Error relativo

            // Mostrar detalles de la iteración
            System.out.printf("Iteración %d: x0 = %.3f, x1 = %.3f, Error A = %.3f, Error R = %.3f\n",
                              i, x0, x1, errorA, errorR);

            // Verificación de convergencia
            if (errorA < tolerancia) {
                System.out.printf("\nRaíz aproximada: %.3f en %d iteraciones\n", x1, i);
                return;
            }

            x0 = x1; // Actualizar para la siguiente iteración
        }

        // Mensaje si no se alcanza la tolerancia dentro del número máximo de iteraciones
        System.out.printf("\nNo se alcanzó la tolerancia deseada después de %d iteraciones. Último valor: %.3f\n", maxIteraciones, x0);
    }

    //Método principal para ejecutar el método de Punto Fijo con valores iniciales predefinidos.
    public static void main(String[] args) {
        double x0 = 0;               // Estimación inicial
        double tolerancia = 0.0001;  // Tolerancia deseada
        int maxIteraciones = 100;    // Límite de iteraciones

        encontrarRaiz(x0, tolerancia, maxIteraciones);
    }
}
