// Función para transformar los valores negativos en 0
function resetNegativos(arr) {
    /**
     * Transforma los valores negativos en 0 en el array dado.
     *
     * @param {Array} arr - El array original con valores numéricos.
     * @returns {Array} - Un nuevo array con los valores negativos reemplazados por 0.
    */
    return arr.map(num => num < 0 ? 0 : num);
}

// Ejemplo de uso
const arr1 = [1, 2, -1, -3];
const result1 = resetNegativos(arr1);
console.log(result1); // [1, 2, 0, 0]



// Función para mover los valores un espacio hacia la izquierda
function moverAdelante(arr) {
    /**
     * Mueve todos los valores un espacio hacia la izquierda en el array dado,
     * eliminando el primer valor y dejando un 0 como último valor.
     *
     * @param {Array} arr - El array original.
     * @returns {Array} - El mismo array modificado con los valores movidos hacia la izquierda y un 0 como último valor.
    */
    arr.shift();
    arr.push(0);
    return arr;
}

// Ejemplo de uso
const arr2 = [1, 2, 3];
const result2 = moverAdelante(arr2);
console.log(result2); // [2, 3, 0]


// Función para retornar el array en orden inverso
function returnReverso(arr) {
    /**
     * Retorna un nuevo array con los valores en orden inverso.
     *
     * @param {Array} arr - El array original.
     * @returns {Array} - Un nuevo array con los valores en orden inverso.
    */
    return arr.reverse();
}

// Ejemplo de uso
const arr3 = [1, 2, 3];
const result3 = returnReverso(arr3);
console.log(result3); // [3, 2, 1]



// Función para repetir los valores del array
function repetirValores(arr) {
    /**
     * Crea un nuevo array repitiendo los valores originales del array dado,
     * manteniendo el mismo orden.
     *
     * @param {Array} arr - El array original.
     * @returns {Array} - Un nuevo array con los valores repetidos, manteniendo el mismo orden.
    */
    return arr.flatMap(value => [value, value]);
}

// Ejemplo de uso
const arr4 = [4, "Ulysses", 42, false];
const result4 = repetirValores(arr4);
console.log(result4); // [4, 4, "Ulysses", "Ulysses", 42, 42, false, false]
