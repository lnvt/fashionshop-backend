package com.fashionshop.server.models;


import javax.persistence.*;

@Entity
@Table(name = "code_sale")
public class CodeSaleModel {

    @Id
    @GeneratedValue
    @Column(name = "code_sale_id")
    public Long CodeSaleId;

    @Column(name = "code_sale_name")
    public String CodeSaleName;

    @Column(name = "code_sale_percent_cost")
    public Long CodeSalePercentCost;

    @Column(name = "code_sale_status")
    public Boolean CodeSaleStatus;

    public CodeSaleModel(Long codeSaleId, String codeSaleName, Long codeSalePercentCost, Boolean codeSaleStatus) {
        CodeSaleId = codeSaleId;
        CodeSaleName = codeSaleName;
        CodeSalePercentCost = codeSalePercentCost;
        CodeSaleStatus = codeSaleStatus;
    }

    public Long getCodeSaleId() {
        return CodeSaleId;
    }

    public void setCodeSaleId(Long codeSaleId) {
        CodeSaleId = codeSaleId;
    }

    public String getCodeSaleName() {
        return CodeSaleName;
    }

    public void setCodeSaleName(String codeSaleName) {
        CodeSaleName = codeSaleName;
    }

    public Long getCodeSalePercentCost() {
        return CodeSalePercentCost;
    }

    public void setCodeSalePercentCost(Long codeSalePercentCost) {
        CodeSalePercentCost = codeSalePercentCost;
    }

    public Boolean getCodeSaleStatus() {
        return CodeSaleStatus;
    }

    public void setCodeSaleStatus(Boolean codeSaleStatus) {
        CodeSaleStatus = codeSaleStatus;
    }

    @Override
    public String toString() {
        return "CodeSaleModel{" +
                "CodeSaleId=" + CodeSaleId +
                ", CodeSaleName='" + CodeSaleName + '\'' +
                ", CodeSalePercentCost=" + CodeSalePercentCost +
                ", CodeSaleStatus=" + CodeSaleStatus +
                '}';
    }
}
