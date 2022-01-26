package com.codetest.fucheng.transactionanalyses.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-26T23:35:26.279+11:00")




public class Transaction   {
  @JsonProperty("transactionId")
  private String transactionId = null;

  @JsonProperty("fromAccountId")
  private String fromAccountId = null;

  @JsonProperty("toAccountId")
  private String toAccountId = null;

  @JsonProperty("createdAt")
  private String createdAt = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  /**
   * Gets or Sets transactionType
   */
  public enum TransactionTypeEnum {
    PAYMENT("PAYMENT"),
    
    REVERSAL("REVERSAL");

    private String value;

    TransactionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TransactionTypeEnum fromValue(String text) {
      for (TransactionTypeEnum b : TransactionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("transactionType")
  private TransactionTypeEnum transactionType = null;

  @JsonProperty("relatedTransaction")
  private String relatedTransaction = null;

  public Transaction transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * Get transactionId
   * @return transactionId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public Transaction fromAccountId(String fromAccountId) {
    this.fromAccountId = fromAccountId;
    return this;
  }

  /**
   * from account Id
   * @return fromAccountId
  **/
  @ApiModelProperty(value = "from account Id")


  public String getFromAccountId() {
    return fromAccountId;
  }

  public void setFromAccountId(String fromAccountId) {
    this.fromAccountId = fromAccountId;
  }

  public Transaction toAccountId(String toAccountId) {
    this.toAccountId = toAccountId;
    return this;
  }

  /**
   * to account Id
   * @return toAccountId
  **/
  @ApiModelProperty(value = "to account Id")


  public String getToAccountId() {
    return toAccountId;
  }

  public void setToAccountId(String toAccountId) {
    this.toAccountId = toAccountId;
  }

  public Transaction createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(example = "create date", value = "")


  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Transaction amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * transfer amount
   * @return amount
  **/
  @ApiModelProperty(value = "transfer amount")

  @Valid

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Transaction transactionType(TransactionTypeEnum transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  /**
   * Get transactionType
   * @return transactionType
  **/
  @ApiModelProperty(value = "")


  public TransactionTypeEnum getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionTypeEnum transactionType) {
    this.transactionType = transactionType;
  }

  public Transaction relatedTransaction(String relatedTransaction) {
    this.relatedTransaction = relatedTransaction;
    return this;
  }

  /**
   * related transaction id
   * @return relatedTransaction
  **/
  @ApiModelProperty(value = "related transaction id")


  public String getRelatedTransaction() {
    return relatedTransaction;
  }

  public void setRelatedTransaction(String relatedTransaction) {
    this.relatedTransaction = relatedTransaction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.transactionId, transaction.transactionId) &&
        Objects.equals(this.fromAccountId, transaction.fromAccountId) &&
        Objects.equals(this.toAccountId, transaction.toAccountId) &&
        Objects.equals(this.createdAt, transaction.createdAt) &&
        Objects.equals(this.amount, transaction.amount) &&
        Objects.equals(this.transactionType, transaction.transactionType) &&
        Objects.equals(this.relatedTransaction, transaction.relatedTransaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, fromAccountId, toAccountId, createdAt, amount, transactionType, relatedTransaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    fromAccountId: ").append(toIndentedString(fromAccountId)).append("\n");
    sb.append("    toAccountId: ").append(toIndentedString(toAccountId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
    sb.append("    relatedTransaction: ").append(toIndentedString(relatedTransaction)).append("\n");
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

