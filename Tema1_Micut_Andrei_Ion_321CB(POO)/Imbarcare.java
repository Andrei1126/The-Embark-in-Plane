//package Tema1;

/**
 * In aceasta clasa realizez adaugarea in vectorul de familii si prioritatea
 * in vectorul de prioritati, iar apoi inserez prioritatea entitatilor in heap
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */

import java.util.HashMap;

/**
 * In aceasta clasa realizez vectorii de familii, grupuri si singur si vectorii
 * prioritatilor entitatilor in care introduc fiecare prioritatea pentru fiecare
 * eentitate in parte in vectorul corepunzator si prioritatea in entitatea
 * corespunzatoare, de asemenea.
 * 
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */

public class Imbarcare {

	private Familie[] familie;
	private int[] fam_prioritate;
	private int size_familie;
	private Grup[] grup;
	private int[] grup_prioritate;
	private int size_grup;
	private Singur[] singur;
	private int[] sg_prioritate;
	private int size_singur;
	private Heap heap;
	private HashMap<String, Integer> harta;
	public static Imbarcare instanta;

	/**
	 * Construiesc si initializez vectorii pentru entitati si prioritati
	 */

	public Imbarcare() {
		familie = new Familie[0];
		grup = new Grup[0];
		singur = new Singur[0];
		fam_prioritate = new int[0];
		grup_prioritate = new int[0];
		sg_prioritate = new int[0];
		heap = new Heap();
		harta = new HashMap<String, Integer>();
		instanta = this;
	}

	static Imbarcare getInstanta() {
		return instanta;
	}

	/**
	 * 
	 * @return prioritatea familie
	 */

	public int[] getFam_prioritate() {
		return fam_prioritate;
	}

	/**
	 * Seter pentru prioritatea familiei
	 * 
	 * @param fam_prioritate de tipul intreg
	 */

	public void setFam_prioritate(int[] fam_prioritate) {
		this.fam_prioritate = fam_prioritate;
	}

	/**
	 * 
	 * @return dimensiunea familiei
	 */

	public int getSize_familie() {
		return size_familie;
	}

	/**
	 * Seter pentru dimensiunea familiei
	 * 
	 * @param size_familie de tipul intreg
	 */

	public void setSize_familie(int size_familie) {
		this.size_familie = size_familie;
	}

	/**
	 * 
	 * @return prioritatea familie
	 */

	public int[] getGrup_prioritate() {
		return grup_prioritate;
	}

	/**
	 * Seter pentru prioritatea grupului
	 * 
	 * @param grup_prioritate de tipul intreg
	 */

	public void setGrup_prioritate(int[] grup_prioritate) {
		this.grup_prioritate = grup_prioritate;
	}

	/**
	 * 
	 * @return dimensiunea grupului
	 */

	public int getSize_grup() {
		return size_grup;
	}

	/**
	 * Seter pentru dimensiunea grupului
	 * 
	 * @param size_grup de tipul intreg
	 */

	public void setSize_grup(int size_grup) {
		this.size_grup = size_grup;
	}

	/**
	 * 
	 * @return prioritatea singurului
	 */

	public int[] getSg_prioritate() {

		return sg_prioritate;
	}

	/**
	 * Seter pentru prioritatea singurului
	 * 
	 * @param sg_prioritate este de tipul intreg
	 */

	public void setSg_prioritate(int[] sg_prioritate) {
		this.sg_prioritate = sg_prioritate;
	}

	/**
	 * 
	 * @return dimensiunea singurului
	 */

	public int getSize_singur() {
		return size_singur;
	}

	/**
	 * Seter pentru dimensiunea singurului
	 * 
	 * @param size_singur de tipul intreg
	 */

	public void setSize_singur(int size_singur) {
		this.size_singur = size_singur;
	}

	/**
	 * 
	 * @return familie
	 */

	public Familie[] getFamilie() {
		return familie;
	}

	/**
	 * Seter pentru familie
	 * 
	 * @param familie de tipul Familie
	 */

	public void setFamilie(Familie[] familie) {
		this.familie = familie;
	}

	/**
	 * 
	 * @return grup
	 */

	public Grup[] getGrup() {
		return grup;
	}

	/**
	 * Seter pentru grup
	 * 
	 * @param grup de tipul Grup
	 */

	public void setGrup(Grup[] grup) {
		this.grup = grup;
	}

	/**
	 * 
	 * @return singur
	 */

	public Singur[] getSingur() {
		return singur;
	}

	/**
	 * Seter pentru singur
	 * 
	 * @param singur de tipul Singur
	 */

	public void setSingur(Singur[] singur) {
		this.singur = singur;
	}

	/**
	 * 
	 * @return heap
	 */

	public Heap getHeap() {
		return heap;
	}

	/**
	 * Seter pentru heap
	 * 
	 * @param heap de tipul Heap
	 */

	public void setHeap(Heap heap) {
		this.heap = heap;
	}

	/**
	 * 
	 * @return harta
	 */

	public HashMap<String, Integer> getHarta() {
		return harta;
	}

	/**
	 * Seter pentru HashMap in care introduc id-ul passagerului si prioritatea sa
	 * 
	 * @param pasager de tipul Pasager
	 */

	public void setHarta(Pasager pasager) {
		this.harta.put(pasager.getId() + " " + pasager.getNume(), new Integer(pasager.sumPriority()));
	}

	/**
	 * Realizez adaugarea in vectorul corespunzator si prioritatea in vectorul de
	 * prioritati al entitatii respective
	 * 
	 * @param pasager
	 */

	public void adaugare(Pasager pasager) {

		boolean era = false;
		if (pasager.getId().charAt(0) == 'f') {
			for (int i = 0; i < size_familie; i++) {
				if (familie[i].getPasager().getId().equals(pasager.getId())) {
					era = true;
					familie[i].prioritate += pasager.sumPriority();
					fam_prioritate[i] += pasager.sumPriority();
				}
			}
			if (era == false) {
				Familie[] familie1 = new Familie[size_familie + 1];
				for (int i = 0; i < size_familie; i++)
					familie1[i] = familie[i];
				familie1[familie.length] = new Familie(pasager);
				familie = familie1;
				size_familie++;

				int[] fam_prioritate1 = new int[fam_prioritate.length + 1];
				for (int i = 0; i < fam_prioritate.length; i++)
					fam_prioritate1[i] = fam_prioritate[i];
				fam_prioritate1[fam_prioritate.length] = pasager.sumPriority();
				fam_prioritate = fam_prioritate1;

			}
		}

		if (pasager.getId().charAt(0) == 'g') {
			for (int i = 0; i < size_grup; i++) {
				if (grup[i].getPasager().getId().equals(pasager.getId())) {
					era = true;
					grup[i].prioritate += pasager.sumPriority();
					grup_prioritate[i] += pasager.sumPriority();
					grup[i].setPasager(pasager);
				}

			}
			if (era == false) {
				Grup[] grup1 = new Grup[size_grup + 1];
				for (int i = 0; i < size_grup; i++)
					grup1[i] = grup[i];
				grup1[grup.length] = new Grup(pasager);
				grup = grup1;
				size_grup++;

				int[] grup_prioritate1 = new int[grup_prioritate.length + 1];
				for (int i = 0; i < grup_prioritate.length; i++)
					grup_prioritate1[i] = grup_prioritate[i];
				grup_prioritate1[grup_prioritate.length] = pasager.sumPriority();
				grup_prioritate = grup_prioritate1;

			}
		}

		if (pasager.getId().charAt(0) == 's') {
			Singur[] singur1 = new Singur[size_singur + 1];
			for (int i = 0; i < size_singur; i++)
				singur1[i] = singur[i];
			singur1[singur.length] = new Singur(pasager);
			singur = singur1;

			int[] sg_prioritate1 = new int[sg_prioritate.length + 1];
			for (int i = 0; i < size_singur; i++)
				sg_prioritate1[i] = sg_prioritate[i];
			sg_prioritate1[sg_prioritate.length] = pasager.sumPriority();
			sg_prioritate = sg_prioritate1;
			size_singur++;
		}
	}

	/**
	 * Inserez prioritatea entitatii in heap
	 * 
	 * @param id
	 */

	public void inserare(String id) {
		for (int i = 0; i < size_familie; i++) {
			if (familie[i].getPasager().getId().equals(id)) {
				familie[i].prioritate = fam_prioritate[i] + 10;
				heap.inserare(familie[i], fam_prioritate[i] + 10);
			}
		}

		for (int i = 0; i < size_grup; i++) {
			if (grup[i].getPasager().getId().equals(id)) {
				grup[i].prioritate = grup_prioritate[i] + 5;
				heap.inserare(grup[i], grup_prioritate[i]);

			}
		}

		for (int i = 0; i < size_singur; i++) {
			if (singur[i].getPasager().getId().equals(id)) {
				singur[i].prioritate = sg_prioritate[i];
				heap.inserare(singur[i], sg_prioritate[i]);

			}
		}
	}
}