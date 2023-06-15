/*
Fibonacci Recursivo;
*/
function fib(n) {
    if (n <= 1) {
        return n; //FIBONACCI mientras el valor sea 0 se mantiene igual
    }
    return fib(n - 1) + fib(n - 2); //Si ninguna se cumple, entonces se hace el calculo n-1 + n-2
}

function getNthFibonacciNumber(n) {
    return fib(n - 1);
}
console.log(getNthFibonacciNumber(6)); // Output: 5
/*
RELLENO RECURSIVO
*/
var world = [
    [1, 1, 1, 0, 0, 0, 0, 3, 2, 2, 2, 5, 0, 2, 4, 0, 3, 3, 3, 0, 6, 3, 3, 3, 3],
    [0, 0, 0, 0, 1, 0, 0, 3, 3, 3, 2, 5, 0, 1, 2, 0, 3, 0, 5, 3, 6, 3, 0, 0, 3],
    [0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 2, 1, 6, 1, 3, 0, 3, 0, 5, 3, 6, 3, 0, 0, 3],
    [0, 2, 2, 0, 1, 1, 1, 1, 0, 0, 1, 1, 6, 2, 6, 0, 3, 0, 5, 3, 6, 3, 4, 4, 3],
    [0, 2, 2, 0, 1, 0, 0, 0, 0, 3, 1, 2, 6, 2, 4, 0, 3, 0, 5, 3, 0, 3, 0, 0, 3],
    [0, 2, 2, 0, 1, 0, 0, 3, 3, 3, 3, 2, 3, 3, 1, 0, 3, 0, 5, 3, 6, 3, 0, 0, 3],
    [0, 0, 0, 0, 1, 0, 0, 3, 3, 3, 3, 3, 6, 0, 2, 2, 3, 3, 3, 0, 6, 3, 3, 3, 3]];

var mapping = {
    0: 'white',
    1: 'red',
    2: 'yellow',
    3: 'blue',
    4: 'green',
    5: 'purple',
    6: 'rgbColor'
}

function drawWorld() {
    var output = '';
    for (var i = 0; i < world.length; i++) {
        output += '<div class="row">';
        for (var j = 0; j < world[i].length; j++) {
            output += "<div class='" + mapping[world[i][j]] + "'></div>";
        }
        output += '</div>';
    }
    document.getElementById('container').innerHTML = output;
    // console.log(output);
}

document.onclick = function (e) {
    // console.log('Coordinate Clicked', e.x, e.y);

    var x = Math.floor(e.x / 50);
    var y = Math.floor(e.y / 50);

    fill(x, y, world[y][x], 4);
}

function fill(x, y, original_color, color) {
    //Restricciones
    if(y<0 || y>=world.length || x<0 || x>=25 ){
        return false;
    }
    //MIENTRAS NO SEA IGUAL, SE LLAMA A LA FUNCION
    if(world[y][x] != original_color){
        return false;
    }

    world[y][x] = color;
    fill(x,y-1,original_color,color);
    fill(x,y+1,original_color,color);
    fill(x-1,y,original_color,color);
    fill(x+1,y,original_color,color);
    drawWorld();

}

drawWorld();

