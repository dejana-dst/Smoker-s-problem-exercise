
public class TobaccoSmoker extends Thread{

	String id="Tobaccos";
	 Table t;
	 boolean tense=false;

 
 public TobaccoSmoker( Table t) {
	super();
	

	this.t = t;
}



public void run()
 {
	 while(true)
	 {
		 System.out.println("Tobaccos waiting on a turn.");
		 tense=true;
		while(tense)
		{
			t.takeMatch(id);
			if(!t.attemptPaper(id))
			{
				t.releaseMatch(id);
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else tense=false;
		}
		
		 smoke();
		t.freeTable();
			
	 }
 }


private void smoke()
	{
		try {
			
				System.out.println("Tobaccos is smoking...");
			
			sleep(500);
			
			System.out.println(id +" is done smoking.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
