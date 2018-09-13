package com.cagmeini.serviciosya.dao.jdbc;

import com.cagmeini.serviciosya.beans.domain.City;
import com.cagmeini.serviciosya.dao.DaoException;
import com.cagmeini.serviciosya.dao.ICityDao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements ICityDao {

    private static final Logger logger = Logger.getLogger (CityDao.class);

    @Override
    public void create(City target) {
        try {
            Connection cnn= CapgeminiDB.getConnection();

            cnn.createStatement ().
                    executeUpdate ("INSERT INTO city (name,province_id) VALUES ('"+target.getName()+"','"+ target.getProvinceId()+"')");


        } catch (Exception e) {

            e.printStackTrace ();
        }

    }

    @Override
    public void update(City target) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("UPDATE city SET name = '"+target.getName()+"',province_id='"+target.getProvinceId()+"' WHERE id ="+target.getId());

        }catch (Exception e){
            throw new DaoException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("DELETE FROM city  WHERE id="+id);
        }catch (Exception e){
            throw new DaoException(e);
        }

    }

    @Override
    public List<City> findall() {
        // Cities list.
        List<City> cities = new ArrayList<>();

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            Statement statement = conn.createStatement ();


            // Execute the query.
            String sql = "select * from city";
            logger.debug (String.format ("Executing query [%s]", sql));
            ResultSet rs = statement.executeQuery (sql);


            // Read the result.

            while (rs.next ()) {

                City o = new City ();
                o.setId (rs.getInt ("id"));
                o.setName (rs.getString ("name"));
                o.setProvinceId(rs.getInt("province_id"));

                // Add new object to list.
                cities.add (o);
            }

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure searching all cities");
            throw new DaoException ("Failure searching all cities", e);
        }

        // Return results.
        return cities;
    }

    @Override
    public City findById(Integer id) {
        try {

            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM city WHERE id="+id);

            if(!resultSet.isBeforeFirst()){
                City o =new City();
                o.setId(resultSet.getInt("name"));
                o.setName(resultSet.getString("name"));
                o.setProvinceId(resultSet.getInt("province_id"));
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
