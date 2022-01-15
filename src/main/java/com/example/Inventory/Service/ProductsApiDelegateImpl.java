package com.example.Inventory.Service;

import com.example.Inventory.Model.Products;
import com.example.Inventory.ORM.ProductsDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer productID) {
        ProductsDAO dao = new ProductsDAO();
        try {
            dao.delete(productID);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Products> searchProductID(Integer productID) {
        ProductsDAO dao = new ProductsDAO();
        Products product = null;
        try {
            product = dao.search(productID);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateProduct(int productID, Products products) {
        ProductsDAO dao = new ProductsDAO();
        Products object = new Products(products.getProductID(), products.getPoName(), products.getQuantity(), products.getPrice(), products.getCurrency());
        try {
            dao.update(productID, object);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ArrayList<Products>> searchInventory() {
        ProductsDAO dao = new ProductsDAO();
        ArrayList<Products> products= null;
        try {
            products = dao.searchAll();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Resource> productsExportToCSVGet() {
        // Header
        String[] csvHeader = {"Product ID", "Product Name", "Quantity in Stock", "Price Per Unit", "Currency"};

        // Data Retrieval
        ProductsDAO dao = new ProductsDAO();
        ArrayList<ArrayList<Object>> csvBody = null;
        try {
            csvBody = dao.exportCSV();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ByteArrayInputStream byteArrayOutputStream;

        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                // defining the CSV printer
                CSVPrinter csvPrinter = new CSVPrinter(
                        new PrintWriter(out),
                        // withHeader is optional
                        CSVFormat.DEFAULT.withHeader(csvHeader)
                );
        ) {
            // Populating the CSV content
            for (ArrayList<Object> product : csvBody)
                csvPrinter.printRecord(product);

            // Writing the underlying stream
            csvPrinter.flush();

            byteArrayOutputStream = new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        InputStreamResource fileInputStream = new InputStreamResource(byteArrayOutputStream);

        String csvFileName = "inventory.csv";

        // setting HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + csvFileName);
        // defining the custom Content-Type
        headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");

        return new ResponseEntity<>(fileInputStream, headers, HttpStatus.OK);
    }
}
