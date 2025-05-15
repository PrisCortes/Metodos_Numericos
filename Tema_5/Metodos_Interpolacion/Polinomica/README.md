# Tema 5: Método de interpolación polinómica: Newton

## Descripción del método

La interpolación polinómica de Newton es una técnica más avanzada que permite construir una curva (polinomio) que pase exactamente por varios puntos conocidos. Su ventaja principal es que se puede modificar fácilmente cuando se agregan nuevos datos, sin recalcular todo desde cero.

## Formula del método
    Pn​(x)=f[x0​]+f[x0​,x1​](x−x0​)+f[x0​,x1​,x2​](x−x0​)(x−x1​)+⋯+f[x0​,…,xn​](x−x0​)…(x−xn−1​)

Donde:
- `(xn,yn)`: Son los puntos conocidos.
- `x`: Es el valor donde interpolamos.

## Pseudocódigo

    Proceso InterpolacionNewton
        Definir n Como Entero
        Definir i, j Como Entero
        Definir xEval, resultado, producto Como Real
        
        Escribir "Ingrese la cantidad de elementos:"
        Leer n
        
        Dimension x[n]
        Dimension w[n]
        Dimension dd[n,n]
        
        Escribir "Ingrese los valores para el arreglo x:"
        Para i <- 1 Hasta n Hacer
            Escribir "x[", i, "] = "
            Leer x[i]
        FinPara
        
        Escribir "Ingrese los valores para el arreglo w:"
        Para i <- 1 Hasta n Hacer
            Escribir "w[", i, "] = "
            Leer w[i]
        FinPara
        
        Escribir "Ingrese el valor de x donde desea interpolar:"
        Leer xEval
        
        // Inicializar la primera columna de diferencias divididas con y
        Para i <- 1 Hasta n Hacer
            dd[i,1] <- w[i]
        FinPara
        
        // Calcular la tabla de diferencias divididas
        Para j <- 2 Hasta n Hacer
            Para i <- 1 Hasta n - j + 1 Hacer
                dd[i,j] <- (dd[i + 1,j - 1] - dd[i,j - 1]) / (x[i + j - 1] - x[i])
            FinPara
        FinPara
        
        // Evaluar el polinomio de Newton en xEval
        resultado <- dd[1,1]
        producto <- 1.0
        
        Para i <- 2 Hasta n Hacer
            producto <- producto * (xEval - x[i - 1])
            resultado <- resultado + dd[1,i] * producto
        FinPara
        
        Escribir "Valor interpolado en x = ", xEval, " es: ", resultado
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/Interpolacion_Newton.java)

## Ejemplo de aplicación
Sabiendo que en ´1 hora´ la temperatura de un paciente es de ´36.5555°´, en ´2 horas´ aumento a ´37.2222°´ y finalmente a las ´4 horas´ se llego a ´38.1111°´. Calcular la temperatura en ´3 horas´.
- [Ejecución del código en Java](./src/Ejecucion.png)