package com.javatraining.jooleprojectteam2.Repository;


import com.javatraining.jooleprojectteam2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    //finds roles starting with string
    List <User> findByRoleStartingWith (String str);
    //finds userNAme starting with string
    List <User> findByUserNameStartingWith (String str);
    //fins userName that contains string, case is ignored
    List <User> findByUserNameContainsIgnoreCase (String str);

    Optional<User> findByUserName(String username);

}
