package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import com.capgemini.serviciosya.dao.DaoException;
import com.capgemini.serviciosya.dao.IConsumerDao;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class ConsumerDao implements IConsumerDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory ();


    private static final Logger logger= Logger.getLogger (ConsumerDao.class);


    @Override
    public void create(ConsumerEntity target) {
        // Validate the arguments.
        if (target == null) {

            logger.warn ("Consumer object is null!");
            return;
        }

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator ();

        Set<ConstraintViolation<ConsumerEntity>> validationErrors = validator.validate(target);

        if(!validationErrors.isEmpty()){
            for(ConstraintViolation<ConsumerEntity> error : validationErrors){
                System.out.println(error.getMessageTemplate()+"::"+error.getPropertyPath()+"::"+error.getMessage());

            }
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Creating new Consumer %s", target));
            session.save (target);
            tx.commit ();
            logger.debug (String.format ("New Consumer %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new Consumer %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void update(ConsumerEntity target) {
        // Validate the arguments.
        if (target == null) {

            logger.warn ("Consumer object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Updating Consumer %s", target));
            session.update (target);
            tx.commit ();
            logger.debug (String.format ("Consumer %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error updating Consumer %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

    }

    @Override
    public void delete(Integer id) {
        // Validate the arguments.
        if (id == null) {

            logger.warn ("Id Consumer is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Deleting Consumer by id %s", id.toString ()));
            ConsumerEntity c = (ConsumerEntity) session.get (ConsumerEntity.class, id);
            if (c != null) {

                session.delete (c);
                tx.commit ();
                logger.debug (String.format ("Consumer by id %s deleted!", id.toString ()));
            } else {
                logger.warn (String.format ("Consumer by id %s not found!", id.toString ()));
            }

        } catch (Exception e) {

            logger.error (String.format ("Error deleting Consumer id %s", id.toString ()));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

    }

    @Override
    public List<ConsumerEntity> findall() {
        List<ConsumerEntity> list = null;

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug ("Finding all Consumers...");
            list = (List<ConsumerEntity>) session.createCriteria (ConsumerEntity.class).list ();

        } catch (Exception e) {

            logger.error ("Error finding all Consumers id");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return list;
    }

    @Override
    public ConsumerEntity findById(Integer id) {
        // Validate the arguments.
        if (id == null) {

            logger.warn ("Id Consumer is null!");
            return null;
        }

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding Consumer by id %s", id.toString ()));
            ConsumerEntity c = (ConsumerEntity) session.get (ConsumerEntity.class, id);
            if (c != null) {

                return c;
            } else {

                logger.warn (String.format ("Consumer by id %s not found!", id.toString ()));
                return null;
            }

        } catch (Exception e) {

            logger.error (String.format ("Error finding Consumer id %s", id.toString ()));
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public ConsumerEntity findByPhone(String phone) {
        if (isEmpty (phone)) {

            logger.warn ("Phone argument is empty!");
            return null;
        }

        ConsumerEntity consumer;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding consumer by phone %s", phone));
            consumer = (ConsumerEntity) session.getNamedQuery ("ConsumerFindByPhone").
                    setString("phone", phone).uniqueResult();
        } catch (Exception e) {

            logger.error ("Error finding a consumer by phone");
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }

        return consumer;
    }

    @Override
    public ConsumerEntity findByDni(Integer dni) {
        if (dni == null) {

            logger.warn ("DNI argument is empty!");
            return null;
        }

        ConsumerEntity consumer;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding Consumer by dni %s", dni.toString()));
            Criteria criteria = session.createCriteria (ConsumerEntity.class);
            criteria.add (Restrictions.eq ("dni", dni));

            consumer = (ConsumerEntity) criteria.uniqueResult ();

        } catch (Exception e) {

            logger.error ("Error finding a Consumer by dni");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return consumer;
    }

    @Override
    public ConsumerEntity findByEmail(String email) {
        if (isEmpty (email)) {

            logger.warn ("Email argument is empty!");
            return null;
        }

        ConsumerEntity consumer;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding Consumer by emai %s", email));
            consumer = (ConsumerEntity) session.
                    createQuery ("From Consumer p where p.email = '" + email + "'").
                    uniqueResult ();

        } catch (Exception e) {

            logger.error ("Error finding a Consumer by email");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return consumer;
    }

}
