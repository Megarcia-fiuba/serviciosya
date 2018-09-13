package com.cagmeini.serviciosya.dao;


import com.cagmeini.serviciosya.beans.domain.Province;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDao implements IProvinceDao {

    private static final Logger logger = Logger.getLogger (ProvinceDao.class);

    @Override
    public void create(Province target) {
        try {
            Connection cnn= CapgeminiDB.getConnection();

            cnn.createStatement ().
                    executeUpdate ("INSERT INTO province (name,country_id) VALUES ('"+target.getName()+"','"+ target.getCountryId()+"')");


        } catch (Exception e) {

            e.printStackTrace ();
        }

    }

    @Override
    public void update(Province target) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("UPDATE province SET name = '"+target.getName()+"',country_id='"+target.getCountryId()+"' WHERE id ="+target.getId());

        }catch (Exception e){
            throw new DaoException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("DELETE FROM province  WHERE id="+id);
        }catch (Exception e){
            throw new DaoException(e);
        }

    }

    @Override
    public List<Province> findall() {
        // Provinces list.
        List<Province> provinces = new ArrayList<>();

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            Statement statement = conn.createStatement ();


            // Execute the query.
            String sql = "select * from province";
            logger.debug (String.format ("Executing query [%s]", sql));
            ResultSet rs = statement.executeQuery (sql);


            // Read the result.

            while (rs.next ()) {

                Province o = new Province ();
                o.setId (rs.getInt ("id"));
                o.setName (rs.getString ("name"));
                o.setCountryId(rs.getInt("country_id"));

                // Add new object to list.
                provinces.add (o);
            }

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure searching all provinces");
            throw new DaoException ("Failure searching all provinces", e);
        }

        // Return results.
        return provinces;
    }

    @Override
    public Province findById(Integer id) {
        try {

            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM province WHERE id="+id);

            if(!resultSet.isBeforeFirst()){
                Province o =new Province();
                o.setId(resultSet.getInt("name"));
                o.setName(resultSet.getString("name"));
                o.setCountryId(resultSet.getInt("country_id"));
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
