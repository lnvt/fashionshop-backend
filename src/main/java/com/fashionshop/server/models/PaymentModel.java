package com.fashionshop.server.models;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentModel {

    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    public Long PaymentId;

    @Column(name = "payment_name")
    public String PaymentName;

    @Column(name = "payment_cost")
    public String PaymentCost;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "account_id")
    public AccountModel fkAccountPayment;

    public PaymentModel(Long paymentId, String paymentName, String paymentCost, AccountModel fkAccountPayment) {
        PaymentId = paymentId;
        PaymentName = paymentName;
        PaymentCost = paymentCost;
        this.fkAccountPayment = fkAccountPayment;
    }

    public Long getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(Long paymentId) {
        PaymentId = paymentId;
    }

    public String getPaymentName() {
        return PaymentName;
    }

    public void setPaymentName(String paymentName) {
        PaymentName = paymentName;
    }

    public String getPaymentCost() {
        return PaymentCost;
    }

    public void setPaymentCost(String paymentCost) {
        PaymentCost = paymentCost;
    }

    public AccountModel getFkAccountPayment() {
        return fkAccountPayment;
    }

    public void setFkAccountPayment(AccountModel fkAccountPayment) {
        this.fkAccountPayment = fkAccountPayment;
    }

    @Override
    public String toString() {
        return "PaymentModel{" +
                "PaymentId=" + PaymentId +
                ", PaymentName='" + PaymentName + '\'' +
                ", PaymentCost='" + PaymentCost + '\'' +
                ", fkAccountPayment=" + fkAccountPayment +
                '}';
    }
}
