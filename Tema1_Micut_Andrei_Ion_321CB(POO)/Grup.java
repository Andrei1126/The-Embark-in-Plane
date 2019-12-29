//package Tema1;

/**
 * Aceasta clasa va contine mai multi pasageri ce fac parte dintr-un singur grup
 * 
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */

public class Grup extends Entitate {

	/**
	 * Atribui unei familii 5 puncte si adun prioritatea pasagerului la familie.
	 * 
	 * @param pasager
	 */
	public Grup(Pasager pasager) {
		super.prioritate = 5;
		this.setPasager(pasager);
		prioritate += pasager.sumPriority();
	}
}
