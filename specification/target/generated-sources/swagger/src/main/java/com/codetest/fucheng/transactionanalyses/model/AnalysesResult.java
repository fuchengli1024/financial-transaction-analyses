package com.codetest.fucheng.transactionanalyses.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AnalysesResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-26T23:35:26.279+11:00")




public class AnalysesResult   {
  @JsonProperty("relativeBalance")
  private BigDecimal relativeBalance = null;

  @JsonProperty("numbers")
  private Integer numbers = null;

  public AnalysesResult relativeBalance(BigDecimal relativeBalance) {
    this.relativeBalance = relativeBalance;
    return this;
  }

  /**
   * transfer amount
   * @return relativeBalance
  **/
  @ApiModelProperty(value = "transfer amount")

  @Valid

  public BigDecimal getRelativeBalance() {
    return relativeBalance;
  }

  public void setRelativeBalance(BigDecimal relativeBalance) {
    this.relativeBalance = relativeBalance;
  }

  public AnalysesResult numbers(Integer numbers) {
    this.numbers = numbers;
    return this;
  }

  /**
   * transaction number
   * @return numbers
  **/
  @ApiModelProperty(value = "transaction number")


  public Integer getNumbers() {
    return numbers;
  }

  public void setNumbers(Integer numbers) {
    this.numbers = numbers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalysesResult analysesResult = (AnalysesResult) o;
    return Objects.equals(this.relativeBalance, analysesResult.relativeBalance) &&
        Objects.equals(this.numbers, analysesResult.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relativeBalance, numbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalysesResult {\n");
    
    sb.append("    relativeBalance: ").append(toIndentedString(relativeBalance)).append("\n");
    sb.append("    numbers: ").append(toIndentedString(numbers)).append("\n");
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

