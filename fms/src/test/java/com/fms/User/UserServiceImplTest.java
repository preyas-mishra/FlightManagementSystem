package com.fms.User;

import com.fms.daos.UserDao;
import com.fms.dtos.User;
import com.fms.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    BigInteger bi1=BigInteger.valueOf(8);
    BigInteger bi2 =BigInteger.valueOf(9989801327L);

    @Autowired
    UserDao userDao;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testViewAllUsersWithAssertThatAssertion()
    {
        List<User> user=userService.viewUser();
        assertThat(user).size().isGreaterThan(6);
    }

    @Test
    public void testViewUserByIdEqualsAssertion()
    {
        User user1=new User("Jayaram", bi2,"jayaram.gorsa@gmail.com","Jayaram","customer");

        userService.addUser(user1);

        User user=userService.viewUser(bi1);
        assertEquals(bi2,user.getUserPhone());
    }

    @Test
    public void testCreateUserWithNotNullAssertion()
    {
        User user1=new User("Jayaram", bi2,"jayaram.gorsa@gmail.com","Jayaram","customer");

        userService.addUser(user1);

        User user=userService.viewUser(bi1);
        assertNotNull(user,"User Inserted Successfully");
    }

    @Test
    public void testUpdateUserWithNotEqualsAssertion()
    {
        User user1=new User("Jayaram", bi2,"jayaram.gorsa@gmail.com","Jayaram","customer");
        User user2=new User(bi1,"Gorsa Jayaram", bi2,"veerachari@gmail.com","Jayaram","customer");

        userService.addUser(user1);
        userService.updateUser(user2);

        User user=userService.viewUser(bi1);
        assertNotEquals("Jayaram",user.getUserName());
    }

    @Test
    public void testDeleteUserByIdWithNotNullAssertion(){
        User user1=new User("Jayaram", bi2,"jayaram.gorsa@gmail.com","Jayaram","customer");

        userService.addUser(user1);
        userService.deleteUser(bi1);

        assertThat(userDao.existsById(bi1)).isFalse();
    }
}