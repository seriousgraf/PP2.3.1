package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repositories.UserRepository;

import java.util.List;

@Service

public class UserService  {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Transactional
    public void add(User user) {
        userRepository.add(user);
    }

    @Transactional
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Transactional
    public void edit(User user) {
        userRepository.edit(user);
    }

    @Transactional
    public User getById(int id) {
        return userRepository.getById(id);
    }
}