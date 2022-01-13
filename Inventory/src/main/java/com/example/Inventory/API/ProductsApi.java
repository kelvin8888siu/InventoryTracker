package com.example.Inventory.API;

import com.example.Inventory.Model.Products;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Validated
@Api(
        value = "products",
        description = "the products API"
)
public interface ProductsApi {
    default ProductsApiDelegate getDelegate() {
        return new ProductsApiDelegate() {
        };
    }

    @ApiOperation(
            value = "Create a product",
            nickname = "createProduct",
            notes = "A product object is created",
            tags = {"products"}
    )
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Successful Operation"
    )})
    @RequestMapping(
            value = {"/products"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    default ResponseEntity<Void> createProduct(@ApiParam(value = "",required = true) @Valid @RequestBody Products products) {
        return this.getDelegate().createProduct(products);
    }

    @ApiOperation(
            value = "Delete an inventory item",
            nickname = "deleteProduct",
            notes = "Delete a product object",
            tags = {"products"}
    )
    @ApiResponses({@ApiResponse(
            code = 400,
            message = "Invalid productID supplied"
    ), @ApiResponse(
            code = 404,
            message = "Product not found"
    )})
    @RequestMapping(
            value = {"/products/{productID}"},
            method = {RequestMethod.DELETE}
    )
    default ResponseEntity<Void> deleteProduct(@ApiParam(value = "The product that needs to be deleted",required = true) @PathVariable("productID") Integer productID) {
        return this.getDelegate().deleteProduct(productID);
    }

    @ApiOperation(
            value = "Searches all inventory items",
            nickname = "searchInventory",
            notes = "Access entire inventory",
            response = Products.class,
            tags = {"products"}
    )
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Successful operation",
            response = Products.class
    ), @ApiResponse(
            code = 404,
            message = "Inventory not found"
    )})
    @RequestMapping(
            value = {"/products"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    default ResponseEntity<ArrayList<Products>> searchInventory() {
        return this.getDelegate().searchInventory();
    }

    @ApiOperation(
            value = "Searches inventory for items based on productID",
            nickname = "searchProductID",
            notes = "Specific productID is required to access all columns related to the inventory item",
            response = Products.class,
            tags = {"products"}
    )
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Successful operation",
            response = Products.class
    ), @ApiResponse(
            code = 400,
            message = "Invalid ID supplied"
    ), @ApiResponse(
            code = 404,
            message = "Product not found"
    )})
    @RequestMapping(
            value = {"/products/{productID}"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    default ResponseEntity<Products> searchProductID(@ApiParam(value = "ID of product to return",required = true) @PathVariable("productID") Integer productID) {
        return this.getDelegate().searchProductID(productID);
    }

    @ApiOperation(
            value = "Updated a product",
            nickname = "updateProduct",
            notes = "Inventory update based on productID",
            tags = {"products"}
    )
    @ApiResponses({@ApiResponse(
            code = 400,
            message = "Invalid productID supplied"
    ), @ApiResponse(
            code = 404,
            message = "Product not found"
    )})
    @RequestMapping(
            value = {"/products/{productID}"},
            consumes = {"application/json"},
            method = {RequestMethod.PUT}
    )
    default ResponseEntity<Void> updateProduct(@ApiParam(value = "Product that needs to be updated",required = true) @PathVariable("productID") int productID, @ApiParam(value = "",required = true) @Valid @RequestBody Products products) {
        return this.getDelegate().updateProduct(productID, products);
    }
}
