package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Interface.IDAO;
import Model.UtilitairesBD;

public class DAOPatients implements IDAO {
	
	public DAOPatients()
	{
		UtilitairesBD.seConnecter("src\\Model\\OracleParameters");
	}

	
	
	
	
	@Override
	public Object findBy(Object o) {
		
		
		Patient pt = new Patient();
		
		try
		{
			ResultSet rs = UtilitairesBD.OuvrirReq("select * from patients where id = '"+o+"'");
			if(rs != null)
			{
				rs.next();
				
				pt.setId(Integer.parseInt(rs.getString(1)));
				pt.setNom(rs.getString(2));
				pt.setPrenom(rs.getString(3));
				pt.setAge(Integer.parseInt(rs.getString(4)));
				pt.setPrenom(rs.getString(5));
				pt.setScore(Integer.parseInt(rs.getString(6)));
				
						
			}
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return pt;
	}

	@Override
	public ArrayList findAll() {
		ArrayList<Patient> list = new ArrayList<Patient>();
		
		Patient pt =null;
	
		try
		{
			ResultSet rs = UtilitairesBD.OuvrirReq("Select * from patients");
			
			if(rs != null)
			{
					while(rs.next())
				{
					pt	= new Patient();
					
					pt.setId(Integer.parseInt(rs.getString(1)));
					pt.setNom(rs.getString(2));
					pt.setPrenom(rs.getString(3));
					pt.setAge(Integer.parseInt(rs.getString(4)));
					pt.setGouvernorat(rs.getString(5));
					pt.setScore(Integer.parseInt(rs.getString(6)));
					
					list.add(pt);
					
				}
					
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		
	return list;
	}

	@Override
	public boolean update(Object o) {
		boolean verUpdate = false;
		Patient pt = null;
		pt = ((Patient) o);
		Connection cn = UtilitairesBD.seConnecter("src\\\\Model\\\\OracleParameters");
		
		String UpdateSQL = "update patients SET nom ='"+pt.getNom()+"'"+
										",prenom = '"+pt.getPrenom()+"'"+
										  ",age = '"+pt.getAge()+"'"+
											",GOUVERNORAT ='" + pt.getGouvernorat()+"'"+
											 ",sc = '"+pt.getScore()+"'"+
											   ",statu = '"+pt.getStatu()+"'"+
												"where id = '"+pt.getId()+"'";
				
		System.out.println(UpdateSQL);	
		try {
			Statement s = cn.createStatement();
			verUpdate = s.execute(UpdateSQL);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return verUpdate;
	}

	@Override
	public boolean insert(Object o) {
		boolean verInsert = false;
		Patient pt = null;
		pt = ((Patient) o);
		Connection cn = UtilitairesBD.seConnecter("src\\\\Model\\\\OracleParameters");
		
		String UpdateSQL = "insert into Patients values ('"+pt.getId()+"','"
															+pt.getNom()+"','"
															 +pt.getPrenom()+"','"
															  +pt.getAge()+"','"
															   +pt.getGouvernorat()+"','"
															   	+pt.calculScore()+"','"
															   		+pt.getStatu()+"')";
				
		System.out.println(UpdateSQL);	
		try {
			Statement s = cn.createStatement();
			verInsert = s.execute(UpdateSQL);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return verInsert;
	}

	@Override
	public boolean delete(Object o) {
		boolean verDelete = false;
		Patient pt = null;
		pt = ((Patient) o);
		
		Connection cn = UtilitairesBD.seConnecter("src\\\\Model\\\\OracleParameters");
		
		String deleteSQL = "delete from Patients where id = '"+pt.getId()+"'";
												
				
		System.out.println(deleteSQL);	
		try {
			Statement s = cn.createStatement();
			verDelete = s.execute(deleteSQL);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return verDelete;
		
	}
	

	


}
