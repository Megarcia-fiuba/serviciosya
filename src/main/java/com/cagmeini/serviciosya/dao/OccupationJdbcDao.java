package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.domain.Occupation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.postgresql.jdbc4.*;

public class OccupationJdbcDao implements IOccupationDao   {


    @Override
    public List<Occupation> findAllOccupations() {
        // Build the occupation list.
        List<Occupation> list = new ArrayList<>();
        try {


            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM \"OCCUPATION\"");

            while (resultSet.next()) {
                int id= resultSet.getInt("ID");
                String name= resultSet.getString("NAME");
                String description = resultSet.getString("DESCRIPTION");

                Occupation oc = new Occupation(String.valueOf(id),name,description);

                list.add (oc);
            }

            cnn.close();

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
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM \"OCCUPATION\"");

            // Build the occupation list.
            List<Occupation> list = new ArrayList<>();
            while (resultSet.next()) {
                String res_name= resultSet.getString("NAME");
                if (name.equals(res_name)) {
                    int id= resultSet.getInt("ID");
                    String description = resultSet.getString("DESCRIPTION");
                    Occupation oc = new Occupation(String.valueOf(id),res_name,description);

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
    public void add(Occupation occupation) {
        try {
            // Register the driver.
            Class.forName ("org.postgresql.Driver");

            // Create a new connection.
            Connection cnn = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/serviciosya", "postgres", "qwerty1234");

            //Connection cnn= this.getConnection();

            cnn.createStatement ().
                    executeUpdate ("INSERT INTO \"OCCUPATION\" (\"NAME\",\"DESCRIPTION\") VALUES ('"+occupation.getName()+"','"+occupation.getDescription()+"')");
            cnn.close();

        } catch (Exception e) {

            e.printStackTrace ();
        }

    }

    @Override
    public Occupation searchById(String id)  {
        try {

            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM \"OCCUPATION\" WHERE \"ID\"="+id);

            if(!resultSet.isBeforeFirst()){
                int res_id= resultSet.getInt("ID");
                String name= resultSet.getString("NAME");
                String description = resultSet.getString("DESCRIPTION");

                return new Occupation(String.valueOf(res_id),name,description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Occupation searchByName(String name) {
        try {

            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM \"OCCUPATION\" WHERE \"NAME\" ="+name);

            if(!resultSet.isBeforeFirst()){
                int id= resultSet.getInt("ID");
                String res_name= resultSet.getString("NAME");
                String description = resultSet.getString("DESCRIPTION");

                return new Occupation(String.valueOf(id),res_name,description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public String getDescprition(String id) {

        try {

            Connection cnn=CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM \"OCCUPATION\" WHERE \"ID\"="+id);

            if(!resultSet.isBeforeFirst()){
                return resultSet.getString("DESCRIPTION");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean exists(String id) {
        try {

            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * FROM \"OCCUPATION\" WHERE \"ID\"="+id);

            return !resultSet.isBeforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void modifyName(String id, String newName) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("UPDATE \"OCCUPATION\" SET \"NAME\" = '"+newName+"' WHERE \"ID\"="+id);

        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public void modifyDescription(String id, String newDescription) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("UPDATE \"OCCUPATION\" SET \"DESCRIPTION\" = '"+newDescription+"' WHERE \"ID\"="+id);


        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public int size() {
        List<Occupation> list= this.findAllOccupations();
        return list.size();
    }

    @Override
    public void remove(String id) {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("DELETE FROM \"OCCUPATION\"  WHERE \"ID\"="+id);
        }catch (Exception e){
            throw new DaoException(e);
        }


    }

    @Override
    public void removeAll() {
        try{
            Connection cnn= CapgeminiDB.getConnection();

            Statement stm = cnn.createStatement ();

            int r = stm.executeUpdate ("DELETE FROM \"OCCUPATION\"");
        }catch (Exception e){
            throw new DaoException(e);
        }


    }
}
