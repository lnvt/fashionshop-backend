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
    @Column( name = "code_sale_id")
    public Long codeSaleId;

    public String codeSaleName;

    public Long codeSalePercentCost;

    public Boolean codeSaleStatus;

}
