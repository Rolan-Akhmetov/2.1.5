package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<User> find(int series, String model);
    public void update(User user);
    public void remove(User user);

}
