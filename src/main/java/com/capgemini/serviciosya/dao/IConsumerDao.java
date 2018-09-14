package com.capgemini.serviciosya.dao;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;

public interface IConsumerDao extends IDao<ConsumerEntity,Integer> {

    public ConsumerEntity findByFullName(String firstname,String lastname);
    public ConsumerEntity findByDni(Integer dni);
}
