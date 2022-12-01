package Model;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Selection {
	
	
	private static HashMap<String, Integer> criteresSelection = new HashMap<String, Integer>();

	
	
	 public Selection() 
	 {
		 
		 	criteresSelection.putIfAbsent("Arrivée de l'étranger", 2);
			criteresSelection.putIfAbsent("Contact avec une personne positive", 2);
			criteresSelection.putIfAbsent("Température élevée", 2);
			criteresSelection.putIfAbsent("Toux sèche", 2);
			criteresSelection.putIfAbsent("Troubles digestifs", 1);
			criteresSelection.putIfAbsent("Mal de gorge", 1);
			criteresSelection.putIfAbsent("Maux de tête", 1);
			criteresSelection.putIfAbsent("Courbatures et douleurs", 1);
			criteresSelection.putIfAbsent("	", 1);
	 }
	 
	 public Selection(HashMap<String, Integer> critere) {
		 
		this.criteresSelection = critere;
		 
	 }
	 
	 
	 public boolean verifCritere(String cr) {
		 
		 return this.criteresSelection.containsKey(cr);
	 }
	 
	 
	 public Set<String> getCritere()
	 {
		 
		 HashSet<String> SetCritere = new HashSet<String>();;
		 
		
		 Iterator it = criteresSelection.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		       
		        SetCritere.add((String) pair.getKey());
		    }
		 
		 
		 return SetCritere;
		 
	 }

	

	

	public void setCriteres(HashMap<String, Integer> criteresSelection) {
		this.criteresSelection = criteresSelection;
	}
	
	
	public void addCritere(String key, int value) {
		
		this.criteresSelection.put(key,value);
	}
	
	
	 
	public static  String getCritere(int pos) {
		
		int i=0;
		String critere = null;
		
		Iterator<String> iterator = criteresSelection.keySet().iterator();
		while (iterator.hasNext()&& i<=pos)
		{
			critere=iterator.next();
			i++;
		}
		
		return critere;
	}
	
	public int getScoreCritere(String cr) 
	{
		
		return this.criteresSelection.get(cr);
	}
	 
	
	public String toString() {
		
		String msg = "List des Criteres\n***********\n";
		
		for(Map.Entry element : criteresSelection.entrySet()  ) {
			
			msg+= ("\nCritere : " + element.getKey() +" Coefficient\n" + element.getValue());
		}
		
		return ( msg);
	}
	 
	 
}
