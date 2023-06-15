var leftValue = 450;
var topValue = 100;
var walkValue = 1;
var max = false;

function update() {
  // Limitar el valor de leftValue entre 0 y 500
  if (leftValue < 0) {
    leftValue = 0;
    max=true;
  } else if (leftValue > 500) {
    leftValue = 500;
    max=true;
  } else{
    max=false;
  }
  // Limitar el valor de topValue entre 0 y 500
  if (topValue < 0) {
    topValue = 0;
  } else if (topValue > 500) {
    topValue = 500;
  }

  document.getElementById("character").style.left = leftValue + "px";
  document.getElementById("character").style.top = topValue + "px";
}

document.onkeydown = function (e) {
  if (walkValue == 1) {
    walkValue = 2;
  } else if (walkValue == 2) {
    walkValue = 1;
  }

  console.log(e);
  
  if (e.keyCode == 37) { // LEFT
    if (!max) {
      leftValue = leftValue - 10;
      document.getElementById("character").style.backgroundImage = "url('../img/left" + walkValue + ".png')";
    }
    else{
        console.log("NO PUEDE CAMINAR MÁS")
    }
  } else if (e.keyCode == 39) { // RIGHT
    if (!max) {
      leftValue = leftValue + 10;
      document.getElementById("character").style.backgroundImage = "url('../img/right" + walkValue + ".png')";
    }
    else{
        console.log("NO PUEDE CAMINAR MÁS")
    }
  } else if (e.keyCode == 40) { // DOWN
    if (!max) {
      topValue = topValue + 10;
      document.getElementById("character").style.backgroundImage = "url('../img/down" + walkValue + ".png')";
    }
    else{
        console.log("NO PUEDE CAMINAR MÁS")
    }
  } else if (e.keyCode == 38) { // UP
    if (!max) {
      topValue = topValue - 10;
      document.getElementById("character").style.backgroundImage = "url('../img/top" + walkValue + ".png')";
    }
    else{
        console.log("NO PUEDE CAMINAR MÁS")        
    }
  }

  update();
}
