package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Etape;

public class EtapeService {

	public void initDefaultValue(Connection conn) {
		try (PreparedStatement stmt = conn
				.prepareStatement("INSERT INTO etape(gare_id, terminus, train_id, ordre) VALUES(?,?,?,?)")) {
			List<Etape> etapes = new ArrayList<>();
			etapes.add(new Etape(1L, true, 1L, 1));
			etapes.add(new Etape(2L, true, 2L, 1));
			etapes.add(new Etape(5L, false, 3L, 1));
			etapes.add(new Etape(4L, false, 3L, 2));
			etapes.add(new Etape(3L, true, 3L, 3));
			etapes.add(new Etape(4L, false, 4L, 1));
			etapes.add(new Etape(5L, false, 4L, 2));
			etapes.add(new Etape(6L, true, 4L, 3));
			for (Etape etape : etapes) {
				stmt.setLong(1, etape.getGareId());
				stmt.setBoolean(2, etape.isTerminus());
				stmt.setLong(3, etape.getTrainId());
				stmt.setInt(4, etape.getOrdre());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methode supprimant un train
	 * @param conn la connexion à la base de données
	 * @param trainId Id du train lié aux étapes
	 */
	public void deleteEtapeOfTrain(Connection conn, long trainId) {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM etape WHERE train_id=?")) {
			stmt.setLong(1, trainId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
