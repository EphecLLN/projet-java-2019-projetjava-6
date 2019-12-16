package Projet6Parking;
import java.sql.*;

/**
 * @author gaeta_2b6psqs
 *
 */
public class DataBase {
	static ParkingLinkedList parkings;  //Liste de tous les parkings
	static ReservationLinkedList reservations; //Liste de toutes les r�servations

	private static String url = "jdbc:mysql://localhost/projetparking";
	private static String login = "root";
	private static String mdp = "";

	
	/**
	 * Initialise les diff�rents listes de donn�es
	 */
	public static void initialisationDonnees() {
		parkings = new ParkingLinkedList();
		getAllParking();
		reservations = new ReservationLinkedList();
		getAllReservation();
	}
	
	
	public void sauvegarde() {
		
	}
	
	/**
	 * R�cup�re tout les parkings dans la base de donn�e et les mets dans la liste chain�e de parking
	 */
	public static void getAllParking() {
		Connection cn0 = null;
		Statement st0 = null;
		ResultSet rs0 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn0 = DriverManager.getConnection(url, login, mdp);
			st0 = cn0.createStatement();
			
			String sql = "SELECT * FROM parking";
			rs0 = st0.executeQuery(sql);
			while(rs0.next()) {
				Parking p = new Parking(rs0.getInt("idParking"), rs0.getString("name"), rs0.getString("position"), rs0.getInt("placeTot"), rs0.getInt("placeDispo"), rs0.getString("type"));
				parkings.enqueue(p);
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn0.close();
				st0.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * R�cup�res toutes les r�servations de la db pour les mettre dans la structure chain�e correspondante
	 */
	public static void getAllReservation() {
		Connection cn1 = null;
		Statement st1 = null;
		ResultSet rs1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn1 = DriverManager.getConnection(url, login, mdp);
			st1 = cn1.createStatement();
						
			String sql = "SELECT * FROM reservation";
			rs1 = st1.executeQuery(sql);
			while(rs1.next()) {
				Reservation r = new Reservation(rs1.getInt("idReservation"),getPlace(rs1.getInt("idPlace")), getUser(rs1.getInt("idUser")));
				reservations.enqueue(r);
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn1.close();
				st1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	/**
	 * R�cup�re un utilisateur dans la base de donn�e sur base de son nom
	 * @param id L'id de l'user que l'on veut
	 * @return le premier user ayant l'id donn�
	 */	
	public static User getUser(int id) {
		Connection cn2 = null;
		Statement st2 = null;
		ResultSet rs2 = null;
		
		User retour = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn2 = DriverManager.getConnection(url, login, mdp);
			st2 = cn2.createStatement();
			
			String sql = "SELECT * FROM users WHERE users.idUser=" + id;
			rs2 = st2.executeQuery(sql);
			if(rs2.first()) {
				retour = new User(rs2.getInt("idUser"), rs2.getString("name"), rs2.getString("firstName"), rs2.getString("phone"), rs2.getString("mail"), rs2.getString("plate"));
			}
			//else {
			//	System.out.println("Aucun resultat");
			//}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn2.close();
				st2.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	
	/**
	 * Retourne la place ayant l'id pass� en argument
	 * @param idPlace l'id de la place que l'on veut
	 * @return la premi�re place avec l'id donn�
	 */
	public static Place getPlace(int idPlace) {
		Connection cn3 = null;
		Statement st3 = null;
		ResultSet rs3 = null;
		
		Place retour = new Place();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn3 = DriverManager.getConnection(url, login, mdp);
			st3 = cn3.createStatement();
			
			Parking parking1 = new Parking(-1, "vide", "vide", 15, 15, "vide");
			
			String sql = "SELECT * FROM place WHERE place.idPlace=" + idPlace;
			rs3 = st3.executeQuery(sql);
			if(rs3.first()) {
				retour = new Place(rs3.getInt("idPlace"), parking1, rs3.getInt("number"));
			}
			//else {
			//	System.out.println("Aucun resultat");
			//}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn3.close();
				st3.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	 
	 
	 
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialisationDonnees();
		System.out.println(parkings);
		System.out.println(reservations);
		
		User u = getUser(3);
		System.out.println(u);
		
	}

}
