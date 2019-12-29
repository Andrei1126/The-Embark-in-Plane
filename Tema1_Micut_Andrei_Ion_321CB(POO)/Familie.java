//package Tema1;

/**
 * Aceasta clasa va contine mai multi pasageri ce fac parte dintr-o singura
 * familie
 * 
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */

public class Familie extends Entitate {

	public Familie(Pasager pasager) {
		super.prioritate = 10;
		this.setPasager(pasager);
	}
}
