package Projet6Parking;
import java.sql.*;

/**
 * Classe faisant le lien avec la base de donnée
 * 
 * @author GORTZ Gaëtan
 * @version 2019/12/17
 */
public class DataBase {
	static ParkingLinkedList parkings;  //Liste de tous les parkings
	static ReservationLinkedList reservations; //Liste de toutes les reservations

	private static String url = "jdbc:mysql://localhost/projetparking";
	private static String login = "root";
	private static String mdp = "";

	
	/**
	 * Initialise les differents listes de donnees
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
	 * Recupere tout les parkings dans la base de donnee et les mets dans la liste chainee de parking
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
	 * Recuperes toutes les reservations de la db pour les mettre dans la structure chainee correspondante
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
	 * Recupere un utilisateur dans la base de donnee sur base de son nom
	 * @param id L'id de l'user que l'on veut
	 * @return le premier user ayant l'id donne
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
				retour = new User(rs2.getInt("idUser"), rs2.getString("username"), rs2.getString("mdp"), rs2.getString("name"), rs2.getString("firstName"), rs2.getString("phone"), rs2.getString("mail"), rs2.getString("plate"));
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
	 * Retourne la place ayant l'id passe en argument
	 * @param idPlace l'id de la place que l'on veut
	 * @return la premiere place avec l'id donne
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
			
			String sql = "SELECT * FROM place WHERE place.idPlace=" + idPlace;
			rs3 = st3.executeQuery(sql);
			if(rs3.first()) {
				retour = new Place(rs3.getInt("idPlace"), getParking(rs3.getInt("idParking")), rs3.getInt("number"));
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
	 * Retourne le parking ayant l'id passe en argument
	 * @param idParking l'id du parking que l'on veut
	 * @return le parking ayant l'id donne
	 */
	 public static Parking getParking(int idParking) {
			Connection cn4 = null;
			Statement st4 = null;
			ResultSet rs4 = null;
			
			Parking retour = new Parking();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn4 = DriverManager.getConnection(url, login, mdp);
				st4 = cn4.createStatement();
				
				String sql = "SELECT * FROM parking WHERE parking.idParking=" + idParking;
				rs4 = st4.executeQuery(sql);
				if(rs4.first()) {
					retour = new Parking(rs4.getInt("idParking"), rs4.getString("name"), rs4.getString("position"), rs4.getInt("placeTot"), rs4.getInt("placeDispo"), rs4.getString("type"));
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
					cn4.close();
					st4.close();

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
