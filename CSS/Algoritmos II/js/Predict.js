
//FUNCION 1

/*
Por favor, completa los siguientes códigos para que la función imprima (print) todos los enteros 
(integers) de 1 a x. Si x es negativo, haz que se muestre (print/log) 
“número negativo” y que la función devuelva falso.
*/
function printUpTo(x) {
    if (x < 0) {
      console.log("número negativo");
      return false;
    }  
    for (let i = 1; i <= x; i++) {
      console.log(i);
    }
   return true;
} 
printUpTo(1000); // debería imprimir todos los enteros de 1 a 1000
y = printUpTo(-10); // debería imprimir "número negativo" y devolver false
console.log(y); // debería imprimir false
  

//FUNCION 2
/*Completa el código de más abajo para que la función imprima enteros 
(integers) de 0 a x y donde cada entero imprima la suma (sum) parcial. 
Haz que la función entregue la suma final. 
*/
function printSum(x) {
    var sum = 0;
    
    for (var i = 0; i <= x; i++) {
      sum += i;
      console.log(i, sum);
    }
    
    return sum;
}
  
y = printSum(255); // debería imprimir todos los enteros de 0 a 255 y mostrar la suma parcial en cada iteración.
console.log(y); // debería imprimir 32640

//FUNCION 3
/* Completa el código a continuación para que la función entregue la suma 
 * de todos los valores en un array dado.
*/  

function printSumArray(x) {
    var sum = 0;
    for (var i = 0; i < x.length; i++) {
      sum += x[i];
    }   
    return sum;
}
  
console.log(printSumArray([1, 2, 3])); // debería imprimir 6

/* 
 * Bonus: LargestElement
    Crea una función que entregue el elemento más grande (largest element) en un array. 
    Por ejemplo largestElement([1,30,5,7]) debiera dar como resultado 30.
*/

function LargestElement(x){
    largest= 0;
    for (let i = 0; i < x.length; i++) {
        if(x[i]>largest){
            largest=x[i]
        }
    }
    return largest
}
console.log(LargestElement([1,30,5,7]))
