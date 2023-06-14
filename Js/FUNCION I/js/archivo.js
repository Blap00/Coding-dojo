// Función para generar un arreglo aleatorio de 10 números entre 1 y 20
function generarArregloAleatorio() {
    var arregloAleatorio = [];
    for (var i = 0; i < 10; i++) {
      var numeroAleatorio = Math.floor(Math.random() * 20) + 1;
      arregloAleatorio.push(numeroAleatorio);
    }
    return arregloAleatorio;
  }
  
  // Función para comparar dos arreglos y contar las coincidencias
  function compararArreglos(arr1, arr2) {
    var coincidencias = 0;
    for (var i = 0; i < 10; i++) {
      if (arr1[i] === arr2[i]) {
        coincidencias++;
      }
    }
    return coincidencias;
  }
  
  // Función principal para comparar los números
  function compararNumeros(numeros) {
    // Generar un arreglo aleatorio
    var arregloAleatorio = generarArregloAleatorio();
  
    // Mostrar ambos arreglos por consola
    console.log("Arreglo ingresado:", numeros);
    console.log("Arreglo aleatorio:", arregloAleatorio);
  
    // Contar las coincidencias entre los arreglos
    var cantidadCoincidencias = compararArreglos(numeros, arregloAleatorio);
  
    // Mostrar la cantidad de coincidencias por consola
    console.log("Coincidencias encontradas:", cantidadCoincidencias);
  }
  
  // Ejemplo de uso de la función compararNumeros con un arreglo de 10 números
  var numeros = [3, 8, 15, 7, 12, 5, 18, 10, 1, 6];
  compararNumeros(numeros);
/**
 * Función a()
           Diagrama T
        ---------------
Parámetros:  |  Ninguno
        ---------------
Valor de retorno:  | 35
        ---------------
Salida:  | 35
        ---------------
Función a()



           Diagrama T
        ---------------
Parámetros:  |  Ninguno
        ---------------
Valor de retorno:  | 4
        ---------------
Salida:  | 8
        ---------------
Función a(b)



           Diagrama T
        ---------------
Parámetros:  |  b: 2
        ---------------
Valor de retorno:  | 2 + 4 = 6
        ---------------
Salida:  | 6
        ---------------
Función a(b)



           Diagrama T
        ---------------
Parámetros:  |  b: 3
        ---------------
Valor de retorno:  | 3 * 3 = 9
        ---------------
Salida:  | 3
        ---------------
Función a(b)



           Diagrama T
        ---------------
Parámetros:  |  b: 10
        ---------------
Valor de retorno:  | 10 * 4 = 40
        ---------------
Salida:  | 40
        ---------------
Función a(b)



           Diagrama T
        ---------------
Parámetros:  |  b: 15
        ---------------
Valor de retorno:  | 4
        ---------------
Salida:  | 4
        ---------------
Función a(b, c)



           Diagrama T
        ---------------
Parámetros:  |  b: 3
             |  c: 10
        ---------------
Valor de retorno:  | 3 * 10 = 30
        ---------------
Salida:  | 10, 3, 30
        ---------------
Función a()



           Diagrama T
        ---------------
Parámetros:  |  Ninguno
        ---------------
Valor de retorno:  | 10
        ---------------
Salida:  | 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4
        ---------------
Función a(b, c)


           Diagrama T
        ---------------
Parámetros:  |  b: 0
             |  c: 10
        ---------------
Valor de retorno:  | 0
        ---------------
Salida:  | 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0
        ---------------
Función a()


        Diagrama T
        ---------------
Parámetros:  |  Ninguno
        ---------------
Valor de retorno:  | Ninguno (ningún return)
        ---------------
Salida:  | 0-9 (repetido 10 veces), 0-9
        ---------------


        Diagrama T
        ---------------
Parámetros:  |  Ninguno
        ---------------
Valor de retorno:  | Ninguno (ningún return)
        ---------------
Salida:  | 0-9 (repetido 10 veces), 9-0
        ---------------


        Diagrama T
        ---------------
Valor de z:  | 10
        ---------------
Salida:  | 10
        ---------------

        Diagrama T
        ---------------
Valor de z:  | 10
        ---------------
Salida:  | 15
        ---------------

           Diagrama T
        ---------------
Valor de z:  | 15
        ---------------
Salida:  | 15
        ---------------
Espero que esto aclare el comportamiento de cada función en el código.





 * 
 * 
 * 
*/  