# Tema 3: Método de Gauss

## Descripción del método

Este método transforma el sistema de ecuaciones en una forma triangular superior mediante operaciones fila (sumas y restas entre filas, y normalización de pivotes). Luego, se aplica sustitución hacia atrás para obtener las soluciones. Es eficiente y directo, pero puede presentar problemas si el pivote es cero o muy pequeño.

## Pseudocódigo

    Algoritmo Eliminacion_Gauss_Normalizada
        Definir n, i, j, k, factor Como Entero
        Definir suma,  pivote Como Real
        
        // Entrada: tamaño del sistema y matriz aumentada
        Escribir "Ingrese el número de ecuaciones (n):"
        Leer n
        Dimension matriz[n, n+1]
        Dimension resultado[n]
        
        Escribir "Ingrese la matriz aumentada:"
        Para i <- 1 Hasta n Con Paso 1
            Para j <- 1 Hasta n+1 Con Paso 1
                Escribir "matriz [", i, ",", j, "] = "
                Leer matriz[i,j]
            FinPara
        FinPara
        
        // Eliminación hacia adelante con normalización
        Para k <- 1 Hasta n-1 Con Paso 1
            pivote <- matriz[k,k]
            // Normalizar fila k
            Para j <- k Hasta n+1 Con Paso 1
                matriz[k,j] <- matriz[k,j] / pivote
            FinPara
            // Eliminar elementos debajo del pivote
            Para i <- k+1 Hasta n Con Paso 1
                factor <- matriz[i,k]
                Para j <- k Hasta n+1 Con Paso 1
                    matriz[i,j] <- matriz[i,j] - factor * matriz[k,j]
                FinPara
            FinPara
        FinPara
        
        // Sustitución hacia atrás
        Para i <- n Hasta 1 Con Paso -1
            suma <- 0
            Para j <- i+1 Hasta n Con Paso 1
                suma <- suma + matriz[i,j] * resultado[j]
            FinPara
            resultado[i] <- (matriz[i,n+1] - suma) / matriz[i,i]
        FinPara
        
        // Mostrar solución
        Escribir "Solución del sistema:"
        Para i <- 1 Hasta n Con Paso 1
            Escribir "x[", i, "] = ", resultado[i]
        FinPara
    FinAlgoritmo

## Método principal
- [Código con método principal en Java](./src/App.java)
> - Para su ejecución descomentar la linea 22 y mantener documentadas las lineas 23, 24 y 25 en el código.

## Método en código
- [Método en lenguaje Java](./src/metodos.java)
> - **Inicio del método**: Linea 45 del código
> - **Fin del método**: Linea 71 del código

## Ejemplo de aplicación
Resolver el siguiente sistema de ecuaciones
- 3x - 5y + 4z = 2
- x + 6y + 3z = 7
- y + 2z = 3

[Ejecución del método](./Ejecuciones/Ejecucion_Gauss.png)

**Resultados:** 
- x = -0.0244
- y = 0.5610
- z = 1.2195