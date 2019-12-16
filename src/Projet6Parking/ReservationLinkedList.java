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
		 * Constructeur d'un noeud de la structure chainée de parking
		 * @param p le parking
		 */
		public Node(Reservation r) {
			this.reservation=r;
			next=null;
		}
	}
	
	private Node first; //Premier élément de la liste
	private Node last; //Dernier élément de la liste
	
	/**
	 * Crèe une liste chainée de reservation avec les premier et le dernier noeud a null
	 * Cette liste ne contient pas encore de reservation
	 */
	public ReservationLinkedList() {
		first=null;
		last=null;
	}
	
	/**
	 * Ajoute une réservation à la fin de la structure chainée
	 * @param r la réservation à ajouter dans la structure
	 */
	public void enqueue(Reservation r) {
		Node newNode = new Node(r);
		if(isEmpty()) { //Si pas d'élément dans la structure => le nouveau noeud est le premier et le dernier
			first = newNode;
			last = newNode;
		}
		else if(first==last) { //s'il y a un seul élément
			first.next=newNode;
			last=newNode;
		}
		else { //S'il y a plus d'un élément on le met a la fin
			last.next=newNode;
			last=newNode;			
		}
	}
	
	
	/**
	 * Retire le premier élément de la structure chainée
	 * @return la première réservation de la structure chainée
	 */
	public Reservation dequeue() {
		Node retour = first;
		first=first.next;
		return retour.reservation;
	}
	
	/**
	 * Dis si la liste chainée est vide
	 * @return true si pas d'élément dans la structure chainée de réservation, false sinon
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
