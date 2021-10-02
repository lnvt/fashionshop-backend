package com.fashionshop.server.repositories;

import com.fashionshop.server.models.RoleAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleAccountRepository extends JpaRepository<RoleAccountModel,Long> {
}
