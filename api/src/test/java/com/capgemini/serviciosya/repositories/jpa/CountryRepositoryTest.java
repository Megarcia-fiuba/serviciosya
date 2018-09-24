package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repositories.jpa.ICountryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

public class CountryRepositoryTest {


    @Autowired
    private ICountryRepository dao = null;

    private final Logger logger = LoggerFactory.getLogger (CountryRepositoryTest.class);


    @Test
    public void testCreate () {
        CountryEntity c= new CountryEntity();
        c.setName("TestCountry");
        this.dao.save(c);

        Assert.assertNotNull ("Failure creating new country.", c.getId ());
        this.dao.delete(c.getId());

    }

    @Test
    public void update() {
        CountryEntity c= new CountryEntity();
        c.setName("TestCountry");
        this.dao.create(c);
        c.setName("TestUpdateCountry");
        this.dao.(c);
        CountryEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating country",cu.getName().equals(c.getName()));

    }

    @Test
    public void delete() {
        CountryEntity c= new CountryEntity();
        c.setName("TestCountry");
        this.dao.create(c);

        Assert.assertNotNull ("Failure creating new country.", c.getId ());
        this.dao.delete(c.getId());
        Assert.assertNull ("Failure deleting new country.", c.getId());
    }

    @Test
    public void findall() {
        CountryEntity c= new CountryEntity();
        CountryEntity c2= new CountryEntity();
        CountryEntity c3= new CountryEntity();
        c.setName("TestCountry");
        c2.setName("TestCountry2");
        c3.setName("TestCountry3");
        this.dao.create(c);
        this.dao.create(c2);
        this.dao.create(c3);

        List<CountryEntity> co=this.dao.findall();
        List<String> l =co.stream().map(CountryEntity::getName).collect(Collectors.toList());
        Assert.assertTrue("failure finding all countries",l.contains(c.getName()) && l.contains(c2.getName())&& l.contains(c3.getName()));

    }

    @Test
    public void findById() {
        CountryEntity c= new CountryEntity();
        c.setName("TestCountry");
        this.dao.create(c);
        CountryEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating country",cu.getName().equals(c.getName()));

    }
}