package Model;

import java.awt.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class Statistics {
	
	private static String[] Gouvernorats = new String[] {
			"Mahdia","Sousse","Monastir",
			"Tunis","Ariana","Ben Arous",
			"Medinin","Kef","Kairouan",
			"Gabes","Gafsa","Tataouin",
			"Nabeul","Sfax","Bizerte",
			"Beja","Kassrine","Tozeur",
			"gbeli","Zaghouan","Jandouba",
			"Seliana","Menouba","tozeur"
	};
	
	public static String[] getGouvernorats() {
		return Gouvernorats;
	}



	private static String[] TranchesAges = new String[]{"Nourisson","Enfant","Jeune","Adulte","Vieux"};
	
	
	
	public Map<String,Integer> statsPositifsGouvernorat (Collection<Patient> pt)
	{
		Map<String,Integer> ppg = new HashMap<String,Integer>();
		
		for(int i=0; i<Gouvernorats.length; i++)
		{ 
			int value = 0;
					for(Patient p : pt)
					{
						if(p.getGouvernorat().equals(Gouvernorats[i]))
						{
							value ++;
						}
							
					}
			ppg.put(Gouvernorats[i], value);
		}
		return ppg;
		
	}
	
	
	
	public static Map<String, Integer> StatsPositifAges(Collection<Patient> Pts){
		
		Map<String, Integer> PtparAge = new HashMap<String, Integer>();
		
		for(int i = 0; i<5;i++) 
		{
			int value = 0;				
							for(Patient pt : Pts) 
							{
								
								if(pt.isCovid())
								{
									
												if(pt.categorieAge().equals(TranchesAges[i]))	
												{
													value++;
													
												}
								}
							}
							
							
			PtparAge.put(TranchesAges[i], value);				
		}
					
												
	return PtparAge;
	
	}
	
	
	
	
	public Map<String, Integer> statsPatientAge(Collection<Patient> Pts){
		
		Map<String, Integer> PtparAge = null;
		
		for(int i = 0; i<5;i++) 
		{
			int value = 0;				
							for(Patient pt : Pts) 
							{
								
								
									
												if(pt.categorieAge().equals(TranchesAges[i]))	
												{
													value++;
													
												}
							}
															
							
							
			PtparAge.put(TranchesAges[i], value);				
		}
					
												
		return PtparAge;
		
		
		
	}
	
	
	
	public static Map<String, Integer> StatsPatientsGouvernorat(Collection<Patient> Pts){
		
		Map<String, Integer> PtparGov = new HashMap<String, Integer>();
		
		for(int i = 0; i<24;i++) 
		{
			int value = 0;				
							for(Patient pt : Pts) 
							{
								
								if(pt.getGouvernorat().equals(Gouvernorats[i]))	
								{
									value++;
								}
							}
							
				PtparGov.put(Gouvernorats[i], value);				
		}
					
												
	return PtparGov;
		
		
	}
	
	
	

}
