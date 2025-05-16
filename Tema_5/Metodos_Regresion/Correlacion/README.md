# Tema 5: Método de regresión de Correlación

## Descripción del método

La correlación evalúa qué tan fuerte y en qué dirección están relacionadas dos variables. Es un paso preliminar importante antes de aplicar cualquier modelo de regresión, ya que permite verificar si tiene sentido suponer que una variable depende de otra.

## Formula del método
    r = (NΣ xy - (Σx)(Σy)) / √[NΣ x^2-(Σx)^2] * √[NΣ y^2-(Σy)^2]

## Pseudocódigo

    Proceso Correlacion	
        Definir n, i Como Entero
        Definir xi, yi Como Real
        Definir sumaX, sumaY, sumaXY, sumaX2, sumaY2 Como Real
        Definir coefPendiente, coefIntercepto, r Como Real
        
        sumaX <- 0
        sumaY <- 0
        sumaXY <- 0
        sumaX2 <- 0
        sumaY2 <- 0
        
        Escribir "Ingrese el número de datos:"
        Leer n
        
        Dimension datosX[n]
        Dimension datosY[n]
        
        Para i <- 1 Hasta n Hacer
            Escribir "Dato ", i
            
            Escribir "Ingrese X[", i, "]:"
            Leer xi
            Escribir "Ingrese Y[", i, "]:"
            Leer yi
            
            datosX[i] <- xi
            datosY[i] <- yi
            
            sumaX <- sumaX + xi
            sumaY <- sumaY + yi
            sumaXY <- sumaXY + xi * yi
            sumaX2 <- sumaX2 + xi^2
            sumaY2 <- sumaY2 + yi^2
        FinPara
        
        coefPendiente <- (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX^2)
        coefIntercepto <- (sumaY - coefPendiente * sumaX) / n
        
        r <- (n * sumaXY - sumaX * sumaY) / RAIZ((n * sumaX2 - sumaX^2) * (n * sumaY2 - sumaY^2))
        
        Escribir "-----------------------------------------"
        Escribir "Ecuación de regresión: Y = ", coefIntercepto, " + ", coefPendiente, " * X"
        Escribir "Coeficiente de correlación r = ", r
        
        Escribir "Interpretación:"
        Si r > 0 Entonces
            Escribir "Relación positiva."
        Sino
            Si r < 0 Entonces
                Escribir "Relación negativa."
            Sino
                Escribir "La correlación es nula."
            FinSi
        FinSi
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/Correlacion.java)

## Ejemplo de aplicación
Un restaurante analiza cómo afecta la temperatura exterior a las ventas de sopa caliente.
| Temperatura  | Ventas |
|--------------|--------|
|      30      |   50   |
|      28      |   60   |
|      26      |   70   |
|      24      |   85   |
|      22      |   95   |

- [Ejecución del código en Java](./src/Ejecucion.png)

- **Resultado:** El valor obtenido, -0.99 es muy cercano a -1, lo cual indica una correlación negativa muy fuerte. Es decir, existe una relación lineal casi perfecta inversa entre las variables: cuando **X** aumenta, **Y** tiende a disminuir proporcionalmente.