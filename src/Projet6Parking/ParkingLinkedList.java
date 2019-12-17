package Projet6Parking;

/**
 * @author GORTZ Gaëtan
 * @version 2019/12/17
 *
 */
public class ParkingLinkedList {
	
	private class Node{
		private Parking parking;
		private Node next;
		
		/**
		 * Constructeur d'un noeud de la structure chainee de parking
		 * @param p le parking
		 */
		public Node(Parking p) {
			this.parking=p;
			next=null;
		}
	}
	
	private Node first; //Premier element de la liste
	private Node last; //Dernier element de la liste
	
	/**
	 * Cree une structure chainee de parking en initialisant le premier et dernier noeud a null
	 * La liste ne contient alors pas encore de parking
	 */
	public ParkingLinkedList() {
		first=null;
		last=null;
	}
	
	/**
	 * Ajoute un parking a la fin de la structure chainee
	 * @param p le parking a ajouter dans la structure
	 */
	public void enqueue(Parking p) {
		Node newNode = new Node(p);
		if(isEmpty()) { //Si pas d'element dans la structure => le nouveau noeud est le premier et le dernier
			first = newNode;
			last = newNode;
		}
		else if(first==last) { //s'il y a un seul element
			first.next=newNode;
			last=newNode;
		}
		else { //S'il y a plus d'un element
			last.next=newNode;
			last=newNode;			
		}
	}
	
	
	/**
	 * Retire le premier element de la structure chainee
	 * @return le premier parkign de la structure chainee
	 */
	public Parking dequeue() {
		Node retour = first;
		first=first.next;
		return retour.parking;
	}
	
	/**
	 * Dis si la liste chainee est vide
	 * @return true si pas d'element dans la structure chainee de parking, false sinon
	 */
	public boolean isEmpty() {
		if(first==null) {
			return true;
		}
		else {
			return false;
		}
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
