package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   User add (User user);
   List<User> listUsers();
   List<User> find (int series, String model);
   void remove (User user);
   void update (User user)
}
