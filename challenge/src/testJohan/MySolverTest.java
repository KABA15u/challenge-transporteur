package testJohan;
import gproblem.GJobData;
import gproblem.GSupplyLinkProblem;
import gsolution.GSupplyLinkSolution;
import gsolver.GSolver;

public class MySolverTest extends GSolver {
	/** Variable � cr�er **/
	//Liste de candidats ( liste de voisins pour une it�ration )
	//Liste Tabou	
	//Nombre d'iteration
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
	public void init(){

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
		int iteration = 0 ;

		GSupplyLinkSolution sol = new GSupplyLinkSolution(problem) ;


		init();


	}
}
