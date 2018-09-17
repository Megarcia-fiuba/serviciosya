package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.*;

import java.util.List;

public interface IService {

    void addCountry(CountryEntity country);
    void removeCountry(CountryEntity country);
    void addProvince(ProvinceEntity province);
    void removeProvince(ProvinceEntity province);
    void addCity(CityEntity city);
    void removeCity(CityEntity city);
    void addConsumer(ConsumerEntity consumer);
    void removeConsumer(ConsumerEntity consumer);
    void addProvider(ProviderEntity provider);
    void removeProvider(ProviderEntity provider);
    void addOccupation(OccupationEntity provider);
    void removeOccupation(OccupationEntity provider);
    List<ProviderEntity> findAvailableProviders(ConsumerEntity consumer);
    List<ProviderEntity> findByOccupation(OccupationEntity occupation);

}
