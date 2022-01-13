package com.example.Inventory.WebController;

import com.example.Inventory.Model.Products;
import com.example.Inventory.ORM.ProductsDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class WebControllerSearchProducts {
    @GetMapping("/products")
    public String searchAll(Model model) {
        ProductsDAO dao = new ProductsDAO();
        try {
            model.addAttribute("products", dao.searchAll());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return "products";
    }

    @GetMapping("/products/exportcsv")
    public void exportToCSV(HttpServletResponse response) throws IOException, SQLException {

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment: filename=users_");

        CsvBeanWriter writer = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] header = {"Product ID", "Product Name", "Quantity in Stock", "Price Per Unit", "Currency"};
        String[] fieldName = {"productID", "poName", "quantity", "price", "currency"};
        writer.writeHeader(header);

        ProductsDAO dao = new ProductsDAO();
        ArrayList<Products> array = dao.searchAll();

        for (Products product: array){
            writer.write(product, fieldName);
        }

        writer.close();
    }
}