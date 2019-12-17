package Projet6Parking;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class View implements Observer{
	
	JPanel p, l, pLabel, pText,valider, gui;
	JTextField nom, prenom, tel, email, mat, username, res, signaler, matSig, retirerRes;
	JPasswordField mdp;
	JFrame frame, frameLog, frameRes, frameSig;
	JButton validerCompte, validerInscr, validerRes, validerSig, buttonSig, compte;
	JLabel validation;
	
	User model = new User(0, null, null, null, null, null, null, null);
	
	public JPanel getP() {
		return p;
	}

	public JPanel getpLabel() {
		return pLabel;
	}

	public JPanel getpText() {
		return pText;
	}
	
	public JPasswordField getMdp() {
		return mdp;
	}

	public JTextField getNom() {
		return nom;
	}

	public JTextField getPrenom() {
		return prenom;
	}

	public JTextField getTel() {
		return tel;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getMat() {
		return mat;
	}

	public JPanel getValider() {
		return valider;
	}

	public JPanel getGui() {
		return gui;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getValiderInscr() {
		return validerInscr;
	}
	
	public JButton getCompte() {
		return compte;
	}
	
	public JLabel getValidation() {
		return validation;
	}

	public JPanel getL() {
		return l;
	}

	public JTextField getUsername() {
		return username;
	}

	public JTextField getRes() {
		return res;
	}

	public JFrame getFrameLog() {
		return frameLog;
	}

	public JFrame getFrameRes() {
		return frameRes;
	}

	public JButton getValiderCompte() {
		return validerCompte;
	}

	public JButton getValiderRes() {
		return validerRes;
	}
	
	
	//interface de base, le log-in qui va soit vers la reservation, soit sur l'inscription du compte
	public void init() {
		
		p = new JPanel(new BorderLayout(5, 5));
		pLabel = new JPanel(new GridLayout(0, 1, 3, 3));
		pText = new JPanel(new GridLayout(0, 1, 3, 3));
		p.add(pLabel, BorderLayout.WEST);
		p.add(pText, BorderLayout.CENTER);
		
		pLabel.add(new JLabel("Nom d'utilisateur: "));
		username = new JTextField(20);
		pText.add(username);
		pLabel.add(new JLabel("Mot de passe: "));
		mdp = new JPasswordField(20);
		pText.add(mdp);
		
		valider = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		validerCompte = new JButton("Valider");
		validerCompte.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        frameRes.setVisible(true);
		        frameLog.setVisible(false);
		        //JOptionPane.showMessageDialog(frame, "Vous ne possedez pas de compte, veillez vous s'inscrire");
		    }
		});
		
		valider.add(validerCompte);
		compte = new JButton("inscrire un compte");
		compte.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        frame.setVisible(true);
		        
		    }
		});
		valider.add(compte);
		
		gui = new JPanel(new BorderLayout(20, 20));
	    gui.setBorder(new TitledBorder("Log-in"));
	    gui.add(p, BorderLayout.CENTER);
	    gui.add(valider, BorderLayout.SOUTH);
		
		frameLog = new JFrame("Parking");
		frameLog.setContentPane(gui);
		
	    frameLog.pack();
	    frameLog.setLocationByPlatform(true);
	    frameLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frameLog.setVisible(true);
	    frameLog.setLocation(500, 300);
	    
	   
	}
	
	
	//interface d'inscription
	public void parkingInscr() {

	    p = new JPanel(new BorderLayout(5, 5));
		pLabel = new JPanel(new GridLayout(0, 1, 3, 3));
		pText = new JPanel(new GridLayout(0, 1, 3, 3));
		p.add(pLabel, BorderLayout.WEST);
		p.add(pText, BorderLayout.CENTER);
		
		pLabel.add(new JLabel("Username: "));
		username = new JTextField(20);
		pText.add(username);
		pLabel.add(new JLabel("Mot de passe: "));
		mdp = new JPasswordField(20);
		pText.add(mdp);
		pLabel.add(new JLabel("Nom: "));
		nom = new JTextField(20);
		pText.add(nom);
		pLabel.add(new JLabel("Prenom: "));
		prenom = new JTextField(20);
		pText.add(prenom);
		pLabel.add(new JLabel("Telephone: "));
		tel = new JTextField(20);
		pText.add(tel);
		pLabel.add(new JLabel("Email: "));
		email = new JTextField(20);
		pText.add(email);
		pLabel.add(new JLabel("Matricule: "));
		mat = new JTextField(20);
		pText.add(mat);
		
		valider = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		validerInscr = new JButton("Valider");
		validerInscr.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        frame.setVisible(false);
		    }
		});
		valider.add(validerInscr);
		
		gui = new JPanel(new BorderLayout(20, 20));
	    gui.setBorder(new TitledBorder("Inscription"));
	    gui.add(p, BorderLayout.NORTH);
	    gui.add(valider, BorderLayout.CENTER);
		
		frame = new JFrame("Parking");
		frame.setContentPane(gui);
		
	    frame.pack();
	    frame.setLocationByPlatform(true);
	    frame.setVisible(false);
	    frame.setLocation(500, 300);
	   
	}
	
	//interface de la reservation qui soit valide la reservation soit retire la reservation soit va dans l'interface de signalisation
	public void parkingReservation(){
	    p = new JPanel(new BorderLayout(5, 5));
		pLabel = new JPanel(new GridLayout(0, 1, 3, 3));
		pText = new JPanel(new GridLayout(0, 1, 3, 3));
		p.add(pLabel, BorderLayout.WEST);
		p.add(pText, BorderLayout.CENTER);
		
		pLabel.add(new JLabel("Reservation: "));
		res = new JTextField(20);
		pText.add(res);
		pLabel.add(new JLabel("Retirer reservation: "));
		retirerRes = new JTextField(20);
		pText.add(retirerRes);
		JLabel nomParking = new JLabel("Nom des parking: ");
		pLabel.add(nomParking);
		JLabel parking = new JLabel("Parking baudoin,Parking baudoin,Parking baudoin,Parking baudoin,Parking baudoin,");
		pText.add(parking);
		pLabel.add(new JLabel(""));
		JLabel parking2 = new JLabel("Parking baudoin,Parking baudoin,Parking baudoin,Parking baudoin,Parking baudoin,");
		pText.add(parking2);
		pLabel.add(new JLabel(""));
		JLabel parking3 = new JLabel("Parking baudoin,Parking baudoin,Parking baudoin,Parking baudoin,Parking baudoin,");
		pText.add(parking3);
		pLabel.add(new JLabel(""));
		JLabel parking4 = new JLabel("Parking baudoin,Parking baudoin,Parking baudoin,Parking baudoin,Parking baudoin,");
		pText.add(parking4);
		
		
		valider = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		validerRes = new JButton("Valider");
		validerRes.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //model.reserve(res);
		    }
		});
		valider.add(validerRes);
		buttonSig = new JButton("Signaler");
		buttonSig.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        frameSig.setVisible(true);
		    }
		});
		valider.add(buttonSig);
		
		gui = new JPanel(new BorderLayout(20, 20));
	    gui.setBorder(new TitledBorder("Reservation"));
	    gui.add(p, BorderLayout.NORTH);
	    gui.add(valider, BorderLayout.CENTER);

		
		frameRes = new JFrame("Parking");
		frameRes.setContentPane(gui);
		
	    frameRes.pack();
	    frameRes.setLocationByPlatform(true);
	    frameRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frameRes.setVisible(false);
	    frameRes.setLocation(500, 300);
	}
	
	
	
	//interface de signalisation
	public void parkingSignaler() {
		    p = new JPanel(new BorderLayout(5, 5));
			pLabel = new JPanel(new GridLayout(0, 1, 3, 3));
			pText = new JPanel(new GridLayout(0, 1, 3, 3));
			p.add(pLabel, BorderLayout.WEST);
			p.add(pText, BorderLayout.CENTER);
			
			pLabel.add(new JLabel("Matricule du vehicule en effraction: "));
			matSig = new JTextField(20);
			pText.add(matSig);
			pLabel.add(new JLabel("Commentaire: "));
			signaler = new JTextField(20);
			signaler.setColumns(10);
			pText.add(signaler);
			
			valider = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
			validerSig = new JButton("Valider");
			validerSig.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {
			    	//model.flagV1(null, null);
			        frameSig.setVisible(false);
			    }
			});
			valider.add(validerSig);
			
			gui = new JPanel(new BorderLayout(20, 20));
		    gui.setBorder(new TitledBorder("Signaler"));
		    gui.add(p, BorderLayout.NORTH);
		    gui.add(valider, BorderLayout.CENTER);

			frameSig = new JFrame("Parking");
			frameSig.setContentPane(gui);
			
		    frameSig.pack();
		    frameSig.setLocationByPlatform(true);
		    frameSig.setVisible(false);
		    frameSig.setLocation(500, 300);
	}
	
	
	//vue console
	public void vueConsole() {
		 Scanner sc = new Scanner(System.in);
		    System.out.println("Avez vous un compte ? y/n (y = oui, n = non)");
		    switch(sc.nextLine()) {
		    case "y" : 
		    	System.out.println("Votre nom d'utilisateur ?");
		    	model.setUsername(sc.nextLine());
		    	System.out.println("Votre mot de passe ?");
		    	model.setMdp(sc.nextLine());
		    	Scanner sc2 = new Scanner(System.in);
		    	System.out.println("Voulez vous reserver ou signaler? r/s (r = reserver, s = signaler)");
		    	switch(sc2.nextLine()) {
		    	case "r":
		    		System.out.println("Reservation");
		    		System.out.println(sc2.nextLine());
		    		Scanner sc3 = new Scanner(System.in);
		    		System.out.println("Voulez vous enlever une reservation ? y/n (y = oui, n = non)");
		    		switch(sc3.nextLine()) {
		    		case "y":
		    			System.out.println("Tapez la reservation a enleve");
		    		case "n":
		    			break;
		    		default : 
		    			System.out.println("Entrée non valide"); 
		    			break;
		    		}
		    		sc3.close();
		    		break;
		    	case "s":
		    		System.out.println("Matricule du vehicule en effraction");
		    		System.out.println(sc2.nextLine());
		    		System.out.println("Commentaire ?");
		    		
		    		break;
		    	default : 
	    			System.out.println("Entrée non valide"); 
	    			break;
		    	}
		    	sc2.close();
		    	break;
		    case "n" : 
		    	Scanner sc4 = new Scanner(System.in);
		    	System.out.println("Voulez vous creer un compte ? y/n (y = oui, n = non)");
		    	switch(sc4.nextLine()) {
		    	case "y":
		    		System.out.println("Taper votre nom d'utilisateur");
		    		model.setUsername(sc4.nextLine());
		    		System.out.println("Tapez votre mdp");
		    		model.setMdp(sc4.nextLine());
		    		System.out.println("Tapez votre nom");
		    		model.setName(sc4.nextLine());
		    		System.out.println("Tapez votre prenom");
		    		model.setFirstName(sc4.nextLine());
		    		System.out.println("Tapez votre numero de telephone");
		    		model.setPhone(sc4.nextLine());
		    		System.out.println("Tapez votre mail");
		    		model.setMail(sc4.nextLine());
		    		System.out.println("Tapez votre plaque d'immatriculation");
		    		model.setPlate(sc4.nextLine());
		    		break;
		    	case "n":
		    		break;
		    	default : 
	    			System.out.println("Entrée non valide"); 
	    			break;
		    	}
		    	sc4.close();
		    break;
		    default : 
    			System.out.println("Entrée non valide"); 
    			break;
		    }
		    sc.close();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
	
	
  }
