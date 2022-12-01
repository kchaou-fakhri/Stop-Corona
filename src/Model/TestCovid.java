package Model;
import java.util.*;

public  class TestCovid {

	public static void main(String[] args) {
		
		
		 Selection s = new Selection();
		 Scanner sc = new Scanner (System.in);

		 String cr, rep, nom, prenom, gouv;
		 int age;
		 ListPatients lp = new ListPatients();
		 Patient p1 ;
		 p1= new Patient ("AA", "AA", "Sousse", 45);
		 p1.addCritere(Selection.getCritere(0));
		 p1.addCritere(Selection.getCritere(2));
		 p1.addCritere(Selection.getCritere(4));
		 lp.addPatient(p1);
		

		 
		 p1= new Patient ("BB", "BB", "Tunis", 25);
		 p1.addCritere(Selection.getCritere(0));
		 p1.addCritere(Selection.getCritere(2));
		 p1.addCritere(Selection.getCritere(3));
		 p1.addCritere(Selection.getCritere(5));
		 p1.addCritere(Selection.getCritere(4));
		 lp.addPatient(p1);
		 
		 p1= new Patient ("CC", "CC", "Sousse", 75);
		 p1.addCritere(Selection.getCritere(0)); 
		 p1.addCritere(Selection.getCritere(2));
		 p1.addCritere(Selection.getCritere(3));
		 p1.addCritere(Selection.getCritere(5));
		 p1.addCritere(Selection.getCritere(7));
		 p1.addCritere(Selection.getCritere(4));
		 lp.addPatient(p1);
		 

		 p1= new Patient ("DD", "DD", "Ariana", 20);
		 lp.addPatient(p1);

		 p1= new Patient ("EE", "EE", "Tunis", 80);
		 p1.addCritere(Selection.getCritere(0));
		 p1.addCritere(Selection.getCritere(2));
		 p1.addCritere(Selection.getCritere(3));
		 p1.addCritere(Selection.getCritere(5));
		 p1.addCritere(Selection.getCritere(4));
		 p1.addCritere(Selection.getCritere(1));
		 lp.addPatient(p1);
		 
		


		 System.out.println ("Liste des patients:");
		 Set<Patient> l= lp.getPatients();
		 Iterator<Patient> itPatients = l.iterator();
		 while (itPatients.hasNext())
		 {
		 p1= itPatients.next();
		 System.out.println (p1);
		 System.out.println ("Les symptômes sont :");
		 System.out.println (p1.getCriteres() );
		 
		 }
		 
		/* System.out.println ("Les patients à tester:");
		 List<Patient>lptest = lp.ToBeTested(3);
		 itPatients = lptest.iterator();
		 while (itPatients.hasNext())
		 {
		 p1= itPatients.next();
		 System.out.println ("\n"+p1 +" \nScore Covid-19: "+ p1.calculScore());

		 }
		 
		 

		 
		 System.out.println ("Les résultats des tests:");
		 ListPatients.EnregistrerResultat(lptest);
		 System.out.println ("Nombre de patients positifs par gouvernorat:");
		Map<String, Integer> hmp1 =Statistics.StatsPatientsGouvernorat(lptest);
		System.out.println (hmp1);
		 System.out.println ("Nombre de patients positifs par catégoried'âges:");
		 Map<String, Integer> hmp2 = Statistics.StatsPositifAges(lptest);
		 System.out.println (hmp2);
		  

		*/
	}

}
