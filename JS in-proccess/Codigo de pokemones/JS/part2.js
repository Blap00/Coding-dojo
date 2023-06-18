//TRABAJAMOS AQUI ABAJO
document.addEventListener("DOMContentLoaded", function () {
    //MODIFICADO 
    /*
    var perros= [
        {
            imagen: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/059.png",
            nombre: "Arcanine",
            pelaje: "Liso",
            color_de_pelaje: "Marrón",
            color_de_ojos: "Negro",
            tamaño_en_metros: 1.9,
            peso_en_kg: 155,
            edad_en_años: 2,
            dormir: function () {
                return "Estoy durmiendo...";
            },
            lanzallamas: function (p2) {
                return this.name + "ha usado lanzallamas, no es muy eficaz"
            }
        },
        {
            imagen: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/038.png",
            nombre: "Ninetales",
            pelaje: "Liso",
            color_de_pelaje: "amarillo",
            color_de_ojos: "Rojos",
            tamaño_en_metros: 1.1,
            peso_en_kg: 19.9,
            edad_en_años: 2,
            dormir: function () {
                return "Estoy durmiendo...";
            },
            lanzallamas: function (p2) {
                return this.nombre + "ha usado lanzallamas, no es muy eficaz"
            }
        }
    ]
    
    console.log(perros);
    console.log(perros[0].nombre);
    console.log(perros[1].nombre);
    */
    //CLASES
    const Perro1 = {
        imagen: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/059.png",
        nombre: "Arcanine",
        pelaje: "Liso",
        color_de_pelaje: "Marrón",
        color_de_ojos: "Negro",
        tamaño_en_metros: 1.9,
        peso_en_kg: 155,
        edad_en_años: 2,
        dormir: function () {
            return "Estoy durmiendo...";
        },
        lanzallamas: function (p2) {
            return this.name + "ha usado lanzallamas, no es muy eficaz"
        }
    };
    const Perro2 = {
        imagen: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/038.png",
        nombre: "Ninetales",
        pelaje: "Liso",
        color_de_pelaje: "amarillo",
        color_de_ojos: "Rojos",
        tamaño_en_metros: 1.1,
        peso_en_kg: 19.9,
        edad_en_años: 2,
        dormir: function () {
            return "Estoy durmiendo...";
        },
        lanzallamas: function (p2) {
            return this.nombre + "ha usado lanzallamas, no es muy eficaz"
        }
    };
    console.log(Perro1.lanzallamas(Perro2));
    console.log(Perro2.lanzallamas(Perro1));
    //INTERACCION HTML
    // Obtén la referencia al elemento de imagen

    // Establece la ruta de la imagen
    function setData(large) {
        for (let i = 1; i <= large; i++) {
            document.getElementById(`imagen${i}`).src = eval(`Perro${i}.imagen`);
            document.getElementById(`nombre${i}`).innerHTML = "Nombre: " + eval(`Perro${i}.nombre`);
            document.getElementById(`pelaje${i}`).innerHTML = "Pelaje: " + eval(`Perro${i}.pelaje`);
            document.getElementById(`colorpelaje${i}`).innerHTML = "Color del pelaje: " + eval(`Perro${i}.color_de_pelaje`);
            document.getElementById(`edad${i}`).innerHTML = "Edad: " + eval(`Perro${i}.edad_en_años`) + " años";
            document.getElementById(`peso${i}`).innerHTML = "Peso: " + eval(`Perro${i}.peso_en_kg`) + " kg";
            document.getElementById(`altura${i}`).innerHTML = "Altura: " + eval(`Perro${i}.tamaño_en_metros`) + " metros";
            document.getElementById(`ojos${i}`).innerHTML = "Color de ojos: " + eval(`Perro${i}.color_de_ojos`);
        }
    }
    setData(2);
    //INTERACCION CSS
    $('#but1').click(function () {

    });
});
$(document).ready(function () {
    $('#but1').click(function () {
        
    });
})