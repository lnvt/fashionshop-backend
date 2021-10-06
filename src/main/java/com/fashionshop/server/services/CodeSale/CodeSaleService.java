package com.fashionshop.server.services.CodeSale;

import com.fashionshop.server.models.CodeSaleModel;
import com.fashionshop.server.repositories.ICodeSaleRepository;
import com.fashionshop.server.services.Interface.ICodeSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CodeSaleService implements ICodeSaleService {

    @Autowired
    private ICodeSaleRepository codeSaleRepository;

    @Override
    public Iterable<CodeSaleModel> findAll() {
        return codeSaleRepository.findAll();
    }

    @Override
    public Optional<CodeSaleModel> findById(long id) {
        return codeSaleRepository.findById(id);
    }

    @Override
    public CodeSaleModel save(CodeSaleModel codeSale) {
        return codeSaleRepository.save(codeSale);
    }

    @Override
    public void remove(Long id) {
        codeSaleRepository.deleteById(id);
    }
}
