

//Devuelve la suma de 1 a N. Por ejemplo,  Sum1toN(3) devolverá la suma de 1+2+3, la cual es 6
//sum1toN(255) devuelve la suma de todos los números de 1 a 255
function Sum1toN(n){
    var suma = 0;
    if(!Number.isInteger(n)){
        
    }else{
        for (let i = 1; i <= n; i++) {
            suma += i;
        }    
    }
    return suma;
}
//devuelve la suma del primer y último número en el array
function sumFirstLast(arr){
    if(Array.isArray(arr)){
        if(arr.length>=1){
            return arr[0] + arr[arr.length - 1]; // Suma del primer y último número
        }
        else{
            return "El array es muy pequeño para los calculos!"
        }
    }else{
        return "No es un array"
    }

}
    
describe("Sum1toN", function() { 
    it("should return 3 when we pass 2 as an argument", function() { 
        expect(Sum1toN(2)).toEqual(3); 
    }); 
    it("should return 6 when we pass 3 as an argument", function() { 
        expect(Sum1toN(3)).toEqual(6); 
    }); 
    it("should return 10 when we pass 4 as an argument", function() { 
        expect(Sum1toN(4)).toEqual(10); 
    }); 
});
    
describe("sumFirstLast", function() { 
    it("should return 3 when we pass [1,2] as an argument", function() { 
        expect(sumFirstLast([1,2])).toEqual(3); 
    }); 
    it("should return 10 when we pass [2,3,8] as an argument", function() { 
        expect(sumFirstLast([2,3,8])).toEqual(10); 
    }); 
    it("should return -10 when we pass [-6,23,3,-4] as an argument", function() { 
        expect(sumFirstLast([-6,23,3,-4])).toEqual(-10); 
    }); 
});


function sumMaxMin(arr){
    if(Array.isArray(arr)){
        if(arr.length>=2){
            return Math.max(...arr)+Math.min(...arr);
        }
        else{
            return "No se puede, digitos muy minimos!";
        }
    }else{
        return "objeto entregado no es un ARRAY"
    }

}
describe("sumMaxMin", function() { 
    it("should return 11 when we pass [1,3,10] as an argument", function() { 
        expect(sumMaxMin([1,3,10])).toEqual(11); 
    }); 
    it("should return -12 when we pass [-2,-5,-10] as an argument", function() { 
        expect(sumMaxMin([-2,-5,-10])).toEqual(-12); 
    }); 
});