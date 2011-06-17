import gproblem.GSupplyLinkProblem;
import gsolution.GSupplyLinkSolution;


public class Main {
	
	public static void main(String args[]) {
		GSupplyLinkProblem pb = new GSupplyLinkProblem("data/instance01.txt") ;
		System.out.println (pb.toString()+"\n") ;
		
		/*GSupplyLinkSolution sol1 = new GSupplyLinkSolution(pb, "data/instance01-sol01.txt") ;
		System.out.println (sol1.toString()+"\n") ;
		
		System.out.println ("Solution evaluation="+sol1.evaluate()+"\n") ;
		
		GSupplyLinkSolution sol2 = new GSupplyLinkSolution(pb, "data/instance01-sol02.txt") ;
		System.out.println (sol2.toString()+"\n") ;
		
		System.out.println ("Solution evaluation="+sol2.evaluate()+"\n") ;*/
		
		// New solver
		MySolver solv = new MySolver(pb) ;
		solv.start() ;
	}

}
