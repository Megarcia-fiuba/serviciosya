package com.cagmeini.serviciosya.service.test.hibernate;

import com.cagmeini.serviciosya.beans.entity.CountryEntity;
import com.cagmeini.serviciosya.beans.entity.ProvinceEntity;
import com.cagmeini.serviciosya.dao.IProvinceDao;
import com.cagmeini.serviciosya.dao.orm.ProvinceDaoHibernate;
import org.junit.Assert;
import org.junit.Test;

public class ProvinceDaoHibernateTest {

    private IProvinceDao dao = new ProvinceDaoHibernate();


    @Test
    public void testCreate () {

        ProvinceEntity p = new ProvinceEntity ();
        p.setName ("CABA");
        CountryEntity c = new CountryEntity();
        c.setId(2);
        p.setCountry(c);
        this.dao.create (p);

        Assert.assertNotNull ("Failure creating new country.", c.getId ());
    }



}
