package testJohan;
import java.util.ArrayList;
import java.util.List;

import gproblem.GJobData;
import gproblem.GSupplyLinkProblem;
import gsolution.GJobVariable;
import gsolution.GSupplyLinkSolution;
import gsolver.GSolver;

public class MySolverTest extends GSolver {
	/** Variable � cr�er **/
	//Liste de candidats ( liste de voisins pour une it�ration )
	private ArrayList<GSupplyLinkSolution> listeCandidats = new ArrayList<GSupplyLinkSolution>();
	private GSupplyLinkSolution meilleurCandidats;
	//Liste Tabou	
	private ArrayList<Tabou> lisetTabou = new ArrayList<Tabou>();
	//Nombre d'iteration
	private int iteration = 0 ;
	//Nombre d'iteration sans am�lioration de la fonction objectives
	//Meilleur solution trouv�	

	//Critere d'aspiration :
	/**Un m�canisme d�aspiration d�termine un crit�re selon lequel un mouvement,
bien que tabou, peut quand m�me �tre accept�. Il faut faire attention,
cependant, au risque d�introduire � nouveau des cycles dans la recherche.
� Par exemple, un crit�re d�aspiration rudimentaire peut consister � accepter un
mouvement s�il conduit � une configuration meilleure que la meilleure
configuration d�j� trouv�e. Des m�canismes plus sophistiqu�s peuvent �tre
introduits.
	 **/
	public MySolverTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MySolverTest(GSupplyLinkProblem problem, GSupplyLinkSolution bestSolution) {
		super(problem, bestSolution);
		// TODO Auto-generated constructor stub
	}

	public MySolverTest(GSupplyLinkProblem problem) {
		super(problem);
		// TODO Auto-generated constructor stub
	}

	/**
	 * solves the problem
	 */
	public GSupplyLinkSolution init(){
		GSupplyLinkSolution sol = new GSupplyLinkSolution(problem) ;

		int nbrbatch = (int) (rand.nextDouble()*problem.getN())+1 ;
		sol.setNbrBatch(nbrbatch);
		for (int i=0;i<problem.getN();++i) {
			//	int batch = 1;
			int batch = (int) (rand.nextDouble()*nbrbatch)+1 ;
			sol.getProcessingSchedule()[i].setBatchIndice(batch) ;
			sol.getProcessingSchedule()[i].setDeliveryCompletionTime((double)batch) ;
		}
		return sol;
	}

	protected void solve() {
		/**
		 * Sch�ma de l�algorithme tabou de base
			� Engendrer une configuration initiale S0 ; S := S0
			� S* := S ; f* := f(S)
			� T := {} // liste taboue
			� R�p�ter
				� m := le meilleur mouvement parmi les mouvements non tabous et les
				mouvements tabous exceptionnels (crit�re d�aspiration)
				� S := S (+) m
				� Si f(S) < f(S*) faire S* := S ; f* := f(S)
				� Mettre T � jour ;
			� Jusqu�� <condition fin>
			� Retourner S*
		 */
		// Cr�ation d'une solution initiale al�atoire valide
		GSupplyLinkSolution sol;
		do {
			sol = init();
		}while(sol.evaluate() <0);
		while (true) {
			//Creation de la liste de voisin de la derniere solution
			creerListeCandidats(sol);


			//MeilleurVoisins parmit les candidats
			sol=meilleurCandidats.clone();

			//MAJ liste tabou

			// Evaluation of the newly built solution 
			//double eval = sol.evaluate() ;

			if (sol.getEvaluation()>=0) {
				if (bestSolution==null || sol.getEvaluation()<bestSolution.getEvaluation()) { 
					bestSolution = sol ;

					// Nouveau message à destination du log (ecran+fichier)
					log.println ("Iteration="+iteration) ;
					log.println ("New Best Solution = "+sol.getEvaluation()+"\n") ;
				}
			}
			iteration ++  ;
			log.println ("Iteration="+iteration) ;
		}
	}
	/**
	 * Creation de la liste des voisins de sol
	 * @param sol
	 */
	public void creerListeCandidats(GSupplyLinkSolution sol){
		double meilleurVal=sol.getEvaluation();
		double eval=0;
		//Initialisation de temp au valeur de sol
		GSupplyLinkSolution temp=sol.clone();
		GSupplyLinkSolution best=sol.clone();
		//Creation de la liste
		System.out.println(sol.toString());
		// Boucle de g�n�ration  et test des voisins
		for (int i=0;i<problem.getN();i++) {
			for (int j=1;j<problem.getN();++j){
				temp.getProcessingSchedule()[i].setBatchIndice( (sol.getProcessingSchedule()[i].getBatchIndice()+j)%(problem.getN()) ) ;
				if(temp.getProcessingSchedule()[i].getBatchIndice()==0){
					temp.getProcessingSchedule()[i].setBatchIndice(problem.getN());
				}
				eval=temp.evaluate();
				if(eval != -1 && eval <= meilleurVal){
					meilleurVal=eval;
					best=temp.clone();
				}
				temp=sol.clone();
			}
		}
		System.out.println("\n\n\nMeilleur voisin:"+best.toString());
		//fin creation liste
		//Evaluation du meilleur voisins de cette liste
		this.meilleurCandidats=best;
	}

	public GSupplyLinkSolution evalListeCandidats(){
		GSupplyLinkSolution mSol=null;
		return mSol;
	}
	public GSupplyLinkSolution getMeilleurCandidats() {
		return meilleurCandidats;
	}

}