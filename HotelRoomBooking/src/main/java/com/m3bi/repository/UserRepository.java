package com.m3bi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.m3bi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUserName(String userName);

}
