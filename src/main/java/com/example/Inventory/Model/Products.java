package com.example.Inventory.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Products is a class used to create instances of a Products object.
 * This class contains getters, setters and a toString method. This class
 * consists of the following attributes:
 *
 * productID: Product identification number.
 * poName: Product name.
 * quantity: Quantity of a product in stock in the inventory.
 * price: Price of a product per unit.
 * currency: Currency of a product.
 */
public class Products {
    @JsonProperty("productID")
    private Integer productID;
    @JsonProperty("poName")
    private String poName;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("currency")
    private String currency;

    /**
     * Products Constructor.
     * @param productID
     * @param poName
     * @param quantity
     * @param price
     * @param currency
     */
    public Products(int productID, String poName, int quantity, double price, String currency) {
        this.productID = productID;
        this.poName = poName;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
    }

    /**
     * Products Constructor.
     */
    public Products(){};

    public Products productID(Integer productID) {
        this.productID = productID;
        return this;
    }

    @ApiModelProperty(
            example = "12345",
            required = true,
            value = ""
    )
    @NotNull
    @Min(0L)
    public Integer getProductID() {
        return this.productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Products poName(String poName) {
        this.poName = poName;
        return this;
    }

    @ApiModelProperty(
            example = "Collier Sofa - Dark Blue",
            required = true,
            value = ""
    )
    @NotNull
    public String getPoName() {
        return this.poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
    }

    public Products quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @ApiModelProperty(
            example = "5",
            required = true,
            value = ""
    )
    @NotNull
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Products price(Double price) {
        this.price = price;
        return this;
    }

    @ApiModelProperty(
            example = "10.5",
            required = true,
            value = ""
    )
    @NotNull
    @DecimalMin("0")
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Products currency(String currency) {
        this.currency = currency;
        return this;
    }

    @ApiModelProperty(
            example = "USD",
            required = true,
            value = ""
    )
    @NotNull
    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Products products = (Products)o;
            return Objects.equals(this.productID, products.productID) && Objects.equals(this.poName, products.poName) && Objects.equals(this.quantity, products.quantity) && Objects.equals(this.price, products.price) && Objects.equals(this.currency, products.currency);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.productID, this.poName, this.quantity, this.price, this.currency});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Products {\n");
        sb.append("    productID: ").append(this.toIndentedString(this.productID)).append("\n");
        sb.append("    poName: ").append(this.toIndentedString(this.poName)).append("\n");
        sb.append("    quantity: ").append(this.toIndentedString(this.quantity)).append("\n");
        sb.append("    price: ").append(this.toIndentedString(this.price)).append("\n");
        sb.append("    currency: ").append(this.toIndentedString(this.currency)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
