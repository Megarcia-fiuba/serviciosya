package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<CityEntity,Integer> {
}
