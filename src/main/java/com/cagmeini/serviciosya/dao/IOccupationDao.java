
package com.cagmeini.serviciosya.dao;


import java.util.List;

import com.cagmeini.serviciosya.beans.domain.Occupation;


public interface IOccupationDao {


    List<Occupation> findAllOccupations ();

    List<Occupation> findDuplicates (String name);

    void add (Occupation occupation);
    
    Occupation searchById(String id);

    Occupation searchByName(String name);

    String getDescprition(String id);

    boolean exists(String id);

    void modifyName(String id,String newName);

    void modifyDescription(String id,String newDescription);

    int size();

    void remove (String id);

    void removeAll();
}
