console.log("RETURN.JS");
/*
Instrucciones:
• Para cada fragmento de código, crea un diagrama T.
• Crea un solo documento de texto o fotografía de tus diagramas T que contengan los 10 
diagramas T para los fragmentos de código a continuación y envíalo
*/ 
//FUNCTION 1
function hello() {
    console.log('hello');   //PRINT 'hello'
}
hello(); //call HELLO
console.log('Dojo'); //Print 'Dojo'
//FUNCTION 2
function hello1() { //ERROR, It was named hello, I modified to hello1
    console.log('hello'); //print 'hello'
    return 15; //'15'
}
var result = hello1(); //result= 15
console.log('result is', result); //It will print 'hello' and 'result is 15'
//FUNCTION 3
function numPlus(num) { // function NameFunction(parameter)
    console.log('num is', num); // print 'num is (parameter)'
    return num+15; // (parameter)+15
   }
var result = numPlus(3); //result = 3+15 = 18, it will print 'num is 3'
console.log('result is', result); // It will print 'result is 18'
//FUNCTION 4
var num = 15;
console.log(num); //It will print '15'
function logAndReturn(num2){
    console.log(num2); //it will print (parameter), in this case it will print 10
    return num2; // It will return (parameter), in this case, it will return the parameter or 10
}
var result = logAndReturn(10); //result = 10
console.log(result); //print '10'
console.log(num); //print '15'
//FUNCTION 5
var num = 15; //num == 15
console.log(num); //it will print 15
function timesTwo(num2){
 console.log(num2); //It will print parameter, in this case '10'
 return num2*2;     //It will return parameter * 2, in this case, it will return 10*2=20
}
var result = timesTwo(10); // Result = 20
console.log(result); //It will print 20
console.log(num); // It will print 15

//FUNCTION 6
function timesTwoAgain(num) {
    console.log('num is', num); // it will print 'num is (parameter)' , in case 1 it will print 'num is 3', in case 2 it will 
                                //  print 'num is 5'
    var y = num*2; // It will declare y = (parameter)*2. in case 1 it will declare '6', in case 2 it will declare '10'
    return y; //return the var y, in case 1, return 6. in case 2, return 10.
   }
var result = /*CASE 1*/timesTwoAgain(3) + /*CASE 2*/timesTwoAgain(5); //result = 6+10 = 16 
console.log('result is', result); //print 'result is 16'

//Function 7
function sumNums(num1, num2) {  //declare function sumNums with parameters: num1 and num2, in case 1, they are num1=2, num2=3. 
                                //in case 2 they are, num1=3, num2=5, 
    return num1+num2; //in case 1 it will return 2+3=5, in case 2 it will return 3+5=8.
}
console.log(sumNums(2,3))//print 5
console.log(sumNums(3,5))//print 8

//FUNCTION 8
function printSumNums(num1, num2) {//declare functionprintsumnums with parameters num1 and num2, in case 1 num1=2; num2=3, 
                            //  in case 2 num1=3; num2=5;
    console.log(num1); //it will print just num1 in both cases, in case 1 it will print '2'. in case 2 it will print='3'
    return num1+num2; //in case 1 it will return 5, in case 2 it will return 8
}
console.log(printSumNums(2,3)) //print '2'/n'5'
console.log(printSumNums(3,5)) //print '3'/n'8'

//FUNCTION 9
function sumNums(num1, num2) {//in case 1; num1=2, num2=3. in case 2; num1=3, num2=5
    var sum = num1 + num2; //in case 1: sum= 2+3 = 5. in case 2: sum=3+5= 8 
    console.log('sum is', sum);//in case 1 print 'sum is 5', in case 2 print 'sum is 8'
    return sum; //in case 1 return 5, in case 2 return 8
}
var result = sumNums(2,3) + sumNums(3,5); //result = 5 + 8 = 13
console.log('result is', result); // print 'result is 13' 

//FUNCTION 10
function sumNums(num1, num2) { //CASE 1: 2,3. CASE 2: 3,3 . CASE 3: 2,1 . CASE 4:3,5 . CASE 5: 2,1 . CASE 6: 2,3 .
    var sum = num1 + num2; //CASE 1: 5, CASE 2: 6, CASE 3: 3, CASE 4: 8, CASE 5: 3, CASE 6: 5
    console.log('sum is', sum); //CASE 1: 'sum is 5',CASE 2: 'sum is 6',CASE 3: 'sum is 3',
                                //CASE 4: 'sum is 8',CASE 5: 'sum is 3',CASE 6: 'sum is 5'.
    return sum;
}
var result = /*CASE 1*/sumNums(2,3) + /*CASE 2*/sumNums(3,sumNums(2,1)) + /*CASE 4*/sumNums(/*CASE 5*/sumNums(2,1),/*CASE 6*/sumNums(2,3));
//SUM CASE 1(5) + CASE 2(6) + CASE 4(8)
console.log('result is', result); //print 'result is 19'



var codeJS=`
//FUNCTION 1
function hello() {
    console.log('hello');   //PRINT 'hello'
}
hello(); //call HELLO
console.log('Dojo'); //Print 'Dojo'
//FUNCTION 2
function hello1() { //ERROR, It was named hello, I modified to hello1
    console.log('hello'); //print 'hello'
    return 15; //'15'
}
var result = hello1(); //result= 15
console.log('result is', result); //It will print 'hello' and 'result is 15'
//FUNCTION 3
function numPlus(num) { // function NameFunction(parameter)
    console.log('num is', num); // print 'num is (parameter)'
    return num+15; // (parameter)+15
   }
var result = numPlus(3); //result = 3+15 = 18, it will print 'num is 3'
console.log('result is', result); // It will print 'result is 18'
//FUNCTION 4
var num = 15;
console.log(num); //It will print '15'
function logAndReturn(num2){
    console.log(num2); //it will print (parameter), in this case it will print 10
    return num2; // It will return (parameter), in this case, it will return the parameter or 10
}
var result = logAndReturn(10); //result = 10
console.log(result); //print '10'
console.log(num); //print '15'
//FUNCTION 5
var num = 15; //num == 15
console.log(num); //it will print 15
function timesTwo(num2){
 console.log(num2); //It will print parameter, in this case '10'
 return num2*2;     //It will return parameter * 2, in this case, it will return 10*2=20
}
var result = timesTwo(10); // Result = 20
console.log(result); //It will print 20
console.log(num); // It will print 15

//FUNCTION 6
function timesTwoAgain(num) {
    console.log('num is', num); // it will print 'num is (parameter)' , in case 1 it will print 'num is 3', in case 2 it will 
                                //  print 'num is 5'
    var y = num*2; // It will declare y = (parameter)*2. in case 1 it will declare '6', in case 2 it will declare '10'
    return y; //return the var y, in case 1, return 6. in case 2, return 10.
   }
var result = /*CASE 1*/timesTwoAgain(3) + /*CASE 2*/timesTwoAgain(5); //result = 6+10 = 16 
console.log('result is', result); //print 'result is 16'

//Function 7
function sumNums(num1, num2) {  //declare function sumNums with parameters: num1 and num2, in case 1, they are num1=2, num2=3. 
                                //in case 2 they are, num1=3, num2=5, 
    return num1+num2; //in case 1 it will return 2+3=5, in case 2 it will return 3+5=8.
}
console.log(sumNums(2,3))//print 5
console.log(sumNums(3,5))//print 8

//FUNCTION 8
function printSumNums(num1, num2) {//declare functionprintsumnums with parameters num1 and num2, in case 1 num1=2; num2=3, 
                            //  in case 2 num1=3; num2=5;
    console.log(num1); //it will print just num1 in both cases, in case 1 it will print '2'. in case 2 it will print='3'
    return num1+num2; //in case 1 it will return 5, in case 2 it will return 8
}
console.log(printSumNums(2,3)) //print '2'/n'5'
console.log(printSumNums(3,5)) //print '3'/n'8'

//FUNCTION 9
function sumNums(num1, num2) {//in case 1; num1=2, num2=3. in case 2; num1=3, num2=5
    var sum = num1 + num2; //in case 1: sum= 2+3 = 5. in case 2: sum=3+5= 8 
    console.log('sum is', sum);//in case 1 print 'sum is 5', in case 2 print 'sum is 8'
    return sum; //in case 1 return 5, in case 2 return 8
}
var result = sumNums(2,3) + sumNums(3,5); //result = 5 + 8 = 13
console.log('result is', result); // print 'result is 13' 

//FUNCTION 10
function sumNums(num1, num2) { //CASE 1: 2,3. CASE 2: 3,3 . CASE 3: 2,1 . CASE 4:3,5 . CASE 5: 2,1 . CASE 6: 2,3 .
    var sum = num1 + num2; //CASE 1: 5, CASE 2: 6, CASE 3: 3, CASE 4: 8, CASE 5: 3, CASE 6: 5
    console.log('sum is', sum); //CASE 1: 'sum is 5',CASE 2: 'sum is 6',CASE 3: 'sum is 3',
                                //CASE 4: 'sum is 8',CASE 5: 'sum is 3',CASE 6: 'sum is 5'.
    return sum;
}
var result = /*CASE 1*/sumNums(2,3) + /*CASE 2*/sumNums(3,sumNums(2,1)) + /*CASE 4*/sumNums(/*CASE 5*/sumNums(2,1),/*CASE 6*/sumNums(2,3));
//SUM CASE 1(5) + CASE 2(6) + CASE 4(8)
console.log('result is', result); //print 'result is 19'
`;
var showCodeButton = document.getElementById("showCodeButton2");
if(showCodeButton){
    showCodeButton.addEventListener("click", function() {
        var codeContainer2 = document.getElementById("codeContainer2");
        codeContainer2.innerHTML = '<pre>'+codeJS+ '</pre>';
    })
}
