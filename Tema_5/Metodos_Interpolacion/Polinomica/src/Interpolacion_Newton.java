import java.util.Scanner;

/*Clase que implementa el método de interpolación de Newton utilizando
 diferencias divididas para estimar el valor de una función en un punto dado.*/
public class Interpolacion_Newton {

    //Calcula la tabla de diferencias divididas para los puntos dados.
    public static double[][] calcularDiferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] dd = new double[n][n];

        // Inicializar la primera columna con los valores de y
        for (int i = 0; i < n; i++) {
            dd[i][0] = y[i];
        }

        // Calcular las diferencias divididas por columnas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                dd[i][j] = (dd[i + 1][j - 1] - dd[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        return dd;
    }

    //Evalúa el polinomio de Newton en un valor dado de x usando las diferencias divididas.
    public static double evaluarPolinomio(double[][] dd, double[] x, double xEval) {
        int n = x.length;
        double resultado = dd[0][0];   // Término independiente (f[x0])
        double producto = 1.0;         // Producto acumulado (x - x0)(x - x1)...

        // Calcular los términos del polinomio interpolado
        for (int i = 1; i < n; i++) {
            producto *= (xEval - x[i - 1]);
            resultado += dd[0][i] * producto;
        }

        return resultado;
    }

    //Método principal que solicita los datos al usuario y realiza la interpolación.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la cantidad de puntos
        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();

        // Crear arreglos para x e y
        double[] x = new double[n];
        double[] y = new double[n];
        double xEval;

        // Ingreso de los valores del arreglo x
        System.out.println("Ingrese los valores para el arreglo x:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] = ");
            x[i] = scanner.nextDouble();
        }

        // Ingreso de los valores del arreglo y
        System.out.println("Ingrese los valores para el arreglo y:");
        for (int i = 0; i < n; i++) {
            System.out.print("y[" + i + "] = ");
            y[i] = scanner.nextDouble();
        }

        // Valor donde se desea interpolar
        System.out.print("Valor de x: ");
        xEval = scanner.nextDouble();

        // Cálculo de la tabla de diferencias divididas
        double[][] dd = calcularDiferenciasDivididas(x, y);

        // Evaluación del polinomio en el valor dado
        double resultado = evaluarPolinomio(dd, x, xEval);

        // Mostrar resultado
        System.out.printf("Valor interpolado en x = %.3f es: %.2f\n", xEval, resultado);
    }
}

//Código desarrollado en equipo: Corea del Sur