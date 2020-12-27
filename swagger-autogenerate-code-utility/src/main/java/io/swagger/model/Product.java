package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Product
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-05T14:21:34.873+05:30")

public class Product   {
  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("productShortName")
  private String productShortName = null;

  @JsonProperty("productLongName")
  private String productLongName = null;

  @JsonProperty("productDescription")
  private String productDescription = null;

  @JsonProperty("productSku")
  private String productSku = null;

  @JsonProperty("productCategoryId")
  private Integer productCategoryId = null;

  @JsonProperty("productUnitPrice")
  private Double productUnitPrice = null;

  @JsonProperty("productAvailable")
  private String productAvailable = null;

  @JsonProperty("productTypeId")
  private Integer productTypeId = null;

  @JsonProperty("productImagesId")
  private String productImagesId = null;

  public Product productId(Integer productId) {
    this.productId = productId;
    return this;
  }

  /**
   * This is the ID of the product
   * @return productId
  **/
  @ApiModelProperty(required = true, value = "This is the ID of the product")
  @NotNull


  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Product productShortName(String productShortName) {
    this.productShortName = productShortName;
    return this;
  }

  /**
   * Short Searchable name of the product
   * @return productShortName
  **/
  @ApiModelProperty(required = true, value = "Short Searchable name of the product")
  @NotNull


  public String getProductShortName() {
    return productShortName;
  }

  public void setProductShortName(String productShortName) {
    this.productShortName = productShortName;
  }

  public Product productLongName(String productLongName) {
    this.productLongName = productLongName;
    return this;
  }

  /**
   * Complete name of the product
   * @return productLongName
  **/
  @ApiModelProperty(value = "Complete name of the product")


  public String getProductLongName() {
    return productLongName;
  }

  public void setProductLongName(String productLongName) {
    this.productLongName = productLongName;
  }

  public Product productDescription(String productDescription) {
    this.productDescription = productDescription;
    return this;
  }

  /**
   * This is detailed description of the product
   * @return productDescription
  **/
  @ApiModelProperty(required = true, value = "This is detailed description of the product")
  @NotNull


  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Product productSku(String productSku) {
    this.productSku = productSku;
    return this;
  }

  /**
   * Internally identifiable sku for the product
   * @return productSku
  **/
  @ApiModelProperty(required = true, value = "Internally identifiable sku for the product")
  @NotNull


  public String getProductSku() {
    return productSku;
  }

  public void setProductSku(String productSku) {
    this.productSku = productSku;
  }

  public Product productCategoryId(Integer productCategoryId) {
    this.productCategoryId = productCategoryId;
    return this;
  }

  /**
   * Denotes the id of the category that the product belongs to. (foreign key to category table)
   * @return productCategoryId
  **/
  @ApiModelProperty(required = true, value = "Denotes the id of the category that the product belongs to. (foreign key to category table)")
  @NotNull


  public Integer getProductCategoryId() {
    return productCategoryId;
  }

  public void setProductCategoryId(Integer productCategoryId) {
    this.productCategoryId = productCategoryId;
  }

  public Product productUnitPrice(Double productUnitPrice) {
    this.productUnitPrice = productUnitPrice;
    return this;
  }

  /**
   * Price of the product
   * @return productUnitPrice
  **/
  @ApiModelProperty(required = true, value = "Price of the product")
  @NotNull


  public Double getProductUnitPrice() {
    return productUnitPrice;
  }

  public void setProductUnitPrice(Double productUnitPrice) {
    this.productUnitPrice = productUnitPrice;
  }

  public Product productAvailable(String productAvailable) {
    this.productAvailable = productAvailable;
    return this;
  }

  /**
   * Denotes the availability of the product
   * @return productAvailable
  **/
  @ApiModelProperty(value = "Denotes the availability of the product")


  public String getProductAvailable() {
    return productAvailable;
  }

  public void setProductAvailable(String productAvailable) {
    this.productAvailable = productAvailable;
  }

  public Product productTypeId(Integer productTypeId) {
    this.productTypeId = productTypeId;
    return this;
  }

  /**
   * Denotes the type of the product(product variant)(foreign key from item_type)
   * @return productTypeId
  **/
  @ApiModelProperty(value = "Denotes the type of the product(product variant)(foreign key from item_type)")


  public Integer getProductTypeId() {
    return productTypeId;
  }

  public void setProductTypeId(Integer productTypeId) {
    this.productTypeId = productTypeId;
  }

  public Product productImagesId(String productImagesId) {
    this.productImagesId = productImagesId;
    return this;
  }

  /**
   * Points to bucket name of the S3 image store
   * @return productImagesId
  **/
  @ApiModelProperty(value = "Points to bucket name of the S3 image store")


  public String getProductImagesId() {
    return productImagesId;
  }

  public void setProductImagesId(String productImagesId) {
    this.productImagesId = productImagesId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.productId, product.productId) &&
        Objects.equals(this.productShortName, product.productShortName) &&
        Objects.equals(this.productLongName, product.productLongName) &&
        Objects.equals(this.productDescription, product.productDescription) &&
        Objects.equals(this.productSku, product.productSku) &&
        Objects.equals(this.productCategoryId, product.productCategoryId) &&
        Objects.equals(this.productUnitPrice, product.productUnitPrice) &&
        Objects.equals(this.productAvailable, product.productAvailable) &&
        Objects.equals(this.productTypeId, product.productTypeId) &&
        Objects.equals(this.productImagesId, product.productImagesId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, productShortName, productLongName, productDescription, productSku, productCategoryId, productUnitPrice, productAvailable, productTypeId, productImagesId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productShortName: ").append(toIndentedString(productShortName)).append("\n");
    sb.append("    productLongName: ").append(toIndentedString(productLongName)).append("\n");
    sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
    sb.append("    productSku: ").append(toIndentedString(productSku)).append("\n");
    sb.append("    productCategoryId: ").append(toIndentedString(productCategoryId)).append("\n");
    sb.append("    productUnitPrice: ").append(toIndentedString(productUnitPrice)).append("\n");
    sb.append("    productAvailable: ").append(toIndentedString(productAvailable)).append("\n");
    sb.append("    productTypeId: ").append(toIndentedString(productTypeId)).append("\n");
    sb.append("    productImagesId: ").append(toIndentedString(productImagesId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

