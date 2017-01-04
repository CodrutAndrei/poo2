package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Facultate;
import domain.Raspuns;
import domain.Specializare;
import domain.Student;
import domain.Utilizator;

public class SQLiteJDBC {
	public static Connection c = null;

	static List<Raspuns> raspunsuriList = new ArrayList<>();
	static List<Utilizator> utilizatoriList = new ArrayList<>();
	static List<Student> studentiList = new ArrayList<>();

	public static List<Raspuns> getRaspunsuriList() {
		return raspunsuriList;
	}

	public static List<Utilizator> getUtilizatoriList() {
		return utilizatoriList;
	}

	public static void connectToDB() {

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:proiect.db");
			System.out.println("Opened database successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
			System.out.println(" database closed. something bad is going on");
			System.exit(0);
		}

	}

	public static List<Facultate> getFacultati() throws SQLException {

		String select = "select * from FACULTATE";
		ResultSet result;
		result = c.createStatement().executeQuery(select);
		List<Facultate> facultatiList = new ArrayList<>();
		while (result.next()) {
			Facultate facultati = new Facultate();
			facultati.setId(result.getInt("id_facultate"));
			facultati.setNumeFacultate(result.getString("nume_facultate"));
			facultatiList.add(facultati);
		}
		return facultatiList;
	}

	public static List<Specializare> getSpecializari(int id_facultate) throws SQLException {
		String select = "SELECT id_specializare, nume_specializare FROM SPECIALIZARE WHERE id_facultate="
				+ Integer.toString(id_facultate);
		ResultSet result;
		result = c.createStatement().executeQuery(select);
		List<Specializare> specializariList = new ArrayList<>();
		while (result.next()) {
			Specializare specializari = new Specializare();
			specializari.setId_specializare(result.getInt("id_specializare"));
			specializari.setNume_specializare(result.getString("nume_specializare"));
			specializariList.add(specializari);
		}
		return specializariList;
	}

	public static List<Raspuns> getRaspuns(String tabel, String coloanaId, String coloanaNume, int numarIntrebare)
			throws SQLException {
		String select = "select * from " + tabel;
		ResultSet result;
		result = c.createStatement().executeQuery(select);
		while (result.next()) {
			Raspuns raspuns = new Raspuns();
			raspuns.setId(result.getInt(coloanaId));
			raspuns.setRaspuns(result.getString(coloanaNume));
			raspuns.setId_intrebare(numarIntrebare);
			raspunsuriList.add(raspuns);
		}
		return raspunsuriList;
	}

	public static List<Raspuns> raspunsuriIntrebare(int nrIntrebare) {
		List<Raspuns> raspunsuri = raspunsuriList.stream().filter(raspuns -> raspuns.getId_intrebare() == nrIntrebare)
				.collect(Collectors.toList());
		return raspunsuri;
	}

	public static List<Utilizator> getUtilizatori() throws SQLException {
		String select = "select * from UTILIZATOR";
		ResultSet result;
		result = c.createStatement().executeQuery(select);
		while (result.next()) {
			Utilizator utilizator = new Utilizator();
			utilizator.setUsername(result.getString("username"));
			utilizator.setParola(result.getString("parola"));
			utilizator.setTipUtilizator(result.getString("tip_uitilizator"));
			utilizatoriList.add(utilizator);
		}
		return utilizatoriList;
	}

	public static Utilizator getUtilizatorLogIn(String username) throws SQLException {
		String select = "SELECT * FROM UTILIZATOR WHERE username =" + "'" + username + "'" + ";";
		Utilizator utilizator = new Utilizator();
		ResultSet result = c.createStatement().executeQuery(select);
		System.out.println(result.getFetchSize());
		utilizator.setUsername(result.getString("username"));
		utilizator.setParola(result.getString("parola"));
		utilizator.setTipUtilizator(result.getString("tip_utilizator"));
		return utilizator;
	}

	public static void modificareParola(String username, String parola) throws SQLException {
		String update = "UPDATE UTILIZATOR SET parola=" + parola + " where username=" + username;
		c.createStatement().executeQuery(update);
		// modificare in utilizatoriList;
	}

	public static String getAlegeri(String tabel, String numeId, int comboItem, String numeColoana)
			throws SQLException {
		String select = "SELECT * FROM " + tabel + " WHERE " + numeId + "=" + Integer.toString(comboItem);
		ResultSet result;
		result = c.createStatement().executeQuery(select);
		return result.getString(numeColoana);
	}

	public static String getAlegereFacultate(int id_specializare) throws SQLException {
		String select = "SELECT nume_facultate FROM FACULTATE WHERE id_facultate = (SELECT id_facultate FROM SPECIALIZARE WHERE id_specializare="
				+ Integer.toString(id_specializare) + ")";
		ResultSet result;
		result = c.createStatement().executeQuery(select);
		return result.getString("nume_facultate");
	}

	public static String getSpecializare(int id_specializare) throws SQLException {
		String select = "SELECT nume_specializare FROM SPECIALIZARE WHERE id_specializare="
				+ Integer.toString(id_specializare);
		ResultSet result;
		result = c.createStatement().executeQuery(select);
		return result.getString("nume_specializare");
	}

}
