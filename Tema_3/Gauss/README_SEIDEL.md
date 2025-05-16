# Tema 3: Método de Gauss Seidel

## Descripción del método

Es un método iterativo, útil para sistemas grandes o dispersos, pues usa los valores actualizados inmediatamente en cada iteración, lo que acelera la convergencia si el sistema cumple ciertas condiciones (como ser diagonalmente dominante). Se detiene cuando las soluciones dejan de cambiar significativamente (según una tolerancia dada).

## Pseudocódigo

    Algoritmo Gauss_Seidel
        Definir n, i, j, k, iter, maxIter Como Entero
        Definir tol, suma, diff, maxDiff Como Real
        Escribir "Ingrese el número de ecuaciones (n):"
        Leer n
        Dimension matriz[n, n+1]
        Dimension resultado[n]
        Dimension resultadoAnt[n]
        
        // Ingreso de datos
        Para i <- 1 Hasta n
            Para j <- 1 Hasta n+1
                Escribir "matriz[", i, ",", j, "] = "
                Leer matriz[i, j]
            FinPara
        FinPara
        
        Escribir "Ingrese número máximo de iteraciones:"
        Leer maxIter
        Escribir "Ingrese tolerancia:"
        Leer tol
        
        // Inicializar resultados
        Para i <- 1 Hasta n
            resultado[i] <- 0
        FinPara
        
        // Iteraciones
        Para iter <- 1 Hasta maxIter
            Para i <- 1 Hasta n
                resultadoAnt[i] <- resultado[i]
            FinPara
            
            Para i <- 1 Hasta n
                suma <- 0
                Para j <- 1 Hasta n
                    Si j <> i Entonces
                        suma <- suma + matriz[i, j] * resultado[j]
                    FinSi
                FinPara
                resultado[i] <- (matriz[i, n+1] - suma) / matriz[i, i]
            FinPara
            
            // Verificar convergencia
            maxDiff <- 0
            Para i <- 1 Hasta n
                diff <- Abs(resultado[i] - resultadoAnt[i])
                Si diff > maxDiff Entonces
                    maxDiff <- diff
                FinSi
            FinPara
            
            Si maxDiff < tol Entonces
                Escribir "Convergencia alcanzada en ", iter, " iteraciones."
            FinSi
        FinPara
        
        Escribir "Resultado después de ", maxIter, " iteraciones:"
        Para i <- 1 Hasta n
            Escribir "x[", i, "] = ", resultado[i]
        FinPara
    FinAlgoritmo

## Método principal
- [Código con método principal en Java](./src/App.java)
> - Para su ejecución descomentar la linea 24 y mantener documentadas las lineas 22, 23 y 25 en el código.

## Método en código
- [Método en lenguaje Java](./src/metodos.java)
> - **Inicio del método**: Linea 120 del código
> - **Fin del método**: Linea 151 del código

## Ejemplo de aplicación
Resolver el siguiente sistema de ecuaciones
- 4x + y + 2z = 4
- 3x + 5y + z = 7
- x + y + 3z = 3

[Ejecución del método](./Ejecuciones/Ejecucion_Seidel.png)

**Resultados:** 
- x = 0.5
- y = 1
- z = 0.5