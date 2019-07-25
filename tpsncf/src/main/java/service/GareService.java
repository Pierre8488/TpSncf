package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Gare;

public class GareService {

	public void initDefaultValue(Connection conn) {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO gare(nom, ville) VALUES(?, ?)")) {
			List<Gare> gares = new ArrayList<>();
			gares.add(new Gare("Flandres", "Lille"));
			gares.add(new Gare("Gare du nord", "Paris"));
			gares.add(new Gare("Gare de Lyon", "Lyon"));
			gares.add(new Gare("Part-Dieu", "Lyon"));
			gares.add(new Gare("Valence TGV", "Valence"));
			gares.add(new Gare("Saint Roch", "Montpellier"));
			for (Gare gare : gares) {
				stmt.setString(1, gare.getNom());
				stmt.setString(2, gare.getVille());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Gare> getAllGare(Connection conn) {
		List<Gare> gares = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement("SELECT id, nom, ville FROM gare")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Gare gare = new Gare();
				gare.setId(rs.getLong("id"));
				gare.setNom(rs.getString("nom"));
				gare.setVille(rs.getString("ville"));
				gares.add(gare);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gares;
	}

	public void deleteGare(Connection conn, long id) {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM gare WHERE id=?")) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erreur suppression gare : " + e.getMessage());
		}
	}
}
