/*
1-Tamaño Grande - Dado un array, escribe una función que cambie todos los números positivos en él, 
    por el string “big”. Ejemplo: grande([-1,3,5,-5]) devuelve [-1, “big”, “big”, -5].
*/
function tamanno(arr1) {
    //Ejemplo 1 Usando un for simple
    /*
    for(i in arr1){ //USING FOR
        if(arr1[i]>0){
            arr1[i]="big"            
        }
    }
    return arr1;
     */

    //EJEMPLO 2 Realiza la funcion de devolver un nuevo array con una funcion anonima con el .map
    /*
        let arrfix = arr1.map(element => {
            if (element > 0) {
                return "big";
            } else {
                return element;
            }
        });
    return arrfix;
    */
    //EJEMPLO 3
    return arr1.map(element => element > 0 ? "big" : element); // Funcion anonima en el return
    //Si element es mayor que 0, el valor de retorno en true es "big", el valor en false es el elemento
}
console.log(tamanno([-1, 3, 5, -5]))
/*
2-Imprime (print) el menor, devuelve (return) el mayor - Crea una función que tome un array de 
    números. La función debería imprimir (print) el menor valor del array, y devolver (return) 
    el mayor. */
function imprimir1(arr1) {
    //EJEMPLO 1 Menos eficiente
    /*
    var miMin=arr1[i];
    var miMax=arr1[i];
    for(i in arr1){
        if(miMin>arr1[i]){
            miMin=arr1[i];
        }else if(miMax<arr1[i]){
            miMax=arr1[i];
        }
    }
    console.log("El numero mas pequeño es: ",miMin);
    return miMax;    
    */
    //Utilizo la libreria de Math, ya que esta incluye funciones inclinadas para obtener el min o el max
    //EJEMPLO 2    
    console.log("El numero mas pequeño es " + Math.min(...arr1));
    return Math.max(...arr1);
}
imprimir1([1, -2, 3]);
/*
3-Imprime (print) uno, devuelve (return) otro- Crea una función para un array de números. La 
    función debería imprimir (print) el penúltimo valor y devolver (return) el primer valor impar. */
function imprimir2(arr) {
    let penultimo = arr[arr.length - 2];
    console.log(penultimo)

    return arr.find(num => num % 2 != 0);
}
console.log(imprimir2([12, 4, 1, 2, 32]));
/*
4-Doble Visión - Dado un array, crea una función que devuelva un nuevo array donde cada valor 
    se duplique. Entonces, doble([1,2,3]) debiera devolver [2, 4, 6] sin cambiar el array original. */
function dobleVision(arra) {
    //ejemplo 1; 
    /*
    var newarray=[];
    for (let i=0 ;i<arra.length;i++){
        newarray.push(arra[i]*2);
    }
    return newarray 
    */
    //EJEMPLO 2 Eficiente;
    return arra.map(num => num * 2);
}
let arr = [1, 2, 3];
console.log("Array original: ", arr);
console.log("Array modificado: ", dobleVision(arr))
/*
5-Contar Positivos -  Dado un array de números, crea una función para reemplazar el 
    último valor con el número de valores positivos encontrados en el array. Ejemplo, 
    contarPositivos([-1,1,1,1]) cambia el array original y devuelve [-1,1,1,3].
*/
function contPoistiv(arr) {
    //EJEMPLO 1 MENOS EFICIENTE
    /*
    var cantpositive=0;
    for(let i in arr){
        if(arr[i]>0){
            cantpositive++;
        }
    }
    arr.pop();
    arr.push(cantpositive);
    return arr
    */
    //EJEMPLO 2 MAS EFICIENTE
    const cantPositive = arr.reduce((count, num) => {
        if (num > 0) {
            return count + 1;
        }
        return count;
    }, 0);

    arr[arr.length - 1] = cantPositive;
    return arr;
}
console.log(contPoistiv([-1, 1, 1, 1]));
/*
6-Pares e Impares - Crea una función que acepte un array. Cada vez que ese array tenga 3 valores 
    impares seguidos, imprime (print) “¡Qué imparcial!”, y cada vez que tenga 3 pares seguidos, 
    imprime (print) “¡Es para bien!”.
*/
function pareImpar(arr) {
    //EJEMPLO 1 INEFICIENTE:
    /* 
    let imparesSeguidos = 0;
    let paresSeguidos = 0;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] % 2 !== 0) {
            imparesSeguidos++;
            paresSeguidos = 0;

            if (imparesSeguidos === 3) {
                console.log("¡Qué imparcial!");
                imparesSeguidos = 0;
            }
        } else {
            paresSeguidos++;
            imparesSeguidos = 0;

            if (paresSeguidos === 3) {
                console.log("¡Es para bien!");
                paresSeguidos = 0;
            }
        }
    }

    if (imparesSeguidos < 3 && paresSeguidos < 3) {
        console.log("No se cumplieron las condiciones.");
    }
    */
    let i = 0;
    const length = arr.length;

    while (i < length - 2) {
        if (arr[i] % 2 === 0) {
            if (arr[i + 1] % 2 === 0 && arr[i + 2] % 2 === 0) {
                console.log("¡Es para bien!");
                break;
            } else {
                i++;
            }
        } else {
            if (arr[i + 1] % 2 !== 0 && arr[i + 2] % 2 !== 0) {
                console.log("¡Qué imparcial!");
                break;
            } else {
                i++;
            }
        }
    }

    if (i >= length - 2) {
        console.log("No se cumplieron las condiciones.");
    }

}
pareImpar([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
/*
7-Incrementa los Segundos - Dado un array de números llamado arr, suma 1 a los elementos, 
    específicamente a aquellos cuyo índice es impar (arr[1], arr[3], arr[5], etc). Luego, 
    imprime (console.log) cada valor del array y devuelve el arreglo arr. 
*/
function incSeg(arr) {
    //EJEMPLO 1
    /*
    for (let index = 0; index < arr.length; index++) {
        var element = arr[index];
        var aux = Number(element);
        if (aux % 2 !== 0) {
            if ((index + 1) % 2 === 1) {
                aux += 1;
            }
        }
        else {
            continue;
        }
        arr[index] = aux;
    }
    return arr;
    */
    //EJEMPLO 2 EFICIENTE
    for (let i = 1; i < arr.length; i += 2) {
        arr[i] += 1;
    }

    arr.forEach((num) => console.log(num));

    return arr;
}

const array = [1, 2, 3, 4, 5, 6, 7, 8, 9];
const resultado = incSeg(array);
console.log(resultado);
// 8-Longitudes previas
function longitudesPrevias(arr) {
    for (let i = arr.length - 1; i > 0; i--) {
        arr[i] = arr[i - 1].length;
    }
    return arr;
}

// Ejemplo de uso:
console.log(longitudesPrevias(["programar", "dojo", "genial"])); // Output: ["programar", 9, 4]

// 9-Agrega Siete
function agregaSiete(arr) {
    const newArr = [];
    for (let i = 0; i < arr.length; i++) {
        newArr.push(arr[i] + 7);
    }
    return newArr;
}

// Ejemplo de uso:
console.log(agregaSiete([1, 2, 3])); // Output: [8, 9, 10]

// 10-Array Inverso
function invertir(arr) {
    const length = arr.length;
    const middle = Math.floor(length / 2);
    for (let i = 0; i < middle; i++) {
        const temp = arr[i];
        arr[i] = arr[length - 1 - i];
        arr[length - 1 - i] = temp;
    }
    return arr;
}

// Ejemplo de uso:
console.log(invertir([3, 1, 6, 4, 2])); // Output: [2, 4, 6, 1, 3]

// 11-Perspectiva: Negativa
function perspectivaNegativa(arr) {
    const newArr = [];
    for (let i = 0; i < arr.length; i++) {
        newArr.push(-Math.abs(arr[i]));
    }
    return newArr;
}

// Ejemplo de uso:
console.log(perspectivaNegativa([1, -3, 5])); // Output: [-1, -3, -5]

// 12-Siempre hambriento
function siempreHambriento(arr) {
    let found = false;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === "comida") {
            console.log("yummy");
            found = true;
        }
    }
    if (!found) {
        console.log("tengo hambre");
    }
}

// Ejemplo de uso:
siempreHambriento(["pizza", "bebida", "fruta"]); // Output: yummy
siempreHambriento(["bebida", "fruta", "snacks"]); // Output: tengo hambre

// 13-Cambiar hacia el centro
function cambiaHaciaElCentro(arr) {
    const length = arr.length;
    const middle = Math.floor(length / 2);
    for (let i = 0; i < middle; i += 2) {
        const temp = arr[i];
        arr[i] = arr[length - 1 - i];
        arr[length - 1 - i] = temp;
    }
}

// Ejemplo de uso:
const array1 = [true, 42, "Ada", 2, "pizza"];
cambiaHaciaElCentro(array1);
console.log(array1); // Output: ["pizza", 42, "Ada", 2, true]

const array2 = [1, 2, 3, 4, 5, 6];
cambiaHaciaElCentro(array2);
console.log(array2); // Output: [6, 2, 4, 3, 5, 1]

// 14-Escala el Array
function escalaArray(arr, num) {
    for (let i = 0; i < arr.length; i++) {
        arr[i] *= num;
    }
    return arr;
}

// Ejemplo de uso:
console.log(escalaArray([1, 2, 3], 3)); // Output: [3, 6, 9]
