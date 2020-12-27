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
 * Category
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-05T14:21:34.873+05:30")

public class Category   {
  @JsonProperty("categoryId")
  private Integer categoryId = null;

  @JsonProperty("categoryName")
  private String categoryName = null;

  @JsonProperty("categoryDescription")
  private String categoryDescription = null;

  public Category categoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * This is the ID of the category
   * @return categoryId
  **/
  @ApiModelProperty(required = true, value = "This is the ID of the category")
  @NotNull


  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Category categoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  /**
   * Name of the category
   * @return categoryName
  **/
  @ApiModelProperty(value = "Name of the category")


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public Category categoryDescription(String categoryDescription) {
    this.categoryDescription = categoryDescription;
    return this;
  }

  /**
   * Description of the category
   * @return categoryDescription
  **/
  @ApiModelProperty(value = "Description of the category")


  public String getCategoryDescription() {
    return categoryDescription;
  }

  public void setCategoryDescription(String categoryDescription) {
    this.categoryDescription = categoryDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.categoryId, category.categoryId) &&
        Objects.equals(this.categoryName, category.categoryName) &&
        Objects.equals(this.categoryDescription, category.categoryDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, categoryName, categoryDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
    sb.append("    categoryDescription: ").append(toIndentedString(categoryDescription)).append("\n");
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

