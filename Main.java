
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Table t= new Table();
		MatchSmoker match=new MatchSmoker(t);
		TobaccoSmoker tobacco=new TobaccoSmoker( t);
		PaperSmoker paper=new PaperSmoker( t);
		
		Agent a= new Agent(t);
		
		
		a.start();
		match.start();
		tobacco.start();
		paper.start();
		
		
		
		
	}

}
