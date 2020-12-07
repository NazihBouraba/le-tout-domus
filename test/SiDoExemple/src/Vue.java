

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class Vue extends JPanel implements Observer {
	// declaration des attributs
	private static final long serialVersionUID = 1L;
	
	CMaisonUser maMaison;
	public ArrayList<String> ma_liste_nomScenarios;
	public ListSelectionModel lsm;

	public JButton jbAfficherScenario, jbPopupDate, jbLancerEvenement,
			jbEvenEntre2Dates, jbResetAppareils, jbIncDateAnnee, jbIncDateMois,
			jbIncDateJour, jbIncHeure, jbIncMinute, jbPopupDate1, jbSimulDate,
			jbSimulPeriode;

	// boutons
	public JPanel jp1North, jp2South, jp3East, jp4West, jp5Center, jp2South1,
			jp2South2, jp2South3, jp2South12, jp2South123, leftPanel, jpSimul;

	// on déclare deux jp pour diviser la zone jp4West
	public JPanel jp4West1, jp4West2;
	// on déclare deux jp pour diviser la zone jp4West1
	public JPanel jp4West11, jp4West12;

	public JList<String> listScenario;
	public JTextArea textAreaScenario, textAreaEvenement;

	public JScrollPane scrollPaneAreaScenario, pScrollPaneTexteScenario,
			scrollListScenario, pScrollPaneTexteEvenement;

	// declaration de JLabel pour chaque JPanel de notre frame jf
	public JLabel lblInterfaceControler, listeScenario, lblProgramEvenements,
			lblAnnee, lblMois, lblJour, lblAnnee1, lblMois1, lblJour1,
			lblTrans;

	// declaration de JLabel pour la liste de scenarios
	public JLabel lblListScenario, lblHeure, lblMinute, lblHeure1, lblMinute1,
			lblDateDebut, lblDateFin;
	FlowLayout floZoneScenario, flotextAreaEvenement, floDateHeure,
			floInterface, floIncDateHeure;
	BorderLayout b1jp, b2jp4West;

	public Box boxListScenario, boxEvenement;
	public JTextField textHeureField, textMinuteField, textHeureField1,
			textMinuteField1, textAnneeField, textMoisField, textJourField,
			textAnneeField1, textMoisField1, textJourField1;

	public ListSelectionModel listSelectionModel;
	public Console console;
	public String nomScenario, textHeure, textMinute, dateHeureMinute,
			textEvenement, newline = "\n";

	int nombreInterface = 20;
	public int xDim = 1980; 
	public int yDim = 1050; 

	// delclaration des controleurs

	private ControljbResetAppareils leControljbResetAppareils;

	private ControljbAfficherScenario leControljbAfficherScenario;

	private ControljbSimulDate leControljbSimulDate;
	private ControljbSimulPeriode leControljbSimulPeriode;

	private ControljbIncDateAnnee leControljbIncDateAnnee;
	private ControljbIncDateMois leControljbIncDateMois;
	private ControljbIncDateJour leControljbIncDateJour;
	private ControljbIncHeure leControljbIncHeure;
	private ControljbIncMinute leControljbIncMinute;

	private ControljbPopupDate leControljbPopupDate;
	private ControljbPopupDate1 leControljbPopupDate1;
	private ControljbjbLancerEvenement leControljbjbLancerEvenement;
	private ControljbEvenEntre2Dates leControljbEvenEntre2Dates;

	private ControlInterface[] tabControleursInterface = new ControlInterface[nombreInterface];

	private JButton[] tabBoutonsInterface = new JButton[nombreInterface];
	AffichageAppareils zoneAffichage;

	JSplitPane splitpane;
	public int n = 0;
	Font font;
	Border blackline;

	public Vue(CMaisonUser maison) {
		super();
		this.maMaison = maison;
		console = new Console();

		font = new Font("TimesRoman", Font.PLAIN, 14);
		// pour la création des bordures
		blackline = BorderFactory.createLineBorder(Color.BLACK);

		// ///// création des contrôleurs///
		leControljbResetAppareils = new ControljbResetAppareils(this, maMaison);

		leControljbAfficherScenario = new ControljbAfficherScenario(this,
				maMaison);

		leControljbSimulDate = new ControljbSimulDate(this);
		leControljbSimulPeriode = new ControljbSimulPeriode(this);
		leControljbIncDateAnnee = new ControljbIncDateAnnee(this, maMaison);
		leControljbIncDateMois = new ControljbIncDateMois(this, maMaison);
		leControljbIncDateJour = new ControljbIncDateJour(this, maMaison);
		leControljbIncHeure = new ControljbIncHeure(this, maMaison);
		leControljbIncMinute = new ControljbIncMinute(this, maMaison);

		leControljbPopupDate = new ControljbPopupDate(this);
		leControljbPopupDate1 = new ControljbPopupDate1(this);

		leControljbjbLancerEvenement = new ControljbjbLancerEvenement(this,
				maMaison);
		leControljbEvenEntre2Dates = new ControljbEvenEntre2Dates(this,
				maMaison);

		// Création des controleurs d'interface
		for (int i = 0; i < maMaison.ma_liste_interfaces.size(); i++) {
			tabControleursInterface[i] = new ControlInterface(this, maMaison, i);
		}

		// //création de JLabel pour chaque jp/////

		lblInterfaceControler = new JLabel("Interface");
		lblInterfaceControler.setFont(font);

		lblListScenario = new JLabel("Liste des Scenarios");
		lblListScenario.setFont(font);
		lblListScenario.setAlignmentX(LEFT_ALIGNMENT);

		lblDateDebut = new JLabel("Date Début");
		lblDateDebut.setFont(new Font("TimesRoman", Font.PLAIN, 22));
		lblDateDebut.setForeground(Color.BLUE);
		
		lblAnnee = new JLabel("Année :");
		lblAnnee.setFont(font);

		lblMois = new JLabel("Mois :");
		lblMois.setFont(font);

		lblJour = new JLabel("Jour :");
		lblJour.setFont(font);

		lblHeure = new JLabel("Heure : ");
		lblHeure.setFont(font);

		lblMinute = new JLabel("Minutes : ");
		lblMinute.setFont(font);

		// creation de JTextfield pour l'année, mois, jour, heure et minutes
		textAnneeField = new JTextField(3);
		textMoisField = new JTextField(3);
		textJourField = new JTextField(3);
		textHeureField = new JTextField(3);
		textMinuteField = new JTextField(3);

		textAnneeField1 = new JTextField(3);
		textMoisField1 = new JTextField(3);
		textJourField1 = new JTextField(3);
		textHeureField1 = new JTextField(3);
		textMinuteField1 = new JTextField(3);

		lblDateFin = new JLabel("Date Fin");
		lblDateFin.setFont(new Font("TimesRoman", Font.PLAIN, 22));
		lblDateFin.setForeground(Color.BLUE);

		lblAnnee1 = new JLabel("Année :");
		lblAnnee1.setFont(font);

		lblMois1 = new JLabel("Mois :");
		lblMois1.setFont(font);

		lblJour1 = new JLabel("Jour :");
		lblJour1.setFont(font);

		lblHeure1 = new JLabel("Heure : ");
		lblHeure1.setFont(font);

		lblMinute1 = new JLabel("Minutes : ");
		lblMinute1.setFont(font);

		jbPopupDate1 = new JButton("PopupDate");
		jbPopupDate1.setFont(font);

		lblTrans = new JLabel("     ");

		// declaration de JPanel secondaires
		jp1North = new JPanel();
		jp2South = new JPanel();
		jp3East = new JPanel();
		jp4West = new JPanel();
		jp5Center = new JPanel();

		// on crée deux les JPanel pour diviser la zone jp4West
		jp4West1 = new JPanel();
		jp4West2 = new JPanel();
		jp4West11 = new JPanel();
		jp4West12 = new JPanel();
		jp2South1 = new JPanel();
		jp2South2 = new JPanel();
		jp2South3 = new JPanel();
		jp2South12 = new JPanel();
		jp2South123 = new JPanel();
		leftPanel = new JPanel();
		jpSimul = new JPanel();

		// organiser les différentes parties de l'interface
		b1jp = new BorderLayout(20, 5);
		this.setLayout(b1jp);

		// positioner les jp secondaires
		this.add(jp1North, BorderLayout.NORTH);
		this.add(jp2South, BorderLayout.SOUTH);
		this.add(console, BorderLayout.EAST);
		this.add(jp4West, BorderLayout.WEST);
		this.add(jp5Center, BorderLayout.CENTER);

		// organizer la zone jp4West avec hgap et vgap
		b2jp4West = new BorderLayout(5, 2);
		jp4West.setLayout(b2jp4West);

		// diviser la zone jp4West sur 2
		jp4West.add(jp4West1, BorderLayout.CENTER);
		jp4West.add(jp4West2, BorderLayout.SOUTH);

		// diviser la zone jp4West1 en jp4West11 et jp4West12 //
		jp4West1.add(jp4West11, BorderLayout.NORTH);
		jp4West1.add(jp4West12, BorderLayout.CENTER);

		// faire de bordures sur chaque jp secondaire
		jp1North.setBorder(blackline);
		jp2South.setBorder(blackline);
		// jp3East.setBorder(blackline);
		jp4West.setBorder(blackline);
		jp5Center.setBorder(blackline);

		// mettre des bordures sur la zone
		jp4West1.setBorder(blackline);
		jp4West2.setBorder(blackline);

		// ajouter des bordures
		jp4West11.setBorder(blackline);
		jp4West12.setBorder(blackline);
		jp2South123.setBorder(blackline);

		// jp2South3.setBorder(blackline);
		//jp4West.setPreferredSize(new Dimension(500, 150));
		jp4West.setPreferredSize(new Dimension(440, 150));
		// créer des bouttons de la zone North

		for (int i = 0; i < maMaison.ma_liste_interfaces.size(); i++) {
			CInterface monInterface = maMaison.ma_liste_interfaces.get(i);
			String nomInterface = monInterface.getNomInterface();
			tabBoutonsInterface[i] = new JButton(nomInterface);
			tabBoutonsInterface[i].setFont(font);
		}

		jbResetAppareils = new JButton("Reset Appareils");
		jbResetAppareils.setFont(font);

		// créer un boutton pour la zone West 11
		jbAfficherScenario = new JButton("Afficher Scenario");
		jbAfficherScenario.setFont(font);

		// créer des bouttons dans la zone South
		jbLancerEvenement = new JButton("Lancer Événement");
		jbLancerEvenement.setFont(font);

		jbPopupDate = new JButton("popupDate");
		jbPopupDate.setFont(font);

		jbIncDateAnnee = new JButton("inc Année");
		jbIncDateAnnee.setFont(font);

		jbIncDateMois = new JButton("inc Mois");
		jbIncDateMois.setFont(font);

		jbIncDateJour = new JButton("inc Jour");
		jbIncDateJour.setFont(font);

		jbIncHeure = new JButton("inc Heure");
		jbIncHeure.setFont(font);

		jbIncMinute = new JButton("inc Min");
		jbIncMinute.setFont(font);

		jbEvenEntre2Dates = new JButton("Événements entre 2 Dates");
		jbEvenEntre2Dates.setFont(font);
		jbEvenEntre2Dates.setPreferredSize(new Dimension(250, 100));

		jbSimulDate = new JButton("Simul. à une Date");
		jbSimulDate.setFont(font);

		jbSimulPeriode = new JButton("Simul. à une Période");
		jbSimulPeriode.setFont(font);
	
		// ajouter les Jlabel aux JPanel
		jp1North.add(lblInterfaceControler);

		// ajouter les bouttons aux jp correspondant
		// declarer et créer un FlowLayout pour la zone North
		floInterface = new FlowLayout(FlowLayout.CENTER, 20, 20);
		jp1North.setLayout(floInterface);

		// ajouter les buttons Interface dans la zone North

		for (int i = 0; i < maMaison.ma_liste_interfaces.size(); i++) {
			jp1North.add(tabBoutonsInterface[i]);
		}
		jp1North.add(jbResetAppareils);

		// /////////////////////////////////
		// zone actions buttons
		// /////////////////////////////////////
		// ajouter des actions écoutées par l'objet this

		jbAfficherScenario.addActionListener(leControljbAfficherScenario);
		jbPopupDate.addActionListener(leControljbPopupDate);
		jbPopupDate1.addActionListener(leControljbPopupDate1);
		jbLancerEvenement.addActionListener(leControljbjbLancerEvenement);
		jbEvenEntre2Dates.addActionListener(leControljbEvenEntre2Dates);
		jbResetAppareils.addActionListener(leControljbResetAppareils);

		jbIncDateAnnee.addActionListener(leControljbIncDateAnnee);
		jbIncDateMois.addActionListener(leControljbIncDateMois);
		jbIncDateJour.addActionListener(leControljbIncDateJour);
		jbIncHeure.addActionListener(leControljbIncHeure);
		jbIncMinute.addActionListener(leControljbIncMinute);
		jbSimulDate.addActionListener(leControljbSimulDate);
		jbSimulPeriode.addActionListener(leControljbSimulPeriode);

		// actions sur interfaces
		for (int i = 0; i < maMaison.ma_liste_interfaces.size(); i++) {
			tabBoutonsInterface[i]
					.addActionListener(tabControleursInterface[i]);
		}

		// ////////////////////////////////////////////
		// Zone West
		// ////////////////////////////////////////////

		// créer la liste des scenarios

		String[] maListe = maMaison
				.arrayListToTableauDeString(maMaison.ma_liste_scenarios);
		listScenario = new JList<String>(maListe);
		listScenario.setFont(font);
		listSelectionModel = listScenario.getSelectionModel();
		listScenario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// créer un flowLayout

		floZoneScenario = new FlowLayout(FlowLayout.CENTER, 40, 20);

		// on crée la boite pour afficher la liste des senarios
		boxListScenario = Box.createVerticalBox();
		jp4West1.setLayout(floZoneScenario);

		// ajouter le label à boxListScenario
		boxListScenario.add(lblListScenario);

		// créer scrollListScenario sur listScenario
		scrollListScenario = new JScrollPane(listScenario);

		scrollListScenario.setAlignmentX(LEFT_ALIGNMENT);

		// ajouter scrollListScenario à l'objet boxListScenario
		boxListScenario.add(scrollListScenario);
		boxListScenario.setPreferredSize(new Dimension(260, 120));

		// ajouter ce box à jp4West11
		jp4West11.add(boxListScenario);

		// ajouter le button jbAfficherScenario dans la zone west11
		jp4West11.add(jbAfficherScenario);

		// /////////////////
		// zone textAreaEvenement
		// zone text Scenario et textAreaEvenement

		// créer la zone texteAreaSenario --> JTextArea(int rows, int columns)
		textAreaScenario = new JTextArea(40, 50);

		// on la rends non editable
		textAreaScenario.setEditable(false);
		// textAreaScenario.setLineWrap(true);
		textAreaScenario.setWrapStyleWord(true);

		// on ajoute JScrolPane sur la zone de texte
		pScrollPaneTexteScenario = new JScrollPane(textAreaScenario,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// on ajuste la taille
		//pScrollPaneTexteScenario.setPreferredSize(new Dimension(400, 240));
		pScrollPaneTexteScenario.setPreferredSize(new Dimension(400, 275));

		// ///////////////////////////
		// text Area programmation événement

		boxEvenement = Box.createVerticalBox();

		lblProgramEvenements = new JLabel("Programmation des Événements");
		lblProgramEvenements.setFont(font);

		boxEvenement.add(lblProgramEvenements);

		textEvenement = maMaison
				.getStringListeDatesTexte(maMaison.ma_liste_programmations);

		textAreaEvenement = new JTextArea(20, 20);
		textAreaEvenement.setText(textEvenement);
		textAreaEvenement.setEditable(false);
		textAreaEvenement.setCaretPosition(0);
		textAreaEvenement.setFont(new Font("TimesRoman", Font.PLAIN, 15));

		pScrollPaneTexteEvenement = new JScrollPane(textAreaEvenement,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		boxEvenement.add(pScrollPaneTexteEvenement);
		boxEvenement.setPreferredSize(new Dimension(405, 180));
		boxEvenement.setBorder(blackline);
		boxEvenement.setVisible(true);
		boxEvenement.setAlignmentX(LEFT_ALIGNMENT);

		flotextAreaEvenement = new FlowLayout(FlowLayout.CENTER, 30, 30);
		jp4West2.setLayout(flotextAreaEvenement);
		jp4West2.add(boxEvenement);

		// ///////////////////////////////////
		// organiser la zone date heure South
		// /////////////////////////////////////

		splitpane = new JSplitPane();

		leftPanel.setLayout(new GridLayout(2, 1));

		splitpane.setLeftComponent(leftPanel);
		splitpane.setRightComponent(jp2South123);

		leftPanel.add(jbSimulDate);
		leftPanel.add(jbSimulPeriode);

		jp2South.add(splitpane, BorderLayout.CENTER);
		jp2South.add(jpSimul, BorderLayout.EAST);

		jp2South12.setLayout(new GridLayout(2, 1));
		jp2South12.add(jp2South1);
		jp2South12.add(jp2South2);

		jp2South123.setMinimumSize(new Dimension(900, 350));
		jp2South123.setLayout(new GridLayout(2, 1));
		jp2South123.add(jp2South12);
		jp2South123.add(jp2South3);
		
		floDateHeure = new FlowLayout(FlowLayout.CENTER, 15, 10);
		jp2South1.setLayout(floDateHeure);
		
		// ajouter les button jbPopupDate et jbPopupHeure
		jp2South1.add(lblDateDebut);
		jp2South1.add(lblAnnee);
		jp2South1.add(textAnneeField);
		jp2South1.add(lblMois);
		jp2South1.add(textMoisField);
		jp2South1.add(lblJour);
		jp2South1.add(textJourField);
		jp2South1.add(jbPopupDate);
		jp2South1.add(lblHeure);
		jp2South1.add(textHeureField);
		jp2South1.add(lblMinute);
		jp2South1.add(textMinuteField);

		floIncDateHeure = new FlowLayout(FlowLayout.CENTER, 45, 10);
		jp2South2.setLayout(floIncDateHeure);

		// ///////////////////
		jp2South2.add(lblTrans);
		jp2South2.add(jbIncDateAnnee);
		jp2South2.add(jbIncDateMois);
		jp2South2.add(jbIncDateJour);
		jp2South2.add(lblTrans);
		jp2South2.add(jbIncHeure);
		jp2South2.add(jbIncMinute);

		jp2South3.setLayout(floDateHeure);
		jp2South3.add(lblDateFin);
		jp2South3.add(lblAnnee1);
		jp2South3.add(textAnneeField1);
		jp2South3.add(lblMois1);
		jp2South3.add(textMoisField1);
		jp2South3.add(lblJour1);
		jp2South3.add(textJourField1);

		jp2South3.add(jbPopupDate1);
		jp2South3.add(lblHeure1);
		jp2South3.add(textHeureField1);
		jp2South3.add(lblMinute1);
		jp2South3.add(textMinuteField1);
		
		jpSimul.add(jbEvenEntre2Dates);
	
		// ajouster les couleurs de bords de JTextField
		// textHeureField.setBorder(BorderFactory.createLineBorder(Color.gray,
		// 2));
		// textHeureField.setBorder(BorderFactory.createLineBorder(Color.BLACK,
		// 1));
		// textMinuteField.setBorder(BorderFactory.createLineBorder(Color.BLACK,
		// 1));

		// //////////////zone affichage objets (Center)/////////////

		zoneAffichage = new AffichageAppareils(maMaison.ma_liste_appareils);
		maMaison.resetAffichageAppareils(maMaison.ma_liste_appareils);
		// zoneAffichage.revalidate();

		this.jp5Center.setBackground(Color.lightGray);
		this.jp5Center.add(zoneAffichage);
		this.jp5Center.revalidate();
		this.jp5Center.repaint();
	}

	@Override
	public void update(String sColor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Color color) {
		// TODO Auto-generated method stub

	}

	public boolean champsNonVideNew(JTextField textAnneeField,
			JTextField textMoisField, JTextField textJourField,
			JTextField textHeureField, JTextField textMinuteField) {
		boolean ok = true;
		if (textAnneeField.getText().isEmpty()
				|| textMoisField.getText().isEmpty()
				|| textJourField.getText().isEmpty()
				|| textHeureField.getText().isEmpty()
				|| textMinuteField.getText().isEmpty()) {
			ok = false;
		}
		return ok;
	}

	// méthode permet de transferer une chaine de Date vers un tableau
	// d'entier(annee,mois,
	// jour)
	public int[] stringDateToTableauInt(String sDate) {
		int[] t = new int[5];
		int i = 0;

		for (String str : sDate.split(",")) {
			try {
				t[i] = Integer.parseInt(str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println("Un(plusieurs) champs est"
				// + " vide ou n'est pas entier");
			}
			i++;
		}
		return t;
	}

	public void lireTabDate(int[] t) {
		System.out.println(t[0]);
		System.out.println(t[1]);
		System.out.println(t[2]);
		System.out.println(t[3]);
		System.out.println(t[4]);
	}

	public CDate TabDateToCDate(int[] tabDateAMJHM) {

		CDate d = new CDate(tabDateAMJHM[0], tabDateAMJHM[1], tabDateAMJHM[2],
				tabDateAMJHM[3], tabDateAMJHM[4]);
		return d;
	}

	// méthode permet de vérfier les champs (annee, jour, mois + heure + min)
	// saisis par
	// l'utilisateur

	public boolean verifSaisieNew(JTextField textAnneeField,
			JTextField textMoisField, JTextField textJourField,
			JTextField textHeureField, JTextField textMinuteField) {
		boolean ok = false;
		int anneeMax = 2050;
		int anneeMin = 1;
		/*
		 * if (!champsNonVideNew(textAnneeField, textMoisField, textJourField,
		 * textHeureField, textMinuteField)) { System.out.print("\n");
		 * System.out
		 * .println("Saisir tous les champs: année,mois, jour, heure , minute");
		 * }
		 */
		// recupere la chaine contenant(annee,mois,jour,heure,minute)
		dateHeureMinute = textAnneeField.getText() + ","
				+ textMoisField.getText() + "," + textJourField.getText() + ","
				+ textHeureField.getText() + "," + textMinuteField.getText();

		// transferer la chaine vers un tableau d'entiers
		int[] dateAMJHM = stringDateToTableauInt(dateHeureMinute);

		boolean verifAnnee = dateAMJHM[0] > anneeMax || dateAMJHM[0] < anneeMin;
		boolean verifMois = dateAMJHM[1] > 12 || dateAMJHM[1] < 1;
		boolean verifJour = dateAMJHM[2] > 31 || dateAMJHM[2] < 1;
		boolean verifHeure = dateAMJHM[3] > 23 || dateAMJHM[3] < 0;
		boolean verifMinute = dateAMJHM[4] > 59 || dateAMJHM[4] < 0;
		if (verifAnnee || verifMois || verifJour || verifHeure || verifMinute) {
			ok = false;
			System.out.print("\n");
			System.out.println("Erreur de valeurs : date , heure ,ou minute");
		} else
			ok = true;
		return ok;
	}

	public CDate transferAMJHMToCDate(JTextField textAnneeField,
			JTextField textMoisField, JTextField textJourField,
			JTextField textHeureField, JTextField textMinuteField) {

		int[] dateAMJHM;
		CDate date = new CDate(0, 0, 0, 0, 0);
		if (verifSaisieNew(textAnneeField, textMoisField, textJourField,
				textHeureField, textMinuteField)) {
			try {
				// recuperer la date saisie par l'utilisateur
				dateHeureMinute = textAnneeField.getText() + ","
						+ textMoisField.getText() + ","
						+ textJourField.getText() + ","
						+ textHeureField.getText() + ","
						+ textMinuteField.getText();
				// transferer une chaine de date vers un tableau
				// (annee,mois,jour,heure,minute)
				dateAMJHM = stringDateToTableauInt(dateHeureMinute);
				// //transferer le tableau de date vers une instance de classe
				// CDate
				date = TabDateToCDate(dateAMJHM);

			} catch (Exception e2) {
				System.out.println("vous avez mal saisi votre date");
			}
		}
		return date;
	}
}
