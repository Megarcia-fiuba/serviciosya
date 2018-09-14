
package com.capgemini.serviciosya.dao;


import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import com.capgemini.serviciosya.dao.IDao;


public interface IProviderDao extends IDao<ProviderEntity, Integer> {


    ProviderEntity findByEmail (String email);

    ProviderEntity findByDNI (Integer dni);

    ProviderEntity findByPhone (String phone);
}