# Tema 3: Método de Jacobi

## Descripción del método

También es un método iterativo, que calcula nuevas aproximaciones usando solo los valores de la iteración anterior.
Es más simple que Gauss-Seidel, pero suele requerir más iteraciones para converger. Requiere que el sistema sea diagonalmente dominante o esté bien condicionado para garantizar convergencia.

## Pseudocódigo

    Algoritmo Metodo_Jacobi
        Definir n, i, j, iter, maxIter Como Entero
        Definir suma, tol, diff Como Real
        Definir convergente Como Logico
        Escribir "Ingrese el número de ecuaciones (n):"
        Leer n
        Dimension matriz[n, n+1]
        Dimension resultado[n]
        Dimension resultadoNuevo[n]
        
        Escribir "Ingrese la matriz aumentada:"
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
        
        iter <- 0
        Repetir
            iter <- iter + 1
            convergente <- Verdadero
            
            Para i <- 1 Hasta n
                suma <- 0
                Para j <- 1 Hasta n
                    Si j <> i Entonces
                        suma <- suma + matriz[i, j] * resultado[j]
                    FinSi
                FinPara
                resultadoNuevo[i] <- (matriz[i, n+1] - suma) / matriz[i, i]
            FinPara
            
            Para i <- 1 Hasta n
                diff <- Abs(resultadoNuevo[i] - resultado[i])
                Si diff > tol Entonces
                    convergente <- Falso
                FinSi
                resultado[i] <- resultadoNuevo[i]
            FinPara
        Hasta Que convergente O iter = maxIter
        
        Si convergente Entonces
            Escribir "Convergencia alcanzada en ", iter, " iteraciones."
        Sino
            Escribir "No se alcanzó convergencia en ", maxIter, " iteraciones."
        FinSi
        
        Escribir "Resultado del sistema:"
        Para i <- 1 Hasta n
            Escribir "x[", i, "] = ", resultado[i]
        FinPara
    FinAlgoritmo


## Método principal
- [Código con método principal en Java](./src/App.java)
> - Para su ejecución descomentar la linea 25 y mantener documentadas las lineas 22, 23 y 24 en el código.

## Método en código
- [Método en lenguaje Java](./src/metodos.java)
> - **Inicio del método**: Linea 153 del código
> - **Fin del método**: Linea 201 del código

## Ejemplo de aplicación
Resolver el siguiente sistema de ecuaciones
- 6x + 3y = 7
- 5x + 8y = 2

[Ejecución del método](./Ejecuciones/Ejecucion_Jacobi.png)

**Resultados:** 
- x = 1.5152
- y = -0.6970