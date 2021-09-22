package dao;

import model.Brewer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrewersDao {


    public Brewer getBrewerById(int id) throws SQLException {
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("SELECT * FROM Brewers WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        }
        Brewer brewer = new Brewer();
        if(resultSet.next()){
            brewer.setId(resultSet.getInt("Id"));
            brewer.setName(resultSet.getString("Name"));
            brewer.setAddress(resultSet.getString("Address"));
            brewer.setZipcode(resultSet.getString("Zipcode"));
            brewer.setCity(resultSet.getString("City"));
            brewer.setTurnover(resultSet.getInt("Turnover"));
        }
        return brewer;
    }

    public List<Brewer> getAllBrewers() throws SQLException {
        ResultSet resultSet;
        try (Statement statement = ConnectionClass.getConnection().createStatement()) {
            String select = "SELECT * FROM Brewers";
            resultSet = statement.executeQuery(select);
        }
        List<Brewer> brewers = new ArrayList<>();
        while (resultSet.next()){
            Brewer brewer = new Brewer();
            brewer.setId(resultSet.getInt("id"));
            brewer.setName(resultSet.getString("name"));
            brewer.setAddress(resultSet.getString("Address"));
            brewer.setZipcode(resultSet.getString("ZipCode"));
            brewer.setCity(resultSet.getString("City"));
            brewer.setTurnover(resultSet.getInt("Turnover"));
            brewers.add(brewer);
        }
        return brewers;
    }

    public void createBrewer(Brewer brewer) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("INSERT INTO Brewers(Id, Name, address, zipcode, city,turnover) VALUES (?,?,?,?,?,?)")) {
            preparedStatement.setInt(1, brewer.getId());
            preparedStatement.setString(2, brewer.getName());
            preparedStatement.setString(3, brewer.getAddress());
            preparedStatement.setString(4, brewer.getZipcode());
            preparedStatement.setString(5, brewer.getCity());
            preparedStatement.setInt(6, brewer.getTurnover());
            preparedStatement.execute();
        }

    }

    public void updateBrewer (Brewer brewer, int id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("UPDATE Brewers SET id = ?,name = ?, address =?, zipcode = ?, city =?, turnover=? WHERE id = ? ")) {
            preparedStatement.setInt(1, brewer.getId());
            preparedStatement.setString(2, brewer.getName());
            preparedStatement.setString(3, brewer.getAddress());
            preparedStatement.setString(4, brewer.getZipcode());
            preparedStatement.setString(5, brewer.getCity());
            preparedStatement.setInt(6, brewer.getTurnover());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteBrewer (int id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("DELETE FROM Brewers WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
