function a(){
    return 35;
}
console.log(a())

function a(){
    return 4;
}
console.log(a()+a());

function a(b){
    return b;
}
console.log(a(2)+a(4));

function a(b){
    console.log(b);
return b*3;
}
console.log(a(3));
    
function a(b){
    return b*4;
    console.log(b);
}
console.log(a(10));
 
function a(b){
    if(b<10) {
        return 2;
    }
    else{
        return 4;
    }
    console.log(b);
}
console.log(a(15));

function a(b,c){
    return b*c;
}
console.log(10,3);
console.log( a(3,10) );

function a(b){
    for(var i=0; i<10; i++){
        console.log(i);
    }
    return i;
}
console.log(3);
console.log(4);

function a(){
    for(var i=0; i<10; i++){
        i = i +2;
        console.log(i);
    }
}
a();

function a(b,c){
    for(var i=b; i<c; i++) {
       console.log(i);
   }
   return b*c;
}
a(0,10);
console.log(a(0,10));

function a(){
    for(var i=0; i<10; i++){
        for(var j=0; j<10; j++){
           console.log(j);
        }
        console.log(i);
    }
}

function a(){
    for(var i=0; i<10; i++){
        for(var j=0; j<10; j++){
            console.log(i,j);
        }
        console.log(j,i);
    }
}

var z = 10;
function a(){
    var z = 15;
    console.log(z);
}
console.log(z);

var z = 10;
function a(){
    var z = 15;
    console.log(z);
}
a();
console.log(z);

var z = 10;
function a(){
    var z = 15;
    console.log(z);
    return z;
}
z = a();
console.log(z);

/**
 * 
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
