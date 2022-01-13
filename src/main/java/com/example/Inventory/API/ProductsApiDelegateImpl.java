package com.example.Inventory.API;

import com.example.Inventory.API.ProductsApiDelegate;
import com.example.Inventory.Model.Products;
import com.example.Inventory.ORM.ProductsDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class ProductsApiDelegateImpl implements ProductsApiDelegate {

    @Override
    public ResponseEntity<Void> createProduct(Products products) {
        ProductsDAO dao = new ProductsDAO();
        Products object = new Products(products.getProductID(), products.getPoName(), products.getQuantity(), products.getPrice(), products.getCurrency());
        try {
            dao.create(object);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer productID) {
        ProductsDAO dao = new ProductsDAO();
        try {
            dao.delete(productID);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<Products> searchProductID(Integer productID) {
        ProductsDAO dao = new ProductsDAO();
        Products product = null;
        try {
            product = dao.search(productID);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<Void> updateProduct(int productID, Products products) {
        ProductsDAO dao = new ProductsDAO();
        Products object = new Products(products.getProductID(), products.getPoName(), products.getQuantity(), products.getPrice(), products.getCurrency());
        try {
            dao.update(productID, object);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<ArrayList<Products>> searchInventory() {
        ProductsDAO dao = new ProductsDAO();
        ArrayList<Products> records = null;
        try {
            records = dao.searchAll();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return ResponseEntity.ok(records);
    }
}
