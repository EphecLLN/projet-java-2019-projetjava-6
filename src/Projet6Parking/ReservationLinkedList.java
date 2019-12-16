package Projet6Parking;


/**
 * @author gaeta_2b6psqs
 *
 */
public class ReservationLinkedList {
	
	private class Node{
		private Reservation reservation;
		private Node next;
		
		/**
		 * Constructeur d'un noeud de la structure chain�e de parking
		 * @param p le parking
		 */
		public Node(Reservation r) {
			this.reservation=r;
			next=null;
		}
	}
	
	private Node first; //Premier �l�ment de la liste
	private Node last; //Dernier �l�ment de la liste
	
	/**
	 * Cr�e une liste chain�e de reservation avec les premier et le dernier noeud a null
	 * Cette liste ne contient pas encore de reservation
	 */
	public ReservationLinkedList() {
		first=null;
		last=null;
	}
	
	/**
	 * Ajoute une r�servation � la fin de la structure chain�e
	 * @param r la r�servation � ajouter dans la structure
	 */
	public void enqueue(Reservation r) {
		Node newNode = new Node(r);
		if(isEmpty()) { //Si pas d'�l�ment dans la structure => le nouveau noeud est le premier et le dernier
			first = newNode;
			last = newNode;
		}
		else if(first==last) { //s'il y a un seul �l�ment
			first.next=newNode;
			last=newNode;
		}
		else { //S'il y a plus d'un �l�ment on le met a la fin
			last.next=newNode;
			last=newNode;			
		}
	}
	
	
	/**
	 * Retire le premier �l�ment de la structure chain�e
	 * @return la premi�re r�servation de la structure chain�e
	 */
	public Reservation dequeue() {
		Node retour = first;
		first=first.next;
		return retour.reservation;
	}
	
	/**
	 * Dis si la liste chain�e est vide
	 * @return true si pas d'�l�ment dans la structure chain�e de r�servation, false sinon
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
		String retour="";
		Node parcours=first;
		while(parcours!=last) {
			retour+=parcours.reservation.toString()+"\n";
			parcours=parcours.next;
		}
		retour+=parcours.reservation.toString();
		return retour;
	}

}
