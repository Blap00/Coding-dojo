var world = [
    [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
    [2, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [2, 1, 1, 2, 2, 2, 1, 1, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 1, 2],
    [2, 1, 1, 2, 0, 0, 2, 1, 2, 1, 1, 1, 1, 2, 1, 3, 1, 2, 1, 2, 0, 0, 2, 1, 1, 1, 2],
    [2, 1, 1, 2, 0, 0, 2, 1, 2, 1, 1, 1, 1, 2, 1, 3, 1, 2, 1, 2, 0, 0, 2, 1, 1, 1, 2],
    [2, 1, 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 1, 2],
    [2, 1, 1, 2, 0, 0, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2],
    [2, 1, 1, 2, 0, 0, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2],
    [2, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2],
    [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2],
    [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
];

var score = 0;
var pacman = {
    x: 3,
    y: 1,
    live: 3,
}
var redghost = {
    x: 21,
    y: 5
}
var blueghost = {
    x: 11,
    y: 5
}

function displayworld() {
    var output = '';

    for (var i = "0"; i < world.length; i++) {
        output += "\n<div class='row'>\n";
        for (var j = "0"; j < world[i].length; j++) {
            if (world[i][j] == 2)
                output += "<div class='brick'></div>";
            else if (world[i][j] == 1)
                output += "<div class='coin'></div>";
            else if (world[i][j] == 0)
                output += "<div class='empty'></div>";
            else if (world[i][j] == 3)
                output += "<div class='furit'></div>";
            // else if (world[i][j] == 4)
            //     output += "<div id='blueghost'></div>";
        }
        output += "</div>";
    }
    // console.log(document);
    document.getElementById('world').innerHTML = output;
}
function displayPacman() {
    document.getElementById('pacman').style.top = pacman.y * 20 + "px";
    document.getElementById('pacman').style.left = pacman.x * 20 + "px";
    document.getElementById('lives').innerHTML = pacman.lives;
}


function displayGhost() {
    document.getElementById('redghost').style.top = redghost.y * 20 + "px";
    document.getElementById('redghost').style.left = redghost.x * 20 + "px";
    document.getElementById('blueghost').style.top = blueghost.y * 20 + "px";
    document.getElementById('blueghost').style.left = blueghost.x * 20 + "px";
}


function displayScore() {
    document.getElementById('score').innerHTML = score;
}

function moveGhost(ghost) {
    var direction = Math.floor(Math.random() * 4); // Generar un número aleatorio entre 0 y 3 para determinar la dirección del movimiento
    var dx = 0;
    var dy = 0;

    if (direction === 0) {
        dx = -1; // Izquierda
    } else if (direction === 1) {
        dx = 1; // Derecha
    } else if (direction === 2) {
        dy = -1; // Arriba
    } else if (direction === 3) {
        dy = 1; // Abajo
    }

    var newX = ghost.x + dx;
    var newY = ghost.y + dy;

    if (world[newY][newX] !== 2) {
        ghost.x = newX;
        ghost.y = newY;
    }
}

function moveGhosts() {
    moveGhost(redghost);
    moveGhost(blueghost);
    checkGhostCollision();
    displayGhost();
}

function checkGhostCollision() {
    if (pacman.x === redghost.x && pacman.y === redghost.y) {
        pacman.lives--;
        if (pacman.lives === 0) {
            gameOver();
        } else {
            resetPositions();
        }
        displayScore();
    }
    if (pacman.x === blueghost.x && pacman.y === blueghost.y) {
        pacman.lives--;
        if (pacman.lives === 0) {
            gameOver();
        } else {
            resetPositions();
        }
        displayScore();
    }
}

function resetPositions() {
    pacman.x = 3;
    pacman.y = 1;
    redghost.x = 21;
    redghost.y = 5;
    blueghost.x = 11;
    blueghost.y = 5;
}

function gameOver() {
    alert("Game Over!");
    score = 0;
    pacman.lives = 3;
    resetPositions();
    displayScore();
    displayWorld();
    displayPacman();
    displayGhost();
}


displayworld();
displayPacman();
displayGhost();
displayScore();

document.onkeydown = function (e) {
    if (e.keyCode == 37 && world[pacman.y][pacman.x - 1] != 2) {
        pacman.x--;
        document.getElementById('pacman').classList.remove('rotatedx'); // Agregar la clase 'rotatedx' al elemento con el id 'pacman'
        document.getElementById('pacman').classList.remove('rotatedyu'); // Agregar la clase 'rotatedx' al elemento con el id 'pacman'
        document.getElementById('pacman').classList.remove('rotatedyd'); // Agregar la clase 'rotatedx' al elemento con el id 'pacman'
    } else if (e.keyCode == 39 && world[pacman.y][pacman.x + 1] != 2) {
        pacman.x++;
        document.getElementById('pacman').classList.add('rotatedx'); // Quitar la clase 'rotatedx' del elemento con el id 'pacman'
        document.getElementById('pacman').classList.remove('rotatedyu'); // Agregar la clase 'rotatedx' al elemento con el id 'pacman'
        document.getElementById('pacman').classList.remove('rotatedyd'); // Agregar la clase 'rotatedx' al elemento con el id 'pacman'
    } else if (e.keyCode == 38 && world[pacman.y - 1][pacman.x] != 2) {
        pacman.y--;
        document.getElementById('pacman').classList.add('rotatedyu'); // Agregar la clase 'rotatedx' al elemento con el id 'pacman'
        document.getElementById('pacman').classList.remove('rotatedx'); // Agregar la clase 'rotatedx' al elemento con el id 'pacman'
        document.getElementById('pacman').classList.remove('rotatedyd'); // Agregar la clase 'rotatedx' al elemento con el id 'pacman'

    } else if (e.keyCode == 40 && world[pacman.y + 1][pacman.x] != 2) {
        pacman.y++;
        document.getElementById('pacman').classList.add('rotatedyd'); // Agregar la clase 'rotatedx' al elemento con el id 'pacman'

    }
    var angle = 0;

    if (world[pacman.y][pacman.x] == 1) {
        world[pacman.y][pacman.x] = 0;
        score += 10;
        displayScore();
        displayworld();
    }
    if (world[pacman.y][pacman.x] == 3) {
        world[pacman.y][pacman.x] = 0;
        score += 50;
        displayScore();
        displayworld();
    }

    if(pacman.x === redghost.x && pacman.y === redghost.y){
        if (pacman.live > 0) {
            pacman.live--;
            console.log(pacman.live);
        }
    }if (pacman.x === blueghost.x && pacman.y === blueghost.y){
        if (pacman.live > 0) {
            pacman.live--;
            console.log(pacman.live);
        }
    }

    // console.log(e.keyCode);
    displayPacman();
    displayworld();
}