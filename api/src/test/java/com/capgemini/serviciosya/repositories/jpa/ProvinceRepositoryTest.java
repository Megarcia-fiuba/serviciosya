package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import org.junit.*;
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
public class ProvinceRepositoryTest {

    @Autowired
    private ICountryRepository   repositoryCountry = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;


    private final Logger logger = LoggerFactory.getLogger (ProvinceRepositoryTest.class);


    public ProvinceRepositoryTest () {

        super ();
    }


    @Before
    public void setup () {

        logger.info ("Creating countries...");
        CountryEntity[] countries = new CountryEntity [] {

                new CountryEntity ( "Argentina"),
                new CountryEntity ( "Venezuela")
        };
        logger.debug (String.format ("Objects country created %s", Arrays.toString (countries)));

        logger.debug ("Saving countries...");
        this.repositoryCountry.save (Arrays.asList (countries));
        logger.debug (String.format ("Countries saved %s", Arrays.toString (countries)));


        logger.info ("Creating provinces...");
        ProvinceEntity[] provinces = new ProvinceEntity [] {

                new ProvinceEntity ( "Buenos Aires", countries[0]),
                new ProvinceEntity ( "Cordoba", countries[0]),
                new ProvinceEntity ( "Caracas", countries[1]),
                new ProvinceEntity ( "Miranda", countries[0])
        };
        logger.debug (String.format ("Objects province created %s", Arrays.toString (countries)));

        logger.debug ("Saving provinces...");
        this.repositoryProvince.save (Arrays.asList (provinces));
        logger.debug (String.format ("Provinces saved %s", Arrays.toString (provinces)));
    }


    @Test
    public void testCount () {

        logger.info ("Counting provinces...");
        Long count = this.repositoryProvince.count ();

        Assert.assertNotNull ("There are provinces...", count);
        Assert.assertTrue ("There are provinces...",count > 0);
    }

    @Test
    public void testGetAll () {

        logger.info ("Getting provinces...");
        List<ProvinceEntity> list = this.repositoryProvince.findAll ();

        Assert.assertNotNull ("There are provinces...", list);
        Assert.assertFalse ("There are provinces...",list.isEmpty ());
    }

    @Test
    public void testGetOne () {

        CountryEntity c=new CountryEntity("TestCountry");

        logger.debug ("Saving country...");
        this.repositoryCountry.save (c);

        ProvinceEntity p= new ProvinceEntity("TestProvince",c);

        logger.debug ("Saving province");
        this.repositoryProvince.save (p);

        logger.info ("Getting provinces...");
        ProvinceEntity province = this.repositoryProvince.findOne (p.getId());

        Assert.assertNotNull ("There is a country...", province);
        Assert.assertEquals ("There is country...", "TestProvince", province.getName ());
    }

    @After
    public void Release () {
        logger.info ("Deleting provinces...");
        this.repositoryProvince.deleteAll ();
        logger.info ("Provinces deleted...");

        logger.info ("Getting Provinces...");
        List<ProvinceEntity> listP = this.repositoryProvince.findAll ();

        Assert.assertTrue ("There are not provinces...",listP.isEmpty ());

        logger.info ("Deleting countries...");
        this.repositoryCountry.deleteAll ();
        logger.info ("Countries deleted...");

        logger.info ("Getting countries...");
        List<CountryEntity> listco = this.repositoryCountry.findAll ();

        Assert.assertTrue ("There are not countries...",listco.isEmpty ());
    }



}