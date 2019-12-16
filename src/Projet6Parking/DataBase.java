package Projet6Parking;
import java.sql.*;

/**
 * Classe faisant le lien avec la base de donnee
 * 
 * @author GORTZ Gaetan
 * @version 2019/12/17
 */
public class DataBase {
//Variable d'instances
	static ParkingLinkedList parkings;  //Liste de tous les parkings
	static ReservationLinkedList reservations; //Liste de toutes les reservations

//Local
	private static String url = "jdbc:mysql://localhost/projetparking";
	private static String login = "root";
	private static String mdp = "";

//Serveur omg
	//private static String url = "jdbc:mysql://localhost/projetparking";
	//private static String login = "root";
	//private static String mdp = "";

//---INITIALISATION STRUCTURE CHAINEE---	
	/**
	 * Initialise les differents listes de donnees
	 */
	public static void initialisationDonnees() {
		parkings = new ParkingLinkedList();
		getAllParking();
		reservations = new ReservationLinkedList();
		getAllReservation();
	}



//---GET ALL OBJECTS IN DB---	
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






//---GET OBJECT IN DB---	
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



//---DATA UPDATE---
	/**
	 * Met � jour le nombre de place disponible du parking pass� en argument
	 * @param p le parking auquel il faut ajouter une place dispo
	 */
	public static void addPlaceDispo(Parking p) {
		Connection cn11 = null;
		Statement st11 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn11 = DriverManager.getConnection(url, login, mdp);
			st11 = cn11.createStatement();
			
			String sql = "UPDATE `parking` SET `placeDispo`=" + (getPlaceDispo(p)+1) + " WHERE `idParking`=" + p.getIdParking();
			st11.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn11.close();
				st11.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Met � jour le nombre de place disponible du parking pass� en argument
	 * @param p Le parking auquel il faut retirer une place dispo
	 */
	public static void removePlaceDispo(Parking p) {
		Connection cn10 = null;
		Statement st10 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn10 = DriverManager.getConnection(url, login, mdp);
			st10 = cn10.createStatement();
			
			String sql = "UPDATE `parking` SET `placeDispo`=" + (getPlaceDispo(p)-1) + " WHERE `idParking`=" + p.getIdParking();
			st10.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn10.close();
				st10.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}




//---GET INFO ABOUT DB
	/**
	 * Retourne l'id que peut prendre une nouvelle place
	 * @return le premier id dispo pour une place
	 */
	public static int getIdPlace() {
		Connection cn5 = null;
		Statement st5 = null;
		ResultSet rs5 = null;

		int retour=-1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn5 = DriverManager.getConnection(url, login, mdp);
			st5 = cn5.createStatement();

			String sql = "SELECT MAX(idPlace) FROM place";
			rs5 = st5.executeQuery(sql);
			if(rs5.first()) {
				retour = rs5.getInt(1) + 1;
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
				cn5.close();
				st5.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}

	/**
	 * Retourne le premier num�ro que peut prendre une place
	 * @param p le parking dans lequel on veut une place
	 * @return le premier num�ro pour une place
	 */
	public static int getNumberPlace(Parking p) {
		Connection cn6 = null;
		Statement st6 = null;
		ResultSet rs6 = null;

		int retour=-1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn6 = DriverManager.getConnection(url, login, mdp);
			st6 = cn6.createStatement();

			String sql = "SELECT MAX(number) FROM place WHERE idParking ="+p.getIdParking();
			rs6 = st6.executeQuery(sql);
			if(rs6.first()) {
				retour = rs6.getInt(1) + 1;
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
				cn6.close();
				st6.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	
	/**
	 * Retourne le premier Id que peut prendre une r�servation
	 * @return le premier id que peut prendre la r�servation
	 */
	public static int getIdReservation() {
		Connection cn7 = null;
		Statement st7 = null;
		ResultSet rs7 = null;
		
		int retour=-1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn7 = DriverManager.getConnection(url, login, mdp);
			st7 = cn7.createStatement();
			
			String sql = "SELECT MAX(idReservation) FROM reservation";
			rs7 = st7.executeQuery(sql);
			if(rs7.first()) {
				retour = rs7.getInt(1) + 1;
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
				cn7.close();
				st7.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	
	/**
	 * Retourne le nombre de place disponible dans le parking donn�
	 * @param p le parking dont on veut le nombre de place dispo
	 * @return le nombre de place dispo dans le parking donn�
	 */
	private static int getPlaceDispo(Parking p) {
		Connection cn12 = null;
		Statement st12 = null;
		ResultSet rs12 = null;
		int retour=-1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn12 = DriverManager.getConnection(url, login, mdp);
			st12 = cn12.createStatement();
			
			String sql = "SELECT placeDispo FROM parking WHERE idParking="+p.getIdParking();
			rs12 = st12.executeQuery(sql);
			if(rs12.first()) {
				retour = rs12.getInt(1);
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
				cn12.close();
				st12.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	
	
	
	
//---ADD DATA TO DB
	/**
	 * Ajoute la place pl dans la base de donn�e
	 * @param pl La place a ajout� dans la DB
	 */
	public static void addPlace(Place pl) {
		Connection cn8 = null;
		Statement st8 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn8 = DriverManager.getConnection(url, login, mdp);
			st8 = cn8.createStatement();
			
			String sql = "INSERT INTO `place`(`idPlace`, `number`, `idParking`, `booked`) VALUES (" + pl.getIdPlace() + "," + pl.getNumber() + "," + pl.getParking().getIdParking() + "," + true + ")";
			st8.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn8.close();
				st8.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Ajoute la r�servation dans la base de donn�e
	 * @param r Une r�servation a ajouter dans la base de donn�e
	 */
	public static void addReservation(Reservation r) {
		Connection cn9 = null;
		Statement st9 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn9 = DriverManager.getConnection(url, login, mdp);
			st9 = cn9.createStatement();
			
			String sql = "\r\n" + 
					"INSERT INTO `reservation`(`idReservation`, `idPlace`, `idUser`) VALUES (" + r.getIdReservation() + "," + r.getPlace().getIdPlace() + "," + r.getUser().getIdUser() + ")";
			st9.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn9.close();
				st9.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	


//---A TRIER---
	/**
	 * Ajoute une p�nalit� � l'utilisateur donn�
	 * @param idUser
	 */
	public static void addPenalty(int idUser) {
		//TODO addpenalit�

	}
	
	/**
	 * Change la valeur du booleen de la place de libre (false) � occup�(true)
	 * @param pl La place dont il faut changer le statut de libre
	 */
	public static void setBooked(Place pl) {
		// TODO Auto-generated method stub

	}


	
	










//---MAIN---
	/**
	 * Permet de tester les diff�rentes m�thodes au-dessus
	 * @param args
	 */
	public static void main(String[] args) {
		initialisationDonnees();
		//System.out.println(parkings);
		System.out.println(reservations);
		//User u = getUser(3);
		//System.out.println(u);
		//System.out.println(getIdPlace());
		//System.out.println(getNumberPlace(getParking(4)));
		//System.out.println(getIdReservation());
		//Place place1 = new Place(getIdPlace(), getParking(4), getNumberPlace(getParking(4)));
		//addPlace(place1);
		//Reservation reservation1 = new Reservation(getIdReservation(), getPlace(2), getUser(0));
		//addReservation(reservation1);
		//Parking parking1 = new Parking(1, "Baudoin 1er", "Boulevard Baudoin Ier", 284, 284, "Gratuit");
		//removePlaceDispo(parking1);
		//addPlaceDispo(parking1);
		User testCompletReservation = getUser(1);
		testCompletReservation.reserve(getParking(3));
		System.out.println(reservations);
		
	}
}

//testAccentéèà
