package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired

	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		System.out.println("In my user: " + username);
		Optional<User> user = repo.findById(username);
		System.out.println("user: " + user.get());
		if (user == null)
			throw new UsernameNotFoundException("USer 404");

		System.out.println("user: " + user.get().getUsername());
		System.out.println("user: " + user.get().getPassword());

		return new UserPrincipal(user.get());
	}

}
