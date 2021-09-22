package dao;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public Category getCategoryById(int id) throws SQLException {
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("SELECT * FROM Categories WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        }
        Category category = new Category();
        if (resultSet.next()) {
            category.setId(resultSet.getInt("id"));
            category.setCategory(resultSet.getString("category"));
        }
        return category;

    }

    public List<Category> getAllCategories() throws SQLException {
        ResultSet resultSet;
        try (Statement statement = ConnectionClass.getConnection().createStatement()) {
            String select = "SELECT * FROM Categories";
            resultSet = statement.executeQuery(select);
        }
        List<Category> categories = new ArrayList<>();
        while (resultSet.next()) {
            Category category = new Category();
            category.setId(resultSet.getInt("id"));
            category.setCategory(resultSet.getString("category"));
            categories.add(category);
        }
        return categories;
    }

    public void createCategory(Category category) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("INSERT INTO Categories(Id, Category) VALUES (?,?)")) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getCategory());
            preparedStatement.execute();
        }
    }

    public void updateCategory (Category category, int id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("UPDATE Categories SET id = ?,category = ? WHERE id = ? ")) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getCategory());
            preparedStatement.setDouble(3, id);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteCategory (int id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("DELETE FROM Categories WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
