package Projet6Parking;
import java.sql.*;
import java.util.Date;

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
				retour.setPenalty(rs2.getInt("penalty"));
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
	 * retourne le premier utilisateur ayant le username fournit en parametre
	 * @param username le username du user qu'on cherche
	 * @return le premier user ayant cet username la
	 */
	public static User getUser(String username) {
		Connection cn20 = null;
		Statement st20 = null;
		ResultSet rs20 = null;

		User retour = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn20 = DriverManager.getConnection(url, login, mdp);
			st20 = cn20.createStatement();

			String sql = "SELECT * FROM users WHERE users.username='" + username + "'";
			rs20 = st20.executeQuery(sql);
			if(rs20.first()) {
				retour = new User(rs20.getInt("idUser"), rs20.getString("username"), rs20.getString("mdp"), rs20.getString("name"), rs20.getString("firstName"), rs20.getString("phone"), rs20.getString("mail"), rs20.getString("plate"));
				retour.setPenalty(rs20.getInt("penalty"));
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
				cn20.close();
				st20.close();

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
	 * Retourne le parking ayant le nom passé en argument
	 * @param parkingName le nom du parking que l'on veut
	 * @return le parking ayant le nom passé en argument
	 */
	public static Parking getParking(String parkingName) {
		Connection cn4 = null;
		Statement st4 = null;
		ResultSet rs4 = null;

		Parking retour = new Parking();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn4 = DriverManager.getConnection(url, login, mdp);
			st4 = cn4.createStatement();

			String sql = "SELECT * FROM parking WHERE parking.name='" + parkingName + "'";
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
	 * Retourne la reservation ayant l'id passe en argument
	 * @param id l'id de la reservation que l'on cherche
	 * @return la reservation ayant l'id donne
	 */
	public static Reservation getReservation(int id) {
		Connection cn15 = null;
		Statement st15 = null;
		ResultSet rs15 = null;

		Reservation retour = new Reservation();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn15 = DriverManager.getConnection(url, login, mdp);
			st15 = cn15.createStatement();

			String sql = "SELECT * FROM reservation WHERE reservation.idReservation=" + id;
			rs15 = st15.executeQuery(sql);
			if(rs15.first()) {
				retour = new Reservation(rs15.getInt("idReservation"), getPlace(rs15.getInt("idPlace")), getUser(rs15.getInt("idUser")));
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
				cn15.close();
				st15.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}



//---DATA UPDATE---
	/**
	 * Met a jour le nombre de place disponible du parking passe en argument
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
	 * Met a jour le nombre de place disponible du parking passe en argument
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

	/**
	 * Change la valeur du booleen de la place de libre (false) a occupe(true)
	 * @param pl La place dont il faut changer le statut de libre
	 */
	public static void setBooked(Place pl) {
		Connection cn13 = null;
		Statement st13 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn13 = DriverManager.getConnection(url, login, mdp);
			st13 = cn13.createStatement();
			
			String sql = "UPDATE `place` SET `booked`=" + true + " WHERE `idPlace`=" + pl.getIdPlace();
			st13.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn13.close();
				st13.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Change la valeur du booleen de la place d'occupe (true) a libre (false)
	 * @param pl La place dont il faut changer le statut d'occupe
	 */
	public static void unsetBooked(Place pl) {
		Connection cn14 = null;
		Statement st14 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn14 = DriverManager.getConnection(url, login, mdp);
			st14 = cn14.createStatement();
			
			String sql = "UPDATE `place` SET `booked`=" + false + " WHERE `idPlace`=" + pl.getIdPlace();
			st14.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn14.close();
				st14.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Ajoute une penalite a l'utilisateur donne
	 * @param idUser l'utilisateur à qui il faut ajouter une penalite
	 */
	public static void addPenalty(int idUser) {
		Connection cn16 = null;
		Statement st16 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn16 = DriverManager.getConnection(url, login, mdp);
			st16 = cn16.createStatement();
			
			String sql = "UPDATE `users` SET `penalty`=" + (getPenalty(idUser)+1) + " WHERE `idUser`=" + idUser;
			st16.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn16.close();
				st16.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	


private static int getPenalty(int idUser) {
		return getUser(idUser).getPenalty();
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
	 * Retourne le premier id que peut prendre un User
	 * @return le premier id que peut prendre un user
	 */
	public static int getIdUser() {
		Connection cn19 = null;
		Statement st19 = null;
		ResultSet rs19 = null;

		int retour=-1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn19 = DriverManager.getConnection(url, login, mdp);
			st19 = cn19.createStatement();

			String sql = "SELECT MAX(idUser) FROM users";
			rs19 = st19.executeQuery(sql);
			if(rs19.first()) {
				retour = rs19.getInt(1) + 1;
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
				cn19.close();
				st19.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	
	/**
	 * Retourne le premier numero que peut prendre une place
	 * @param p le parking dans lequel on veut une place
	 * @return le premier numero pour une place
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
	
	/**
	 * Retourne le premier id que peut prendre une offence
	 * @return le premier id que peut prendre une offence
	 */
	public static int getIdOffence() {
		Connection cn15 = null;
		Statement st15 = null;
		ResultSet rs15 = null;

		int retour=-1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn15 = DriverManager.getConnection(url, login, mdp);
			st15 = cn15.createStatement();

			String sql = "SELECT MAX(idOffence) FROM offence";
			rs15 = st15.executeQuery(sql);
			if(rs15.first()) {
				retour = rs15.getInt(1) + 1;
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
				cn15.close();
				st15.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	
	
	/**
	 * Permet de verifier lors de la connexion si le user est deja dans la base de donnee et si son mot de passe est correct
	 * @param username Le username du user
	 * @param password Le mot de passe du user
	 * @return true si le user existe et son mot de passe est correct, false sinon
	 */
	public static boolean getUserExist(String username, String password) {
		Connection cn17 = null;
		Statement st17 = null;
		ResultSet rs17 = null;

		boolean retour=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn17 = DriverManager.getConnection(url, login, mdp);
			st17 = cn17.createStatement();

			String sql = "SELECT * FROM users WHERE users.username='" + username + "'";
			rs17 = st17.executeQuery(sql);
			if(rs17.first()) {
				return(rs17.getString("mdp").contentEquals(password));
			}
			else {
				return false; //Pas d'user avec ce nom la
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn17.close();
				st17.close();

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
	 * Ajoute la reservation dans la base de donnee
	 * @param r Une reservation a ajouter dans la base de donnee
	 */
	public static void addReservation(Reservation r) {
		Connection cn9 = null;
		Statement st9 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn9 = DriverManager.getConnection(url, login, mdp);
			st9 = cn9.createStatement();
			
			String sql ="INSERT INTO `reservation`(`idReservation`, `idPlace`, `idUser`) VALUES (" + r.getIdReservation() + "," + r.getPlace().getIdPlace() + "," + r.getUser().getIdUser() + ")";
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
	
	/**
	 * Ajoute une offence dans la base de donnee
	 * @param of L'offence a ajoute dans la base de donnee
	 */
	public static void addOffence(Offence of) {
		Connection cn16 = null;
		Statement st16 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn16 = DriverManager.getConnection(url, login, mdp);
			st16 = cn16.createStatement();
			
			String sql = "INSERT INTO `offence`(`idOffence`, `idUserSignal`, `idUserFlagged`, `comment`, `idPlace`, `date`) VALUES (" + of.getIdOffence() + "," + of.getUserSignal().getIdUser() + "," + of.getUserFlagged().getIdUser() + ",'" + of.getComment() + "'," + of.getPlace().getIdPlace() + ",'" + of.getDate().toString() + "')";
			st16.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn16.close();
				st16.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	/**
	 * Ajoute un utilisateur a la base de donnee
	 * @param nouveau l'utilisateur a ajoute
	 */
	public static void addUser(User nouveau) {
		Connection cn18 = null;
		Statement st18 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn18 = DriverManager.getConnection(url, login, mdp);
			st18 = cn18.createStatement();
			
			String sql = "INSERT INTO `users`(`idUser`, `name`, `firstName`, `phone`, `mail`, `plate`, `penalty`, `username`, `mdp`) VALUES (" + nouveau.getIdUser() + ",'" + nouveau.getName() + "','" + nouveau.getFirstName() + "','" + nouveau.getPhone() + "','" + nouveau.getMail() + "','" + nouveau.getPlate() + "'," + nouveau.getPenalty() +",'" + nouveau.getUsername() + "','" + nouveau.getMdp() + "')";
			st18.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn18.close();
				st18.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	


//---A TRIER---

	


//---MAIN---
	/**
	 * Permet de tester les differentes methodes au-dessus
	 * @param args rien
	 */
	public static void main(String[] args) {
		initialisationDonnees();
		//System.out.println(parkings);
		//System.out.println(reservations);
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
		//User testCompletReservation = getUser(1);
		//testCompletReservation.reserve(getParking(3));
		//System.out.println(reservations);
		//User testCompletLiberation = getUser(1);
		//testCompletLiberation.libereReservation(getReservation(13));
		//System.out.println(reservations);
		//Date d = new Date();
		//Offence offence1 = new Offence(getIdOffence(), getUser(1), getUser(2), "BlaBla4", getPlace(3),d);
		//addOffence(offence1);	
		//User user1 = getUser(1);
		//Reservation reservation1 = getReservation(5);
		//user1.flagV2(reservation1, "UnCommentRandom4");
		//User user2 = getUser(3);
		//user2.reserve(getParking(6));
		//System.out.println(getUserExist("BLuk", "Bla"));
		//System.out.println(getUserExist("BLuk", "BLuk1GFP497"));
		//System.out.println(getUser("BLuk"));
		//System.out.println(getIdUser());
		//User n = new User(26,"Gae","gaet","Gaet","gaet","0478262700","get.g@fmai.com","87tc3");
		//addUser(n);
		System.out.println(getParking(3));
		System.out.println(getParking(getParking(3).getName()));
		
	}



















}
