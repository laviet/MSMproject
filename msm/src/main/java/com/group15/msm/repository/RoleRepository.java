package com.group15.msm.repository;

import com.group15.msm.dao.Role;
import com.group15.msm.dao.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 14-11-2019
 * Time: 23:12
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
