package com.example.Inventory.WebController;

import com.example.Inventory.Model.Products;
import com.example.Inventory.ORM.ProductsDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class WebControllerCreateProducts {
    @GetMapping("/products/create")
        public String createProductForm(Model model) {
        model.addAttribute("products", new Products());
        return "createProducts";
    }

    @PostMapping("/products/create")
    public String submitProductForm(@ModelAttribute("products") Products product) throws SQLException {
        ProductsDAO dao = new ProductsDAO();
        dao.create(product);
        return "redirect:/products";
    }
}
