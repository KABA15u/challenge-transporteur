package testJohan;

import gsolution.GSupplyLinkSolution;

/**
 * Classe repr�sentant la structure de la liste Taboue
 * @author johan
 *
 */
public class Tabou {

	//Dur�e tabou : nombre de tour
	private int dur�eTaboue;
	// solution tabou
	private GSupplyLinkSolution sol; 
	/**
	 * Constructeur 
	 */
	public Tabou(GSupplyLinkSolution s,int t){
		this.sol=s;
		this.dur�eTaboue=t;
	}
	/**
	 * Reduit la dur�e tabou, return vrai si la dur�e tabou est = �0
	 * @return
	 */
	public boolean reductionDur�eTabou(){
		dur�eTaboue--;
		if (dur�eTaboue==0){
			return true;
		}
		return false;
	}
	public GSupplyLinkSolution getSol() {
		return sol;
	}
	
}
