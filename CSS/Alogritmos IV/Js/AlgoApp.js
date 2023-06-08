//Dados un array y un valor Y, cuenta e imprime (print) el número de valores del array que sean mayores que Y.
console.log("EJERCICIO 1");

function contarMayores(array, Y) {
    let contador = 0;
    for (let i = 0; i < array.length; i++) {
        if (array[i] > Y) {
            contador++;
        }
    }
    console.log("Cantidad de valores que son mayores que Y:", contador);
}

// Ejemplo de la funcion:
const array = [1, 3, 5, 7, 9];
const Y = 4;
contarMayores(array, Y);

console.log("EJERCICIO 2");
//Dado un array, imprime los valores máximos (max), mínimos (min) y promedio (average) para el array. 
function calcularEstadisticas(arr) {
    const maximum = Math.max(...arr); // Obtiene el valor máximo del array utilizando la función Math.max(). El operador spread (...) se utiliza para expandir los elementos del array como argumentos individuales.
    const minimum = Math.min(...arr); // Obtiene el valor mínimo del array utilizando la función Math.min(). Al igual que en el caso anterior, el operador spread (...) se utiliza para expandir los elementos del array.
    const sum = arr.reduce((acc, num) => acc + num, 0); // Utiliza el método reduce() para sumar todos los valores del array. El acumulador (acc) va almacenando la suma acumulada y se inicializa en 0. Se utiliza una función de flecha (arrow function) para definir la operación de suma.
    const average = sum / arr.length; // Calcula el promedio dividiendo la suma total entre la longitud del array.
    console.log("Máximo:", maximum); // Imprime el valor máximo.
    console.log("Mínimo:", minimum); // Imprime el valor mínimo.
    console.log("Promedio:", average); // Imprime el promedio.
}

// Ejemplo de la funcion:
const arr = [10, 5, 7, 3, 9];
calcularEstadisticas(arr);

console.log("EJERCICIO 3");
//Dado un array de números, crea una función que dé como resultado un nuevo array donde los valores negativos se reemplacen por el texto (string) ‘Dojo’. Por ejemplo, reemplazarNegativos([1,2,-3,-5,5]) debiera devolver [1,2, “Dojo”, “Dojo”, 5].
function reemplazarNegativos(arr1) {
    // Utiliza el método map() para crear un nuevo array basado en el array original
    const newArray = arr1.map((num) => (num < 0 ? "Dojo" : num));
    // Si el número es negativo, se reemplaza por el string "Dojo", de lo contrario se mantiene el número original
    return newArray; // Retorna el nuevo array
}

// Ejemplo de esta funcion:
const arr1 = [1, 2, -3, -5, 5];
const newArray = reemplazarNegativos(arr1); // Llama a la función reemplazarNegativos y pasa el array como argumento
console.log(newArray); // Imprime el nuevo array en la consola

console.log("EJERCICIO 4")
//Dado un array y su respectivo índice, remueve los valores en el rango del índice dado( acortando el array). Por ejemplo, removerRango([20,30,40,50,60,70],2,4)debiera devolver [20,30,70].
function removerRango(arr, inicio, fin) {
    // Filtra los valores del array que se encuentren fuera del rango dado por los índices inicio y fin
    // Utilizamos el método `filter` para recorrer cada elemento del array y mantener solo aquellos cuyos índices cumplan la condición
    const nuevoArray = arr.filter((valor, indice) => indice < inicio || indice > fin);

    // Devuelve el nuevo array resultante
    return nuevoArray;
}

// Ejemplo de uso:
const arr2 = [20, 30, 40, 50, 60, 70];
const nuevoArray = removerRango(arr2, 2, 4);
console.log(nuevoArray);