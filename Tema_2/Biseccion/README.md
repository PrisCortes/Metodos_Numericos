# Tema 2: Método de Bisección

## Descripción del método

Es un método cerrado que requiere dos valores iniciales **a** y **b**. En cada iteración, divide el intervalo a la mitad y selecciona el subintervalo donde ocurre el cambio de signo. Es confiable pero lento.

## Formula del método
    Xmedio = (a + b) / 2

Donde:
- `a`: Límite inferior del intervalo.
- `b`: Límite inferior del intervalo.
- `Xmedio`: Punto medio del intervalo actual, posible raíz.

    *Criterio de parada*: |a - b| < tolerancia.

## Pseudocódigo

    Proceso Metodo_Biseccion
        Definir a, b, c, fa, fb, fc, tolerancia Como Real
        Definir maxIteraciones, i Como Entero
        Definir f_a, f_b, f_c Como Real
        
        // Ingreso de datos
        Escribir "Ingrese el límite inferior a:"
        Leer a
        Escribir "Ingrese el límite superior b:"
        Leer b
        Escribir "Ingrese la tolerancia:"
        Leer tolerancia
        Escribir "Ingrese el número máximo de iteraciones:"
        Leer maxIteraciones
        
        // Evaluar f(a) y f(b): f(x) = x^3 - 4x + 1
        f_a <- a^3 - 4 * a + 1
        f_b <- b^3 - 4 * b + 1
        
        // Verificar que haya cambio de signo
        Si f_a * f_b >= 0 Entonces
            Escribir "La función no cambia de signo en el intervalo. No se puede aplicar Bisección."
        FinSi

        // Iteraciones del método de bisección
        Para i <- 1 Hasta maxIteraciones Hacer
            c <- (a + b) / 2
            f_c <- c^3 - 4 * c + 1
        
            // Mostrar detalles de la iteración
            Escribir "Iteración ", i, ": a = ", a, ", b = ", b, ", c = ", c, ", f(c) = ", f_c
            
            // Verificar si la raíz ya es suficientemente precisa
            Si abs(f_c) < tolerancia O (b - a) / 2 < tolerancia Entonces
                Escribir ""
                Escribir "Raíz aproximada: ", c, " en ", i, " iteraciones"
            FinSi

            // Elegir nuevo intervalo
            Si f_a * f_c < 0 Entonces
                b <- c
                f_b <- f_c
            Sino
                a <- c
                f_a <- f_c
            FinSi
        FinPara

        // No se alcanzó la tolerancia deseada
        Escribir ""
        Escribir "No se alcanzó la tolerancia deseada después de ", maxIteraciones, " iteraciones. Último valor: ", c
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/Biseccion.java)

## Ejemplo de aplicación
- Hallar la raíz de la función: f(x) = x^3 - 4x + 1
- Intervalo a: x = 0
- Intervalo b: 1
- [Ejecución del código en Java](./src/Ejecucion.png)
- **Número de iteraciones**: 8
- **Resultado:** 0.254
