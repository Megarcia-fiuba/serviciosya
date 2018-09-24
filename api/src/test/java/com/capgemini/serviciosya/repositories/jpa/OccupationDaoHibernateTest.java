package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import com.capgemini.serviciosya.repositories.jpa.IOccupationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.stream.Collectors;
/*
public class OccupationDaoHibernateTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");

    private IOccupationRepository dao = context.getBean(OccupationDao.class);


    @Test
    public void testCreate () {
        OccupationEntity o = new OccupationEntity();
        o.setName("Test");
        o.setDescription("testing...");
        this.dao.create(o);

        Assert.assertNotNull ("Failure creating new Occupation.", o.getId ());
    }
    @Test
    public void update() {
        OccupationEntity c= new OccupationEntity();
        c.setName("TestOccupation");
        c.setDescription("testing...");
        this.dao.create(c);
        c.setName("TestUpdateOccupation");
        this.dao.update(c);
        OccupationEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating Occupation",cu.getName().equals(c.getName()));

    }

    @Test
    public void delete() {
        OccupationEntity c= new OccupationEntity();
        c.setName("TestOccupation");
        c.setDescription("testing...");
        this.dao.create(c);

        Assert.assertNotNull ("Failure creating new Occupation.", c.getId ());
        this.dao.delete(c.getId());
        Assert.assertNull ("Failure deleting new Occupation.", c.getId());
    }

    @Test
    public void findall() {
        OccupationEntity c= new OccupationEntity();
        OccupationEntity c2= new OccupationEntity();
        OccupationEntity c3= new OccupationEntity();
        c.setName("TestOccupation");
        c.setDescription("testing...");
        c2.setName("TestOccupation2");
        c2.setDescription("testing...");
        c3.setName("TestOccupation3");
        c3.setDescription("testing...");
        this.dao.create(c);
        this.dao.create(c2);
        this.dao.create(c3);

        List<OccupationEntity> co=this.dao.findall();
        List<String> l =co.stream().map(OccupationEntity::getName).collect(Collectors.toList());

        Assert.assertTrue("failure finding all countries",l.contains(c.getName()) && l.contains(c2.getName())&& l.contains(c3.getName()));

    }

    @Test
    public void findById() {
        OccupationEntity c= new OccupationEntity();
        c.setName("TestOccupation");
        c.setDescription("testing...");
        this.dao.create(c);
        OccupationEntity cu=this.dao.findById(c.getId());

        Assert.assertTrue("Failure updating Occupation",cu.getName().equals(c.getName()));

    }

}
*/