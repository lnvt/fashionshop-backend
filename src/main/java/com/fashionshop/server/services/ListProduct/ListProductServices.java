package com.fashionshop.server.services.ListProduct;

import com.fashionshop.server.models.ListProductModel;
import com.fashionshop.server.repositories.IListProductRepository;
import com.fashionshop.server.services.Interface.IListProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ListProductServices implements IListProductService {

    @Autowired
    private IListProductRepository listProductRepository;


    @Override
    public Iterable<ListProductModel> findAll() {
        return listProductRepository.findAll();
    }

    @Override
    public Optional<ListProductModel> findById(long id) {
        return listProductRepository.findById(id);
    }

    @Override
    public ListProductModel save(ListProductModel listProductModel) {
        return listProductRepository.save(listProductModel);
    }

    @Override
    public void remove(Long id) {
        listProductRepository.deleteById(id);
    }
}
