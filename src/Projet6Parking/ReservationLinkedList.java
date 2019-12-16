package Projet6Parking;


/**
 * Structure chainee permettant d'enregistrer les modifications faites sur les reservations
 * 
 * @author GORTZ Gaëtan
 * @version 2019-12-17
 */
public class ReservationLinkedList {
	
	/**
	 * Classe permettant de creer un Node necessaire a la structure chainee
	 *
	 */
	private class Node{
		private Reservation reservation;
		private Node next;
		
		/**
		 * Constructeur d'un noeud de la structure chainee de parking
		 * @param p le parking
		 */
		public Node(Reservation r) {
			this.reservation=r;
			next=null;
		}
	}
	
	//Variables d'instance
	private Node first; //Premier element de la liste
	private Node last; //Dernier element de la liste
	
	//Methodes
	/**
	 * Cree une liste chainee de reservation avec les premier et le dernier noeud a null
	 * Cette liste ne contient pas encore de reservation
	 */
	public ReservationLinkedList() {
		first=null;
		last=null;
	}
	
	/**
	 * Ajoute une reservation a la fin de la structure chainee
	 * @param r la reservation a ajouter dans la structure
	 */
	public void enqueue(Reservation r) {
		Node newNode = new Node(r);
		if(isEmpty()) { //Si pas d'element dans la structure => le nouveau noeud est le premier et le dernier
			first = newNode;
			last = newNode;
		}
		else if(first==last) { //s'il y a un seul element
			first.next=newNode;
			last=newNode;
		}
		else { //S'il y a plus d'un element on le met a la fin
			last.next=newNode;
			last=newNode;			
		}
	}
	
	
	/**
	 * Retire le premier element de la structure chainee
	 * @return la premiere reservation de la structure chainee
	 */
	public Reservation dequeue() {
		Node retour = first;
		first=first.next;
		return retour.reservation;
	}
	
	/**
	 * Dis si la liste chainee est vide
	 * @return true si pas d'element dans la structure chainee de reservation, false sinon
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
	 * Methode toString permettant d'afficher sous forme d'une chaine de caracteres l'objet
	 * @return une chaine de caracteres representant l'objet
	 */
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
