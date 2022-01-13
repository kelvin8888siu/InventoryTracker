package com.example.Inventory.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * ProductLog is a class used to create instances of a ProductLog object.
 * This class contains getters, setters and a toString method. This class
 * consists of the following attributes:
 *
 * logID: Log identification number.
 * productID: Product identification number.
 * quantity: Quantity of a product in stock in the inventory.
 * date: time-stamp of an update being made to the Products table.
 */
public class ProductLog {
    @JsonProperty("logID")
    private Integer logID;
    @JsonProperty("productID")
    private Integer productID;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("date")
    private LocalDate date;

    public ProductLog(int logID, int productID, int quantity, LocalDate date) {
        this.logID = logID;
        this.productID = productID;
        this.quantity = quantity;
        this.date = date;
    }

    public ProductLog(){};

    public ProductLog logID(Integer logID) {
        this.logID = logID;
        return this;
    }

    @ApiModelProperty(
            example = "12345",
            required = true,
            value = ""
    )
    @NotNull
    @Min(0L)
    public Integer getLogID() {
        return this.logID;
    }

    public void setLogID(Integer logID) {
        this.logID = logID;
    }

    public ProductLog productID(Integer productID) {
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

    public ProductLog quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @ApiModelProperty(
            example = "5",
            required = true,
            value = ""
    )
    @NotNull
    @Min(0L)
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductLog date(LocalDate date) {
        this.date = date;
        return this;
    }

    @ApiModelProperty(
            example = "Sun Aug 28 20:00:00 EDT 2016",
            required = true,
            value = ""
    )
    @NotNull
    @Valid
    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ProductLog productLog = (ProductLog)o;
            return Objects.equals(this.logID, productLog.logID) && Objects.equals(this.productID, productLog.productID) && Objects.equals(this.quantity, productLog.quantity) && Objects.equals(this.date, productLog.date);
        } else {
            return false;
        }
    }
    public int hashCode() {
        return Objects.hash(new Object[]{this.logID, this.productID, this.quantity, this.date});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductLog {\n");
        sb.append("    logID: ").append(this.toIndentedString(this.logID)).append("\n");
        sb.append("    productID: ").append(this.toIndentedString(this.productID)).append("\n");
        sb.append("    quantity: ").append(this.toIndentedString(this.quantity)).append("\n");
        sb.append("    date: ").append(this.toIndentedString(this.date)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
