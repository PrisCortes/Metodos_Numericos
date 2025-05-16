# Tema 3: Método de Gauss Jordan

## Descripción del método

Es una extensión del método de Gauss, ya que después de triangular la matriz, continúa el proceso hasta convertirla en una matriz identidad, lo que da directamente las soluciones sin necesidad de sustitución hacia atrás. Requiere más operaciones que el método de Gauss, pero el resultado es más limpio y útil en algunas aplicaciones como la inversión de matrices.

## Pseudocódigo

    Algoritmo Gauss_Jordan
        Definir n, i, j, k Como Entero
        Definir pivote, factor Como Real
        Escribir "Ingrese el número de ecuaciones (n):"
        Leer n
        Dimension matriz[n, n+1]
        Dimension resultado[n]
        
        // Llenado de la matriz
        Para i <- 1 Hasta n
            Para j <- 1 Hasta n+1
                Escribir "matriz[", i, ",", j, "] = "
                Leer matriz[i, j]
            FinPara
        FinPara
        
        // Aplicación del método Gauss-Jordan
        Para i <- 1 Hasta n
            // Verificar si el pivote es 0 y hacer intercambio si es necesario
            Si matriz[i, i] = 0 Entonces
                Para k <- i+1 Hasta n
                    Si matriz[k, i] <> 0 Entonces
                        Para j <- 1 Hasta n+1
                            pivote <- matriz[i, j]
                            matriz[i, j] <- matriz[k, j]
                            matriz[k, j] <- pivote
                        FinPara
                    FinSi
                FinPara
            FinSi
            
            // Normalizar fila
            pivote <- matriz[i, i]
            Para j <- 1 Hasta n+1
                matriz[i, j] <- matriz[i, j] / pivote
            FinPara
            
            // Hacer ceros en la columna del pivote
            Para k <- 1 Hasta n
                Si k <> i Entonces
                    factor <- matriz[k, i]
                    Para j <- 1 Hasta n+1
                        matriz[k, j] <- matriz[k, j] - factor * matriz[i, j]
                    FinPara
                FinSi
            FinPara
        FinPara
        
        // Extraer soluciones
        Para i <- 1 Hasta n
            resultado[i] <- matriz[i, n+1]
        FinPara
        
        Escribir "Solución del sistema:"
        Para i <- 1 Hasta n
            Escribir "x[", i, "] = ", resultado[i]
        FinPara
    FinAlgoritmo



## Método principal
- [Código con método principal en Java](./src/App.java)
> - Para su ejecución descomentar la linea 23 y mantener documentadas las lineas 22, 24 y 25 en el código.

## Método en código
- [Método en lenguaje Java](./src/metodos.java)
> - **Inicio del método**: Linea 73 del código
> - **Fin del método**: Linea 118 del código

## Ejemplo de aplicación
Resolver el siguiente sistema de ecuaciones
- 4x + 2y = 6
- 4x + 8y = 4

[Ejecución del método](./Ejecuciones/Ejecucion_Jordan.png)

**Resultados:** 
- x = 1.6667
- y = -0.3333