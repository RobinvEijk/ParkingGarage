public class Simulator extends AbstractController
{
	private LogicModel model;
	

    public Simulator(){
    	model = new LogicModel();
    }
    
    //old run method, 
    //performs 10000 steps
    public void run(){
    	for (int i = 0;i < 10000; i++){
    		model.tick();
    	}
    }
    
    //new run method
    //@param the amount of steps the simulator should perform
    public void runSteps(int getal) {
    	int i = getal;
    	while(i > 0){
    		model.tick();
    		i--; }
    	}
    public static void main(String[] args)
    {
    	new Simulator();
    	
    }
}
   
    
    
    
   

