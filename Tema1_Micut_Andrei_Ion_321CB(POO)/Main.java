//package Tema1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Clasa Main imi va deschide, citi si inchide fisierul de input si imi va crea
 * si afisa in fisierul de output
 * 
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */
public class Main {
	public static PrintStream output;

	/**
	 * Deschid, citesc, inchid fisierul de intrare si imi va crea si afisa fisierul
	 * de iesire
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */

	public static void main(String[] args) throws FileNotFoundException {

		File output_file = new File("queue.out");
		Main.output = new PrintStream(output_file);
		MainReader r = new MainReader();
		r.open();
		r.read();
		r.close();

	}

}
