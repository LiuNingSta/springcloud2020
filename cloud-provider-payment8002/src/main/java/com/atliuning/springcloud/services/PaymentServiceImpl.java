package com.atliuning.springcloud.services;

import com.atliuning.springcloud.dao.PaymentDao;
import com.atliuning.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl {

    @Autowired
    PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.insert(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.selectOne(new Payment(id, null));
    }

}
