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
    /*
     * const sum: Declara una constante llamada sum para almacenar el resultado de la suma.
     * arr.reduce: Aplica el método reduce al array arr. El método reduce se utiliza para reducir los elementos de un array a un solo valor.
     * (acc, num) => acc + num: Es una función de flecha (arrow function) que se utiliza como argumento para el método reduce. Toma dos parámetros: acc (acumulador) y num (el elemento actual del array). En cada iteración, esta función suma el valor del acumulador acc con el elemento num.
     * , 0: Es el segundo argumento pasado al método reduce y se utiliza como valor inicial para el acumulador. En este caso, se establece en 0.
     * El resultado final es el valor de la suma de todos los elementos del array arr, que se almacena en la constante sum.
     * En resumen, la línea de código utiliza el método reduce para sumar todos los valores del array arr.
     * La función de flecha especificada como argumento define la operación de suma, utilizando un acumulador que se inicializa en 0. El resultado se almacena en la constante sum.
     */
    const sum = arr.reduce((acc, num) => acc + num, 0); // Utiliza el método reduce() para sumar todos los valores del array. El acumulador (acc) va almacenando la suma acumulada y se inicializa en 0. Se utiliza una función de flecha (arrow function) para definir la operación de suma.
    const average = sum / arr.length;
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
    /**
     * MAP: para iterar a través de los elementos dentro de una colección de arreglos en JavaScript.
     * 
     * const newArray: Declara una nueva constante llamada newArray para almacenar el resultado de la operación map.
     * arr1.map: Aplica el método map al array arr1. El método map se utiliza para crear un nuevo array con los resultados de aplicar una función a cada elemento del array original.
     * (num) => (num < 0 ? "Dojo" : num): Es una función de flecha (arrow function) que se utiliza como argumento para el método map. Toma un parámetro num, que representa cada elemento del array arr1. En cada iteración, esta función verifica si el número num es menor que 0. Si es así, devuelve la cadena de texto "Dojo". Si no, devuelve el número num sin modificar.
     * El resultado final es un nuevo array llamado newArray, donde cada elemento es el resultado de aplicar la función definida en el paso anterior a los elementos correspondientes del array arr1.
     */
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