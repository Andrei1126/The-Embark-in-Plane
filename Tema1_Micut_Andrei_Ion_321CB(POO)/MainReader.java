//package Tema1;

import java.io.*;
import java.util.Scanner;

/**
 * Clasa MainReader este cea care imi face legatura cu fisierul de intrare si
 * imi citeste fiecare cuvant sau litera in parte si se duce pe cazul respectiv
 * 
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */

public class MainReader {

	Pasager pasageri;
	private Scanner x;

	/**
	 * Incerc sa deschid fisierul de input, iar daca nu reusesc se va afisa "could
	 * not find file"
	 */

	public void open() {
		try {
			x = new Scanner(new File("queue.in"));
		}

		catch (Exception e) {
			System.out.println("could not find file");
		}
	}

	/**
	 * Citeste informatiile despre pasager
	 * 
	 * @return pasagerul citit
	 */

	public Pasager citeste_pasager() {
		String id = x.next();
		String nume = x.next();
		String v = x.next();
		int varsta = Integer.parseInt(v);
		String t_b = x.next();
		char tip_bilet = t_b.charAt(0);
		String i_p = x.next();
		boolean imbarcare_prioritara = Boolean.parseBoolean(i_p);
		String n_s = x.next();
		boolean nevoi_speciale = Boolean.parseBoolean(n_s);
		Pasager pasager = new Pasager(id, nume, varsta, tip_bilet, imbarcare_prioritara, nevoi_speciale);
		Pasager.setNr_pasageri(Pasager.getNr_pasageri() + 1);
		return pasager;
	}

	/**
	 * Intra pe cazurile aferente
	 * 
	 * @throws NullPointerException
	 */

	public void read() throws NullPointerException {

		String y = x.nextLine();
		int numar_pasageri = Integer.parseInt(y);
		Imbarcare imbarcare = new Imbarcare();

		for (int i = 0; i < numar_pasageri; i++) {
			Pasager pasager = citeste_pasager();
			imbarcare.adaugare(pasager);
			imbarcare.setHarta(pasager);
		}

		while (x.hasNext()) {

			String id1 = x.next();
			if (id1.equals("insert")) {
				id1 = x.next();
				imbarcare.inserare(id1);
			} else if (id1.equals("embark")) {
				imbarcare.getHeap().embark();
			} else if (id1.equals("list")) {
				imbarcare.getHeap().list();

				if (x.hasNext()) {

					Main.output.println();
				}
			} else if (id1.equals("delete")) {

				id1 = x.nextLine();

				String[] sir = id1.split(" ");
				if (sir.length == 2) {
					imbarcare.getHeap().delete(sir[1]);
				} else {
					imbarcare.getHeap().delete(sir[1], sir[2]);
				}
			}
		}

	}

	/**
	 * Inchide fisierul de intrare
	 */

	public void close() {
		x.close();
	}

}
