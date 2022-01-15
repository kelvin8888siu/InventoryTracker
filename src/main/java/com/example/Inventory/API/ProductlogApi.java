package com.example.Inventory.API;

import com.example.Inventory.Model.ProductLog;
import com.example.Inventory.Service.ProductlogApiDelegate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Validated
@Api(
        value = "productlog",
        description = "the productlog API"
)
public interface ProductlogApi {
    default ProductlogApiDelegate getDelegate() {
        return new ProductlogApiDelegate() {
        };
    }

    @ApiOperation(
            value = "Searches entire log history",
            nickname = "searchProductLog",
            notes = "Retrieves all product log objects",
            response = ProductLog.class,
            tags = {"productLog"}
    )
    @ApiResponses({@ApiResponse(
            code = 200,
            message = "Successful operation",
            response = ProductLog.class
    ), @ApiResponse(
            code = 404,
            message = "Not found"
    )})
    @RequestMapping(
            value = {"/productlog"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    default ResponseEntity<ProductLog> searchProductLog() {
        return this.getDelegate().searchProductLog();
    }
}
