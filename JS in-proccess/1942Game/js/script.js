document.addEventListener("DOMContentLoaded", function () {
    var hero = {
        x: 500,
        y: 700
    };
    var bullets = [];
    var score = 0;
    var offsetHero = 13;
    var offsetBullets = 9;

    var enemies = [];

    function enemiesDeployment() {
        var max = 2; //el valor numérico máximo para el nombre del tipo de enemigo
        var min = 1; //el valor numérico mínimo para el nombre del tipo de enemigo

        for (var i = 0; i < 10; i++) {
            var enemy = {
                c: "enemy" + Math.floor(Math.random() * (max - min + 1) + min) + "",
                x: Math.floor(Math.random() * (1000 - 100 + 1) + 100),
                y: Math.random() * 100,
                s: 2 + Math.random() * 0.5
            };
            if (enemy.c == "enemy1") {
                enemy.offset = 14;
            } else {
                enemy.offset = 6;
            }
            enemies.push(enemy);
        }
    }
    enemiesDeployment();

    function displayHero() {
        document.getElementById('heroe').style.left = hero.x + "px";
        document.getElementById('heroe').style.top = hero.y + "px";
    }

    function displayEnemies() {
        var output = "";
        for (var i = 0; i < enemies.length; i++) {
            output += "<div class='" + enemies[i].c + "' style='top:" + enemies[i].y + "px; left:" + enemies[i].x + "px;'></div>";
        }
        document.getElementById('enemigos').innerHTML = output;
    }

    function displayBullets() {
        var output = "";
        for (var i = 0; i < bullets.length; i++) {
            output += "<div class='balas' style='top:" + bullets[i].y + "px; left:" + bullets[i].x + "px;'></div>";
        }
        document.getElementById('balas').innerHTML = output;
    }

    function displayScore() {
        document.getElementById('score').innerHTML = score;
    }

    function moveEnemies() {
        for (var i = 0; i < enemies.length; i++) {
            enemies[i].y += enemies[i].s;
            if (enemies[i].y > 800) {
                enemies[i].y = 0;
                enemies[i].x = Math.random() * (1000 - 100 + 1) + 100;
                enemies[i].s = 2 + Math.random() * 0.5;
            }
        }
    }

    function moveBullets() {
        for (var i = 0; i < bullets.length; i++) {
            bullets[i].y -= 2;
            if (bullets[i].y < 0) {
                bullets[i] = bullets[bullets.length - 1];
                bullets.pop();
            }
        }
    }

    function gameLoop() {
        displayHero();
        moveEnemies();
        displayEnemies();
        moveBullets();
        displayBullets();
        detectCollision();
        displayScore();
    }

    function delayedLoop() {
        removeExploded();
    }

    setInterval(gameLoop, 20);
    setInterval(delayedLoop, 200);
    function playSound() {
        var sound = new Audio('./js/mi_explosion_03_hpx.mp3');  // Reemplaza 'sound.mp3' con la ruta y nombre de tu archivo de sonido
        sound.play();
    }
    function detectCollision() {
        for (var i = 0; i < enemies.length; i++) {
            for (var j = 0; j < bullets.length; j++) {
                if (
                    Math.abs((bullets[j].x + offsetBullets) - (enemies[i].x + enemies[i].offset)) < 5 &&
                    Math.abs((bullets[j].y + offsetBullets) - (enemies[i].y + enemies[i].offset)) < 3
                ) {
                    score += 10;
                    console.log('bullet', j, 'hit enemy', i);
                    playSound();
                    enemies[i].c = "enemyExplode";
                    enemies[i].s = 1;
                    console.log(enemies);
                }
            }
            if (
                Math.abs((hero.x + offsetHero) - (enemies[i].x + enemies[i].offset)) < (offsetHero + enemies[i].offset) &&
                Math.abs((hero.y + offsetHero) - (enemies[i].y + enemies[i].offset)) < 1
            ) {
                score -= 500;
                console.log('hero hit enemy', i);
            }
        }
    }

    function removeExploded() {
        for (var i = 0; i < enemies.length; i++) {
            if (enemies[i].c == "enemyExplode") {
                enemies[i] = enemies[enemies.length - 1];
                enemies.pop();
            }
        }
    }

    document.onkeydown = function (a) {
        if (a.keyCode == 37) {
            hero.x -= 10;
        }
        if (a.keyCode == 39) {
            hero.x += 10;
        }
        if (a.keyCode == 38) {
            hero.y -= 10;
        }
        if (a.keyCode == 40) {
            hero.y += 10;
        }
        if (a.keyCode == 32) {
            //spacebar
            bullets.push({ x: hero.x + 6, y: hero.y - 13 });
        }
        displayHero();
    };
});
