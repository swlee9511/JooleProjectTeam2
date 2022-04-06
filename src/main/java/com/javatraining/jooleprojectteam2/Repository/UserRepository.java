package com.javatraining.jooleprojectteam2.Repository;


import com.javatraining.jooleprojectteam2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //finds roles starting with string
    List <User> findByRoleStartingWith (String str);
//    List <User> findByusernameStartingWith (String str);


}
