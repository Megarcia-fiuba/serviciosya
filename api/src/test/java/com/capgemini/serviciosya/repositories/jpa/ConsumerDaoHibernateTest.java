package com.capgemini.serviciosya.repositories.jpa;
/*
import com.capgemini.serviciosya.beans.entity.*;
import com.capgemini.serviciosya.repositories.jpa.ICityRepository;
import com.capgemini.serviciosya.repositories.jpa.IConsumerRepository;
import com.capgemini.serviciosya.repositories.jpa.ICountryRepository;
import com.capgemini.serviciosya.repositories.jpa.IProvinceRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

public class ConsumerDaoHibernateTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");


    private ICountryRepository cDao = context.getBean(CountryDao.class);
    private IProvinceRepository pDao = context.getBean(ProvinceDao.class);
    private ICityRepository ciDao = context.getBean(CityDao.class);
    private IConsumerRepository dao = context.getBean(ConsumerDao.class);
    private CountryEntity testCountry;
    private ProvinceEntity testProvince;
    private CityEntity testCity;
    private ConsumerEntity testconsumer;

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
        this.testconsumer.setName("TestConsumer");
        this.testconsumer.setLastName("testLastname");
        this.testconsumer.setAddress("testaddress");
        this.testconsumer.setCity(this.testCity);
        this.testconsumer.setDni(1234);
        this.testconsumer.setPhone("1234");
        this.testconsumer.setEmail("email@gmail.com");

    }


    @Test
    public void testCreate () {
        this.dao.create(this.testconsumer);

        Assert.assertNotNull ("Failure creating new Consumer.", this.testconsumer.getId ());
        this.dao.delete(this.testconsumer.getId());

    }

    @Test
    public void update() {
        this.dao.create(this.testconsumer);
        this.testconsumer.setName("TestUpdateConsumer");
        this.dao.update(this.testconsumer);
        ConsumerEntity cu=this.dao.findById(this.testconsumer.getId());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));

    }

    @Test
    public void delete() {

        this.dao.create(this.testconsumer);

        Assert.assertNotNull ("Failure creating new Consumer.", this.testconsumer.getId ());
        this.dao.delete(this.testconsumer.getId());
        Assert.assertNull ("Failure deleting new Consumer.", this.testconsumer.getId());
    }

    @Test
    public void findall() {
        this.dao.create(this.testconsumer);

        List<ConsumerEntity> co=this.dao.findall();
        List<String> l =co.stream().map(ConsumerEntity::getName).collect(Collectors.toList());

        Assert.assertTrue("failure finding all countries",l.contains(this.testconsumer.getName()) );

    }

    @Test
    public void findById() {
        this.dao.create(this.testconsumer);
        ConsumerEntity cu=this.dao.findById(this.testconsumer.getId());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));

    }

    @After
    @Test
    public void testafter(){
        this.cDao.delete(this.testCountry.getId());
        this.pDao.delete(this.testProvince.getId());
        this.ciDao.delete(this.testCity.getId());
    }


    @Test
    public void findByPhone() {
        this.dao.create(this.testconsumer);
        ConsumerEntity cu=this.dao.findById(this.testconsumer.getId());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));

    }

    @Test
    public void findByDni() {
        this.dao.create(this.testconsumer);
        ConsumerEntity cu=this.dao.findByPhone(this.testconsumer.getPhone());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));

    }

    @Test
    public void findByEmail() {
        this.dao.create(this.testconsumer);
        ConsumerEntity cu=this.dao.findByEmail(this.testconsumer.getEmail());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));

    }
}
*/