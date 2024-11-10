package com.jayda.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jayda.loginandregistration.models.LoginUser;
import com.jayda.loginandregistration.models.User;
import com.jayda.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User register(User newUser , BindingResult result) {
		
		Optional<User> optionalUser = this.userRepository.findByEmail(newUser.getEmail());
		if (optionalUser.isPresent()) {
			result.rejectValue("email","Matches" , "Email already exists!");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords don't match!");
		}
		
		if (result.hasErrors()) {
			return null;
		}
		String hash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hash);
		this.userRepository.save(newUser);
		return newUser;
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
        Optional<User> optionalUser = this.userRepository.findByEmail(newLoginObject.getEmail());
        if (optionalUser.isEmpty()) {
        	result.rejectValue("email", "Matches" , "No user with this email exists in our database");
        }else if(!BCrypt.checkpw(newLoginObject.getPassword(), optionalUser.get().getPassword())) {
        	result.rejectValue("password", "Matches" , "Wrong password");
        }
        
        if (result.hasErrors()) {
        	return null;
        }
        
        return optionalUser.get();
    }
	
	public User getUser(Long id) {
		Optional<User> user = this.userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}
}
