package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@EnableWebSecurity
public class Appsecurityconfig {
	@Autowired
	private MyUserDetailsService userDetailsService;


	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}

/*	@Bean
	public InMemoryUserDetailsManager userDetailManager() {

		System.out.println("user detail manager");

		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();
		InMemoryUserDetailsManager configurer = new InMemoryUserDetailsManager();
		configurer.createUser(user);
		return configurer;

	}*/
	
	/*
	@Bean
	public UserDetailsManager jpaUserDetailManager() {

		System.out.println("user detail manager");

		
		UserDetailsManager userDetailsManager = new UserDetailsManager() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return userDetailsService.loadUserByUsername(username);
			}
			
			@Override
			public boolean userExists(String username) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void updateUser(UserDetails user) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void deleteUser(String username) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void createUser(UserDetails user) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changePassword(String oldPassword, String newPassword) {
				// TODO Auto-generated method stub
				
			}
		};;
		return userDetailsManager;
	}
*/
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		System.out.println("In security configure");
		return http.csrf(csrf -> csrf.disable())
				// .authenticationManager(manager -> manager.)
				.authorizeHttpRequests(auth -> auth
//					//
						.requestMatchers("/getalldepartments").permitAll()
						// .requestMatchers("/getallstudents").permitAll()
						.requestMatchers("/user").hasRole("USER").requestMatchers("/getallstudents").hasRole("USER"))
				// .requestMatchers("/getalldepartments").hasRole("USER"))
				// .csrf().disable()
				// .authorizeHttpRequests()
				.httpBasic(Customizer.withDefaults()).formLogin(new Customizer<FormLoginConfigurer<HttpSecurity>>() {

					@Override
					public void customize(FormLoginConfigurer<HttpSecurity> t) {
						t.defaultSuccessUrl("http://localhost:4200/students");

					}
				})
				//.userDetailsService(userDetailsService)
				.authenticationProvider(authProvider())
		
				//.passwordManagement(customizer -> customizer.)
			// .formLogin(configurer -> confun)
				// .defaultSuccessUrl("/homepage.html", true)

				.build();

	}

//	//In Angular, write a component - students-list. Create an angular route
//	//In ngOnInit of that component, make an API call to get all students
//	//After login spring boot should redirect to students route

}