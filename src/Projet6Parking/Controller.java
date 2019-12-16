package Projet6Parking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Projet6Parking.User;

public class Controller implements ActionListener{
	
	User model;
	JTextField nom, prenom, tel, email, mat;
	JLabel validation;
	JButton compte, validerInscr;
	View view = new View();
	
	public Controller(User model, JTextField nom, JTextField prenom, 
			JTextField tel, JTextField email, JTextField mat, JButton validerInscr) {
		
		this.model = model;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.mat = mat;
		this.validerInscr = validerInscr;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*Model test = new Model(nom.getText(),prenom.getText(), tel.getText(), email.getText(), mat.getText());
		System.out.println(test);*/
		
		model.setName(nom.getText());
		model.setFirstName(prenom.getText());
		model.setPhone(tel.getText());
		model.setMail(email.getText());
		model.setPlate(mat.getText());
		
	}


}

