package com.fashionshop.server.controller;


import com.fashionshop.server.models.PaymentModel;
import com.fashionshop.server.services.Interface.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/payment")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @GetMapping
    public ResponseEntity<Iterable<PaymentModel>> getAllPayment() {
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentModel> getPayment(@PathVariable Long id) {
        Optional<PaymentModel> paymentModelOptional = paymentService.findById(id);
        return paymentModelOptional.map(payment -> new ResponseEntity<>(payment, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PaymentModel> createPayment(@RequestBody PaymentModel payment) {
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentModel> updatePayment(@PathVariable Long id, @RequestBody PaymentModel payment) {
        Optional<PaymentModel> paymentModelOptional = paymentService.findById(id);
        return paymentModelOptional.map(item -> {
            payment.setPaymentId(item.getPaymentId());
            return new ResponseEntity<>(paymentService.save(item), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentModel> deletePayment(@PathVariable Long id) {
        Optional<PaymentModel> paymentModelOptional = paymentService.findById(id);
        return paymentModelOptional.map(item -> {
            paymentService.remove(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
