package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.IProvinceDao;
import com.capgemini.serviciosya.dao.orm.ProvinceDao;
import org.junit.Assert;
import org.junit.Test;

public class ProvinceDaoHibernateTest {

    private IProvinceDao dao = new ProvinceDao();


    @Test
    public void testCreate () {

        ProvinceEntity p = new ProvinceEntity ();
        p.setName ("CABA");
        CountryEntity c = new CountryEntity();
        c.setId(1);
        p.setCountry(c);
        this.dao.create (p);

        Assert.assertNotNull ("Failure creating new country.", c.getId ());
    }



}
