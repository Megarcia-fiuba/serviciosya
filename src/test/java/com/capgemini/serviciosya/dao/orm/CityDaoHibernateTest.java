package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.ICityDao;
import com.capgemini.serviciosya.dao.orm.CityDao;
import org.junit.Assert;
import org.junit.Test;

public class CityDaoHibernateTest {
    private ICityDao dao = new CityDao();


    @Test
    public void testCreate () {

        CityEntity c = new CityEntity ();
        c.setName ("Retiro");
        ProvinceEntity p = new ProvinceEntity();
        p.setId(1);
        c.setProvince(p);
        this.dao.create (c);

        Assert.assertNotNull ("Failure creating new country.", c.getId ());
    }
}
