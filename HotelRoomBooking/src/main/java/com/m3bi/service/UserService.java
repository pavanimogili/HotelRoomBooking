package com.m3bi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m3bi.model.User;
import com.m3bi.repository.UserRepository;


@Service
@Transactional
public class UserService {
	
	@Autowired UserRepository repo;
	
	
	public void save(User user) {
        repo.save(user);
    }
     
    public List<User> listAll() {
        return (List<User>) repo.findAll();
        		}
     
    public User get(Long id) {
        return repo.findById(id).get();
    }
     
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
    public User search(String keyword) {
        return repo.findByUserName(keyword);
    }

}
