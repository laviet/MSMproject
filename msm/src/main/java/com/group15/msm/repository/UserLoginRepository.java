package com.group15.msm.repository;

import com.group15.msm.dao.UserDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 21-11-2019
 * Time: 08:53
 */
@Repository
public interface UserLoginRepository extends CrudRepository<UserDao, Integer> {

    @Modifying
    @Query(value="UPDATE users SET email=:email, name=:name WHERE id=:id",nativeQuery = true)
    void setUser(@Param("email") String email, @Param("name") String name, @Param("id") int id );
}
