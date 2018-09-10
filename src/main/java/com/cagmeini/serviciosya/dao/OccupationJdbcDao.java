package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.domain.Occupation;

import java.util.List;

public class OccupationJdbcDao implements IOccupationDao {

    @Override
    public List<Occupation> findAllOccupations() {
    return null;
  }

    @Override
    public List<Occupation> findDuplicates(String name) {
        return null;
    }

    @Override
    public void add(Occupation occupation) {

    }

    @Override
    public Occupation searchById(String id) {
        return null;
    }

    @Override
    public Occupation searchByName(String name) {
        return null;
    }

    @Override
    public String getDescprition(String id) {
        return null;
    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public void modifyName(String id, String newName) {

    }

    @Override
    public void modifyDescription(String id, String newDescription) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void removeAll() {

    }
}
