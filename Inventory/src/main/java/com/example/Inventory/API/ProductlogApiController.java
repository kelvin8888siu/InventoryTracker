package com.example.Inventory.API;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping({"${openapi.simpleInventory.base-path:}"})
public class ProductlogApiController implements ProductlogApi {
    private final ProductlogApiDelegate delegate;

    public ProductlogApiController(@Autowired(required = false) ProductlogApiDelegate delegate) {
        this.delegate = (ProductlogApiDelegate)Optional.ofNullable(delegate).orElse(new ProductlogApiDelegate() {
        });
    }

    public ProductlogApiDelegate getDelegate() {
        return this.delegate;
    }
}
