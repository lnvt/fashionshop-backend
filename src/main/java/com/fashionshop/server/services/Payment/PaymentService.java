package com.fashionshop.server.services.Payment;

import com.fashionshop.server.models.PaymentModel;
import com.fashionshop.server.repositories.IPaymentRepository;
import com.fashionshop.server.services.Interface.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public Iterable<PaymentModel> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<PaymentModel> findById(long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public PaymentModel save(PaymentModel paymentModel) {
        return paymentRepository.save(paymentModel);
    }

    @Override
    public void remove(Long id) {
        paymentRepository.deleteById(id);
    }
}
