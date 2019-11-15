/**
 * 
 */
package Projet6Parking;

/**
 * @author he201676
 *
 */
public class User {
	
	//propriétés
	private String name;
	private String firstname;
	private String phone;
	private String mail;
	private String plate;
	private int penalty;
	
	//getters
	public String getName() {
		return name;
	}
	public String getFirstName() {
		return firstname;
	}
	public String getPhone() {
		return phone;
	}
	public String getMail() {
		return mail;
	}
	public String getPlate() {
		return plate;
	}
	public int getPenalty() {
		return penalty;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	//constructeurs
	
	/**
	 * constructeur de l'objet User, les différents utilisateurs de l'application
	 * 
	 * @param name : nom de l'utilisateur
	 * @param firstname : son prénom
	 * @param phone : son numéro de téléphone
	 * @param mail : son email
	 * @param plate : la plaque d'immatriculation de son véhicule
	 * @param penalty : le nombre de fraude que l'utilisateur a reçu
	 */
	public User(String name, String firstname, String phone, String mail,
			String plate,int penalty) {
		this.name = name;
		this.firstname = firstname;
		this.phone = phone;
		this.mail = mail;
		this.plate = plate;
		this.penalty = penalty;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
