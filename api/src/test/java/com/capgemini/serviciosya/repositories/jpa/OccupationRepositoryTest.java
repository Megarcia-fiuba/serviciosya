package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupationRepositoryTest {

    @Autowired
    private IOccupationRepository dao = null;


    @Test
    public void testCreate () {
        OccupationEntity o = new OccupationEntity();
        o.setName("Test");
        o.setDescription("testing...");
        this.dao.save(o);

        Assert.assertNotNull ("Failure creating new Occupation.", o.getId ());
    }
    @Test
    public void update() {
        OccupationEntity c= new OccupationEntity();
        c.setName("TestOccupation");
        c.setDescription("testing...");
        this.dao.save(c);
        c.setName("TestUpdateOccupation");
        this.dao.save(c);
        OccupationEntity cu=this.dao.findOneById(c.getId());

        Assert.assertTrue("Failure updating Occupation",cu.getName().equals(c.getName()));

    }

    @Test
    public void delete() {
        OccupationEntity c= new OccupationEntity();
        c.setName("TestOccupation");
        c.setDescription("testing...");
        this.dao.save(c);

        Assert.assertNotNull ("Failure creating new Occupation.", c.getId ());
        this.dao.delete(c.getId());
        OccupationEntity oc =this.dao.findOneById(c.getId());
        Assert.assertNull ("Failure deleting new Occupation.",oc);
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
        this.dao.save(c);
        this.dao.save(c2);
        this.dao.save(c3);

        List<OccupationEntity> co=this.dao.findAll();
        List<String> l =co.stream().map(OccupationEntity::getName).collect(Collectors.toList());

        Assert.assertTrue("failure finding all countries",l.contains(c.getName()) && l.contains(c2.getName())&& l.contains(c3.getName()));

    }

    @Test
    public void findById() {
        OccupationEntity c= new OccupationEntity();
        c.setName("TestOccupation");
        c.setDescription("testing...");
        this.dao.save(c);
        OccupationEntity cu=this.dao.findOneById(c.getId());

        Assert.assertTrue("Failure updating Occupation",cu.getName().equals(c.getName()));

    }

    @Test
    public void findParent(){
        OccupationEntity c= new OccupationEntity();
        OccupationEntity c2= new OccupationEntity();
        c.setName("TestOccupation");
        c.setDescription("testing...");
        c2.setName("TestOccupation2");
        c2.setDescription("testing...");
        this.dao.save(c);
        c2.setOccupation(c);
        this.dao.save(c2);

        OccupationEntity c3= this.dao.findOneById(c2.getId()).getOccupation();

        Assert.assertTrue("Failure finding parent Occupation ",c3.getName().equals(c.getName()));
    }

}