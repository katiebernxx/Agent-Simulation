/* 
 * Katie Bernard
 * 10/3/2022
 */
import java.awt.Graphics;
import java.awt.Color;
public class Landscape{
    int width;
    int height;
    LinkedList<Agent> agentList;
    public Landscape(int w, int h) {
        width = w;
        height = h;
        agentList = new LinkedList<Agent>();
    }
    
    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void addAgent(Agent a){
        agentList.add(a);
    }

    public String toString(){
        return ("" + agentList.size() + " agents in landscape");
    }

    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius){ 
        //returns a list of the Agents within radius distance of the location x0, y0.
        LinkedList<Agent> neighbors = new LinkedList<Agent>();
        for(Agent agent : agentList){
            if(!( agent instanceof SuperSocialAgents)){

            if (Math.pow(agent.getX() - x0, 2) + Math.pow(agent.getY() - y0, 2) < Math.pow(radius, 2)){
             neighbors.add(agent);
            }
        }
        }     

            return neighbors;
        }

        public LinkedList<Agent> extensionGetNeighbors(double x0, double y0, double radius){ 
            //returns a list of the Agents within radius distance of the location x0, y0.
            LinkedList<Agent> neighbors = new LinkedList<Agent>();
            for(Agent agent : agentList){
                if( agent instanceof SuperSocialAgents){
                    if (Math.pow(agent.getX() - x0, 2) + Math.pow(agent.getY() - y0, 2) < Math.pow(radius, 2)){
                        neighbors.add(agent);
                       }
                }
               
            }     
    
                return neighbors;
            }
    
    public void draw(Graphics g){
        for(Agent agent : agentList){
           agent.draw(g);
        }
    }
    boolean still;
    public void updateAgents(){
        
        for (Agent agent : agentList){
            Agent old = agent;
            agent.updateState(this);
            if( agent == old){
                still = true;
            }
        }
    }

}





