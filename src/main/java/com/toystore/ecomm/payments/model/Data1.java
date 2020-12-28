package com.toystore.ecomm.payments.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.toystore.ecomm.payments.factory.UIModelFactory;

import io.swagger.annotations.ApiModelProperty;

/**
 * Data
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-06T13:12:16.732Z")
@Component
public class Data1 {

	static {
		UIModelFactory.register("DATA1", Data1.class);
	}

	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("startDate")
	private String startDate = null;

	@JsonProperty("endDate")
	private String endDate = null;

	public Data1 id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Data1 startDate(String startDate) {
		this.startDate = startDate;
		return this;
	}

	/**
	 * This indicates the Start Date of Subscription
	 * 
	 * @return startDate
	 **/
	@ApiModelProperty(required = false, value = "This indicates the Start Date of Subscription")

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Data1 endDate(String endDate) {
		this.endDate = endDate;
		return this;
	}

	/**
	 * This indicates the End Date of Subscription
	 * 
	 * @return endDate
	 **/
	@ApiModelProperty(required = false, value = "This indicates the End Date of Subscription")

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Data1 data = (Data1) o;
		return Objects.equals(this.id, data.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Data {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
		sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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
