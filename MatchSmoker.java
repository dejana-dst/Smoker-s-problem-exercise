
public class MatchSmoker extends Thread{

	String id="Matches";
	 Table t;
	 boolean tense=false;

 
 public MatchSmoker( Table t) {
	super();
	

	this.t = t;
}



public void run()
 {
	 while(true)
	 {
		 System.out.println("Matches waiting on a turn.");
		 tense=true;
		while(tense)
		{
			t.takeTobacco(id);
			if(!t.attemptPaper(id))
			{
				t.releaseTobacco(id);
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
			
				System.out.println("Matches is smoking...");
			
			sleep(500);
			
			System.out.println(id +" is done smoking.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
