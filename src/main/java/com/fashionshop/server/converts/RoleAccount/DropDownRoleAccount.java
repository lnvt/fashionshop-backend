package com.fashionshop.server.converts.RoleAccount;

import com.fashionshop.server.dtos.RoleAccount.DropDownRoleAccountResponse;
import com.fashionshop.server.models.RoleAccountModel;

public class DropDownRoleAccount {

    public static DropDownRoleAccountResponse mappingDropDownRoleAccount(RoleAccountModel roleAccountModel)
    {
        DropDownRoleAccountResponse dropDownRoleAccountResponse = new DropDownRoleAccountResponse();

        dropDownRoleAccountResponse.setRoleId(roleAccountModel.getRoleId());
        dropDownRoleAccountResponse.setRoleName(roleAccountModel.getRoleName());

        return dropDownRoleAccountResponse;
    }
}
