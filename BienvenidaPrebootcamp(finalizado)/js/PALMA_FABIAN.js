console.log("PALMA_FABIAN.JS");
//FUNCION NUMERO 1
function myBirthYearFunc(){
    console.log("Nací en " + 1980); //NACI EN 1980
}
myBirthYearFunc();
//FUNCION NUMERO 2
function myBirthYearFunc1(EntradaAñoNacimiento){
    console.log("Nací en " + EntradaAñoNacimiento); //NACI EN (EntradaAñoNacimiento)
}
myBirthYearFunc1(1980); //(EntradaAñoNacimiento==1980)
//FUNCION NUMERO 3
function add(num1, num2){
    console.log("¡Sumando números!");   
    console.log("num1 is: " + num1);//num1 is 10
    console.log("num2 is: " + num2);//num2 is 20
    var sum = num1 + num2;//10+20
    console.log(sum);//30
}
add(10,20); //num1==10, num2==20.
console.log("");
var showCodeButton = document.getElementById("showCodeButton");
var jsCode = `console.log("PALMA_FABIAN.JS");
//FUNCION NUMERO 1
function myBirthYearFunc(){
    console.log("Nací en " + 1980); //NACI EN 1980
}
myBirthYearFunc();
//FUNCION NUMERO 2
function myBirthYearFunc1(EntradaAñoNacimiento){
    console.log("Nací en " + EntradaAñoNacimiento); //NACI EN (EntradaAñoNacimiento)
}
myBirthYearFunc1(1980); //(EntradaAñoNacimiento==1980)
//FUNCION NUMERO 3
function add(num1, num2){
    console.log("¡Sumando números!");   
    console.log("num1 is: " + num1); //num1 is 10
    console.log("num2 is: " + num2); //num2 is 20
    var sum = num1 + num2; //10+20
    console.log(sum); //30
}
add(10,20); //num1==10, num2==20. 
console.log(""); //FALTA SETEAR LOS BR CORRECTAMENTE!, revisar PALMA_FABIAN.js`



const formattedjsCode = jsCode.replace(/[&<>"']/g, function(match) {
    return {
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        '"': '&quot;',
        "'": '&#39;'
    }[match];
});

