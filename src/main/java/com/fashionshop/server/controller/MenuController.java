package com.fashionshop.server.controller;

import com.fashionshop.server.models.MenuModel;
import com.fashionshop.server.services.Interface.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/menu")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping
    public ResponseEntity<Iterable<MenuModel>> getAllMenu() {
        return new ResponseEntity<>(menuService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuModel> getMenu(@PathVariable Long id) {
        Optional<MenuModel> menuModelOptional = menuService.findById(id);
        return menuModelOptional.map(menu -> new ResponseEntity<>(menu, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MenuModel> createMenu(@RequestBody MenuModel menu) {
        return new ResponseEntity<>(menuService.save(menu), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuModel> updateMenu(@PathVariable Long id, @RequestBody MenuModel menu) {
        Optional<MenuModel> menuModelOptional = menuService.findById(id);
        return menuModelOptional.map(item -> {
            menu.setMenuId(item.getMenuId());
            return new ResponseEntity<>(menuService.save(item), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MenuModel> deleteMenu(@PathVariable Long id) {
        Optional<MenuModel> menuModelOptional = menuService.findById(id);
        return menuModelOptional.map(item -> {
            menuService.remove(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
