package com.fashionshop.server.models;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
public class PaymentModel {

    @Id
    @GeneratedValue
    @Column( name = "payment_id")
    public Long paymentId;

    public String paymentName;

    public String paymentCost;

    private Long fkAccountPayment;
}
