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

