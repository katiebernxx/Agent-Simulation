/* 
 * Katie Bernard
 * 10/3/2022
 */
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
public class SocialAgent extends Agent{
    boolean moved;
    int R;

    public SocialAgent(double x0, double y0, int radius) {
        super( x0, y0 );
        R = radius;
    }

    public void setRadius(int radius){
        R = radius;
    }

    public int getRadius(){
        return R;
    }

    public void draw(Graphics g){
        if(!moved) g.setColor(new Color(0, 0, 255));
        else g.setColor(new Color(125, 125, 255));
    
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape){
        //if there are less than 4 agents in its radius,  it changes both its x and y coordinates by a random value between -10 and 10
        int numNeighbors = scape.getNeighbors(xPos, yPos, R).size();
        Random rand = new Random();
        double deltaX = rand.nextDouble(-10, 10);;
        double deltaY =  rand.nextDouble(-10, 10);

            if(xPos+10 > scape.width){
                deltaX = rand.nextDouble(-10, scape.width - xPos);
            }
            else if(xPos-10 < 0){
                deltaX = rand.nextDouble(xPos, 10);
            } 
            if(yPos+10 > scape.height){
                deltaY = rand.nextDouble(-10, scape.height - xPos);
            }
            else if(yPos-10 < 0){
                deltaY = rand.nextDouble(yPos, 10);
            } 

        if(numNeighbors < 4){
            xPos = xPos + deltaX;
            yPos = yPos + deltaY;
            moved = true;
        }
        else{ moved = false;}
    }
}