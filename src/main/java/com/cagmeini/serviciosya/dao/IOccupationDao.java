
package com.cagmeini.serviciosya.dao;


import java.util.List;

import com.cagmeini.serviciosya.beans.domain.Occupation;


public interface IOccupationDao {

    /**
     *
     *  <p>Return a list of all the occupations available.
     *
     *  @return Return a list of occupations
     * */
    List<Occupation> findAllOccupations ();

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
    void add (Occupation occupation);

    /**
     *
     *  <p> Receives an occupation id
     *      Returns an occupation with the same id or null if there is none
     *
     *  @return Return an occupation or null.
     * */
    Occupation searchById(int id);

    /**
     *
     *  <p> Receives an occupation name
     *      Returns an occupation with the same name or null if there is none
     *
     *  @return Return an occupation or null.
     * */
    Occupation searchByName(String name);

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
    void modifyName(int id,String newName);

    /**
     *
     *  <p> Receives an occupation id and a new description for it. Then changes its description if found.
     *
     * */
    void modifyDescription(int id,String newDescription);

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
    void remove (int id);

    /**
     *
     *  <p> Removes all occupations.
     *
     * */
    void removeAll();
}
