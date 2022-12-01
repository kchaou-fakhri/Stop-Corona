package Controleur;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;

import Model.DAOPatients;
import Model.ListPatients;
import Model.Patient;
import Model.Selection;
import Model.Statistics;
import Views.GestionDesPatients;
import Views.ListeDesPatients;
import Views.NbTest;
import Views.PatientsTester;
import Views.Statistiques;

public class CovidControleur implements ActionListener 
{
	JFrame jf;
	Patient pt;
	DAOPatients ed = new DAOPatients();
	ListPatients lp = new ListPatients();

	public CovidControleur(JFrame listeDesPatients, Patient pt)
	{
		jf = listeDesPatients;
		this.pt = pt;
	}

	public CovidControleur(JFrame frame) {
	jf = frame;	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton b = (JButton)e.getSource();
		
		if(b.getText() == "Ajouter")
		{
			new GestionDesPatients();
			pt.notifyObservers(pt);
			
		}
		if(b.getText() == "Enregistrer")
		{
			pt = ((GestionDesPatients)jf).getInformations();
			System.out.println (pt);
			ed.insert(pt);
			
			pt.notifyObservers(pt);
			jf.setVisible(false);
			
		}
		if(b.getText()=="Vider")
		{
			((GestionDesPatients)jf).Vider();
		}
		
		if (b.getText()=="Supprime")
		{
		String s= ((ListeDesPatients)jf).getMatriculeSelectionne();
		pt = (Patient) ed.findBy(s);
		System.out.println (pt);
		
		ed.delete(pt);

		pt.addObserver((ListeDesPatients)jf);
		
		pt.notifyObservers(pt);
		
		}
		if(b.getText() == "Tests")
		{
			new NbTest();
		}
		if(b.getText() == "Tester")
		{
			ArrayList<Patient> list = new ArrayList<Patient>();
			
			int nb = ((NbTest)jf).getNbTest();
			System.out.println ("Nombre des tests: "+ nb);
			
			
			list = ed.findAll();
			for(Patient pt : list)
			{

				 lp.addPatient(pt);
			}
			list = (ArrayList<Patient>) lp.ToBeTested(nb);
			
			
			
			jf.setVisible(false);
			
			new PatientsTester(list);
			for(Patient pt : list)
			{
				pt.setStatu("oui");
				ed.update(pt);
				
			}
		}
		
		if(b.getText() == "Return")
		{
			jf.setVisible(false);
		}
		if(b.getText() == "Statistiques")
		{
			new Statistiques(new Statistics().statsPositifsGouvernorat(ed.findAll()) , new Statistics().StatsPositifAges(ed.findAll()) );
		}
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeDesPatients frame = new ListeDesPatients(new DAOPatients().findAll());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
