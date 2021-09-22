import dao.CategoryDao;
import model.Category;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {

        try {
         /* Testcode for beers

            Beer beer = new Beer(3001, "Luc", 0, 0, 1.35, 2, 6);
            BeersDao beersDao = new BeersDao();
            beersDao.createBeer(beer);
            beersDao.deleteBeer(3000);
            beersDao.deleteBeer(7000);
            beersDao.getAllBeers().forEach(System.out::println);*/

           /* Testcode for brewers

            BrewersDao brewersDao = new BrewersDao();
            Brewer brewer = new Brewer(200, "Luc", "Herdebeekstraat 267", "1701", "Itterbeek", 20000);
            //brewersDao.createBrewer(brewer);
            Brewer brewerUpdate = new Brewer(201, "Luc VS", "Herdebeek", "1701", "Itterbeek", 10000);
            //brewersDao.updateBrewer(brewerUpdate,200);

            brewersDao.deleteBrewer(201);
            brewersDao.getAllBrewers().forEach(System.out::println);*/


            // Testcode for categories

            CategoryDao categoryDao = new CategoryDao();
            Category category = new Category(100, "Fruitbier");
            Category updatedCategory = new Category(100, "Fruitbier-kriek");
            categoryDao.createCategory(category);
            categoryDao.updateCategory(updatedCategory,100);
            //categoryDao.deleteCategory(100);
            categoryDao.getAllCategories().forEach(System.out::println);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}