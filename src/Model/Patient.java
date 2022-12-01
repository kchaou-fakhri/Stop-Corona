package Model;

import java.util.ArrayList;
import java.util.HashSet;

import Interface.Observable;
import Interface.Observer;

public class Patient implements Comparable<Patient>,Observable {

	private String nom;
	private String prenom;
	private String gouvernorat;
	private int age;
	private HashSet<String> criteres = new HashSet<String>();;
	private boolean testCovid;
	private int score = 0;
	private int id = 0;
	private String statu = "non";
	private ArrayList<Observer> ListOb = new ArrayList<Observer>();
	
	
	
	public String getStatu() {
		return statu;
	}


	public void setStatu(String statu) {
		this.statu = statu;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
		notifyObservers(nom);
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Patient(String nom, String prenom, String gouvr, int age)
	{
		
		this.nom = nom;
		this.prenom = prenom;
		this.gouvernorat = gouvr;
		this.age = age;
		
	}
	
	
	public Patient() {
		
	}


	public HashSet<String> getCriteres()
	{
		return criteres;
	}
	
	public void addCriteres(HashSet<String> crs)
	{
		criteres.addAll(crs);
	}
	
	public void addCritere(String cr)
	{
		criteres.add(cr);
	}

	

	public boolean getTestCovid() {
		return testCovid;
	}


	public void setTestCovid(boolean testCovid) {
		this.testCovid = testCovid;
	}


	public String categorieAge() 
	{
		
		String Categorie;
		
		if (age < 3) {
			Categorie = "Nourisson";
		}
				else if(age <18) {
					
					Categorie = "Enfant";
				}
					else if(age < 40) {
						Categorie = "Jeune";
					}
						else if( age < 65) {
							Categorie = "Adulte";
						}
							else {
								Categorie = "Vieux";
							}
		
		return Categorie;
		}		
	
	public String toString() 
	{
		
		return ("Nom : "+nom + ", Prenom : "+prenom+", Age : "+age);
	}



	
	public String getGouvernorat() {
		return gouvernorat;
	}


	

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	
	public boolean isCovid() {
		
		boolean test = false;
		
		if(score > 5) 
		{
			test = true;
		}
		
		
		return test;
	}
	
	public int  calculScore() 
	{
		
		
		int score = 0;
		Selection sl = new Selection();
				
		for(String cr : criteres) 
			{
				if(sl.verifCritere(cr))
				{
					score += sl.getScoreCritere(cr);
				}
			}
			
				return score;
	}


	


	@Override
	public void addObserver(Observer o) {
		ListOb.add(o);
		
	}


	@Override
	public void notifyObservers(Object pt) {
		Observer o;
		
		for(int i =0; i<ListOb.size(); i++)
		{
			o = ListOb.get(i);
			o.update(this, pt);
		}

	}


	@Override
	public void removeObservers() {
		ListOb = new ArrayList<Observer>();
		
	}


	@Override
	public int compareTo(Patient o) {
		
		return score- o.score;
	}

}
