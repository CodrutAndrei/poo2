package model;

import java.sql.SQLException;

import database.SQLiteJDBC;
import domain.Utilizator;

public class LoginUtils {
	public static boolean verifLogIn(String username, String parola, String tipUtilizator) throws SQLException {
		Utilizator utilizator = SQLiteJDBC.getUtilizatorLogIn(username);
		if (utilizator.getParola().equals(parola)) {
			if (utilizator.getTipUtilizator().equalsIgnoreCase((tipUtilizator)))
				return true;
		}
		return false;

	}

}
