import processing.core.PApplet;

public class Main extends PApplet{

    int numOfFaces = 50;
    float h=100,r=60;
    boolean autoRotate=true;

    public void settings(){
        size(600,600, P3D);
        smooth(8);
    }

    @Override
    public void setup() {
        camera(0,0,0,0,0,-5,0,1,0);
    }

    @Override
    public void mouseClicked() {
        autoRotate = !autoRotate;
    }

    float a=0,b=0;
    @Override
    public void draw() {

        background(240,240,240);

        translate(0,0,-200);

        if(!autoRotate) {
            b = mouseX * 0.01f;
            a = mouseY * 0.01f;
        }

        rotateY(b);
        rotateX(a);

        a += 0.004f;
        b += 0.008f;

        stroke(100,100,100);
        fill(0,0,255);

        // Top circle
        beginShape();
        for (int i = 0; i < numOfFaces; i++) {
            float angle = map(i,0,numOfFaces,0,TWO_PI);
            vertex(r*cos(angle),- h/2f,r*sin(angle));
        }
        endShape(CLOSE);

        fill(0,255,0);
        //Cylindrical body
        beginShape(QUAD_STRIP);
        for (int i = 0; i <= numOfFaces; i++) {
            float angle = map(i,0,numOfFaces,0,TWO_PI);

            vertex(r*cos(angle),- h/2f,r*sin(angle));
            vertex(r*cos(angle),h/2f,r*sin(angle));
        }
        endShape();

        // Bottom circle
        fill(0,240,240);
        beginShape(TRIANGLE_FAN);
        vertex(0,h/2f,0);
        for (int i = 0; i <= numOfFaces; i++) {
            float angle = map(i,0,numOfFaces,0,TWO_PI);
            vertex(r*cos(angle),h/2f,r*sin(angle));
        }
        endShape();
    }

    public static void main(String[] args){
        PApplet.main("Main");
    }
}
