package tabou;

import gsolution.GSupplyLinkSolution;

/**
 * Classe repr�sentant la structure de la liste Taboue
 * @author johan
 *
 */
public class MouvementTabou {

	//Dur�e tabou : nombre de tour
	private int dur�eTaboue;

	//Mouvement Tabou
	private Mouvement mouv;
	
	/**
	 * Constructeur 
	 */
	public MouvementTabou(Mouvement m,int t){
		this.mouv=m;
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
	public Mouvement getMouv() {
		return mouv;
	}
	public int compareTo(Mouvement mvtTabou,int dur�eTaboue) {
		// TODO Auto-generated method stub
		if(this.mouv.getIndiceBatch() == mvtTabou.getIndiceBatch() && this.mouv.getIndiceProcessingSchedule()==mvtTabou.getIndiceProcessingSchedule()){
			this.dur�eTaboue=dur�eTaboue;
			return 0;
		}
		return 1;
	}
	public int compareTo(Mouvement mvtTabou) {
		// TODO Auto-generated method stub
		if(this.mouv.getIndiceBatch() == mvtTabou.getIndiceBatch() && this.mouv.getIndiceProcessingSchedule()==mvtTabou.getIndiceProcessingSchedule()){
			return 0;
		}
		return 1;
	}
	
}
