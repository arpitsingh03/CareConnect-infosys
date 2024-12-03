package com.careconnectapi.api.service;

import com.careconnectapi.api.entity.UserEntity;
import com.careconnectapi.api.model.UserIdRequest;
import com.careconnectapi.api.model.UserRequestBody; 
import com.careconnectapi.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class UserService  {

	@Autowired
	private UserRepository UserRepository;

	

	public UserEntity createUser(UserRequestBody userRequestBodyObj) {

		UserEntity newUser = new UserEntity();
		newUser.setUserId(userRequestBodyObj.getUserId());
		newUser.setFirstName(userRequestBodyObj.getFirstName());
		newUser.setLastName(userRequestBodyObj.getLastName());
		newUser.setPhoneNumber(userRequestBodyObj.getPhoneNumber());
		newUser.setEmailId(userRequestBodyObj.getEmailId());
		newUser.setPassWord(userRequestBodyObj.getPassWord());
		return UserRepository.save(newUser);		 
	}

	public UserEntity updateUser(UserRequestBody userRequestBodyObj) {
		UserEntity newUser = new UserEntity();
		newUser.setUserId(userRequestBodyObj.getUserId() );
		newUser.setFirstName(userRequestBodyObj.getFirstName());
		newUser.setLastName(userRequestBodyObj.getLastName());
		newUser.setPhoneNumber(userRequestBodyObj.getPhoneNumber());
		newUser.setEmailId(userRequestBodyObj.getEmailId());
		newUser.setPassWord(userRequestBodyObj.getPassWord());
		return UserRepository.save(newUser);		 
	}

	public Page<UserEntity> listAllUsers(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return UserRepository.listAllUsers(pageable);
	}
 
	public String deleteUser(UserIdRequest user) {
		int UserId= user.getUserId();
		UserRepository.deleteById(UserId);
		return "User Deleted";
	}

	public String countNumberOfUsers() {

		return UserRepository.countNumberOfUsers();
	}

}