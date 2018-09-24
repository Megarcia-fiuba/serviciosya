package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repositories.jpa.ICountryRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryRepositoryTest {


    @Autowired
    private ICountryRepository repository = null;


    private final Logger logger = LoggerFactory.getLogger (CountryRepositoryTest.class);


    public CountryRepositoryTest () {

        super ();
    }

    @Before
    public void setup () {

        logger.info ("Creating countries...");
        CountryEntity[] countries = new CountryEntity [] {

                new CountryEntity ( "Argentina"),
                new CountryEntity ( "Venezuela"),
                new CountryEntity ( "Uruguay"),
                new CountryEntity ( "Chile"),
                new CountryEntity ( "Peru")
        };
        logger.debug (String.format ("Objects country created %s", Arrays.toString (countries)));

        logger.debug ("Saving countries...");
        this.repository.save (Arrays.asList (countries));
        logger.debug (String.format ("Countries saved %s", Arrays.toString (countries)));
    }

    @Test
    public void testCount () {

        logger.info ("Counting countries...");
        Long count = this.repository.count ();

        Assert.assertNotNull ("There are countries...", count);
        Assert.assertTrue ("There are countries...",count > 0);
    }

    @Test
    public void testGetAll () {

        logger.info ("Getting countries...");
        List<CountryEntity> list = this.repository.findAll ();

        Assert.assertNotNull ("There are countries...", list);
        Assert.assertFalse ("There are countries...",list.isEmpty ());
    }

    @After
    public void Release () {

        logger.info ("Deleting countries...");
        this.repository.deleteAll ();
        logger.info ("Countries deleted...");

        logger.info ("Getting countries...");
        List<CountryEntity> list = this.repository.findAll ();

        Assert.assertTrue ("There are not countries...",list.isEmpty ());
    }



}