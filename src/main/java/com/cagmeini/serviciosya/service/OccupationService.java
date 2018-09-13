
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

        return this.occupationDao.findall ();
    }

    public List<Occupation> findOccupationDuplicates(String occupationName){
        return this.occupationDao.findDuplicates(occupationName);
    }

    public void addOccupation (Occupation occupation) {

        this.occupationDao.create (occupation);
    }

    public Occupation findOccupationByid(int id ){
        return this.occupationDao.findById(id);
    }


    public String getOccupationDescription(int id){
        return this.occupationDao.getDescprition(id);
    }

    public void modifyOccupationName(Occupation update){
        this.occupationDao.update(update);
    }


    public boolean occupationExists(int id){
        return this.occupationDao.exists(id);
    }

    public int occupationsQuantity(){
        return this.occupationDao.size();
    }

    public void removeOccupation(int id){
        this.occupationDao.delete(id);
    }

    public void removeAll(){
        this.occupationDao.removeAll();
    }




}