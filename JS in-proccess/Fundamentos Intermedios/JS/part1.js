/*
Sigma - Implementa una función sigma(num) que, dado un número, devuelve la suma de todos 
los enteros positivos (incluyendo el número dado). Ej: sigma(3) = 6 (1+2+3); sigma(5) = 15 
(1+2+3+4+5).
*/
function sigma(num) {
    var suma = 0;
    for (let i = 1; i <= num; i++) {
        suma += i;
    }
    return suma;
}
let a = sigma(3);
console.log(a)
let b = sigma(5);
console.log(b)

/*
Factorial - Escribe una función factorial(num) que, dado un número, devuelva el producto 
(multiplicación) de todos los enteros positivos (incluyendo el número dado). Por ejemplo: 
factorial(3) = 6 (1*2*3); factorial(5) = 120 (1*2*3*4*5).
*/

function factorial(num) {
    let producto = 1;
    for (let i = 1; i <= num; i++) {
        producto *= i; //TUVE UN ERROR el cual era producto *= num
    }
    return producto;
}
let c = factorial(3);
console.log(c); // Output: 6
let d = factorial(5);
console.log(d); // Output: 120

/*
Fibonacci - Crea una función para generar números de Fibonacci. En esta famosa secuencia matemática, cada número es 
la suma de las dos anteriores, partiendo con los valores 0 y 1. Tu función debería aceptar un argumento, un índice en 
la secuencia (donde 0 corresponde al valor inicial, 4 corresponden al valor cuatro más tarde, etc). Ejemplos: fibonacci(0) 
= 0 (dado), fibonacci(1) = 1 (dado), fibonacci(2) = 1 (fib(0)+fib(1), o 0+1), fibonacci(3) = 2 (fib(1) + fib(2)3, o 1+1), 
fibonacci(4) = 3 (1+2), fibonacci(5) = 5 (2+3), fibonacci(6) = 8 (3+5), fibonacci(7) = 13 (5+8). Haz esto primero sin usar
recursión. Si no sabes qué es una recursión, no te preocupes puesto que vamos a introducir este concepto en la Parte 2 de 
esta actividad.
*/
function fibonacci(num) {
    if (num === 0) {
        return 0;
    }
    let num1 = 0;
    let num2 = 1;
    let fibnum = 1;
    for (let i = 2; i <= num; i++) {
        fibnum = num1 + num2;
        num1 = num2;
        num2 = fibnum;
    }
    return fibnum;
}
let fibo1 = fibonacci(0);
console.log(fibo1); // Output: 0
let fibo2 = fibonacci(1);
console.log(fibo2); // Output: 1
let fibo3 = fibonacci(2);
console.log(fibo3); // Output: 1
let fibo4 = fibonacci(3);
console.log(fibo4); // Output: 2
let fibo5 = fibonacci(4);
console.log(fibo5); // Output: 3
let fibo6 = fibonacci(5);
console.log(fibo6); // Output: 5
let fibo7 = fibonacci(6);
console.log(fibo7); // Output: 8
let fibo8 = fibonacci(7);
console.log(fibo8); // Output: 13
/*
Array: Penúltimo: Devuelve el penúltimo elemento del array. 
Dado [42,true,4,”Liam”, 7] devuelve “Liam”. Si el array es muy pequeño, 
devuelve null.  
*/
function penultimo(arr) {
    var penultimo = null;
    if (arr.length < 4) {
        return penultimo;
    }
    return penultimo = arr[arr.length - 2];

}

let e = penultimo([42, true, 5, "Liam", 7]) //ERROR ANTERIOR; let e= penultimo(42, true,5,"Liam",7)
console.log(e)
/*
Array: “N” último: Devuelve el elemento “N” último. Dado ([5,2,3,6,4,9,7],3], 
devuelve 6. Si el array es muy pequeño, devuelve null. 
*/
function nultimo(arr, max) {
    if (arr.length < max) {
        return null;
    }

    // return arr[arr.length - max];//MENOS EFICIENTE
    return arr.slice(max)[0];//MAS EFICIENTE //
}
let f = [5, 2, 3, 6, 4, 9, 7];
let fmax = 3;
console.log(nultimo(f, fmax));
/*
Array: Segundo más grande: Devuelve el segundo elemento más grande de un array. 
Dado [42,1,4,3.14,7], devuelve 7.  Si el array es muy pequeño, devuelve null.
*/
function secBigger(arr) {
    // Verificar si el array es demasiado pequeño
    if (arr.length < 2) {
        return null;
    }

    // Inicializar las variables para el número más grande y el segundo más grande
    let biggest = Math.max(arr[0], arr[1]); // Mayor número encontrado hasta ahora
    let secondBiggest = Math.min(arr[0], arr[1]); // Segundo mayor número encontrado hasta ahora

    // Recorrer el array desde el tercer elemento
    for (let i = 2; i < arr.length; i++) {
        // Si el elemento actual es mayor que el mayor número encontrado,
        // actualizar el segundo mayor y el mayor número
        if (arr[i] > biggest) {
            secondBiggest = biggest;
            biggest = arr[i];
        } else if (arr[i] > secondBiggest) {
            // Si el elemento actual es mayor que el segundo mayor,
            // actualizar el segundo mayor
            secondBiggest = arr[i];
        }
    }

    // Retornar el segundo número más grande encontrado
    return secondBiggest;
}
let g = [42, 1, 4, 3.14, 7];
let gresultado = secBigger(g);
console.log(gresultado); // Imprime 7

/*
Doble Problema Par: Crea una función que cambie un array dado duplicando cada uno de sus elementos y 
manteniendo el orden original. Convierte [4, "Ulysses", 42, false]   a    
[4,4, "Ulysses", "Ulysses", 42, 42, false, false].
*/
function dobleProblemaPar(arr){
    let newarr=[];
    for(let i in arr){
        newarr.push(arr[i], arr[i]);
    }
    return newarr
}
let h =[4, "Ulysses", 42, false];
let hresultado= dobleProblemaPar(h);
console.log(hresultado);