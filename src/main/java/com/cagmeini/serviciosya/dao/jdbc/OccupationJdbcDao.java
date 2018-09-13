package com.cagmeini.serviciosya.dao.jdbc;

import com.cagmeini.serviciosya.beans.domain.Occupation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cagmeini.serviciosya.dao.DaoException;
import com.cagmeini.serviciosya.dao.IOccupationDao;
import org.apache.log4j.Logger;

public class OccupationJdbcDao implements IOccupationDao {

    private static final Logger logger = Logger.getLogger (OccupationJdbcDao.class);

    @Override
    public List<Occupation> findall() {
        // Build the occupation list.
        List<Occupation> list = new ArrayList<>();
        try {
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM occupation");

            while (resultSet.next()) {
                int id= resultSet.getInt("id");
                String name= resultSet.getString("name");
                String description = resultSet.getString("description");

                Occupation oc = new Occupation(id,name,description);

                list.add (oc);
            }

        } catch (Exception e) {
            throw new DaoException(e);
        }

        // Return the occupations.
        return list;
    }

    @Override
    public List<Occupation> findDuplicates(String name) {
        try {
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM occupation");

            // Build the occupation list.
            List<Occupation> list = new ArrayList<>();
            while (resultSet.next()) {
                String res_name= resultSet.getString("name");
                if (name.equals(res_name)) {
                    int id= resultSet.getInt("id");
                    String description = resultSet.getString("description");
                    Occupation oc = new Occupation(id,res_name,description);

                    list.add (oc);
                }
            }

            // Return the occupations.
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Occupation occupation) {
        try {
            Connection cnn= CapgeminiDB.getConnection();

            cnn.createStatement ().
                    executeUpdate ("INSERT INTO occupation (name,description) VALUES ('"+occupation.getName()+"','"+occupation.getDescription()+"')");

        } catch (Exception e) {

            e.printStackTrace ();
        }

    }

    @Override
    public Occupation findById(Integer id)  {
        try {

            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM occupation WHERE id ="+String.valueOf(id));

            if(!resultSet.isBeforeFirst()){
                int res_id= resultSet.getInt("id");
                String name= resultSet.getString("name");
                String description = resultSet.getString("description");

                return new Occupation(res_id,name,description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public String getDescprition(int id) {

        try {

            Connection cnn=CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM occupation WHERE id ="+id);

            if(!resultSet.isBeforeFirst()){
                return resultSet.getString("description");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean exists(int id) {
        try {

            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM occupation WHERE id="+id);

            return !resultSet.isBeforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void update(Occupation o) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("UPDATE occupation SET name = '"+o.getName()+"' desciprtion ='"+o.getDescription()+"' WHERE id="+String.valueOf(o.getId()) );

        }catch (Exception e){
            throw new DaoException(e);
        }
    }


    @Override
    public int size() {
        List<Occupation> list= this.findall();
        return list.size();
    }

    @Override
    public void delete(Integer id) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("DELETE FROM occupation  WHERE id="+String.valueOf(id));
        }catch (Exception e){
            throw new DaoException(e);
        }
    }


    @Override
    public void removeAll() {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("DELETE FROM occupation");
        }catch (Exception e){
            throw new DaoException(e);
        }


    }
}