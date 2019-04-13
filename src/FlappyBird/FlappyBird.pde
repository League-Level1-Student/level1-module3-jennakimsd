int x= 20;
int y= 20;
int birdXSpeed;
int birdYSpeed= 30;
int gravity = 2;
int pipeX= 600;
int upperPipeHeight = (int) random(100, 400);

void setup(){
  size(600,600);
}

void draw(){
  background(#009BFF);
  fill(#FFEC5A);
  stroke(#030303);
  y+=gravity;
  ellipse(x, y, 30, 30);
  fill(#00F039);
  pipeX-=2;
  rect(pipeX, 0, 40, upperPipeHeight);
   teleportPipes();
}

void mousePressed(){
  y-=birdYSpeed;
}

void teleportPipes(){
  if(pipeX== 0){
    pipeX=600;
  }
}
boolean intersectsPipes() { 
     if (y < upperPipeHeight && x > pipeX && x < (pipeX+40)){
          return true; }
     else if (y>upperPipeHeight && x > pipeX && x < (pipeX+40)) {
          return true; }
     else { return false; }
}