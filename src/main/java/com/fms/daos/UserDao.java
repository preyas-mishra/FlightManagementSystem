package com.fms.daos;

import com.fms.dtos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, BigInteger>
{
    Optional<User> findByUserEmail(String userEmail);
    
}
