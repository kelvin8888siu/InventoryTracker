package com.example.Inventory.ORM;

import com.example.Inventory.Model.Products;
import java.sql.*;
import java.util.ArrayList;

/**
 * The ProductsDAO class is created for the purpose of mapping Products
 * objects to the Products entity in the relational database.
 */
public class ProductsDAO {
    protected ConnManager connManager;

    /**
     * ProductsDAO constructor: Used to create a ProductsDAO instance
     * for the purpose of generating a new instance of the ConnManager object.
     */
    public ProductsDAO(){
        this.connManager = new ConnManager();
    }

    /**
     * create() method: used for creating a new data record in the Products entity.
     * @param products attributes are required for the creation of a new Products entity data record.
     * @return products object is returned once the data record has been successfully added.
     * @throws SQLException
     */
    public Products create(Products products) throws SQLException {
        String insertProducts = "INSERT INTO Products(productID, poName, quantity, price, currency) VALUES(?,?,?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        try {
            connection = connManager.getConnection();
            insertStmt = connection.prepareStatement(insertProducts);
            insertStmt.setInt(1, products.getProductID());
            insertStmt.setString(2, products.getPoName());
            insertStmt.setInt(3, products.getQuantity());
            insertStmt.setDouble(4, products.getPrice());
            insertStmt.setString(5, products.getCurrency());
            insertStmt.executeUpdate();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    };

    /**
     * update method(): used to update a data record in the Products table.
     * @param productID the product ID is needed to update the correct data record.
     * @param products object is required for updating attributes of a particular data record.
     * @return products object is returned once a data record is successfully udpated.
     * @throws SQLException
     */
    public Products update(Integer productID, Products products) throws SQLException {
        String updateProducts = "UPDATE Products SET poName = ?, quantity = ?, price = ?, currency = ? WHERE productID = ?;";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        try {
            connection = connManager.getConnection();
            insertStmt = connection.prepareStatement(updateProducts);
            insertStmt.setString(1, products.getPoName());
            insertStmt.setInt(2, products.getQuantity());
            insertStmt.setDouble(3, products.getPrice());
            insertStmt.setString(4, products.getCurrency());
            insertStmt.setInt(5, productID);
            insertStmt.executeUpdate();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    };

    /**
     * delete method(): used to delete a data record from the Products table.
     * @param productsID is required to delete the correct product from the table.
     * @return result value.
     * @throws SQLException
     */
    public int delete(Integer productsID) throws SQLException {
        String delete = "DELETE FROM Products WHERE productID = ?";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connManager.getConnection();
            deleteStmt = connection.prepareStatement(delete);
            deleteStmt.setInt(1, productsID);
            int result = deleteStmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (deleteStmt != null) {
                deleteStmt.close();
            }
        }
    };

    /**
     * search method(): used for selecting or viewing a specific data record in the database.
     * @param productsID is required for viewing a specific product in the Products table.
     * @return products object is returned.
     * @throws SQLException
     */
    public Products search(Integer productsID) throws SQLException {
        String selectStmt = "SELECT * FROM Products WHERE productID = ?;";
        Connection connection = null;
        PreparedStatement select = null;
        ResultSet result = null;

        try {
            connection = connManager.getConnection();
            select = connection.prepareStatement(selectStmt);
            select.setInt(1, productsID);
            result = select.executeQuery();
            if(result.next()) {
                int resultID = result.getInt("productID");
                String resultName = result.getString("poName");
                int resultQuantity = result.getInt("quantity");
                double resultPrice = result.getDouble("price");
                String resultCurrency = result.getString("currency");
                Products products = new Products(resultID, resultName, resultQuantity, resultPrice, resultCurrency);
                return products;
            }
            return null;
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (select != null) {
                select.close();
            }
            if (result != null) {
                result.close();
            }
        }
    };

    /**
     * searchAll method(): used to select or view all data records from the Products table.
     * @return productList is an array list consisting of a product objects that represent
     *         each data record from the Products table.
     * @throws SQLException
     */
    public ArrayList<Products> searchAll() throws SQLException {
        String products = "SELECT * FROM Products";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet result = null;
        try {
            connection = connManager.getConnection();
            selectStmt = connection.prepareStatement(products);
            result = selectStmt.executeQuery();
            ArrayList<Products> productList = new ArrayList<Products>();

            while (result.next()) {
                int resultID = result.getInt("productID");
                String resultName = result.getString("poName");
                int resultQuantity = result.getInt("quantity");
                double resultPrice = result.getDouble("price");
                String resultCurrency = result.getString("currency");
                Products object = new Products(resultID, resultName, resultQuantity, resultPrice, resultCurrency);
                productList.add(object);
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (selectStmt != null) {
                selectStmt.close();
            }
            if (result != null) {
                result.close();
            }
        }
    };
}
