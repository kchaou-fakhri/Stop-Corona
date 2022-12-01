package Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UtilitairesBD {
	private static Connection cn= null;
	
	//Charger un driver Oracle
	public static void chargerDriverOracle()
	{
		 System.out.println("-------- Oracle JDBC Connection Testing ------");

	        try {

	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            System.out.println("Oracle JDBC Driver Registered!");

	        } catch (ClassNotFoundException e) {

	            System.out.println("Where is your Oracle JDBC Driver?");              

	        }

	}
	//Charger un driver SQL Server
	public static void chargerDriverSQLServer()
	{
		 System.out.println("-------- SQL Server JDBC Connection Testing ------");

	        try {

	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            System.out.println("SQL Server JDBC Driver Registered!");

	        } catch (ClassNotFoundException e) {

	            System.out.println("Where is your SQL Server JDBC Driver?");

	        }

	}
	//Charger un driver MySQL
	public static void chargerDriverMySQL()
	{
		System.out.println("-------- MySQL JDBC Connection Testing ------");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");

        } 
        catch (ClassNotFoundException e) {
 
            System.out.println("Where is your MySQL JDBC Driver?");
         }
	}
	//Charger un driver correspondant au type de BD donné en paramètre
	public static void chargerDriver (String typeBD)
	{	System.out.println (typeBD);
		if (typeBD.contentEquals("Oracle"))
			chargerDriverOracle();
		else
		{
			if(typeBD.contentEquals("SQL Server"))
			chargerDriverSQLServer();
			else
				if(typeBD.contentEquals("MySQL"))
					chargerDriverMySQL();
		}
		
	}
	//Se connecter à n'importe quelle base de données tout en supposant que le driver est déjà chargé
	public static Connection seConnecter(String connectionString, String user, String pwd)
	{	if (cn==null)
		{
		try {

				cn = DriverManager.getConnection(connectionString, user, pwd);
             	System.out.println("Succeed connection, take control your database now!");

		} 
		catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		}

		return cn;
	}
	//Charger le contenu d'un fichier de configuration dans un objet de type Properties
	public static Properties load(String filename) throws IOException, FileNotFoundException{
	      Properties properties = new Properties();
	      FileInputStream input = new FileInputStream(filename);
	      try{
	         properties.load(input);
	         return properties;
	      }

	      finally{

	         input.close();
	      }
	   }
	//Se connecter à une base de données en utilisant les paramètres de connexion se trouvant dans le fichier en paramètre
	public static Connection seConnecter(String f)
	{
		Properties p = new Properties();
		if (cn==null)
		{
		try
		{
		p=load(f) ;
		System.out.println (p);
		String typeBD= (String)p.get("typeBD");
		String url = (String)p.get("Url");
		String user = (String)p.get("login");
		String pwd = (String)p.get("pwd");
		chargerDriver (typeBD);
		cn = seConnecter(url, user, pwd);
			
		}
		catch (Exception e)
		{
			System.out.println (e.getMessage());
		}
		}
		return cn;
	}
	//Permet d'ouvrir n'importe quelle requête Select et retourner son résultat dans un objet de type ResultSet
	public static ResultSet OuvrirReq( String req)
	{   ResultSet res = null;
		try
	    {   if (cn!=null) {
		    Statement  state = cn.createStatement();
		    res = state.executeQuery(req);   
	    	}
	    else
	    	System.out.println ("Connexion non initialisée");
	    }
	    catch (SQLException e)
	    {
	    	System.out.println (e.getMessage());
	    }
		finally {
			return res;
		}
	}

}
