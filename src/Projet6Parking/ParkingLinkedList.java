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
		 * Constructeur d'un noeud de la structure chainée de parking
		 * @param p le parking
		 */
		public Node(Parking p) {
			this.parking=p;
			next=null;
		}
	}
	
	private Node first; //Premier élément de la liste
	private Node last; //Dernier élément de la liste
	
	/**
	 * Crée une structure chainée de parking en initialisant le premier et dernier noeud a null
	 * La liste ne contient alors pas encore de parking
	 */
	public ParkingLinkedList() {
		first=null;
		last=null;
	}
	
	/**
	 * Ajoute un parking à la fin de la structure chainée
	 * @param p le parking à ajouter dans la structure
	 */
	public void enqueue(Parking p) {
		Node newNode = new Node(p);
		if(isEmpty()) { //Si pas d'élément dans la structure => le nouveau noeud est le premier et le dernier
			first = newNode;
			last = newNode;
		}
		else if(first==last) { //s'il y a un seul élément
			first.next=newNode;
			last=newNode;
		}
		else { //S'il y a plus d'un élément
			last.next=newNode;
			last=newNode;			
		}
	}
	
	
	/**
	 * Retire le premier élément de la structure chainée
	 * @return le premier parkign de la structure chainée
	 */
	public Parking dequeue() {
		Node retour = first;
		first=first.next;
		return retour.parking;
	}
	
	/**
	 * Dis si la liste chainée est vide
	 * @return true si pas d'élément dans la structure chainée de parking, false sinon
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
