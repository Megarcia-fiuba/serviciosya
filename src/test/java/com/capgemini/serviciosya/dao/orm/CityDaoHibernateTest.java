package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.ICityDao;
import com.capgemini.serviciosya.dao.ICountryDao;
import com.capgemini.serviciosya.dao.IProvinceDao;
import com.capgemini.serviciosya.dao.orm.CityDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CityDaoHibernateTest {
    private ICountryDao cDao = new CountryDao();
    private IProvinceDao pDao = new ProvinceDao();
    private ICityDao dao = new CityDao();
    private CountryEntity testCountry;
    private ProvinceEntity testProvince;

    @Before
    @Test
    public void init(){
        this.testCountry= new CountryEntity();
        this.testCountry.setName("testCountry");
        this.cDao.create(this.testCountry);
        this.testProvince= new ProvinceEntity();
        this.testProvince.setName("testProvince");
        this.testProvince.setCountry(this.testCountry);
        this.pDao.create(this.testProvince);

    }


    @Test
    public void testCreate () {
        CityEntity c= new CityEntity();
        c.setName("TestCity");
        c.setProvince(this.testProvince);
        this.dao.create(c);

        Assert.assertNotNull ("Failure creating new City.", c.getId ());
        this.dao.delete(c.getId());

    }

    @Test
    public void update() {
        CityEntity c= new CityEntity();
        c.setName("TestCity");
        c.setProvince(this.testProvince);
        this.dao.create(c);
        c.setName("TestUpdateCity");
        this.dao.update(c);
        CityEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating City",cu.getName().equals(c.getName()));

    }

    @Test
    public void delete() {
        CityEntity c= new CityEntity();
        c.setName("TestCity");
        c.setProvince(this.testProvince);

        this.dao.create(c);

        Assert.assertNotNull ("Failure creating new City.", c.getId ());
        this.dao.delete(c.getId());
        Assert.assertNull ("Failure deleting new City.", c.getId());
    }

    @Test
    public void findall() {
        CityEntity c= new CityEntity();
        CityEntity c2= new CityEntity();
        CityEntity c3= new CityEntity();
        c.setName("TestCity");
        c.setProvince(this.testProvince);
        c2.setName("TestCity2");
        c2.setProvince(this.testProvince);
        c3.setName("TestCity3");
        c3.setProvince(this.testProvince);
        this.dao.create(c);
        this.dao.create(c2);
        this.dao.create(c3);

        List<CityEntity> co=this.dao.findall();
        List<String> l =co.stream().map(CityEntity::getName).collect(Collectors.toList());

        Assert.assertTrue("failure finding all countries",l.contains(c.getName()) && l.contains(c2.getName())&& l.contains(c3.getName()));

    }

    @Test
    public void findById() {
        CityEntity c= new CityEntity();
        c.setName("TestCity");
        c.setProvince(this.testProvince);
        this.dao.create(c);
        CityEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating City",cu.getName().equals(c.getName()));

    }

    @After
    @Test
    public void testafter(){
        this.cDao.delete(this.testCountry.getId());
        this.pDao.delete(this.testProvince.getId());
    }
}
