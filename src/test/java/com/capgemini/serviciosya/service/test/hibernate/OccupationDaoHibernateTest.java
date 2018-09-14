package com.capgemini.serviciosya.service.test.hibernate;

import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import com.capgemini.serviciosya.dao.IOccupationDao;
import com.capgemini.serviciosya.dao.orm.OccupationDao;
import org.junit.Assert;
import org.junit.Test;

public class OccupationDaoHibernateTest {
    private IOccupationDao dao = new OccupationDao();


    @Test
    public void testCreate () {
        OccupationEntity o = new OccupationEntity();
        o.setName("Test");
        o.setDescription("testing...");
        this.dao.create(o);

        Assert.assertNotNull ("Failure creating new country.", o.getId ());
    }
}
