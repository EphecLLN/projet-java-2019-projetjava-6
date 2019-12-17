package Projet6Parking;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Classe permettant de realiser l'affichage de l'interface graphique et console 
 * du programme
 * 
 * @author LUK Brian
 * @version 2019/12/17
 */
public class View {
	
	JPanel p, l, pLabel, pText,valider, gui;
	JTextField nom, prenom, tel, email, mat, username, username1, res, signaler, matSig, retirerRes;
	JPasswordField mdp, mdp1;
	JFrame frame, frameLog, frameRes, frameSig;
	JButton validerCompte, validerInscr, validerRes, validerSig, buttonSig, compte;
	JLabel validation;
	
	User model = new User(0, null, null, null, null, null, null, null);
	User connecte = new User();//L'utilisateur connecté en ce moment
	
	/**
	 * @return le mot de passe entre
	 */
	public JPasswordField getMdp() {
		return mdp;
	}

	/**
	 * @return le nom
	 */
	public JTextField getNom() {
		return nom;
	}

	/**
	 * @return le prenom
	 */
	public JTextField getPrenom() {
		return prenom;
	}

	/**
	 * @return le numero de telephone
	 */
	public JTextField getTel() {
		return tel;
	}

	/**
	 * @return l'adresse email entree
	 */
	public JTextField getEmail() {
		return email;
	}

	/**
	 * @return le numero de matricule
	 */
	public JTextField getMat() {
		return mat;
	}

	/**
	 * @return action de valider 
	 */
	public JPanel getValider() {
		return valider;
	}

	/**
	 * @return action de valider une inscription
	 */
	public JButton getValiderInscr() {
		return validerInscr;
	}
	
	/**
	 * @return le compte
	 */
	public JButton getCompte() {
		return compte;
	}
	
	/**
	 * @return action de validation
	 */
	public JLabel getValidation() {
		return validation;
	}

	/**
	 * @return le nom d'utilisateur
	 */
	public JTextField getUsername() {
		return username;
	}

	/**
	 * @return le resultat renvoye
	 */
	public JTextField getRes() {
		return res;
	}

	/**
	 * @return action de valider le compte
	 */
	public JButton getValiderCompte() {
		return validerCompte;
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
		        if(DataBase.getUserExist(username.getText(), mdp.getText())) {
		        	frameRes.setVisible(true);
			        frameLog.setVisible(false);
			        connecte = DataBase.getUser(username.getText());
		        }
		        else {
		        	JOptionPane.showMessageDialog(frame, "Vous ne possedez pas de compte ou le mot de passe est incorrect");
		        }
		    }
		});
		
		valider.add(validerCompte);
		compte = new JButton("Inscrire un compte");
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
		username1 = new JTextField(20);
		pText.add(username1);
		pLabel.add(new JLabel("Mot de passe: "));
		mdp1 = new JPasswordField(20);
		pText.add(mdp1);
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
		pLabel.add(new JLabel("Plaque: "));
		mat = new JTextField(20);
		pText.add(mat);
		
		valider = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		validerInscr = new JButton("Valider");
		validerInscr.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        frame.setVisible(false);
		        User nouveau = new User(DataBase.getIdUser(), username1.getText(), mdp1.getText(), nom.getText(), prenom.getText(), tel.getText(), email.getText(), mat.getText());
		        DataBase.addUser(nouveau);
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
		JLabel parking = new JLabel("Baudoin 1er, Parking Agro, Parking croix du sud, Parking Cyclotron, Parking de Lauzelle,");
		pText.add(parking);
		pLabel.add(new JLabel(""));
		JLabel parking2 = new JLabel("Parking des Sciences, Parking Euler, Parking Grand-Place, Parking Grand-Rue, Parking Halles,");
		pText.add(parking2);
		pLabel.add(new JLabel(""));
		JLabel parking3 = new JLabel("Parking Leclercq, Parking Les Serres, Parking Magritte, Parking Montesquieu, Parking P14,");
		pText.add(parking3);
		pLabel.add(new JLabel(""));
		JLabel parking4 = new JLabel("Parking Rédimé, Parking Sablon, Parking Sainte-Barbe, Parking Socrate, Parking Wallons,");
		pText.add(parking4);
		pLabel.add(new JLabel(""));
		JLabel parking5 = new JLabel("Parking Vinci, Parking Hocaille");
		pText.add(parking5);
		
		
		valider = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		validerRes = new JButton("Valider");
		validerRes.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	if(retirerRes.getText().isEmpty()) {
		        connecte.reserve(DataBase.getParking(res.getText()));
		    	}
		    	else {
		    		connecte.libereReservation(DataBase.getReservation(Integer.parseInt(retirerRes.getText())));
		    	}
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
			
			pLabel.add(new JLabel("Reservation où il y a une infraction : "));
			matSig = new JTextField(20);
			pText.add(matSig);
			pLabel.add(new JLabel("Commentaire (Max 50 caractères) : "));
			signaler = new JTextField(20);
			signaler.setColumns(10);
			pText.add(signaler);
			
			valider = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
			validerSig = new JButton("Valider");
			validerSig.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {
			    	connecte.flagV2(DataBase.getReservation(Integer.parseInt(matSig.getText())), signaler.getText());
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
		    	if(DataBase.getUserExist(model.getUsername(), model.getMdp())) { //Si l'utilisateur existe
		    		connecte=DataBase.getUser(model.getUsername());
		    		System.out.println("Vous etes bien connecte");
			    	Scanner sc2 = new Scanner(System.in);
			    	System.out.println("Voulez vous reserver, signaler ou liberer? r/s/l (r = reserver, s = signaler, l = liberer)");
			    	switch(sc2.nextLine()) {
			    	case "r":
			    		System.out.println("Entrez le nom du parking");
			    		System.out.println("Baudoin 1er, Parking Agro, Parking croix du sud, Parking Cyclotron, Parking de Lauzelle, Parking des Sciences, Parking Euler, Parking Grand-Place, Parking Grand-Rue, Parking Halles, Parking Leclercq,");
			    		System.out.println("Parking Les Serres, Parking Magritte, Parking Montesquieu, Parking P14, Parking Rédimé, Parking Sablon, Parking Sainte-Barbe, Parking Socrate, Parking Wallons, Parking Vinci, Parking Hocaille");
			    		Scanner sc5 = new Scanner(System.in);
			    		connecte.reserve(DataBase.getParking(sc5.nextLine()));
			    		sc5.close();
			    		break;
			    	case "s":
			    		int nR;
			    		String co;
			    		System.out.println("Reservation ou a lieu l'infraction");
			    		Scanner sc7 = new Scanner(System.in);
			    		nR=Integer.parseInt(sc7.nextLine());
			    		System.out.println("Commentaire ?");
			    		co=sc7.nextLine();
			    		connecte.flagV2(DataBase.getReservation(nR), co);
			    		sc7.close();
			    		break;
			    	case "l":
			    		System.out.println("Tapez le numero de la reservation a enleve");
			    		Scanner sc6 = new Scanner(System.in);
			    		connecte.libereReservation(DataBase.getReservation(Integer.parseInt(sc6.nextLine())));
			    		sc6.close();
			    		break;
			    	default : 
		    			System.out.println("Entree non valide, redemarrez le programme"); 
		    			break;
			    	}
			    	sc2.close();
			    	break;
		    	}
		    	else { //Si l'utilisateur n'exite pas ou le mot de passe est incorrect
		    		System.out.println("Cet utilisateur n'existe pas ou le mot de passe est incorrect");
		    	}
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
		    		model.setIdUser(DataBase.getIdUser());
		    		DataBase.addUser(model);
		    		System.out.println("Vous avez bien ete ajoute a la base de donnee, relancez le programme");
		    		break;
		    	case "n":
		    		break;
		    	default : 
	    			System.out.println("Entree non valide, redemarrez le programme"); 
	    			break;
		    	}
		    	sc4.close();
		    break;
		    default : 
    			System.out.println("Entree non valide, redemarrez le programme"); 
    			break;
		    }
		    sc.close();
	}	
  }
