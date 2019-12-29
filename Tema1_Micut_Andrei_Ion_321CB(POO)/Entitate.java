//package Tema1;

/**
 * Aceasta clasa este supraclasa familiilor, grupurilor si singurilor.
 * 
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */

public abstract class Entitate {

	protected int prioritate;
	private Pasager pasager;

	/**
	 * Constructorul entitatii
	 */
	public Entitate() {

	}

	/**
	 * 
	 * @return pasager
	 */

	public Pasager getPasager() {
		return pasager;
	}

	/**
	 * 
	 * @param pasager de tipul Pasager
	 */

	public void setPasager(Pasager pasager) {
		this.pasager = pasager;
	}

	/**
	 * 
	 * @return prioritate
	 */

	public int getPrioritate() {
		return prioritate;
	}

	/**
	 * 
	 * @param prioritate de tipul intreg
	 */
	public void setPrioritate(int prioritate) {
		this.prioritate = prioritate;
	}

	/**
	 * Suprascriu metoda String si returnez id-ul
	 */
	public String toString() {
		return this.getPasager().getId();
	}
}
