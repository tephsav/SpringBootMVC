package app.service;

import app.model.User;

public interface UserService {
    Iterable<User> allUsers();
    User getById(int id) throws Exception;
    void add(User user);
    void delete(User user);
    void edit(User user);
}