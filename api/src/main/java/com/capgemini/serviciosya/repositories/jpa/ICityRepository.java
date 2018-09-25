package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<CityEntity,Integer> {

    CityEntity findOnByName(String name);

    List<CityEntity> findAllByProvince(ProvinceEntity province);
}
