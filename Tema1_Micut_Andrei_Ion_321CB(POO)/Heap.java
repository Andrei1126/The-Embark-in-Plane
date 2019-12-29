//package Tema1;
/**
 * Construiesc heap-ul
 * 
 * @author Micut Andrei-Ion, Grupa 321CB
 *
 */

public class Heap {
	private Entitate[] heap;
	private int size;

	public Heap() {
		this.size = 0;
		heap = new Entitate[1];
	}

	/**
	 * Verific daca nodul este frunza
	 * 
	 * @param poz
	 * @return true sau fals
	 */

	private boolean Este_Frunza(int poz) {
		int frunza;
		if (size == 1)
			frunza = 1;
		else
			frunza = size / 2;
		if (poz >= frunza)
			return true;
		return false;
	}

	/**
	 * Intorc parintele nodului de pe pozitia poz
	 * 
	 * @param poz
	 * @return pozitia parintelui
	 */

	public int parinte(int poz) {
		return (poz - 1) / 2;
	}

	/**
	 * Realizez interschimbarea nodurilor
	 * 
	 * @param poz1
	 * @param poz2
	 */

	private void swap(int poz1, int poz2) {
		Entitate aux;
		aux = heap[poz1];
		heap[poz1] = heap[poz2];
		heap[poz2] = aux;
	}

	/**
	 * Realizez inserarea in heap
	 * 
	 * @param entitate
	 * @param prioritate
	 */

	public void inserare(Entitate entitate, int prioritate) {
		if (this.size == 0) {
			if (heap == null) {
				heap = new Entitate[1];
			}
			heap[0] = entitate;
			this.size++;
			return;
		}

		Entitate[] new_heap = new Entitate[this.size + 1];

		for (int i = 0; i < heap.length; i++)
			new_heap[i] = heap[i];

		new_heap[this.size++] = entitate;
		heap = new_heap;

		int curent = heap.length - 1;

		while (heap[curent].getPrioritate() > heap[parinte(curent)].getPrioritate()) {

			swap(curent, parinte(curent));
			curent = parinte(curent);
		}

	}

	/**
	 * Realizez extragerea radacinii
	 */

	public void embark() {
		if (size == 1) {
			Entitate[] new_heap = new Entitate[1];
			heap = new_heap;
			size = 0;
			return;
		}

		heap[0] = heap[this.size - 1];

		Entitate[] new_heap = new Entitate[this.size - 1];

		for (int i = 0; i < heap.length - 1; i++)
			new_heap[i] = heap[i];

		heap = new_heap;

		this.size--;

		if (size != 1)
			MaxHeap(0);
	}

	/**
	 * Construiesc heap-ul
	 * 
	 * @param curent
	 */

	private void MaxHeap(int curent) {
		while (Este_Frunza(curent) == false) {
			if (2 * curent + 2 >= size) {
				if (heap[curent].getPrioritate() <= heap[2 * curent + 1].getPrioritate()) {
					swap(curent, 2 * curent + 1);
					curent = 2 * curent + 1;
				} else
					break;
			} else if (!(heap[curent].getPrioritate() >= heap[2 * curent + 1].getPrioritate()
					&& heap[curent].getPrioritate() >= heap[2 * curent + 2].getPrioritate())) {
				if (heap[2 * curent + 1].getPrioritate() >= heap[2 * curent + 2].getPrioritate()) {
					swap(curent, 2 * curent + 1);
					curent = 2 * curent + 1;
				} else {
					swap(curent, 2 * curent + 2);
					curent = 2 * curent + 2;
				}
			} else {
				break;
			}
		}
	}

	/**
	 * Afisez elementul din heap de pe pozitia poz
	 * 
	 * @param poz
	 */
	public void afisare(int poz) {
		if (heap.length - poz - 1 < 0)
			return;
		if (poz == 0)
			Main.output.print(heap[poz]);
		else if (poz != 0)
			Main.output.print(" " + heap[poz]);

		afisare(2 * poz + 1);
		afisare(2 * poz + 2);
	}

	/**
	 * Voi realiza stergerea unui pasager in functie de numele sau din entitate
	 * comparand id-ul din heap cu cel primit ca parametru, recarculez prioritatea
	 * entitatii din heap, iar apoi resortez heap-ul
	 * 
	 * @param entitate de tipul String
	 * @param id       de tipul String
	 */

	public void delete(String entitate, String id) {
		String nume_complet = entitate + " " + id;
		Entitate tinta = null;
		int pos = 0;
		for (int i = 0; i < heap.length; i++) {
			if (heap[i].getPasager().getId().equals(entitate)) {
				tinta = heap[i];
				pos = i;
				break;
			}
		}
		if (tinta == null)
			return;
		int decrement = Imbarcare.getInstanta().getHarta().get(nume_complet);
		tinta.setPrioritate(tinta.getPrioritate() - decrement);
		MaxHeap(pos);
	}

	/**
	 * Realizez stergerea entitatii din heap prin compararea entitatii primite ca
	 * parametru cu cea din heap, iar daca sunt egale, atunci voi interschimba
	 * radacina cu nodul in care se gaseste id-ul entitatii
	 * 
	 * @param entitate este de tipul String
	 */

	public void delete(String entitate) {
		for (int i = 0; i < heap.length; i++) {
			if (heap[i].getPasager().getId().equals(entitate)) {

				swap(0, i);
				break;
			}
		}
		embark();
	}

	/**
	 * Apelez functia recursiva pentru radacina
	 */

	public void list() {
		afisare(0);
	}

}
