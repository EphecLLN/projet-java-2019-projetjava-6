package Projet6Parking;

/**
 * @author gaeta_2b6psqs
 *
 */
public class ParkingLinkedList {
	
	private class Node{
		private Parking parking;
		private Node next;
		
		/**
		 * Constructeur d'un noeud de la structure chain�e de parking
		 * @param p le parking
		 */
		public Node(Parking p) {
			this.parking=p;
			next=null;
		}
	}
	
	private Node first; //Premier �l�ment de la liste
	private Node last; //Dernier �l�ment de la liste
	
	/**
	 * Cr�e une structure chain�e de parking en initialisant le premier et dernier noeud a null
	 * La liste ne contient alors pas encore de parking
	 */
	public ParkingLinkedList() {
		first=null;
		last=null;
	}
	
	/**
	 * Ajoute un parking � la fin de la structure chain�e
	 * @param p le parking � ajouter dans la structure
	 */
	public void enqueue(Parking p) {
		Node newNode = new Node(p);
		if(isEmpty()) { //Si pas d'�l�ment dans la structure => le nouveau noeud est le premier et le dernier
			first = newNode;
			last = newNode;
		}
		else if(first==last) { //s'il y a un seul �l�ment
			first.next=newNode;
			last=newNode;
		}
		else { //S'il y a plus d'un �l�ment
			last.next=newNode;
			last=newNode;			
		}
	}
	
	
	/**
	 * Retire le premier �l�ment de la structure chain�e
	 * @return le premier parkign de la structure chain�e
	 */
	public Parking dequeue() {
		Node retour = first;
		first=first.next;
		return retour.parking;
	}
	
	/**
	 * Dis si la liste chain�e est vide
	 * @return true si pas d'�l�ment dans la structure chain�e de parking, false sinon
	 */
	public boolean isEmpty() {
		if(first==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	
	public String toString() {
		Node parcours = first;
		String retour = "";
		while(parcours!=last) {
			retour += parcours.parking.toString() + "\n";
			parcours=parcours.next;
		}
			retour +=parcours.parking.toString();
		return retour;
	}
}
