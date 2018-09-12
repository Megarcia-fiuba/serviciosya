package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.domain.Country;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDao implements ICountryDao {

    private static final Logger logger = Logger.getLogger (CountryDao.class);

    @Override
    public void create(Country target) {
        try {
            Connection cnn= CapgeminiDB.getConnection();

            cnn.createStatement ().
                    executeUpdate ("INSERT INTO country (name) VALUES ('"+target.getName()+"')");


        } catch (Exception e) {

            e.printStackTrace ();
        }

    }

    @Override
    public void update(Country target) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("UPDATE country SET name = '"+target.getName()+"' WHERE id ="+String.valueOf(target.getId()));

        }catch (Exception e){
            throw new DaoException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("DELETE FROM country  WHERE id="+String.valueOf(id));
        }catch (Exception e){
            throw new DaoException(e);
        }

    }

    @Override
    public List<Country> findall() {
        // Countriess list.
        List<Country> countries = new ArrayList<>();

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            Statement statement = conn.createStatement ();


            // Execute the query.
            String sql = "select * from country";
            logger.debug (String.format ("Executing query [%s]", sql));
            ResultSet rs = statement.executeQuery (sql);


            // Read the result.

            while (rs.next ()) {

                Country o = new Country ();
                o.setId (rs.getInt ("id"));
                o.setName (rs.getString ("name"));

                // Add new object to list.
                countries.add (o);
            }

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure searching all countries");
            throw new DaoException ("Failure searching all countries", e);
        }

        // Return results.
        return countries;
    }

    @Override
    public Country findById(Integer id) {
        try {

            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM country WHERE id="+String.valueOf(id));

            if(!resultSet.isBeforeFirst()){
                Country c =new Country();
                c.setId(resultSet.getInt("name"));
                c.setName(resultSet.getString("name"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
