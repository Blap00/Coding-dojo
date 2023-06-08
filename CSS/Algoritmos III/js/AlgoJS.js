//FUNCION 1
function a(x,y){ //FUNCTION NOMBRE ARCHIVO(PARAMS)
    return 5; //RETURN JUST 5
}
console.log(a(5,5)) //Console.log(function(5,5))

//FUNCION 2
function a(x,y){ //FUNCTION NOMBRE ARCHIVO(PARAMS)
    z = []  //Z=[]
    z.push(x); //Z=[2]
    z.push(y); //Z=[2,2]
    z.push(5); //Z=[2,2,5]
    console.log(z);//[2,2,5]
    return z; //return[2,2,5]
}
b = a(2,2) //[2,2,5]
console.log(b); //[2,2,5]
console.log(a(6,8)); //[6,8,5]

//FUNCION 3
function a(x){ //FUNCTION NOMBRE ARCHIVO(PARAMS)
    z = []; //z=[]
    z.push(x);//z=[2]
    z.pop();//z=[]
    z.push(x);//z=[2]
    z.push(x);//z=[2,2]
    return z;//return [2,2]
}
y = a(2); //y= [2,2]
y.push(5);//y= [2,2,5]
console.log(y);//[2,2,5]

//FUNCION 4
function a(x){ //FUNCTION NOMBRE ARCHIVO(PARAMS)
    if(x[0] < x[1]) { //SI 2 < 3
       return true; //TRUE B=TRUE
    }
    else {
       return false; //FALSE
    }
 }
 b = a([2,3,4,5]) //B=TRUE
 console.log(b);//TRUE

//FUNCION 5
function a(x){ //X=[1,2,3,4]
    for(var i=0; i<x.length; i++){ //X.LENGTH = 4
        if(x[i] > 0){ 
            x[i] = "Coding"; //X=['CODING','CODING','CODING','CODING']
        }
    }
    return x;//['CODING','CODING','CODING','CODING',]
}
console.log(a([1,2,3,4]))//['CODING','CODING','CODING','CODING',]

//FUNCION 6
function a(x){ //X=[5,7,-1,4]
    for(var i=0; i<x.length; i++){
        if(x[i] > 5){ //MIENTRAS QUE X[I] SEA MAYOR QUE 5
            x[i] = "Coding"; //[5, 'coding', -1, 4]
        }
        else if(x[i] < 0){
            x[i] = "Dojo";//[5, 'coding', 'Dojo', 4]
        }
    }
    return x;
}
console.log(a([5,7,-1,4])) //[5, 'coding', 'Dojo', 4]

//FUNCION 7
function a(x){ //X=[5,10]
    if(x[0] > x[1]) { // 5 > 10 //NO
        return x[1]; //10
    }
    return 10; //RETURN 10
}
b = a([5,10]) // B= 10
Console.log(b); //10

//FUNCION 8
function sum(x){ // [..., ..., ...]
    sum = 0;
    for(var i=0; i<x.length; i++){ //X.LENGTH = [...,...,...]
       sum = sum + x[i]; //0 + X[I] SEGUIDAMENTE
       console.log(sum); //IMPRIMER EL VALOR ACTUAL DE SUM
    }
    return sum;//RETORNA SUM
}

//PARTE 2

//FUNCION 9
function printAverage(x) { //consigue un ARRAY
    var sum = 0;//SUMA 0
    for (var i = 0; i < x.length; i++) {
        sum += x[i]; //Cada suma se actualiza a si misma
    }
    const average = sum / x.length; //Obtiene un promedio
    return average; //RETORNA VALOR
}

var y = printAverage([1, 2, 3]);
console.log(y); // debería mostrar 2

y = printAverage([2, 5, 8]);
console.log(y); // debería mostrar 5

//FUNCION 10
function returnOddArray() {
    var oddArray = [];  // Creamos un array vacío llamado oddArray para almacenar los números impares
    for (let i = 1; i <= 255; i += 2) {
        // Iteramos desde el número 1 hasta el número 255 incrementando en 2 en cada iteración
        // de esta forma solo obtenemos los números impares
        oddArray.push(i);  // Agregamos el número impar al array oddArray utilizando el método push()
    }
    return oddArray;  // Devolvemos el array oddArray como resultado
}

var y = returnOddArray();  // Llamamos a la función returnOddArray y almacenamos el resultado en la variable y
console.log(y);  // Imprimimos en la consola el contenido de la variable y, que debería ser [1, 3, 5, ..., 253, 255]

//FUNCION 11
function squareValue(x) {
    // Iterar sobre cada elemento del array
    for (let i = 0; i < x.length; i++) {
        // Calcular el cuadrado del elemento actual y guardar en la misma posición del array
        x[i] = x[i] * x[i];
    }
    // Devolver el array modificado
    return x;
}

// Ejemplo de uso de la función squareValue
let y = squareValue([1, 2, 3]);
console.log(y); // debería mostrar [1, 4, 9]

y = squareValue([2, 5, 8]);
console.log(y); // debería mostrar [4, 25, 64] 