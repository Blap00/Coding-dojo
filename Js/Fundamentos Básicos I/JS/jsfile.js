// Obtén del 1 al 255
function obtenerDel1Al255() {
    var arr = [];
    for (var i = 1; i <= 255; i++) {
        arr.push(i);
    }
    return arr;
}

// Consigue pares hasta 1000
function sumaParesHasta1000() {
    var suma = 0;
    for (var i = 1; i <= 1000; i++) {
        if (i % 2 === 0) {
            suma += i;
        }
    }
    return suma;
}

// Suma impares hasta 5000
function sumaImparesHasta5000() {
    var suma = 0;
    for (var i = 1; i <= 5000; i++) {
        if (i % 2 !== 0) {
            suma += i;
        }
    }
    return suma;
}

// Itera un array
function sumaArray(arr) {
    var suma = 0;
    for (var i = 0; i < arr.length; i++) {
        suma += arr[i];
    }
    return suma;
}

// Encuentra el mayor (max)
function encontrarMayor(arr) {
    var max = arr[0];
    for (var i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

// Encuentra el promedio (avg)
function calcularPromedio(arr) {
    var suma = 0;
    for (var i = 0; i < arr.length; i++) {
        suma += arr[i];
    }
    var promedio = suma / arr.length;
    return promedio;
}

// Array de impares
function obtenerImparesHasta50() {
    var impares = [];
    for (var i = 1; i <= 50; i++) {
        if (i % 2 !== 0) {
            impares.push(i);
        }
    }
    return impares;
}

// Mayor que Y
function contarMayoresQueY(arr, Y) {
    var count = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > Y) {
            count++;
        }
    }
    return count;
}

// Cuadrados
function cuadrados(arr) {
    for (var i = 0; i < arr.length; i++) {
        arr[i] = arr[i] * arr[i];
    }
    return arr;
}

// Negativos
function reemplazarNegativosPorCero(arr) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            arr[i] = 0;
        }
    }
    return arr;
}

// Max/Min/Avg
function maxMinAvg(arr) {
    var max = arr[0];
    var min = arr[0];
    var suma = arr[0];

    for (var i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
        if (arr[i] < min) {
            min = arr[i];
        }
        suma += arr[i];
    }

    var promedio = suma / arr.length;

    return [max, min, promedio];
}

// Intercambia Valores
function intercambiarValores(arr) {
    var temp = arr[0];
    arr[0] = arr[arr.length - 1];
    arr[arr.length - 1] = temp;
    return arr;
}

// De Número a String
function convertirNegativosADojo(arr) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            arr[i] = "Dojo";
        }
    }
    return arr;
}
