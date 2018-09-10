
package com.cagmeini.serviciosya.service.test;


import java.util.List;

import com.cagmeini.serviciosya.dao.IOccupationDao;
import com.cagmeini.serviciosya.dao.OccupationDaoMemory;
import org.junit.Assert;
import org.junit.Test;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import com.cagmeini.serviciosya.service.OccupationService;


public class OccupationServiceTest {


    private OccupationService occupationService = new OccupationService ();

    private IOccupationDao occupationDao = new OccupationDaoMemory ();


    @Test
    public void testFindAllOccupations () {


        this.occupationService.setOccupationDao (this.occupationDao);

        List<Occupation> list = this.occupationService.findAllOccupations ();

        Assert.assertFalse (list.isEmpty ());
    }

    @Test
    public void testAddOccupation () {


        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Catador de Ron", "Beber alcohol...");

        List<Occupation> init = this.occupationDao.findAllOccupations ();

        this.occupationService.addOccupation (o);

        List<Occupation> end = this.occupationDao.findAllOccupations ();

        Assert.assertTrue (init.size()+1 == end.size());
    }

    @Test
    public void testRemoveAll() {
        this.occupationService.setOccupationDao(this.occupationDao);

        this.occupationService.removeAll();

        Assert.assertTrue(this.occupationService.occupationsQuantity()==0);

        Occupation o1 = new Occupation("1", "testing", "testing");
        Occupation o2 = new Occupation("2", "testingA", "testing");
        Occupation o3 = new Occupation("3", "testingB", "testing");

        this.occupationService.addOccupation(o1);
        this.occupationService.addOccupation(o2);
        this.occupationService.addOccupation(o3);

        Assert.assertTrue(this.occupationService.occupationsQuantity()==3);

        this.occupationService.removeAll();

        Assert.assertTrue(this.occupationService.occupationsQuantity()==0);

    }

    @Test
    public void testFindDuplicates(){
        this.occupationService.setOccupationDao (this.occupationDao);

        this.occupationService.removeAll();
        Occupation o1= new Occupation("1","testing","testing");
        Occupation o2= new Occupation("2","testing","testing");
        Occupation o3= new Occupation("3","testingB","testing");
        this.occupationService.addOccupation (o1);
        this.occupationService.addOccupation (o2);
        this.occupationService.addOccupation (o3);

        List<Occupation> result = this.occupationService.findOccupationDuplicates ("testing");

        Assert.assertTrue(result.size()==2);
        Assert.assertTrue(result.contains(o1));
        Assert.assertTrue(result.contains(o2));
        Assert.assertFalse(result.contains(o3));

    }

    @Test
    public void testfindByid(){
        this.occupationService.setOccupationDao (this.occupationDao);

        this.occupationService.removeAll();
        Occupation o1= new Occupation("1","testing","testing");
        Occupation o2= new Occupation("2","testing","testing");
        Occupation o3= new Occupation("3","testingB","testing");
        this.occupationService.addOccupation (o1);
        this.occupationService.addOccupation (o2);
        this.occupationService.addOccupation (o3);

        Occupation oa=this.occupationService.findOccupationByid("1");
        Occupation ob=this.occupationService.findOccupationByid("2");
        Occupation oc=this.occupationService.findOccupationByid("3");
        Occupation od=this.occupationService.findOccupationByid("4");

        Assert.assertTrue((oa.getName().equals(o1.getName())&&oa.getDescription().equals(o1.getDescription())));
        Assert.assertTrue((ob.getName().equals(o2.getName())&&ob.getDescription().equals(o2.getDescription())));
        Assert.assertTrue((oc.getName().equals(o3.getName())&&oc.getDescription().equals(o3.getDescription())));
        Assert.assertTrue(od==null);

    }

    @Test
    public void testfindByName() {
        this.occupationService.setOccupationDao(this.occupationDao);

        this.occupationService.removeAll();
        Occupation o1 = new Occupation("1", "testing", "testing");
        Occupation o2 = new Occupation("2", "testingA", "testing");
        Occupation o3 = new Occupation("3", "testingB", "testing");
        this.occupationService.addOccupation(o1);
        this.occupationService.addOccupation(o2);
        this.occupationService.addOccupation(o3);

        Occupation oa = this.occupationService.findOccupationByName("testing");
        Occupation ob = this.occupationService.findOccupationByName("testingA");
        Occupation oc = this.occupationService.findOccupationByName("testingB");
        Occupation od = this.occupationService.findOccupationByName("test");

        Assert.assertTrue((oa.getId().equals(o1.getId())&&oa.getDescription().equals(o1.getDescription())));
        Assert.assertTrue((ob.getId().equals(o2.getId())&&ob.getDescription().equals(o2.getDescription())));
        Assert.assertTrue((oc.getId().equals(o3.getId())&&oc.getDescription().equals(o3.getDescription())));
        Assert.assertTrue(od==null);


    }

    @Test
    public void testgetDescription() {
        this.occupationService.setOccupationDao(this.occupationDao);

        this.occupationService.removeAll();
        Occupation o1 = new Occupation("1", "testing", "testing");
        Occupation o2 = new Occupation("2", "testingA", "testing");
        Occupation o3 = new Occupation("3", "testingB", "testing");
        this.occupationService.addOccupation(o1);
        this.occupationService.addOccupation(o2);
        this.occupationService.addOccupation(o3);

        Assert.assertTrue(this.occupationService.getOccupationDescription("1").equals(o1.getDescription()));
        Assert.assertTrue(this.occupationService.getOccupationDescription("2").equals(o2.getDescription()));
        Assert.assertTrue(this.occupationService.getOccupationDescription("3").equals(o3.getDescription()));

    }

    @Test
    public void testmodifyName() {
        this.occupationService.setOccupationDao(this.occupationDao);

        this.occupationService.removeAll();
        Occupation o1 = new Occupation("1", "testing", "testing");
        Occupation o2 = new Occupation("2", "testingA", "testing");
        Occupation o3 = new Occupation("3", "testingB", "testing");
        this.occupationService.addOccupation(o1);
        this.occupationService.addOccupation(o2);
        this.occupationService.addOccupation(o3);

        this.occupationService.modifyOccupationName("1","test");
        Occupation a1=this.occupationService.findOccupationByid("1");

        Assert.assertTrue(a1.getName().equals("test"));

    }

    @Test
    public void testmodifyDescription() {
        this.occupationService.setOccupationDao(this.occupationDao);

        this.occupationService.removeAll();
        Occupation o1 = new Occupation("1", "testing", "testing");
        Occupation o2 = new Occupation("2", "testingA", "testing");
        Occupation o3 = new Occupation("3", "testingB", "testing");
        this.occupationService.addOccupation(o1);
        this.occupationService.addOccupation(o2);
        this.occupationService.addOccupation(o3);

        this.occupationService.modifyOccupationDescription("1","test");
        Occupation a1=this.occupationService.findOccupationByid("1");
        Assert.assertTrue(a1.getDescription().equals("test"));

    }

    @Test
    public void testExists() {
        this.occupationService.setOccupationDao(this.occupationDao);

        this.occupationService.removeAll();
        Occupation o1 = new Occupation("1", "testing", "testing");
        Occupation o2 = new Occupation("2", "testingA", "testing");
        Occupation o3 = new Occupation("3", "testingB", "testing");
        this.occupationService.addOccupation(o1);
        this.occupationService.addOccupation(o2);
        this.occupationService.addOccupation(o3);

        Assert.assertTrue(this.occupationService.occupationExists("1"));
        Assert.assertTrue(this.occupationService.occupationExists("2"));
        Assert.assertTrue(this.occupationService.occupationExists("3"));
        Assert.assertFalse(this.occupationService.occupationExists("q"));
    }

    @Test
    public void testRemove() {
        this.occupationService.setOccupationDao(this.occupationDao);

        this.occupationService.removeAll();
        Occupation o1 = new Occupation("1", "testing", "testing");
        Occupation o2 = new Occupation("2", "testingA", "testing");
        Occupation o3 = new Occupation("3", "testingB", "testing");
        this.occupationService.addOccupation(o1);
        this.occupationService.addOccupation(o2);
        this.occupationService.addOccupation(o3);

        this.occupationService.removeOccupation("1");
        this.occupationService.removeOccupation("q");

        Assert.assertFalse(this.occupationService.occupationExists("1"));
        Assert.assertTrue(this.occupationService.occupationExists("2"));
        Assert.assertTrue(this.occupationService.occupationExists("3"));

    }

    @Test
    public void testQuantity() {
        this.occupationService.setOccupationDao(this.occupationDao);

        this.occupationService.removeAll();

        Assert.assertTrue(this.occupationService.occupationsQuantity()==0);

        Occupation o1 = new Occupation("1", "testing", "testing");
        Occupation o2 = new Occupation("2", "testingA", "testing");
        Occupation o3 = new Occupation("3", "testingB", "testing");

        this.occupationService.addOccupation(o1);
        this.occupationService.addOccupation(o2);
        this.occupationService.addOccupation(o3);

        Assert.assertTrue(this.occupationService.occupationsQuantity()==3);

        this.occupationService.removeOccupation("1");

        Assert.assertTrue(this.occupationService.occupationsQuantity()==2);

    }

}