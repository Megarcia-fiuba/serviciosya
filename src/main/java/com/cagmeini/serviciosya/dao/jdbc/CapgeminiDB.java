package com.cagmeini.serviciosya.dao.jdbc;

import com.cagmeini.serviciosya.dao.DaoException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public abstract class CapgeminiDB {

    private static final BasicDataSource dataSource= new BasicDataSource();

    static{
        try{

            Properties pop = new Properties();
            pop.load(CapgeminiDB.class.getClassLoader().
                    getResourceAsStream("jdbc.properties"));

            dataSource.setUrl(pop.getProperty("jdbc.url"));
            dataSource.setUsername (pop.getProperty("jdbc.user"));
            dataSource.setPassword (pop.getProperty("jdbc.pw"));
            dataSource.setMinIdle (Integer.valueOf(pop.getProperty("jdbc.pool.ini")));
            dataSource.setMaxIdle (Integer.valueOf(pop.getProperty("jdbc.pool.min")));
            dataSource.setMaxOpenPreparedStatements (Integer.valueOf(pop.getProperty("jdbc.pool.max")));

        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    private CapgeminiDB(){

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();


    }

}
