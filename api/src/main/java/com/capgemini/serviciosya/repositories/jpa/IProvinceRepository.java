package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvinceRepository extends JpaRepository<ProvinceEntity,Integer> {

    List<ProvinceEntity> findAllByCountry(CountryEntity country);
}
