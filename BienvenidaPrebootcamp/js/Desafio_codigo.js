console.log("DESAFIO_CODIGO.JS")
function muestraInformaciónContacto() {
    var auntContactInfo = ["Paula", "Smith", "Calle Principal 1234", "St. Louis", "MO", 12345];
    //auntContactInfo[0]= "Paula"
    //auntContactInfo[1]= "Smith"
    //auntContactInfo[2]= "Calle Principal 1234"
    //auntContactInfo[3]= "St. Louis"
    //auntContactInfo[4]= "MO"
    //auntContactInfo[5]= "12345"
    console.log(auntContactInfo); // ["Paula", "Smith", "Calle Principal 1234", "St. Louis", "MO", 12345]
}
muestraInformaciónContacto();
function muestraListaDeCompras() {
    var produce = ["manzanas", "naranjas"]; //PRODUCE = ["manzanas", "naranjas"]
    var frozen = ["brócoli", "helado"]; //frozen = ["brocoli", "helado"]
    frozen.push("croqueta de papa"); //Frozen = ["brocoli", "helado", "croqueta de papa"]
    console.log(frozen); // ["brocoli", "helado", "croqueta de papa"]
}
muestraInformaciónContacto();

    var movieLibrary = ["Bambi", "E.T.", "Toy Story"]; // movieLibrary = ["Bambi", "E.T.", "Toy Story"]
    //movieLibrary[0]= "Bambi"
    //movieLibrary[1]= "E.T"
    //movieLibrary[2]= "Toy Story"
    movieLibrary.push("Zoro"); //movieLibrary =["Bambi", "E.T.", "Toy Story", "Zoro"]
    movieLibrary[1] = "Beetlejuice"; //movieLibrary = ["Bambi", "Beetlejuice", "Toy Story", "Zoro"]
    console.log(movieLibrary) // ["Bambi", "Beetlejuice", "Toy Story", "Zoro"]


console.log("");//SALTO DE LINEA
var showCodeButton1 = document.getElementById("showCodeButton1");
var codeJS1 = `
console.log("DESAFIO_CODIGO.JS")
function muestraInformaciónContacto() {
    var auntContactInfo = ["Paula", "Smith", "Calle Principal 1234", "St. Louis", "MO", 12345];
    //auntContactInfo[0]= "Paula"
    //auntContactInfo[1]= "Smith"
    //auntContactInfo[2]= "Calle Principal 1234"
    //auntContactInfo[3]= "St. Louis"
    //auntContactInfo[4]= "MO"
    //auntContactInfo[5]= "12345"
    console.log(auntContactInfo); // ["Paula", "Smith", "Calle Principal 1234", "St. Louis", "MO", 12345]
}
muestraInformaciónContacto();

function muestraListaDeCompras() {
    var produce = ["manzanas", "naranjas"]; //PRODUCE = ["manzanas", "naranjas"]
    var frozen = ["brócoli", "helado"]; //frozen = ["brocoli", "helado"]
    frozen.push("croqueta de papa"); //PRODUCE = ["manzanas", "naranjas", "croqueta de papa"]
    console.log(frozen); //["manzanas", "naranjas", "croqueta de papa"]
}
muestraInformaciónContacto();


    var movieLibrary = ["Bambi", "E.T.", "Toy Story"]; // movieLibrary = ["Bambi", "E.T.", "Toy Story"]
    //movieLibrary[0]= "Bambi"
    //movieLibrary[1]= "E.T"
    //movieLibrary[2]= "Toy Story"
    movieLibrary.push("Zoro"); //movieLibrary =["Bambi", "E.T.", "Toy Story", "Zoro"]
    movieLibrary[1] = "Beetlejuice"; //movieLibrary = ["Bambi", "Beetlejuice", "Toy Story", "Zoro"]
    console.log(movieLibrary) // ["Bambi", "Beetlejuice", "Toy Story", "Zoro"]



console.log("");//SALTO DE LINEA
// FALTA LOS ESPACIADOS, revisar archivo JS
`;
if(showCodeButton1){
    showCodeButton1.addEventListener("click", function() {
        var codeContainer1 = document.getElementById("codeContainer1");
        codeContainer1.innerHTML = "<pre>" + codeJS1 + "</pre>";
    });    
}
   