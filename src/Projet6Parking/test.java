package Projet6Parking;

import java.util.Scanner;

import Projet6Parking.User;
import Projet6Parking.View;
import Projet6Parking.Controller;

public class test {

	public static void main(String[] args) {
		View view = new View();

		view.init();
		view.parkingReservation();
		view.parkingInscr();
		view.parkingSignaler();
		
		User model = new User(0, null, null, null, null, null, null, null);
		
		Controller controller = new Controller(model, view.getNom(), view.getPrenom(), view.getTel(), view.getEmail(), view.getMat(),view.getCompte());
		view.getValiderInscr().addActionListener(controller);
		
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Tapez votre nom d'utilisateur");
		  model.setUsername(scanner.nextLine());
		  System.out.println("Tapez votre mot de passe");
		  model.setMdp(scanner.nextLine());
		  scanner.close();
		  
	}

}

