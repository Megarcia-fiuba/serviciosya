package com.capgemini.serviciosya.repositories.jpa;

import com.capgemini.serviciosya.beans.entity.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProviderRepositoryTest {

    @Autowired
    private ICountryRepository cDao = null;
    @Autowired
    private IProvinceRepository pDao = null;
    @Autowired
    private ICityRepository ciDao = null;
    @Autowired
    private IProviderRepository dao = null;
    @Autowired
    private IOccupationRepository occupationRepository=null;
    private CountryEntity testCountry;
    private ProvinceEntity testProvince;
    private CityEntity testCity;
    private ProviderEntity testProvider;
    private OccupationEntity testoccupation;

    @Before
    @Test
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
        this.testoccupation= new OccupationEntity();
        this.testoccupation.setName("TestOccupation");
        this.testoccupation.setDescription("Testing");
        this.occupationRepository.save(this.testoccupation);
        this.testProvider=new ProviderEntity();
        this.testProvider.setName("TestProvider");
        this.testProvider.setLastName("testLastname");
        this.testProvider.setAddress("testaddress");
        this.testProvider.setCity(this.testCity);
        this.testProvider.setDni(1234);
        this.testProvider.setPhone("1234");
        this.testProvider.setEmail("email@gmail.com");
        Set<OccupationEntity> occupations= new HashSet();
        occupations.add(this.testoccupation);
        this.testProvider.setOccupations(occupations);

    }


    @Test
    public void testCreate () {
        this.dao.save(this.testProvider);

        Assert.assertNotNull ("Failure creating new Provider.", this.testProvider.getId ());
        this.dao.delete(this.testProvider.getId());

    }

    @Test
    public void update() {
        this.dao.save(this.testProvider);
        this.testProvider.setName("TestUpdateProvider");
        this.dao.save(this.testProvider);
        ProviderEntity cu=this.dao.findOne(this.testProvider.getId());

        Assert.assertTrue("Failure updating Provider",cu.getName().equals(this.testProvider.getName()));
        this.dao.delete(this.testProvider.getId());
    }

    /*  @Test
      public void delete() {
  
          this.dao.save(this.testProvider);
  
          Assert.assertNotNull ("Failure creating new Provider.", this.testProvider.getId ());
          this.dao.delete(this.testProvider.getId());
          Assert.assertNull ("Failure deleting new Provider.", this.dao.findOne(this.testProvider.getId()));
      }
  */
    @Test
    public void findall() {
        this.dao.save(this.testProvider);

        List<ProviderEntity> co=this.dao.findAll();
        List<String> l =co.stream().map(ProviderEntity::getName).collect(Collectors.toList());

        Assert.assertTrue("failure finding all countries",l.contains(this.testProvider.getName()) );
        this.dao.delete(this.testProvider.getId());

    }

    @Test
    public void findById() {
        this.dao.save(this.testProvider);
        ProviderEntity cu=this.dao.findOne(this.testProvider.getId());

        Assert.assertTrue("Failure updating Provider",cu.getName().equals(this.testProvider.getName()));
        this.dao.delete(this.testProvider.getId());

    }

    /*@After
    @Test
    public void testafter(){
        this.cDao.delete(this.testCountry.getId());
        this.pDao.delete(this.testProvince.getId());
        this.ciDao.delete(this.testCity.getId());
    }
*/

    @Test
    public void findByPhone() {
        this.dao.save(this.testProvider);
        ProviderEntity cu=this.dao.findOneByPhone(this.testProvider.getPhone());

        Assert.assertTrue("Failure updating Provider",cu.getName().equals(this.testProvider.getName()));
        this.dao.delete(this.testProvider.getId());

    }

    @Test
    public void findByDni() {
        this.dao.save(this.testProvider);
        ProviderEntity cu=this.dao.findOneByDni(this.testProvider.getDni());

        Assert.assertTrue("Failure updating Provider",cu.getName().equals(this.testProvider.getName()));
        this.dao.delete(this.testProvider.getId());

    }

    @Test
    public void findByEmail() {
        this.dao.save(this.testProvider);
        ProviderEntity cu=this.dao.findOneByEmail(this.testProvider.getEmail());

        Assert.assertTrue("Failure updating Provider",cu.getName().equals(this.testProvider.getName()));
        this.dao.delete(this.testProvider.getId());

    }
}
