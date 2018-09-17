package com.capgemini.serviciosya.dao;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;

public interface IConsumerDao extends IDao<ConsumerEntity,Integer> {

    ConsumerEntity findByPhone(String phone);
    ConsumerEntity findByDni(Integer dni);
    ConsumerEntity findByEmail(String email);

}
