package com.example.Inventory.WebController;
import com.example.Inventory.ORM.ProductsDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class WebControllerDeleteProducts {
    @RequestMapping(value = "/products/delete", method = RequestMethod.GET)
    public String handleDeleteProduct(@RequestParam(name="productID")int productID) {
        ProductsDAO dao = new ProductsDAO();
        try {
            dao.delete(productID);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return "redirect:/products";
    }
}
