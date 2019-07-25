package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {

	private final String URL = "jdbc:postgresql://localhost:5432/sncf";
	private final String USER = "postgres";
	private final String PASS = "Inthemix84!";

	private Connection conn;

	public void initConnexion() {
		try {
			this.conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
		} catch (SQLException e) {
			System.out.println("erreur connexion !, " + e.getMessage());
		}
	}

	public void deconnexion() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			System.out.println("erreur d�connexion !, " + e.getMessage());
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void initSchema() {
		this.dropTable();
		this.createTable();
	}

	private void dropTable() {
		try(Statement stmt = conn.createStatement()){
			stmt.executeUpdate("DROP TABLE IF EXISTS reservation");
			stmt.executeUpdate("DROP TABLE IF EXISTS utilisateur");
			stmt.executeUpdate("DROP TABLE IF EXISTS etape");
			stmt.executeUpdate("DROP TABLE IF EXISTS train");
			stmt.executeUpdate("DROP TABLE IF EXISTS gare");
			stmt.executeUpdate("DROP TABLE IF EXISTS carte_reduction");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createTable() {
		try(Statement stmt = conn.createStatement()){
			stmt.executeUpdate("CREATE TABLE carte_reduction("
			+ "id bigserial PRIMARY KEY, "
			+ "nom varchar(255) NOT NULL, "
			+ "description_avantage varchar(255),"
			+ "pourcentage_reduction integer)");

			stmt.executeUpdate("CREATE TABLE gare("
			+ "id bigserial PRIMARY KEY,"
			+ "nom varchar(255) NOT NULL, "
			+ "ville varchar(255) NOT NULL)");

			stmt.executeUpdate("CREATE TABLE train("
			+ "id bigserial PRIMARY KEY," 
			+ "gare_depart_id bigint NOT NULL,"
			+ "date_depart date," 
			+ "numero_train varchar(255) NOT NULL," 
			+ "nombre_place integer NOT NULL,"
			+ "type_train varchar(255) NOT NULL,"
			+ "FOREIGN KEY (gare_depart_id) REFERENCES gare(id))");
			
			stmt.executeUpdate("CREATE TABLE etape("
			+ "id bigserial PRIMARY KEY,"
			+ "gare_id bigint NOT NULL, "
			+ "terminus boolean," 
			+ "train_id bigint NOT NULL," 
			+ "ordre integer,"
			+ "FOREIGN KEY (gare_id) REFERENCES gare(id),"
			+ "FOREIGN KEY (train_id) REFERENCES train(id))");
			
			stmt.executeUpdate("CREATE TABLE utilisateur("
			+ "id bigserial PRIMARY KEY," 
			+ "nom varchar(255) NOT NULL,"
			+ "prenom varchar(255) NOT NULL," 
			+ "date_naissance date,"
			+ "carte_reduction_id bigint,"
			+ "FOREIGN KEY (carte_reduction_id) REFERENCES carte_reduction(id))");

			stmt.executeUpdate("CREATE TABLE reservation("
			+ "id bigserial PRIMARY KEY," 
			+ "numero integer NOT NULL,"
			+ "utilisateur_id bigint NOT NULL," 
			+ "train_id bigint," 
			+ "date_depart date," 
			+ "gare_depart bigint,"
			+ "FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id),"
			+ "FOREIGN KEY (train_id) REFERENCES train(id),"
			+ "FOREIGN KEY (gare_depart) REFERENCES gare(id)"
			+ ")");
			
			

			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
