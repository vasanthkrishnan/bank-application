package bank.entity;

import java.time.LocalDate;

public class Transaction {

    private LocalDate transactionDate;
    private String transactionuserId;
    private Double transactionAmount;
    private String transactionType;
    private Double initialBalance;
    private Double finalBalance;
    private String transactionPerformedBy;

    public Transaction(LocalDate transancionDate, String transactionuserId, Double transactionAmount, String transactionType, 
                            Double initialBalance, Double finalBalance, String transactionPerformedBy) {
            
        this.transactionDate = transancionDate;
        this.transactionuserId = transactionuserId;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
        this.transactionPerformedBy = transactionPerformedBy;

    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
    public String getTransactionUserId() {
        return transactionuserId;
    }
    public void setTransactionUserId(String transactionUserId) {
        this.transactionuserId = transactionUserId;
    }
    public Double getTransactionAmount() {
        return transactionAmount;
    } 
    public void setTransactionAmount(Double trnasactionAmount) {
        this.transactionAmount = trnasactionAmount;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public Double getInitialBalance() {
        return initialBalance;
    }
    public void setIntialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }
    public Double getFinlaBalance() {
        return finalBalance;
    }
    public void setFinalBalance(Double finalBalance) {
        this.finalBalance = finalBalance;
    }
    public String getTransactionPerformedBy() {
        return transactionPerformedBy;
    }
    public void setTransactionPerformedBy(String transactionPerformedBy) {
        this.transactionPerformedBy = transactionPerformedBy;
    }

    @Override
    public String toString() {
        return "Transaction{" + 
                "Transaction Date : " + transactionDate + ", " +
                "Transaction UserId : " + transactionuserId + ", " +
                "Transaction Amound : " + transactionAmount + ", " +
                "Transaction Type : " + transactionType + ", " +
                "Initial Balance : " + initialBalance + ", " +
                "Final Balance : " + finalBalance + ", " + 
                "Transaction Performed By : " + transactionPerformedBy + " " +
                "}";
    }

}
