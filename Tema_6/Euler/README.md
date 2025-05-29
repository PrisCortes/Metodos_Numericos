# Tema 6: Método Euler para sistemas de ecuaciones diferenciales ordinarias

## Descripción del método

Este método se aplica a sistemas de ecuaciones diferenciales. Es un método de un solo paso que avanza la solución usando la pendiente actual. Es simple pero con baja precisión.
Este método calcula todas las derivadas del sistema y avanza cada variable de forma independiente usando su ecuación diferencial.

## Formula del método
    y​n+1​=y​n​+h⋅f​(tn​,y​n​)

Donde:
- `yn+1`: vector con el valor de todas las variables en el paso n
- `h`: paso de integración
- `f(tn, yn)`: vector de derivadas para cada ecuación del sistema
- `yn+1`: vector con los valores actualizados de las variables

## Pseudocódigo

    Algoritmo Euler2EDOs 
        Definir pasos, i Como Entero 
        Definir h, tFinal, t, dx, dy Como Real 
        Definir x0, y0 Como Real 
        
        Dimension tiempo[1000] 
        Dimension solucionX[1000] 
        Dimension solucionY[1000] 
        
        Escribir "Ingrese x(0):" 
        Leer x0 
        
        Escribir "Ingrese y(0):" 
        Leer y0 
        
        Escribir "Ingrese el paso de tiempo h:" 
        Leer h 
        
        Escribir "Ingrese el tiempo final de simulación:" 
        Leer tFinal 
        
        pasos <- trunc(tFinal / h) + 1 
        
        tiempo[0] <- 0 
        solucionX[0] <- x0 
        solucionY[0] <- y0 
        
        Para i <- 1 Hasta pasos - 1 
            tiempo[i] <- tiempo[i - 1] + h 
            t <- tiempo[i - 1] 
            
            // Derivadas del sistema 
            dx <- solucionX[i - 1] + t 
            dy <- -solucionY[i - 1] + t 
            
            // Método de Euler 
            solucionX[i] <- solucionX[i - 1] + h * dx 
            solucionY[i] <- solucionY[i - 1] + h * dy 
        FinPara 
        
        // Imprimir tabla de resultados 
        Escribir "t", "       x(t)      y(t)" 
        Para i <- 0 Hasta pasos - 1 
            Escribir tiempo[i], "   ", solucionX[i], "   ", solucionY[i] 
        FinPara 
    FinAlgoritmo 

## Programa ejecutable
- [Código en lenguaje Java](./src/EulerODESolver.java)

## Ejemplo de aplicación
En una habitación con temperatura ambiente de 22 °C, se coloca una taza de café caliente. 
La temperatura del café disminuye con el tiempo según la ley de enfriamiento de Newton: dy/dt = -0.1(y - 22).
En el minuto 0, el café tiene una temperatura de 90 °C. Se desea predecir la temperatura 
del café cada minuto hasta el minuto 10, utilizando el método de Euler con paso de 1 
minuto. 
- y(0) = 90
- h = 1h
- Tiempo final = 10 min

- [Ejecución del código en Java](./src//Ejecucion.png)

- **Resultado:** En el minuto 1 ya se ha enfriado a 83.2 °C y al minuto 10 alcanza los 43.34 °C. Esto indica que el café pierde calor más rápidamente cuando la diferencia con la temperatura ambiente (22 °C) es mayor, y se enfría más lentamente conforme se aproxima a dicha temperatura.