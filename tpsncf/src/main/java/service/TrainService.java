package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Train;

public class TrainService {

	public void initDefaultValue(Connection conn) {
		try (PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO train(gare_depart_id, date_depart, numero_train, nombre_place, type_train) VALUES(?,?,?, ?, ?)")) {
			List<Train> trains = new ArrayList<>();
			trains.add(new Train(2L, new Date(2019,07,01), "72001", 184, "TGV"));
			trains.add(new Train(1L, new Date(2019,07,01), "73001", 157, "TGV"));
			trains.add(new Train(6L, new Date(2019,07,01), "96001", 189, "TGV"));
			trains.add(new Train(3L, new Date(2019,07,01), "57001", 179, "TGV"));
			for (Train train : trains) {
				stmt.setLong(1, train.getGareDepartId());
				stmt.setDate(2, new java.sql.Date(train.getDateDepart().getTime()));
				stmt.setString(3, train.getNumTrain());
				stmt.setInt(4, train.getNbPlaces());
				stmt.setString(5, train.getType());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void CreateTrain(Connection conn, Train train ) {
		try (PreparedStatement stmt = conn.
				prepareStatement("INSERT INTO train (gare_depart_id, date_depart, numero_train, nombre_place, type_train)VALUES (?,?,?,?,?)")){
				stmt.setLong(1, train.getGareDepartId());
				stmt.setDate(2, new java.sql.Date(train.getDateDepart().getTime()));
				stmt.setString(3, train.getNumTrain());
				stmt.setInt(4, train.getNbPlaces());
				stmt.setString(5, train.getType());
			
			stmt.addBatch();
			stmt.executeBatch();
		}catch (SQLException e) {
	e.printStackTrace();	
} 
}

		
	public void deleteTrain(Connection conn, long id) {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM train WHERE id=?")) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Train> getAllTrain(Connection conn) {
		List<Train> trains = new ArrayList<>();
		try (PreparedStatement stmt = conn
				.prepareStatement("SELECT id, gare_depart_id, date_depart, numero_train, nombre_place, type_train from train")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Train train = new Train();
				train.setId(rs.getLong("id"));
				train.setGareDepartId(rs.getLong("gare_depart_id"));
				train.setDateDepart(rs.getDate("date_depart"));
				train.setNumTrain(rs.getString("numero_train"));
				train.setNbPlaces(rs.getInt("nombre_place"));
				train.setType(rs.getString("type_train"));
				trains.add(train);
			}
		} catch (SQLException e) {
		}
		return trains;
	}
}
