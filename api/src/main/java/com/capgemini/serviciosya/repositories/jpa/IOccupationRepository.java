
package com.capgemini.serviciosya.repositories.jpa;


import java.util.List;

import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOccupationRepository extends JpaRepository<OccupationEntity, Integer> {

    OccupationEntity findOneById(Integer id);
    List<OccupationEntity> findAllByName(String name);

}
