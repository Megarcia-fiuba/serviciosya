package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.dao.DaoException;
import com.capgemini.serviciosya.dao.ICityDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CityDao implements ICityDao {
    private SessionFactory sessionFactory ;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    private static final Logger logger= Logger.getLogger (CityDao.class);


    @Override
    public void create (CityEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("City object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Creating new city %s", target));
            session.save (target);
            tx.commit ();
            logger.debug (String.format ("New city %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new city %s", target));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void update (CityEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("City object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Updating city %s", target));
            session.update (target);
            tx.commit ();
            logger.debug (String.format ("City %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error updating City %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void delete (Integer id) {

        // Validate the arguments.
        if (id == null) {

            logger.warn ("Id city is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Deleting city by id %s", id.toString ()));
            CityEntity c = (CityEntity) session.get (CityEntity.class, id);
            if (c != null) {

                session.delete (c);
                tx.commit ();
                logger.debug (String.format ("City by id %s deleted!", id.toString ()));
            } else {
                logger.warn (String.format ("City by id %s not found!", id.toString ()));
            }

        } catch (Exception e) {

            logger.error (String.format ("Error deleting city id %s", id.toString ()));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public List<CityEntity> findall() {

        List<CityEntity> list = null;

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug ("Finding all cities");
            list = (List<CityEntity>) session.createCriteria (CityEntity.class).list ();

        } catch (Exception e) {

            logger.error ("Error finding all cities id");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return list;
    }

    @Override
    public CityEntity findById (Integer id) {

        // Validate the arguments.
        if (id == null) {

            logger.warn ("Id city is null!");
            return null;
        }

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding city by id %s", id.toString ()));
            CityEntity c = (CityEntity) session.get (CityEntity.class, id);
            if (c != null) {

                return c;
            } else {

                logger.warn (String.format ("City by id %s not found!", id.toString ()));
                return null;
            }

        } catch (Exception e) {

            logger.error (String.format ("Error finding city id %s", id.toString ()));
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }
}
