
package com.capgemini.serviciosya.repositories.jpa;


import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IProviderRepository extends JpaRepository<ProviderEntity, Integer> {


    ProviderEntity findOneByEmail (String email);

    ProviderEntity findOneByDni (Integer dni);

    ProviderEntity findOneByPhone (String phone);

    List<ProviderEntity> findAllByCity(Integer city_id);
}