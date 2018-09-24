package com.capgemini.serviciosya.repositories.jpa;
/*
import com.capgemini.serviciosya.beans.entity.*;
import com.capgemini.serviciosya.repositories.configuration.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.stream.Collectors;

public class ProviderDaoHibernateTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");


    private ICountryRepository cDao = context.getBean(CountryDao.class);
    private IProvinceRepository pDao = context.getBean(ProvinceDao.class);
    private ICityRepository ciDao = context.getBean(CityDao.class);
    private IOccupationRepository oDao = context.getBean(OccupationDao.class);
    private IProviderRepository dao = context.getBean(ProviderDao.class);
    private CountryEntity testCountry;
    private ProvinceEntity testProvince;
    private CityEntity testCity;
    private OccupationEntity testOccupation;
    private Set<OccupationEntity> testOccupations;
    private ProviderEntity testProvider;

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
        this.testOccupations= new HashSet<>();
        this.testOccupations.add(this.testOccupation);
        this.testProvider = new ProviderEntity();
        this.testProvider.setName("TestConsumer");
        this.testProvider.setLastName("testLastname");
        this.testProvider.setAddress("testaddress");
        this.testProvider.setCity(this.testCity);
        this.testProvider.setDni(1234);
        this.testProvider.setPhone("1234");
        this.testProvider.setEmail("email@gmail.com");
        this.testProvider.setOccupations(this.testOccupations);

    }


    @Test
    public void testCreate () {

        this.dao.create(this.testProvider);

        Assert.assertNotNull ("Failure creating new Provider.", this.testProvider.getId ());
        this.dao.delete(this.testProvider.getId());

    }

    @Test
    public void update() {

        this.dao.create(this.testProvider);
        this.testProvider.setName("TestUpdateProvider");
        this.dao.update(this.testProvider);
        ProviderEntity cu=this.dao.findById(this.testProvider.getId());

        Assert.assertTrue("Failure updating Provider",cu.getName().equals(this.testProvider.getName()));

    }

    @Test
    public void delete() {
        this.dao.create(this.testProvider);

        Assert.assertNotNull ("Failure creating new Provider.", this.testProvider.getId ());
        this.dao.delete(this.testProvider.getId());
        Assert.assertNull ("Failure deleting new Provider.", this.testProvider.getId());
    }

    @Test
    public void findall() {
        this.dao.create(this.testProvider);

        List<ProviderEntity> co=this.dao.findall();
        List<String> l =co.stream().map(ProviderEntity::getName).collect(Collectors.toList());

        Assert.assertTrue("failure finding all countries",l.contains(this.testProvider.getName()) );

    }

    @Test
    public void findById() {
        this.dao.create(this.testProvider);
        ProviderEntity cu=this.dao.findById(this.testProvider.getId());

        Assert.assertTrue("Failure updating Provider",cu.getName().equals(this.testProvider.getName()));

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
    public void findByPhone() {
        this.dao.create(this.testProvider);
        ProviderEntity cu=this.dao.findById(this.testProvider.getId());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testProvider.getName()));

    }

    @Test
    public void findByDni() {
        this.dao.create(this.testProvider);
        ProviderEntity cu=this.dao.findByPhone(this.testProvider.getPhone());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testProvider.getName()));

    }

    @Test
    public void findByEmail() {
        this.dao.create(this.testProvider);
        ProviderEntity cu=this.dao.findByEmail(this.testProvider.getEmail());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testProvider.getName()));

    }
    @Test
    public void findAllByLocation() {
        this.dao.create(this.testProvider);

        List<ProviderEntity> co=this.dao.findAllByLocation(this.testCity.getId());
        List<String> l =co.stream().map(ProviderEntity::getName).collect(Collectors.toList());

        Assert.assertTrue("failure finding all countries",l.contains(this.testProvider.getName()) );
    }
}*/