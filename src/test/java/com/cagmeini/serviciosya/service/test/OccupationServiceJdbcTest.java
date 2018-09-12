package com.cagmeini.serviciosya.service.test;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import com.cagmeini.serviciosya.dao.IOccupationDao;
import com.cagmeini.serviciosya.dao.OccupationDaoMemory;
import com.cagmeini.serviciosya.dao.OccupationJdbcDao;
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

        Assert.assertFalse (list.isEmpty ());
    }


}
