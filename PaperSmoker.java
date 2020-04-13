
public class PaperSmoker extends Thread{

	String id="Papers";
	 Table t;
	 boolean tense=false;

 
 public PaperSmoker( Table t) {
	super();
	

	this.t = t;
}



public void run()
 {
	 while(true)
	 {
		 System.out.println("Papers waiting on a turn.");
		 tense=true;
		while(tense)
		{
			t.takeTobacco(id);
			if(!t.attemptMatch(id))
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


private  void smoke()
	{
		try {
			
				System.out.println("Papers is smoking...");
			
			sleep(500);
			
			System.out.println(id +" is done smoking.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
