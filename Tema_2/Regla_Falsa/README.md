# Tema 2: Método de la Regla Falsa

## Descripción del método

Similar a bisección, pero en lugar de usar el punto medio, usa una interpolación lineal entre los puntos **a** y **b** para encontrar una mejor aproximación de la raíz.

## Formula del método
    x = b - ((f(b) (a-b)) / (f(a) - f(b)))

Donde:
- `a`: límite inferior del intervalo
- `b`: límite superior del intervalo
- `f(a) y f(b)`: valores de la función en los extremos del intervalo
- `x`: nuevo valor aproximado de la raíz, obtenido por interpolación lineal

    *Criterio de parada*: |f(x)| < tolerancia o |Xnuevo - Xanterior| < tolerancia.

## Pseudocódigo

    Proceso Metodo_Regla_Falsa
        Definir a, b, c, fa, fb, fc, tolerancia Como Real
        Definir maxIteraciones, i Como Entero
        
        // Entrada de datos
        Escribir "Ingrese el límite inferior a:"
        Leer a
        Escribir "Ingrese el límite superior b:"
        Leer b
        Escribir "Ingrese la tolerancia:"
        Leer tolerancia
        Escribir "Ingrese el número máximo de iteraciones:"
        Leer maxIteraciones
        
        // Evaluar f(a) y f(b): f(x) = x^3 - 4x + 1
        fa <- a^3 - 4 * a + 1
        fb <- b^3 - 4 * b + 1
        
        // Verificar cambio de signo
        Si fa * fb >= 0 Entonces
            Escribir "La función no cambia de signo en el intervalo. No se puede aplicar Regla Falsa."
        FinSi

        // Inicialización
        c <- a

        // Iteraciones de la Regla Falsa
        Para i <- 1 Hasta maxIteraciones Hacer
            // Calcular punto de intersección lineal
            c <- (a * fb - b * fa) / (fb - fa)
            fc <- c^3 - 4 * c + 1
            
            // Mostrar información de la iteración
            Escribir "Iteración ", i, ": a = ", a, ", b = ", b, ", c = ", c, ", f(c) = ", fc
            
            // Verificar tolerancia
            Si abs(fc) < tolerancia Entonces
                Escribir ""
                Escribir "Raíz aproximada: ", c, " en ", i, " iteraciones"
        FinSi

        // Actualizar intervalo
        Si fa * fc < 0 Entonces
            b <- c
            fb <- fc
        Sino
            a <- c
            fa <- fc
        FinSi
        FinPara

        // Si no se alcanzó la tolerancia en las iteraciones permitidas
        Escribir ""
        Escribir "No se alcanzó la tolerancia deseada después de ", maxIteraciones, " iteraciones. Último valor: ", c
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/ReglaFalsa.java)

## Ejemplo de aplicación
- Hallar la raíz de la función: f(x) = x^3 - 4x + 1
- Intervalo a: 0
- Intervalo b = 1
- [Ejecución del código en Java](./src/Ejecucion.png)
- **Número de iteraciones**: 4
- **Resultado:** 0.254
