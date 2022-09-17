package com.fms.services;

import com.fms.dtos.User;
import java.math.BigInteger;
import java.util.List;

public interface UserService {

    public User addUser(User newUser);

    public User updateUser(User user);

    public void deleteUser(BigInteger userId);

    public List<User> viewUser();

    public User viewUser(BigInteger userId);

    public void validateUser(User user);
}
