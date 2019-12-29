//package Tema1;

/**
 * Clasa Singur este aferenta unui pasager. In aceasta clasa ii atribui
 * pasagerului prioritatea sa.
 * 
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */

public class Singur extends Entitate {

	public Singur(Pasager pasager) {
		this.setPasager(pasager);
		setPrioritate();
	}

	/**
	 * Prioritatea pasagerului singur
	 */

	void setPrioritate() {
		prioritate = getPasager().sumPriority();
	}

	/**
	 * 
	 * @param pasager
	 */
}
