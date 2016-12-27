package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Facultate;
import domain.Raspuns;


public class SQLiteJDBC {
	public static Connection c=null;
	public static void main( String args[] ){
		
		try{
			Class.forName("org.sqlite.JDBC");
			c=DriverManager.getConnection("jdbc:sqlite:proiect.db");
		}   catch(Exception e){
			System.err.println(e.getClass().getName()+":"+e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
	
	public static List<Facultate> getFacultati() throws SQLException {
		
		String select= "select * from FACULTATE";
		ResultSet result;
		result = c.createStatement().executeQuery(select);
		List<Facultate> facultatiList=new ArrayList<>();
		while (result.next()) {
			Facultate facultati = new Facultate();	
			facultati.setId(result.getInt("id_facultate"));
			facultati.setNumeFacultate(result.getString("nume_facultate"));
			facultatiList.add(facultati);
		}
		return facultatiList;
	}
	static List<Raspuns> raspunsuriList = new ArrayList<>();
	public static List<Raspuns> getRaspuns(String tabel,String coloanaId,String coloanaNume,int numarIntrebare) throws SQLException{
		String select= "select * from '"+tabel+"'";
		ResultSet result;
		result = c.createStatement().executeQuery(select);
		while(result.next()){
			Raspuns raspuns=new Raspuns();
			raspuns.setId(result.getInt(coloanaId));
			raspuns.setRaspuns(result.getString(coloanaNume));
			raspuns.setId_intrebare(numarIntrebare);
			raspunsuriList.add(raspuns);
		}
		return raspunsuriList;
	}
}
