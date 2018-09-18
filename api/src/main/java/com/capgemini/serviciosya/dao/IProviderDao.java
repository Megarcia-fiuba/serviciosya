
package com.capgemini.serviciosya.dao;


import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import com.capgemini.serviciosya.dao.IDao;

import java.util.List;


public interface IProviderDao extends IDao<ProviderEntity, Integer> {


    ProviderEntity findByEmail (String email);

    ProviderEntity findByDNI (Integer dni);

    ProviderEntity findByPhone (String phone);

    List<ProviderEntity> findAllByLocation(Integer city_id);
}