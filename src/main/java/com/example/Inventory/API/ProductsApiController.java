package com.example.Inventory.API;

import java.util.Optional;

import com.example.Inventory.Service.ProductsApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"${openapi.simpleInventory.base-path:}"})
public class ProductsApiController implements ProductsApi {
    private final ProductsApiDelegate delegate;

    public ProductsApiController(@Autowired(required = false) ProductsApiDelegate delegate) {
        this.delegate = (ProductsApiDelegate)Optional.ofNullable(delegate).orElse(new ProductsApiDelegate() {
        });
    }

    public ProductsApiDelegate getDelegate() {
        return this.delegate;
    }
}
