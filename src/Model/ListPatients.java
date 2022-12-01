package Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



public class ListPatients {
	
	
	private static TreeSet<Patient> ListPt = new TreeSet<Patient>();
	
	
	
	
	public ListPatients ()
	{
		
	
	}
	
	public static void setListPt(TreeSet<Patient> listPt) {
		ListPt = listPt;
	}

	public void addPatient(Patient pt)
	{
		ListPt.add(pt);
		
	}
	public void addPatients(Collection<Patient> pt)
	{
		ListPt.addAll(pt);
		
	}
	
	
	
	
	public void removePatient(Patient pt)
	{
		ListPt.remove(pt);
	}
	
	
	public int getNbPatient()
	{
		return ListPt.size();
	}
	
	public Patient getPatient(int pos) {
		 
		Iterator<Patient> it = ListPt.iterator();
		
		int index = 0;
		Patient pt = null;
		
		while(it.hasNext() && index < pos)
		{
			pt = it.next();
			index++;
		}
		
		return pt;
		
		
	}
	
	public Set<Patient> getPatients()
	{
		return ListPt;
	}

	public ArrayList<Patient> PatientsParGovr (String govr)
	{
		
		ArrayList<Patient> Lgvr = null;
		
		for (Patient pt : ListPt) {
			
			if(pt.getGouvernorat().equals(govr)) {
				Lgvr.add(pt);
			}
			
		}
		return Lgvr;
		
	}
 	
	public ArrayList<Patient> PatientsParAge (String age)
	{
		
		ArrayList<Patient> Lage = null;
		
		for (Patient pt : ListPt) {
			
			if(pt.categorieAge().equals(age)) {
				Lage.add(pt);
			}
			
		}
		return Lage;
	
	}
	
	
	public static void EnregistrerResultat(List<Patient> lp) 
	{
		int i =0;
		for(Patient pt : lp)
		{
			
			for(Patient p : ListPt)
			{
				if(p.equals(pt))
				{
				p.setTestCovid(pt.getTestCovid());
				}
			}
			
		}
		
	}
	
	
	public List<Patient> ToBeTested(int nbTest) {
		int index = 0;
		
		ArrayList<Patient> list = new ArrayList<Patient>();
		
		
		TreeSet<Patient> list2 = (TreeSet<Patient>)ListPt.descendingSet();
		
		for(Patient pt : list2) {
			
			if(index == nbTest) 
			{
				
				break;
			}
			else 
			{
				
				list.add(pt);
			}
			index++;
		}
		
		
		return list;
		
	}
	
	public String toString()
	{
		String s="";
		for(Patient pt : ListPt)
		{
			s+= pt.toString();
		}
		return s;
	}
}
