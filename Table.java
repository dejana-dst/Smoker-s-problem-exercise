
public class Table {

	int match=0;
	int tobacco=0;
	int paper=0;
	boolean clean= true;
	
	
	
	
	
	public synchronized void freeTable()
	{
		match=0;
		tobacco=0;
		paper=0;
		clean=true;
		notifyAll();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public synchronized void takeMatch(String id)
	{
		System.out.println(id+" is scrambling for matches");
		while (match==0)
		{
			try {
				System.out.println(id+" finds no matches");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(id+" got matches");
		match=0;
	}
	
	public synchronized void takeTobacco(String id)
	{
		System.out.println(id+" is scrambling for tobacco");
		while (tobacco==0)
		{
			try {
				System.out.println(id+" finds no tobacco");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(id+" got tobacco");
		tobacco=0;
	}
	
	public synchronized void takePaper(String id)
	{
		System.out.println(id+" is scrambling for paper");
		while (paper==0)
		{
			try {
				System.out.println(id+" finds no paper");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(id+" got paper");
		paper=0;
	}
	
	
	
	
	
	
	
	
	
	public synchronized void placeItems(int m, int t, int p,String items)
	{
		while(!clean)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(items);
		match=m;
		tobacco=t;
		paper=p;
		System.out.println("The agent has placed items and awaits..");
		clean=false;
		notifyAll();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	

	public synchronized boolean attemptPaper(String id) {
		// TODO Auto-generated method stub
		System.out.println(id+" is trying to obtain paper");
		if(paper==0)
			return false;
		else
		{
			paper=0;
			System.out.println(id+" obtained paper");
			return true;
		}
	}
	
	public synchronized boolean attemptMatch(String id) {
		// TODO Auto-generated method stub
		System.out.println(id+" is trying to obtain matches");
		if(match==0)
			return false;
		else
		{
			match=0;
			System.out.println(id+" obtained matches");
			return true;
		}
	}
	
	public  synchronized boolean attemptTobacco(String id) {
		// TODO Auto-generated method stub
		System.out.println(id+" is trying to obtain tobacco");
		if(tobacco==0)
			return false;
		else
		{
			tobacco=0;
			System.out.println(id+" obtained tobacco");
			return true;
		}
	}


	public synchronized void releaseTobacco(String string) {
		// TODO Auto-generated method stub
		tobacco=1;
		System.out.println(string+" is letting go of tobacco");
		notifyAll();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public synchronized void releasePaper(String string) {
		// TODO Auto-generated method stub
		paper=1;
		System.out.println(string+" is letting go of paper");
		notifyAll();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public synchronized void releaseMatch(String string) {
		// TODO Auto-generated method stub
		match=1;
		System.out.println(string+" is letting go of matches");
		notifyAll();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
