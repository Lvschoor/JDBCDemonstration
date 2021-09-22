package dao;

import model.Beer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeersDao {



    public Beer getBeerById(int id) throws SQLException {
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("SELECT * FROM Beers WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        }
        Beer beer = new Beer();
        if(resultSet.next()){
            beer.setId(resultSet.getInt("id"));
            beer.setName(resultSet.getString("name"));
            beer.setAlcohol(resultSet.getInt("alcohol"));
            beer.setBrewerId(resultSet.getInt("BrewerId"));
            beer.setCategoryId(resultSet.getInt("CategoryId"));
            beer.setPrice(resultSet.getDouble("price"));
            beer.setStock(resultSet.getInt("stock"));
        }
        return beer;
    }

    public List<Beer> getAllBeers() throws SQLException {
        ResultSet resultSet;
        try (Statement statement = ConnectionClass.getConnection().createStatement()) {
            String select = "SELECT * FROM Beers";
            resultSet = statement.executeQuery(select);
        }
        List<Beer> beers = new ArrayList<>();
        while (resultSet.next()){
            Beer beer = new Beer();
            beer.setId(resultSet.getInt("id"));
            beer.setName(resultSet.getString("name"));
            beer.setAlcohol(resultSet.getInt("alcohol"));
            beer.setBrewerId(resultSet.getInt("BrewerId"));
            beer.setCategoryId(resultSet.getInt("CategoryId"));
            beer.setPrice(resultSet.getDouble("price"));
            beer.setStock(resultSet.getInt("stock"));
            beers.add(beer);
        }
        return beers;
    }

    public void createBeer(Beer beer) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("INSERT INTO Beers(Id, Name, price, stock, alcohol) VALUES (?,?,?,?,?)")) {
            preparedStatement.setInt(1, beer.getId());
            preparedStatement.setString(2, beer.getName());
            preparedStatement.setDouble(3, beer.getPrice());
            preparedStatement.setInt(4, beer.getStock());
            preparedStatement.setInt(5, beer.getAlcohol());
            preparedStatement.execute();
        }
    }

    public void updateBeer (Beer beer, int id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("UPDATE Beers SET id = ?,name = ?, price =?, stock = ?, alcohol =? WHERE id = ? ")) {
            preparedStatement.setInt(1, beer.getId());
            preparedStatement.setString(2, beer.getName());
            preparedStatement.setDouble(3, beer.getPrice());
            preparedStatement.setInt(4, beer.getStock());
            preparedStatement.setInt(5, beer.getAlcohol());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteBeer (int id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("DELETE FROM Beers WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }



}
