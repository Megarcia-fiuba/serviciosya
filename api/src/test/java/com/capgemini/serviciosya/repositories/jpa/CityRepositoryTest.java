package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityRepositoryTest {

    @Autowired
    private ICountryRepository repositoryCountry = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;

    @Autowired
    private ICityRepository repositoryCity = null;


    private final Logger logger = LoggerFactory.getLogger (CityRepositoryTest.class);

    @Before
    public void setup () {

        logger.info ("Creating countries...");
        CountryEntity[] countries = new CountryEntity [] {

                new CountryEntity ( "Argentina"),
                new CountryEntity ("Venezuela")
        };
        logger.debug (String.format ("Objects country created %s", Arrays.toString (countries)));

        logger.debug ("Saving countries...");
        this.repositoryCountry.save (Arrays.asList (countries));
        logger.debug (String.format ("Countries saved %s", Arrays.toString (countries)));


        logger.info ("Creating provinces...");
        ProvinceEntity[] provinces = new ProvinceEntity [] {

                new ProvinceEntity ( "Buenos Aires", countries[0]),
                new ProvinceEntity ( "Cordoba", countries[0])
        };
        logger.debug (String.format ("Objects province created %s", Arrays.toString (countries)));

        logger.debug ("Saving provinces...");
        this.repositoryProvince.save (Arrays.asList (provinces));
        logger.debug (String.format ("Provinces saved %s", Arrays.toString (provinces)));

        logger.info ("Creating cities...");
        CityEntity[] cities = new CityEntity [] {

                new CityEntity ( provinces[0], "CABA"),
                new CityEntity ( provinces[1], "Cordoba"),
                new CityEntity ( provinces[0],"Tigre" ),
                new CityEntity ( provinces[0],"San Fernando" )
        };
        logger.debug (String.format ("Objects City created %s", Arrays.toString (countries)));

        logger.debug ("Saving Cities...");
        this.repositoryCity.save (Arrays.asList (cities));
        logger.debug (String.format ("Cities saved %s", Arrays.toString (cities)));
    }


    @Test
    public void testGetAllByProvince () {

        logger.info ("Getting  cities...");

        ProvinceEntity p = new ProvinceEntity ();
        p.setId (Integer.valueOf (1));

        List<CityEntity> list = this.repositoryCity.findAllByProvince(p);
        Assert.assertNotNull ("There are cities...", list);
        Assert.assertFalse ("There are cities...",list.isEmpty ());
    }

}