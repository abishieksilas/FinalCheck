/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Abishiek
 *
 */
public class ConnectionHandler {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			URL resource = Thread.currentThread().getContextClassLoader()
					.getResource("connection.properties");
			Properties prop = new Properties();
			File file = new File(resource.toURI());
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);

			String dbDriverName = prop.getProperty("driver");
			String jdbcUrl = prop.getProperty("connection-url");
			String dbUserName = prop.getProperty("user");
			String dbPassword = prop.getProperty("password");

			Class.forName(dbDriverName);
			conn = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

}
