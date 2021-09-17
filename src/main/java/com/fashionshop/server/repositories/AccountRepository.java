package com.fashionshop.server.repositories;

import com.fashionshop.server.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository  extends JpaRepository<AccountModel, Long> {

}
