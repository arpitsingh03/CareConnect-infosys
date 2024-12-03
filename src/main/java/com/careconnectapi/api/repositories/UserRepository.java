package com.careconnectapi.api.repositories;

import java.util.List;

 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.careconnectapi.api.entity.UserEntity;
import com.careconnectapi.api.model.UserRequestBody;
 
@Repository
public interface  UserRepository extends CrudRepository<UserEntity,Integer> {

	@Query(value = "select * from  asutosh_user ", nativeQuery = true)
	Page<UserEntity> listAllUsers(Pageable pageable);

	@Query(value = "SELECT count(*) from asutosh_user", nativeQuery = true)
	String countNumberOfUsers();



}