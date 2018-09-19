package com.capgemini.serviciosya.dao;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryDao extends JpaRepository<CountryEntity, Integer> {
}
