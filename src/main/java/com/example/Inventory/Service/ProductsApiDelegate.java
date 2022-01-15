package com.example.Inventory.Service;

import com.example.Inventory.API.ApiUtil;
import com.example.Inventory.Model.Products;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

public interface ProductsApiDelegate {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    default ResponseEntity<Void> createProduct(Products products) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Resource> productsExportToCSVGet() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Void> deleteProduct(Integer productID) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<ArrayList<Products>> searchInventory() {
        this.getRequest().ifPresent((request) -> {
            Iterator var1 = MediaType.parseMediaTypes(request.getHeader("Accept")).iterator();

            while(var1.hasNext()) {
                MediaType mediaType = (MediaType)var1.next();
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"quantity\" : 5, \"productID\" : 12345, \"poName\" : \"Collier Sofa - Dark Blue\", \"price\" : 10.5, \"currency\" : \"USD\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }

        });
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Products> searchProductID(Integer productID) {
        this.getRequest().ifPresent((request) -> {
            Iterator var1 = MediaType.parseMediaTypes(request.getHeader("Accept")).iterator();

            while(var1.hasNext()) {
                MediaType mediaType = (MediaType)var1.next();
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"quantity\" : 5, \"productID\" : 12345, \"poName\" : \"Collier Sofa - Dark Blue\", \"price\" : 10.5, \"currency\" : \"USD\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }

        });
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Void> updateProduct(int productID, Products products) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
}
