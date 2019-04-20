int x= 20;
int y= 20;
int birdXSpeed;
int birdYSpeed= 30;
int gravity = 2;
int pipeX= 600;
int upperPipeHeight = (int) random(100, 400);
boolean hitsGround= false;
int score= 0;

void setup(){
  size(600,600);
}

void draw(){
  if (intersectsPipes()== true){
    exit();
  }
  if (y>=570){
    hitsGround= true;
    exit();
  }
  else {
    hitsGround= false;
  }
  background(#009BFF);
  fill(#FFEC5A);
  stroke(#030303);
  y+=gravity;
  ellipse(x, y, 30, 30);
  fill(#00F039);
  pipeX-=1;
  rect(pipeX, 0, 40, upperPipeHeight);
  teleportPipes();
  fill(#B77525);
  rect(0, 570, 600, 30);
  fill(#00F039);
  pipeX-=1;
  rect(pipeX, upperPipeHeight + 100, 40, 600-(upperPipeHeight + 100));
  teleportPipes();
  fill(#000000);
  text("your score is " + score, 20, 30);
}

void mousePressed(){
  y-=birdYSpeed;
}

void teleportPipes(){
  if(pipeX== 0){
    pipeX=600;
    upperPipeHeight = (int) random(100, 400);
    score++;
  }
}
boolean intersectsPipes() { 
     if (y < upperPipeHeight && x > pipeX && x < (pipeX+40)){
          return true; }
     else if (y >(upperPipeHeight + 100) && x > pipeX && x < (pipeX+40)) {
          return true; }
     else { return false; }
}
