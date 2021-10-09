package com.fashionshop.server.services.Menu;

import com.fashionshop.server.models.MenuModel;
import com.fashionshop.server.repositories.IMenuRepository;
import com.fashionshop.server.services.Interface.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService implements IMenuService {

    @Autowired
    private IMenuRepository menuRepository;

    @Override
    public Iterable<MenuModel> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<MenuModel> findById(long id) {
        return menuRepository.findById(id);
    }

    @Override
    public MenuModel save(MenuModel menuModel) {
        return menuRepository.save(menuModel);
    }

    @Override
    public void remove(Long id) {
        menuRepository.deleteById(id);
    }
}
