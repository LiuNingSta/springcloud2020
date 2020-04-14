package com.atliuning.springcloud.dao;

import com.atliuning.springcloud.config.BaseMapper;
import com.atliuning.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

}
