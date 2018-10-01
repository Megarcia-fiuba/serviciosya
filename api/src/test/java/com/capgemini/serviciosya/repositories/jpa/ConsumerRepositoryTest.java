package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.*;
import com.capgemini.serviciosya.repositories.jpa.ICityRepository;
import com.capgemini.serviciosya.repositories.jpa.IConsumerRepository;
import com.capgemini.serviciosya.repositories.jpa.ICountryRepository;
import com.capgemini.serviciosya.repositories.jpa.IProvinceRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsumerRepositoryTest {

    @Autowired
    private ICountryRepository cDao = null;
    @Autowired
    private IProvinceRepository pDao = null;
    @Autowired
    private ICityRepository ciDao = null;
    @Autowired
    private IConsumerRepository dao = null;
    private CountryEntity testCountry;
    private ProvinceEntity testProvince;
    private CityEntity testCity;
    private ConsumerEntity testconsumer;

    @Before
    public void init(){
        this.testCountry= new CountryEntity();
        this.testCountry.setName("testCountry");
        this.cDao.save(this.testCountry);
        this.testProvince= new ProvinceEntity();
        this.testProvince.setName("testProvince");
        this.testProvince.setCountry(this.testCountry);
        this.pDao.save(this.testProvince);
        this.testCity= new CityEntity();
        this.testCity.setName("testCity");
        this.testCity.setProvince(this.testProvince);
        this.ciDao.save(this.testCity);
        this.testconsumer=new ConsumerEntity();
        this.testconsumer.setName("TestConsumer");
        this.testconsumer.setLastName("testLastname");
        this.testconsumer.setAddress("testaddress");
        this.testconsumer.setCity(this.testCity);
        this.testconsumer.setDni(1234);
        this.testconsumer.setPhone("1234");
        this.testconsumer.setEmail("email@gmail.com");

    }


    @Test
    public void testCreate () {
        this.testconsumer.setId(99);
        this.dao.save(this.testconsumer);

        Assert.assertNotNull ("Failure creating new Consumer.", this.testconsumer.getId ());
        this.dao.delete(this.testconsumer.getId());

    }

    @Test
    public void update() {
        this.dao.save(this.testconsumer);
        this.testconsumer.setName("TestUpdateConsumer");
        this.dao.save(this.testconsumer);
        ConsumerEntity cu=this.dao.findOne(this.testconsumer.getId());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));
        this.dao.delete(this.testconsumer.getId());
    }

  /*  @Test
    public void delete() {

        this.dao.save(this.testconsumer);

        Assert.assertNotNull ("Failure creating new Consumer.", this.testconsumer.getId ());
        this.dao.delete(this.testconsumer.getId());
        Assert.assertNull ("Failure deleting new Consumer.", this.dao.findOne(this.testconsumer.getId()));
    }
*/
    @Test
    public void findall() {
        this.dao.save(this.testconsumer);

        List<ConsumerEntity> co=this.dao.findAll();
        List<String> l =co.stream().map(ConsumerEntity::getName).collect(Collectors.toList());

        Assert.assertTrue("failure finding all countries",l.contains(this.testconsumer.getName()) );
        this.dao.delete(this.testconsumer.getId());

    }

    @Test
    public void findById() {
        this.dao.save(this.testconsumer);
        ConsumerEntity cu=this.dao.findOne(this.testconsumer.getId());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));
        this.dao.delete(this.testconsumer.getId());

    }


    @Test
    public void findByPhone() {
        this.dao.save(this.testconsumer);
        ConsumerEntity cu=this.dao.findOneByPhone(this.testconsumer.getPhone());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));
        this.dao.delete(this.testconsumer.getId());

    }

    @Test
    public void findByDni() {
        this.dao.save(this.testconsumer);
        ConsumerEntity cu=this.dao.findOneByDni(this.testconsumer.getDni());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));
        this.dao.delete(this.testconsumer.getId());

    }

    @Test
    public void findByEmail() {
        this.dao.save(this.testconsumer);
        ConsumerEntity cu=this.dao.findOneByEmail(this.testconsumer.getEmail());

        Assert.assertTrue("Failure updating Consumer",cu.getName().equals(this.testconsumer.getName()));
        this.dao.delete(this.testconsumer.getId());

    }
/*
    @After
    public void testafter(){
        this.ciDao.delete(this.testCity.getId());
        this.pDao.delete(this.testProvince.getId());
        this.cDao.delete(this.testCountry.getId());
    }
*/

}
