import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet{

    int numOfFaces = 50;
    float h=100,r=60;
    public void settings(){
        size(600,600, P3D);
        smooth(8);
    }

    @Override
    public void setup() {
        camera(0,0,0,0,0,-5,0,1,0);
    }

    float a=0,b=0;

    @Override
    public void draw() {

        background(240,240,240);

        translate(0,0,-200);
        rotateY(b);
        rotateX(a);

        a += 0.004f;
        b += 0.008f;

        PVector upCenter = new PVector(0,- h/2f, 0);
        PVector up, down;

        stroke(100,100,100);
        fill(0,255,0);

        beginShape(QUAD_STRIP);
        for (int i = 0; i <= numOfFaces; i++) {
            float angle = map(i,0,numOfFaces,0,TWO_PI);
            up=upCenter.copy().add(r*cos(angle),0, r*sin(angle));
            down=upCenter.copy().add(r*cos(angle),h, r*sin(angle));

            vertex(up.x,up.y,up.z);
            vertex(down.x,down.y,down.z);
        }
        endShape();
    }

    public static void main(String[] args){
        PApplet.main("Main");
    }
}
