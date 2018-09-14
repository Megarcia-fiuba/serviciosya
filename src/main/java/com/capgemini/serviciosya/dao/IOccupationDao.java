
package com.capgemini.serviciosya.dao;


import java.util.List;

import com.capgemini.serviciosya.beans.entity.OccupationEntity;


public interface IOccupationDao extends IDao<OccupationEntity, Integer> {

    /**
     *
     *  <p>Return a list of all the occupations available.
     *
     *  @return Return a list of occupations
     * */
    List<OccupationEntity> findall ();


    /**
     *
     *  <p> Adds an occupation
     * */
    void create (OccupationEntity occupation);

    /**
     *
     *  <p> Receives an occupation id
     *      Returns an occupation with the same id or null if there is none
     *
     *  @return Return an occupation or null.
     * */
    OccupationEntity findById(Integer id);

    /**
     *
     *  <p> Receives an occupation id and a new name for it. Then changes its name if found.
     *
     * */
    void update(OccupationEntity oc);

    void delete (Integer id);

}
