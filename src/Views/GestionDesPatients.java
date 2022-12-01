

package Views;

import Model.Statistics;
import Model.Patient;
import Model.Selection;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.CovidControleur;
import Interface.Observable;
import Interface.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;


public class GestionDesPatients extends JFrame {

	
	private JPanel contentPane;
	private JTextField tnom;
	private JTextField tprenom;
	private JTextField tage;
	String var = "";
	private JTextField tid;
	private JComboBox comboBox ;
	private Patient pt ;
	JCheckBox chckbxNewCheckBox;
	JCheckBox chckbxNewCheckBox_1;
	JCheckBox chckbxNewCheckBox_2;
	JCheckBox chckbxNewCheckBox_3;
	JCheckBox chckbxNewCheckBox_4;
	JCheckBox chckbxNewCheckBox_5;
	JCheckBox chckbxNewCheckBox_6;
	JCheckBox chckbxNewCheckBox_7;
	JCheckBox chckbxNewCheckBox_8;
	
	
	public GestionDesPatients() {
		super("Gestion Des Patients");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb10 = new JLabel("Id");
		lb10.setBounds(25, 20, 46, 14);
		contentPane.add(lb10);
		
		JLabel lb1 = new JLabel("Nom");
		lb1.setBounds(25, 47, 46, 14);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("Prenom");
		lb2.setBounds(25, 72, 46, 14);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("Age");
		lb3.setBounds(25, 100, 46, 14);
		contentPane.add(lb3);
		
		JLabel lb4 = new JLabel("Gouvernorat");
		lb4.setBounds(25, 136, 77, 14);
		contentPane.add(lb4);
		
		tid = new JTextField();
		tid.setColumns(10);
		tid.setBounds(176, 13, 233, 20);
		contentPane.add(tid);
		
		
		tnom = new JTextField();
		tnom.setBounds(176, 44, 233, 20);
		contentPane.add(tnom);
		tnom.setColumns(10);
		
		tprenom = new JTextField();
		tprenom.setColumns(10);
		tprenom.setBounds(176, 69, 233, 20);
		contentPane.add(tprenom);
		
		tage = new JTextField();
		tage.setColumns(10);
		tage.setBounds(176, 97, 233, 20);
		contentPane.add(tage);
		
		
		comboBox = new JComboBox(Statistics.getGouvernorats());
		comboBox.setBounds(176, 132, 233, 22);
		contentPane.add(comboBox);
		
		JLabel lb5 = new JLabel("Cochez les  symptomes et/ou incidents correspondants au patient");
		lb5.setForeground(Color.BLUE);
		lb5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb5.setBounds(10, 197, 439, 27);
		contentPane.add(lb5);
		
		JButton btnEngr = new JButton("Enregistrer");
		btnEngr.setBounds(100, 494, 110, 23);
		contentPane.add(btnEngr);
		
		JButton btnVider = new JButton("Vider");
		btnVider.setBounds(241, 494, 110, 23);
		contentPane.add(btnVider);
		
		btnEngr.addActionListener(new CovidControleur(this, pt));
		btnVider.addActionListener(new CovidControleur(this, pt));
		
		 chckbxNewCheckBox = new JCheckBox("Arrivée de l'étranger");
		chckbxNewCheckBox.setBounds(25, 243, 202, 23);
		contentPane.add(chckbxNewCheckBox);
		
		 chckbxNewCheckBox_1 = new JCheckBox("Contact avec une personne positive");
		chckbxNewCheckBox_1.setBounds(25, 267, 233, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		 chckbxNewCheckBox_2 = new JCheckBox("Température élevée");
		chckbxNewCheckBox_2.setBounds(25, 293, 162, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		 chckbxNewCheckBox_3 = new JCheckBox("Toux sèche");
		chckbxNewCheckBox_3.setBounds(25, 319, 97, 23);
		contentPane.add(chckbxNewCheckBox_3);
		
		 chckbxNewCheckBox_4 = new JCheckBox("Troubles digestifs");
		chckbxNewCheckBox_4.setBounds(25, 348, 162, 23);
		contentPane.add(chckbxNewCheckBox_4);
		
		 chckbxNewCheckBox_5 = new JCheckBox("Mal de gorge");
		chckbxNewCheckBox_5.setBounds(25, 374, 118, 23);
		contentPane.add(chckbxNewCheckBox_5);
		
		 chckbxNewCheckBox_6 = new JCheckBox("Maux de tête");
		chckbxNewCheckBox_6.setBounds(25, 400, 97, 23);
		contentPane.add(chckbxNewCheckBox_6);
		
		 chckbxNewCheckBox_7 = new JCheckBox("Courbatures et douleurs");
		chckbxNewCheckBox_7.setBounds(25, 426, 162, 23);
		contentPane.add(chckbxNewCheckBox_7);
		
		 chckbxNewCheckBox_8 = new JCheckBox("Fatigue générale");
		chckbxNewCheckBox_8.setBounds(25, 456, 162, 23);
		contentPane.add(chckbxNewCheckBox_8);
		
		
		
		
		setVisible(true);
		
	}
	
	
	public Patient getInformations()
	{
		pt = new Patient();
		
		pt.setId(Integer.parseInt(tid.getText()));
		pt.setNom(tnom.getText());
		pt.setPrenom(tprenom.getText());
		pt.setAge(Integer.parseInt(tage.getText()));
		pt.setGouvernorat(comboBox.getSelectedItem().toString());
		
		
		 Selection s = new Selection();
			if(chckbxNewCheckBox.isSelected()) 
			{
				pt.addCritere(Selection.getCritere(0));
				
			} 
			
			if(chckbxNewCheckBox_1.isSelected()) 
			{
			 pt.addCritere(Selection.getCritere(1));
				

			 
			} 
			if(chckbxNewCheckBox_2.isSelected()) 
			{
			 pt.addCritere(Selection.getCritere(2));
			 
				

			} 
			if(chckbxNewCheckBox_3.isSelected()) 
			{
			 pt.addCritere(Selection.getCritere(3));
			 
			} 
			if(chckbxNewCheckBox_4.isSelected()) 
			{
			 pt.addCritere(Selection.getCritere(4));
			 
			} 
			if(chckbxNewCheckBox_5.isSelected()) 
			{
			 pt.addCritere(Selection.getCritere(5));
			 
			} 
			if(chckbxNewCheckBox_6.isSelected()) 
			{
			 pt.addCritere(Selection.getCritere(6));
			 
			} 
			if(chckbxNewCheckBox_7.isSelected()) 
			{
			 pt.addCritere(Selection.getCritere(7));
			 
			} 
			if(chckbxNewCheckBox_8.isSelected()) 
			{
			 pt.addCritere(Selection.getCritere(8));
			 
			} 
			
		pt.setScore(pt.calculScore());
		
		
		return pt;
	}
	
	public void Vider()
	{
		
		tid.setText("");
		tnom.setText("");
		tprenom.setText("");
		tage.setText("");
		
		chckbxNewCheckBox.setSelected(false);
		chckbxNewCheckBox_1.setSelected(false);
		chckbxNewCheckBox_2.setSelected(false);
		chckbxNewCheckBox_3.setSelected(false);
		chckbxNewCheckBox_4.setSelected(false);
		chckbxNewCheckBox_5.setSelected(false);
		chckbxNewCheckBox_6.setSelected(false);
		chckbxNewCheckBox_7.setSelected(false);
		chckbxNewCheckBox_8.setSelected(false);
	
	}


	
		
		
		
		
		
	
	
}