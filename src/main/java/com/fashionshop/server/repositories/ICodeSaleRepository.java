package com.fashionshop.server.repositories;

import com.fashionshop.server.models.CodeSaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeSaleRepository extends JpaRepository<CodeSaleModel, Long> {
}
