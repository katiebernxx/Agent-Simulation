/* 
 * Katie Bernard
 * 10/3/2022
 */
import java.awt.Graphics;
abstract class Agent{
    double xPos;
    double yPos;
    
    public Agent(double x0, double y0){ // a constructor that sets the position.
        xPos = x0;
        yPos = y0;
    }

    public double getX() { //returns the x position.
        return xPos;
    }

    public double getY(){// returns the y position.
        return yPos;
    }

    public void setX( double newX ){// sets the x position.
        xPos = newX;
   }

    public void setY( double newY ){// sets the y position.
        yPos = newY;
    }

    public String toString(){// returns a String containing the x and y positions, e.g. "(3.024, 4.245)".
    return (""+ xPos + "," + yPos);
    }

    public abstract void updateState( Landscape scape );

    public abstract void draw(Graphics g);


}