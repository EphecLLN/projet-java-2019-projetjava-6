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
	static Connection cn = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	/**
	 * Initialise les diff�rents listes de donn�es
	 */
	public static void initialisationDonnees() {
		parkings = new ParkingLinkedList();
		getAllParking();
		reservations = new ReservationLinkedList(); 
	}
	
	
	public void sauvegarde() {
		
	}
	
	/**
	 * R�cup�re tout les parkings dans la base de donn�e et les mets dans la liste chain�e de parking
	 */
	public static void getAllParking() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, mdp);
			st = cn.createStatement();
			
			String sql = "SELECT * FROM parking";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Parking p = new Parking(rs.getInt("idParking"), rs.getString("name"), rs.getString("position"), rs.getInt("placeTot"), rs.getInt("placeDispo"), rs.getString("type"));
				parkings.enqueue(p);
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getAllReservation() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, mdp);
			st = cn.createStatement();
			
			String sql = "SELECT * FROM reservation";
			rs = st.executeQuery(sql);
			while(rs.next()) {
					//TODO 
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialisationDonnees();
		System.out.println(parkings);
		System.out.println(reservations);
	}

}
