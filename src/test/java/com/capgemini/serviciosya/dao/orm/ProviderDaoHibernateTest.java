package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.*;
import com.capgemini.serviciosya.dao.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProviderDaoHibernateTest {

    private ICountryDao cDao = new CountryDao();
    private IProvinceDao pDao = new ProvinceDao();
    private ICityDao ciDao = new CityDao();
    private IOccupationDao oDao = new OccupationDao();
    private IProviderDao dao = new ProviderDao();
    private CountryEntity testCountry;
    private ProvinceEntity testProvince;
    private CityEntity testCity;
    private OccupationEntity testOccupation;
    private List<OccupationEntity> testOccupations;

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
        this.testCity= new CityEntity();
        this.testCity.setName("testCity");
        this.testCity.setProvince(this.testProvince);
        this.ciDao.create(this.testCity);
        this.testOccupation =new OccupationEntity();
        this.testOccupation.setName("TestOccupation");
        this.testOccupation.setDescription("testing");
        this.oDao.create(this.testOccupation);
        this.testOccupations.add(this.testOccupation);
    }


    @Test
    public void testCreate () {
        ProviderEntity c= new ProviderEntity();
        c.setName("TestProvider");
        c.setLastName("testLastname");
        c.setAddress("testaddress");
        c.setOccupations(this.testOccupations);
        c.setCity(this.testCity);
        this.dao.create(c);

        Assert.assertNotNull ("Failure creating new Provider.", c.getId ());
        this.dao.delete(c.getId());

    }

    @Test
    public void update() {
        ProviderEntity c= new ProviderEntity();
        c.setName("TestProvider");
        c.setCity(this.testCity);
        this.dao.create(c);
        c.setName("TestUpdateProvider");
        this.dao.update(c);
        ProviderEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating Provider",cu.getName().equals(c.getName()));

    }

    @Test
    public void delete() {
        ProviderEntity c= new ProviderEntity();
        c.setName("TestProvider");
        c.setCity(this.testCity);

        this.dao.create(c);

        Assert.assertNotNull ("Failure creating new Provider.", c.getId ());
        this.dao.delete(c.getId());
        Assert.assertNull ("Failure deleting new Provider.", c.getId());
    }

    @Test
    public void findall() {
        ProviderEntity c= new ProviderEntity();
        ProviderEntity c2= new ProviderEntity();
        ProviderEntity c3= new ProviderEntity();
        c.setName("TestProvider");
        c.setCity(this.testCity);
        c2.setName("TestProvider2");
        c2.setCity(this.testCity);
        c3.setName("TestProvider3");
        c3.setCity(this.testCity);
        this.dao.create(c);
        this.dao.create(c2);
        this.dao.create(c3);

        List<ProviderEntity> co=this.dao.findall();
        List<String> l = new ArrayList<>();
        co.stream().map(Provider ->l.add(Provider.getName()) );
        Assert.assertTrue("failure finding all countries",l.contains(c.getName()) && l.contains(c2.getName())&& l.contains(c3.getName()));

    }

    @Test
    public void findById() {
        ProviderEntity c= new ProviderEntity();
        c.setName("TestProvider");
        c.setCity(this.testCity);
        this.dao.create(c);
        ProviderEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating Provider",cu.getName().equals(c.getName()));

    }

    @After
    @Test
    public void testafter(){
        this.cDao.delete(this.testCountry.getId());
        this.pDao.delete(this.testProvince.getId());
        this.ciDao.delete(this.testCity.getId());
        this.oDao.delete(this.testOccupation.getId());
    }

    @Test
    public void findByEmail() {
    }

    @Test
    public void findByDNI() {
    }

    @Test
    public void findByPhone() {
    }

    @Test
    public void findAllByLocation() {
    }
}