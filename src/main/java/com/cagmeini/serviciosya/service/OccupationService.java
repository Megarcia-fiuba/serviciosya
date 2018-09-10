
package com.cagmeini.serviciosya.service;


import java.util.List;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import com.cagmeini.serviciosya.dao.IOccupationDao;


public class OccupationService {


    private IOccupationDao occupationDao;


    public OccupationService () {

        super ();
    }

    public OccupationService (IOccupationDao occupationDao) {

        super ();

        this.occupationDao = occupationDao;
    }

    public void setOccupationDao(IOccupationDao occupationDao) {

        this.occupationDao = occupationDao;
    }

    public List<Occupation> findAllOccupations () {

        return this.occupationDao.findAllOccupations ();
    }

    public List<Occupation> findOccupationDuplicates(String occupationName){
        return this.occupationDao.findDuplicates(occupationName);
    }

    public void addOccupation (Occupation occupation) {

        this.occupationDao.add (occupation);
    }

    public Occupation findOccupationByid(String id ){
        return this.occupationDao.searchById(id);
    }

    public Occupation findOccupationByName(String name){
        return this.occupationDao.searchByName(name);
    }

    public String getOccupationDescription(String id){
        return this.occupationDao.getDescprition(id);
    }

    public void modifyOccupationName(String id, String newName){
        this.occupationDao.modifyName(id,newName);
    }

    public void modifyOccupationDescription(String id, String newDescription){
        this.occupationDao.modifyDescription(id,newDescription);
    }

    public boolean occupationExists(String id){
        return this.occupationDao.exists(id);
    }

    public int occupationsQuantity(){
        return this.occupationDao.size();
    }

    public void removeOccupation(String id){
        this.occupationDao.remove(id);
    }

    public void removeAll(){
        this.occupationDao.removeAll();
    }




}