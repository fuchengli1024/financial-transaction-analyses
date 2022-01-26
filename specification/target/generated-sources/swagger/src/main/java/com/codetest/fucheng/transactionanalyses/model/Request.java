package com.codetest.fucheng.transactionanalyses.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Request
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-26T23:35:26.279+11:00")




public class Request   {
  @JsonProperty("accountId")
  private String accountId = null;

  @JsonProperty("from")
  private String from = null;

  @JsonProperty("to")
  private String to = null;

  public Request accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * from account Id
   * @return accountId
  **/
  @ApiModelProperty(value = "from account Id")


  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public Request from(String from) {
    this.from = from;
    return this;
  }

  /**
   * start date
   * @return from
  **/
  @ApiModelProperty(example = "2018-10-20T12:00:00", value = "start date")


  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public Request to(String to) {
    this.to = to;
    return this;
  }

  /**
   * end date
   * @return to
  **/
  @ApiModelProperty(example = "2018-10-20T19:00:00", value = "end date")


  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Request request = (Request) o;
    return Objects.equals(this.accountId, request.accountId) &&
        Objects.equals(this.from, request.from) &&
        Objects.equals(this.to, request.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, from, to);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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

