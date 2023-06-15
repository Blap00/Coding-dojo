// Función para generar un arreglo aleatorio de 10 números entre 1 y 20
function generarArregloAleatorio() {
    var arregloAleatorio = [];
    for (var i = 0; i < 10; i++) {
        var numeroAleatorio = Math.floor(Math.random() * 20) + 1;
        if(!arregloAleatorio.includes(numeroAleatorio)){
            arregloAleatorio.push(numeroAleatorio);
        }
        else{
            i--;
        }
    }
    return arregloAleatorio;
}

// Función para comparar dos arreglos y contar las coincidencias
function compararArreglos(arr1, arr2) {
    let coincidencias = arr1.filter(arrayinicial => arr2.includes(arrayinicial)) //los genera como array, si un numero repite lo imprime
    // var coincidencia = 0;
    // for (var i = 0; i < arr1.length; i++) {
    //     if(arr1.includes(arr2[i])){
    //         coincidencia++;   
    //     }
    // }
    // console.log(coincidencia);
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
var numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
compararNumeros(numeros);

