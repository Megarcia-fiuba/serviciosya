
package com.cagmeini.serviciosya.dao;


import java.util.List;

import com.cagmeini.serviciosya.beans.domain.Occupation;


public interface IOccupationDao extends IDao<Occupation, Integer> {

    /**
     *
     *  <p>Return a list of all the occupations available.
     *
     *  @return Return a list of occupations
     * */
    List<Occupation> findall ();

    /**
     *
     *  <p> Receives an occupation name
     *      Return a list of all the duplicates.
     *
     *  @return Return a list of occupations with the name received.
     * */
    List<Occupation> findDuplicates (String name);

    /**
     *
     *  <p> Adds an occupation
     * */
    void create (Occupation occupation);

    /**
     *
     *  <p> Receives an occupation id
     *      Returns an occupation with the same id or null if there is none
     *
     *  @return Return an occupation or null.
     * */
    Occupation findById(Integer id);


    /**
     *
     *  <p> Receives an occupation id
     *      Returns a description of an occupation with the same id or null if there is none
     *
     *  @return Return a String or null.
     * */
    String getDescprition(int id);

    /**
     *
     *  <p> Receives an occupation id
     *      Returns True if found or False if not
     *
     *  @return Returns True if found or False if not
     * */
    boolean exists(int id);

    /**
     *
     *  <p> Receives an occupation id and a new name for it. Then changes its name if found.
     *
     * */
    void update(Occupation oc);


    /**
     *
     *  <p> Returns the quantity of occupations
     *
     *  @return Returns the quantity of occupations
     * */
    int size();

    /**
     *
     *  <p> Receives an occupation id and removes it.
     *
     * */
    void delete (Integer id);

    /**
     *
     *  <p> Removes all occupations.
     *
     * */
    void removeAll();
}
