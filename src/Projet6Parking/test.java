package Projet6Parking;

import Projet6Parking.User;
import Projet6Parking.View;
import Projet6Parking.Controller;

public class test {

	public static void main(String[] args) {
		View view = new View();

		DataBase.initialisationDonnees();
		view.init();
		view.parkingReservation();
		view.parkingInscr();
		view.parkingSignaler();
		view.vueConsole();
		
		User model = new User(0, null, null, null, null, null, null, null);
		
		Controller controller = new Controller(model, view.getNom(), view.getPrenom(), view.getTel(), view.getEmail(), view.getMat(),view.getCompte());
		view.getValiderInscr().addActionListener(controller);
		

	}

}

