import gproblem.GSupplyLinkProblem;
import gsolution.GSupplyLinkSolution;
import gsolver.GSolver;


/**
 * A solver
 * 
 * @author Olivier Grunder
 * @version 0.01
 * @date 14 avril 2011
 *
 */
public class MySolver extends GSolver {
	
	/**
	 * 
	 */
	public MySolver() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param problem
	 */
	public MySolver(GSupplyLinkProblem problem) {
		super(problem);
		// TODO Auto-generated constructor stub
	}

	/**
	 * solves the problem
	 */
	protected void solve() {
		int iteration = 0 ;
		while (true) {
			// Generate a new random solution
			GSupplyLinkSolution sol = new GSupplyLinkSolution(problem) ;
			
			// To generate a random number, use the "rand" attribute which is inherited from GSolver
			int nbrbatch = (int) (rand.nextDouble()*problem.getN())+1 ;
			sol.setNbrBatch(nbrbatch);
			for (int i=0;i<problem.getN();++i) {
				int batch = (int) (rand.nextDouble()*nbrbatch)+1 ;
				sol.getProcessingSchedule()[i].setBatchIndice(batch) ;
				sol.getProcessingSchedule()[i].setDeliveryCompletionTime((double)batch) ;
			}
			
			// Evaluation of the newly built solution 
			double eval = sol.evaluate() ;
			
			if (sol.getEvaluation()>=0) {
				if (bestSolution==null || sol.getEvaluation()<bestSolution.getEvaluation()) { 
					bestSolution = sol ;
					
					// Nouveau message à destination du log (ecran+fichier)
					log.println ("Iteration="+iteration) ;
					log.println ("New Best Solution = "+sol.getEvaluation()+"\n") ;
				}
			}
			iteration ++  ;
		}
	}
	

}
