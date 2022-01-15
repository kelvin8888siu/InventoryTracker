package com.example.Inventory.Service;

import com.example.Inventory.Model.ProductLog;
import com.example.Inventory.ORM.ProductLogDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ProductlogApiDelegateImpl implements ProductlogApiDelegate {

    @Override
    public ResponseEntity<ProductLog> searchProductLog() {
        ProductLogDAO dao = new ProductLogDAO();
        ProductLog product = null;
        try {
            product = dao.search();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return ResponseEntity.ok(product);
    }
}
