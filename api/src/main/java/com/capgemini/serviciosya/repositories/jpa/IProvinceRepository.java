package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<ProvinceEntity,Integer> {
}
