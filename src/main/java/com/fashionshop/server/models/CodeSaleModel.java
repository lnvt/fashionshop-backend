package com.fashionshop.server.models;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "code_sale")
public class CodeSaleModel {

    @Id
    @GeneratedValue
    @Column(name = "code_sale_id")
    public Long codeSaleId;

    @Column(name = "code_sale_name")
    public String codeSaleName;

    @Column(name = "code_sale_percent_cost")
    public Long codeSalePercentCost;

    @Column(name = "code_sale_status")
    public Boolean codeSaleStatus;


}
