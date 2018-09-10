
package com.cagmeini.serviciosya.dao;


import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.*;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import org.apache.commons.lang3.ObjectUtils;


public class OccupationDaoMemory implements IOccupationDao {


    private Map<String, Occupation> occupations;

    /**
     * OccupationDaoMemory initialization.
     *
     * @return Returns an OccupationDaoMemory object
     */
    public OccupationDaoMemory() {

        super ();

        this.occupations = new TreeMap<>();

        // Load occupations.
        Occupation o1 = new Occupation (randomAlphabetic(5),
                                        "Entandador de Serpientes",
                                    "Entandador de Serpientes");

        Occupation o2 = new Occupation (randomAlphabetic(5),
                                       "Cuidador de Suegras",
                                   "Cuidador de Suegras");

        // Add values to map.
        this.occupations.put (o1.getId (), o1);
        this.occupations.put (o2.getId (), o2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Occupation> findAllOccupations () {

        // Get the entries.
        Set<Map.Entry<String, Occupation>> entries = this.occupations.entrySet ();

        // Build the occupation list.
        List<Occupation> list = new ArrayList<> ();
        for (Map.Entry<String, Occupation> item: entries) {

            list.add (item.getValue ());
        }

        // Return the occupations.
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Occupation> findDuplicates(String name) {
        // Get the entries.
        Set<Map.Entry<String, Occupation>> entries = this.occupations.entrySet ();

        // Build the occupation list.
        List<Occupation> list = new ArrayList<> ();
        for (Map.Entry<String, Occupation> item: entries) {
            if(item.getValue().getName().equals(name)){
                list.add (item.getValue ());
            }
        }

        // Return the occupations.
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add (Occupation occupation) {

        this.occupations.put (occupation.getId (), occupation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Occupation searchById(String id) {
        return this.occupations.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Occupation searchByName(String name) {
        Set<Map.Entry<String, Occupation>> entries = this.occupations.entrySet ();
        List<Occupation> list = new ArrayList<> ();
        for (Map.Entry<String, Occupation> item: entries) {
            if(item.getValue().getName().equals(name)){
                return item.getValue();
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescprition(String id) {
        try {
            Occupation oc= this.occupations.get(id);
            return oc.getDescription();
        }catch (Exception ex){
            return null;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyName(String id, String newName) {
        this.occupations.get(id).setName(newName);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyDescription(String id, String newDescription) {
        this.occupations.get(id).setDescription(newDescription);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.occupations.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean exists(String id) {
        return (this.occupations.containsKey(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(String id) {
        this.occupations.remove(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAll() {
        this.occupations.clear();
    }

}