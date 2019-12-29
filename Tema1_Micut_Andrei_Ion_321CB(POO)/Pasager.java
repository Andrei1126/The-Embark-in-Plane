//package Tema1;

/**
 * Aceasta clasa contine caracteristicile pasagerului, inclusiv calcularea
 * prioritatii.
 * 
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */

public class Pasager {

	private static int nr_pasageri;
	private String id;
	private String nume;
	private int varsta;
	private char tip_bilet;
	private boolean imbarcare_prioritara;
	private boolean nevoi_speciale;

	/**
	 * 
	 * @param id
	 * @param nume
	 * @param varsta
	 * @param tip_bilet
	 * @param imbarcare_prioritara
	 * @param nevoi_speciale
	 * 
	 *                             Construieste si initializeaza toate campurile
	 *                             clasei Pasager, mai putin numarul de pasageri.
	 */
	public Pasager(String id, String nume, int varsta, char tip_bilet, boolean imbarcare_prioritara,
			boolean nevoi_speciale) {
		this.id = id;
		this.nume = nume;
		this.varsta = varsta;
		this.tip_bilet = tip_bilet;
		this.imbarcare_prioritara = imbarcare_prioritara;
		this.nevoi_speciale = nevoi_speciale;
	}

	/**
	 * 
	 * @return id
	 */

	public String getId() {
		return id;
	}

	/**
	 * Seter pentru id
	 * 
	 * @param id de tipul String
	 */

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return nume
	 */

	public String getNume() {
		return nume;
	}

	/**
	 * Seter pentru nume
	 * 
	 * @param nume de tipul String
	 */

	public void setNume(String nume) {
		this.nume = nume;
	}

	/**
	 * 
	 * @return varsta
	 */

	public int getVarsta() {
		return varsta;
	}

	/**
	 * Seter pentru varsta
	 * 
	 * @param varsta de tipul intreg
	 */

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	/**
	 * 
	 * @return tipul biletului
	 */

	public char getTip_bilet() {
		return tip_bilet;
	}

	/**
	 * Seter pentru tipul biletului
	 * 
	 * @param tip_bilet de tipul char
	 */

	public void setTip_bilet(char tip_bilet) {
		this.tip_bilet = tip_bilet;
	}

	/**
	 * 
	 * @return imbarcarea prioritara
	 */

	public boolean isImbarcare_prioritara() {
		return imbarcare_prioritara;
	}

	/**
	 * Seter pentru imbarcarea prioritara
	 * 
	 * @param imbarcare_prioritara de tipul boolean
	 */

	public void setImbarcare_prioritara(boolean imbarcare_prioritara) {
		this.imbarcare_prioritara = imbarcare_prioritara;
	}

	/**
	 * 
	 * @return nevoi speciale
	 */

	public boolean isNevoi_speciale() {
		return nevoi_speciale;
	}

	/**
	 * Seter pentru nevoi speciale
	 * 
	 * @param nevoi_speciale de tipul boolean
	 */

	public void setNevoi_speciale(boolean nevoi_speciale) {
		this.nevoi_speciale = nevoi_speciale;
	}

	/**
	 * 
	 * @return numarul de pasageri
	 */

	public static int getNr_pasageri() {
		return nr_pasageri;
	}

	/**
	 * Seter pentru numar de pasageri
	 * 
	 * @param nr_pasageri de tipul intreg
	 */

	public static void setNr_pasageri(int nr_pasageri) {
		Pasager.nr_pasageri = nr_pasageri;
	}

	/**
	 * Calculez prioritatea pentru fiecare pasager
	 * 
	 * @return sum(suma prioritatii)
	 */

	int sumPriority() {
		int sum = 0;

		if (this.varsta >= 0 && this.varsta < 2)
			sum += 20;
		else if (this.varsta >= 2 && this.varsta < 5) {
			sum += 10;
		} else if (this.varsta >= 5 && this.varsta < 10) {
			sum += 5;
		} else if (this.varsta >= 10 && this.varsta < 60) {
			sum += 0;
			// System.out.println(this.getId());
		} else if (this.varsta >= 60) {
			sum += 15;
		}

		if (this.tip_bilet == 'b') {
			sum += 35;
		} else if (this.tip_bilet == 'p') {
			sum += 20;
		} else if (this.tip_bilet == 'e') {
			sum += 0;
		}

		if (this.imbarcare_prioritara == true)
			sum += 30;
		else if (this.imbarcare_prioritara == false) {
			sum += 0;
			// System.out.println(this.getId());
		}

		if (this.nevoi_speciale == true)
			sum += 100;
		else {
			sum += 0;
		}

		return sum;
	}
}
