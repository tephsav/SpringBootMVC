package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userRepo) {
        this.userDao = userRepo;
    }

    @Override
    public Iterable<User> allUsers() {
        return userDao.findAll();
    }

    @Override
    public User getById(int id) throws Exception {
        return userDao.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void edit(User user) {
        userDao.save(user);
    }
}
