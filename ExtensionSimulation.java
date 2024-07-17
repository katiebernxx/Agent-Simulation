/* 
 * Katie Bernard
 * 10/3/2022
 */
import java.util.Scanner;  // Import the Scanner class
import java.util.Random;
public class ExtensionSimulation {
    public static void main(String[]args){
    
        Scanner w = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What should be the width of the landscape?");
        String width = w.nextLine();  // Read user input
        int widthInt = Integer.parseInt(width); //Parse into int

        Scanner h = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What should be the height of the landscape");
        String height = h.nextLine();  // Read user input
        int heightInt = Integer.parseInt(height); //Parse into int

        Scanner times = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many times should we advance the simulation?");
        String t = times.nextLine();  // Read user input
        int timesInt = Integer.parseInt(t); //Parse into int

        Scanner radius = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What should the radius be?");
        String r = radius.nextLine();  // Read user input
        int radiusInt = Integer.parseInt(r); //Parse into int

        Landscape l = new Landscape(widthInt, heightInt);
        LandscapeDisplay display = new LandscapeDisplay(l);

        for (int i = 0; i<100; i++){
            Random rand = new Random();
            double x = rand.nextDouble(0, widthInt);
            double y = rand.nextDouble(0, heightInt);

            Agent agent = new SocialAgent(x, y, radiusInt);
            l.agentList.add(agent);
        }
        for (int i = 0; i<100; i++){
            Random rand = new Random();
            double x = rand.nextDouble(0, widthInt);
            double y = rand.nextDouble(0, heightInt);

            Agent agent = new AntiSocialAgent(x, y, radiusInt);
            l.agentList.add(agent);
        }
        for (int i = 0; i<150; i++){
            Random rand = new Random();
            double x = rand.nextDouble(0, widthInt);
            double y = rand.nextDouble(0, heightInt);

            Agent agent = new SuperSocialAgents(x, y, radiusInt);
            l.agentList.add(agent);
        }
        

        for(int i = 0; i<timesInt; i++){
            l.updateAgents();
            display.repaint();
            try{
                Thread.sleep( 250 );
            }
            catch (InterruptedException e){
                System.out.println("Exception Thrown");
            }
            
        }
    }
}