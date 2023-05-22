package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public User add(User user) {
      Long id = (Long) sessionFactory.getCurrentSession().save(user);
      user.setId(id);
      return user;
   }


   public void remove(User user) {
      sessionFactory.getCurrentSession().delete(user);
   }


   public void update(User user) {
      sessionFactory.getCurrentSession().update(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Transactional
   public List<User> find(int series, String model) {
      Session session = sessionFactory.getCurrentSession();
      Query<User> query = session.createQuery(
              "from User where car.series = :series and car.model = :model");
      query.setParameter("series", series);
      query.setParameter("model", model);
      return query.getResultList();
   }

}
