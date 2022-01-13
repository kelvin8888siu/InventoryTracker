package com.example.Inventory.ORM;

import com.example.Inventory.Model.ProductLog;
import com.example.Inventory.Model.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * The ProductLogDAO class is created for the purpose of mapping ProductLog
 * objects to the ProductLog entity in the relational database.
 */
public class ProductLogDAO {
    protected ConnManager connManager;

    /**
     * ProductLogDAO constructor: Used to create a ProductLogDAO instance
     * for the purpose of generating a new instance of the ConnManager object.
     */
    public ProductLogDAO() {this.connManager = new ConnManager();}

    /**
     * search() method: used for accessing all data records from the ProductLog entity.
     * @return a ProductLog object will be returned containing information relating a
     *         single data record from the ProductLog entity.
     * @throws SQLException
     */
    public ProductLog search() throws SQLException {
        String selectStmt = "SELECT * FROM ProductLog;";
        Connection connection = null;
        PreparedStatement select = null;
        ResultSet result = null;

        try {
            connection = connManager.getConnection();
            select = connection.prepareStatement(selectStmt);
            result = select.executeQuery();
            if(result.next()) {
                int resultLID = result.getInt("logID");
                int resultPID = result.getInt("productID");
                int resultQuantity = result.getInt("quantity");
                LocalDate resultDate = result.getDate("date").toLocalDate();
                ProductLog object = new ProductLog(resultLID, resultPID, resultQuantity, resultDate);
                return object;
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
}
