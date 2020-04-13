import java.util.Random;

public class Agent extends Thread{

	Table t;
	int combo;
	String items;
	
	
	
	public Agent(Table t) {
		super();
		this.t = t;
	}

	
	
	
	private void placeMT()
	{
		items=("The agent is placing the match and the tobacco.");
		t.placeItems(1, 1, 0,items);
	}
	
	
	private void placeMP()
	{
		items=("The agent is placing the match and the paper.");

		t.placeItems(1, 0, 1,items);
	}
	private void placeTP()
	{
		items=("The agent is placing the tobacco and the paper.");
		t.placeItems(0, 1, 1,items);
	}
	
	public void run()
	{
		while(true)
		{
			combo= new Random().nextInt(3);
			
			
			switch (combo) {
			case 0:
				placeMT();
				break;
			case 1:
				placeMP();
				break;
			case 2:
				placeTP();
				break;
			default:
				break;
			}
			
			
			
			
		}
	}
	
}
