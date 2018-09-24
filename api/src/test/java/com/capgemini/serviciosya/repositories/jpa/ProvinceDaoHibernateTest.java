package com.capgemini.serviciosya.repositories.jpa;
/*
import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repositories.configuration.ICountryRepository;
import com.capgemini.serviciosya.repositories.configuration.IProvinceRepository;
import com.capgemini.serviciosya.dao.orm.ProvinceDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

public class ProvinceDaoHibernateTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");

    private ICountryRepository cDao = context.getBean(CountryDao.class);
    private IProvinceRepository dao = context.getBean(ProvinceDao.class);
    private CountryEntity testCountry;

    @Before
    @Test
    public void init(){
        this.testCountry= new CountryEntity();
        this.testCountry.setName("testCountry");
        this.cDao.create(this.testCountry);

    }


    @Test
    public void testCreate () {
        ProvinceEntity c= new ProvinceEntity();
        c.setName("Testprovince");
        c.setCountry(this.testCountry);
        this.dao.create(c);

        Assert.assertNotNull ("Failure creating new Province.", c.getId ());
        this.dao.delete(c.getId());

    }

    @Test
    public void update() {
        ProvinceEntity c= new ProvinceEntity();
        c.setName("TestProvince");
        c.setCountry(this.testCountry);
        this.dao.create(c);
        c.setName("TestUpdateProvince");
        this.dao.update(c);
        ProvinceEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating Province",cu.getName().equals(c.getName()));

    }

    @Test
    public void delete() {
        ProvinceEntity c= new ProvinceEntity();
        c.setName("TestProvince");
        c.setCountry(this.testCountry);

        this.dao.create(c);

        Assert.assertNotNull ("Failure creating new Province.", c.getId ());
        this.dao.delete(c.getId());
        Assert.assertNull ("Failure deleting new Province.", c.getId());
    }

    @Test
    public void findall() {
        ProvinceEntity c= new ProvinceEntity();
        ProvinceEntity c2= new ProvinceEntity();
        ProvinceEntity c3= new ProvinceEntity();
        c.setName("TestProvince");
        c.setCountry(this.testCountry);
        c2.setName("TestProvince2");
        c2.setCountry(this.testCountry);
        c3.setName("TestProvince3");
        c3.setCountry(this.testCountry);
        this.dao.create(c);
        this.dao.create(c2);
        this.dao.create(c3);

        List<ProvinceEntity> co=this.dao.findall();
        List<String> l =co.stream().map(ProvinceEntity::getName).collect(Collectors.toList());
        Assert.assertTrue("failure finding all countries",l.contains(c.getName()) && l.contains(c2.getName())&& l.contains(c3.getName()));

    }

    @Test
    public void findById() {
        ProvinceEntity c= new ProvinceEntity();
        c.setName("TestProvince");
        c.setCountry(this.testCountry);
        this.dao.create(c);
        ProvinceEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating Province",cu.getName().equals(c.getName()));

    }

    @After
    @Test
    public void testafter(){
        this.cDao.delete(this.testCountry.getId());
    }


}
*/