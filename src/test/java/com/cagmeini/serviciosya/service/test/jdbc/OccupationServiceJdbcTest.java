package com.cagmeini.serviciosya.service.test.jdbc;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import com.cagmeini.serviciosya.dao.IOccupationDao;
import com.cagmeini.serviciosya.dao.jdbc.OccupationJdbcDao;
import com.cagmeini.serviciosya.service.OccupationService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class OccupationServiceJdbcTest {
    private OccupationService occupationService = new OccupationService ();

    private IOccupationDao occupationDao;

    {
        try {
            occupationDao = new OccupationJdbcDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllOccupations () {


        this.occupationService.setOccupationDao (this.occupationDao);

        List<Occupation> list = this.occupationService.findAllOccupations ();

        Assert.assertFalse (list==null || list.isEmpty ());
    }
    @Test
    public void testAddOccupation () {


        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation (2, "Catador de Ron", "Beber Ron...");

        List<Occupation> init = this.occupationService.findAllOccupations ();

        this.occupationService.addOccupation (o);

        List<Occupation> end = this.occupationService.findAllOccupations ();

        Assert.assertTrue (init.size()+1 == end.size());
    }

    @Test
    public void testRemoveAll() {
        this.occupationService.setOccupationDao(this.occupationDao);

        this.occupationService.removeAll();

        Assert.assertTrue(this.occupationService.occupationsQuantity()==0);

        Occupation o1 = new Occupation(1, "testing", "testing");
        Occupation o2 = new Occupation(2, "testingA", "testing");
        Occupation o3 = new Occupation(3, "testingB", "testing");

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
        Occupation o1= new Occupation(1,"testing","testing");
        Occupation o2= new Occupation(2,"testing","testing");
        Occupation o3= new Occupation(3,"testingB","testing");
        this.occupationService.addOccupation (o1);
        this.occupationService.addOccupation (o2);
        this.occupationService.addOccupation (o3);

        List<Occupation> result = this.occupationService.findOccupationDuplicates ("testing");

        System.out.print(result.size());
        Assert.assertTrue(result.get(0).getName().equals(o1.getName()));
        Assert.assertTrue(result.get(1).getName().equals("testing"));

    }


}
