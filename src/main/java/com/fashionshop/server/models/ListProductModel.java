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
@Table(name = "list_product")
public class ListProductModel {

    @Id
    private Long listProductId;

    private String listProductName;

    private Boolean listProductStatus;

}
