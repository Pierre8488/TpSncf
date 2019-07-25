package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CarteReduction;


public class CarteReductionService {

	public void initDefaultValue(Connection conn) {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO carte_reduction(nom,description_avantage,pourcentage_reduction) VALUES(?,?,?)")) {
			List<CarteReduction> carteReductions = new ArrayList<>();
			carteReductions.add(new CarteReduction("Jeune", "12-26 ans : 30%", 30));
			carteReductions.add(new CarteReduction("Senior", "+ 60ans : 30%", 30));
			carteReductions.add(new CarteReduction("Week-end", "Week-end : 30%", 30));
			for (CarteReduction carteReduction : carteReductions) {
				stmt.setString(1, carteReduction.getNom());
				stmt.setString(2, carteReduction.getDescriptionAvantage());
				stmt.setInt(3, carteReduction.getPourcentageReduction());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
