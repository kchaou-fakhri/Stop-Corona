package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controleur.CovidControleur;
import Model.DAOPatients;
import Model.Patient;


import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JButton;

public class PatientsTester extends JFrame {

	private JPanel contentPane;
	private JTable table;

	

	
	Patient pt = new Patient();
	public PatientsTester( List<Patient> list) {
		setTitle("Liste des patients à tester");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 524, 204);
		contentPane.add(scrollPane);
		String [][] cont;
		cont = Remplir(list);
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			cont 
			,
			new String[] {
				"Id", "Nom", "Prenom", "Age", "Gouvernorat", "Score Covid-19"
			}
		));
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(87);
		
		JButton btnAjouter = new JButton("Return");
		btnAjouter.setBounds(85, 227, 89, 23);
		contentPane.add(btnAjouter);
		
		
		
		btnAjouter.addActionListener(new CovidControleur(this, pt));
		
		setVisible(true);
		
	}
	
	public String [][] Remplir ( List <Patient> c)
	{
	String [][] t = new String [c.size()][6];


		for(int i = 0; i< c.size(); i++)
		{
			t[i][0] = (String.valueOf(c.get(i).getId())) ;
			t[i][1] = c.get(i).getNom();
			t[i][2] = c.get(i).getPrenom();
			
			t[i][3] = (String.valueOf(c.get(i).getAge()));
			t[i][4] = c.get(i).getGouvernorat();
			t[i][5] = (String.valueOf( c.get(i).getScore()));

			
			
			
		}

	return t;
	}
	
	
}
