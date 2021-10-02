package com.fashionshop.server.services.RoleAccount;

import com.fashionshop.server.converts.RoleAccount.DropDownRoleAccount;
import com.fashionshop.server.dtos.RoleAccount.DropDownRoleAccountResponse;
import com.fashionshop.server.models.RoleAccountModel;
import com.fashionshop.server.repositories.IRoleAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleAccountServices {
    @Autowired
    IRoleAccountRepository roleAccountRepository;

    public List<DropDownRoleAccountResponse> getDropDownRoleAccount()
    {
        List<RoleAccountModel> roleAccountModels = roleAccountRepository.findAll();
        List<DropDownRoleAccountResponse> dropDownRoleAccountResponses = new ArrayList<>();
        roleAccountModels.forEach( item -> {
            DropDownRoleAccountResponse dropDownRoleAccountResponse = DropDownRoleAccount.mappingDropDownRoleAccount(item);
            dropDownRoleAccountResponses.add(dropDownRoleAccountResponse);
        });
        return dropDownRoleAccountResponses;
    }
}
