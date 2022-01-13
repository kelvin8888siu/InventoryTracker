package com.example.Inventory.WebController;

import com.example.Inventory.Model.Products;
import com.example.Inventory.ORM.ProductsDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class WebControllerUpdateProducts {
    @GetMapping("/products/update")
    public String getUpdateProductForm(Model model) {
        model.addAttribute("products", new Products());
        return "updateProducts";
    }

    @PostMapping("/products/update")
    public String updateProductForm(@ModelAttribute("products") Products product) throws SQLException {
        ProductsDAO dao = new ProductsDAO();
        dao.update(product.getProductID(), product);
        return "redirect:/products";
    }
}
