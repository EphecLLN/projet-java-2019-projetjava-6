/**
 * 
 */
package Projet6Parking;

/**
 * Classe permettant de gérer les places des parkings
 * 
 * @author Nathan DE LEENER - HE201742
 * @version 2019/11/12
 *
 */
public class Place {
	
	//Variables d'instance
	
	private int dbId;			//Numero global de la place dans la DB
	private int number;			//Numero de la place dans le parking
	private int parkingId;		//Numero du parking
	private boolean booked;		//Etat de la reservation de la place 
	
	
	//Constructeur(s)
	
	public Place(int dbId, int number, int parkingId) {
		this.dbId = dbId;
		this.number = number;
		this.parkingId = parkingId;
		this.booked = false;
	}

	
	//Getters & Setters
	
	/**
	 * @return the dbId
	 */
	public int getDbId() {
		return dbId;
	}

	/**
	 * @param dbId the dbId to set
	 */
	public void setDbId(int dbId) {
		this.dbId = dbId;
	}

	/**
	 * @return the parkingId
	 */
	public int getParkingId() {
		return parkingId;
	}

	/**
	 * @param parkingId the parkingId to set
	 */
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}

	/**
	 * @return the booked
	 */
	public boolean isBooked() {
		return booked;
	}

	/**
	 * @param booked the booked to set
	 */
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	
	//Méthodes
	
	public boolean isFree() {
		return booked;
	}
	
	/**
	 * 
	 * @param dbId
	 * @return
	 */
	public Place getPlace(int dbId) {
		// Requete SQL : SELECT "var_instance_place" FROM "Place" WHERE "idPlace" = "dbId"
		// Traitement des resultats pour creer un objet Place
		Place r = new Place(dbId, dbId, dbId);		//int venant du traitement fait à la ligne precedente
		return r;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
