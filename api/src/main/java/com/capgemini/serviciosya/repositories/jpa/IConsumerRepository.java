package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsumerRepository extends JpaRepository<ConsumerEntity,Integer> {

    ConsumerEntity findOneByPhone(String phone);
    ConsumerEntity findOneByDni(Integer dni);
    ConsumerEntity findOneByEmail(String email);

}
