package com.fms.services;

import com.fms.dtos.User;
import com.fms.exceptions.IdAlreadyExistException;
import com.fms.exceptions.IdNotFoundException;
import com.fms.daos.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private static final String STR="User with id ";

    @Autowired
    UserDao userDao;

    @Override
    public User addUser(User newUser)
    {
        Optional<User> findUserByEmail=userDao.findByUserEmail(newUser.getUserEmail());
        if(findUserByEmail.isPresent())
        {
            throw new IdAlreadyExistException("User with email :" + newUser.getUserEmail() + " already exist.");
        }
        userDao.save(newUser);
        return newUser;
    }

    @Override
    public User updateUser(User updateUser)
    {
        Optional<User> findUserById = userDao.findById(updateUser.getUserId());
        if(findUserById.isPresent())
        {
            userDao.save(updateUser);
            return updateUser;
        }
        else
        {
            throw new IdNotFoundException(STR+updateUser.getUserId()+" doesnot exist so cannot update the user.");
        }
    }

    @Override
    public void deleteUser(BigInteger userId)
    {
        Optional<User> findUserById = userDao.findById(userId);
        if(findUserById.isPresent())
        {
            userDao.deleteById(userId);
        }
        else
        {
            throw new IdNotFoundException(STR+userId+" doesnot exist so cannot delete the user.");
        }
    }

    @Override
    public User viewUser(BigInteger userId)
    {
        Optional<User> findUserById = userDao.findById(userId);
        if(findUserById.isPresent())
        {
            return findUserById.get();
        }
        else
        {
            throw new IdNotFoundException(STR+userId+" doesnot exist so cannot show the user details.");
        }
    }

    @Override
    public List<User> viewUser()
    {
        return userDao.findAll();
    }

    @Override
    public void validateUser(User users)
    {
        Optional<User> findUserByEmail=userDao.findByUserEmail(users.getUserEmail());
        if(findUserByEmail.isPresent())
        {
            throw new IdAlreadyExistException(STR + users.getUserId() + " already exist.");
        }
    }
}
