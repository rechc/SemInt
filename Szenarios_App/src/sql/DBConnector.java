package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {

	private String host;
	private String username;
	private String password;
	private String driver;
	private boolean connected = false;
	public Connection con = null;
	private static DBConnector instance = null;
	
	private DBConnector() {
		Property prop = new Property("Datenbank.ini");
		host = prop.getProp("host");
		username = prop.getProp("username");
		password = prop.getProp("password");
		driver = prop.getProp("driver");
		try {
			connected = connect();
		} catch (Exception e) {
			e.printStackTrace();
			disconnect();
		}
	}

	protected void finalize() {
		connected = disconnect();
		instance = null;
	}

	public boolean isConnected() {
		return connected;
	}

	public static DBConnector getInstance(){
		if (instance == null) {
			instance = new DBConnector();
		}
		return instance;
	}

	private boolean connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName(driver).newInstance();
		con = DriverManager.getConnection(host, username, password);
		return true;
	}

	public boolean disconnect() {
		if (connected) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}