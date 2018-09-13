package com.cagmeini.serviciosya.service.test.jdbc;

import com.cagmeini.serviciosya.beans.domain.Country;
import com.cagmeini.serviciosya.dao.jdbc.CountryDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CountryDaoTest {
    CountryDao co=new CountryDao();

    @Test
    public void TestAdd(){

        Country o= new Country(1,"Test");
        co.create(o);

        List<Country> lco=co.findall();

        Assert.assertFalse(lco.isEmpty());

    }

}
