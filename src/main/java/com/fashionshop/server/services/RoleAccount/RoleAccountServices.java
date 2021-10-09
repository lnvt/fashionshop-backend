package com.fashionshop.server.services.RoleAccount;

import com.fashionshop.server.models.RoleAccountModel;
import com.fashionshop.server.repositories.IRoleAccountRepository;
import com.fashionshop.server.services.Interface.IRoleAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleAccountServices implements IRoleAccountService {

    @Autowired
    private IRoleAccountRepository roleAccountRepository;


    @Override
    public Iterable<RoleAccountModel> findAll() {
        return roleAccountRepository.findAll();
    }

    @Override
    public Optional<RoleAccountModel> findById(long id) {
        return roleAccountRepository.findById(id);
    }

    @Override
    public RoleAccountModel save(RoleAccountModel roleAccountModel) {
        return roleAccountRepository.save(roleAccountModel);
    }

    @Override
    public void remove(Long id) {
        roleAccountRepository.deleteById(id);
    }
}
