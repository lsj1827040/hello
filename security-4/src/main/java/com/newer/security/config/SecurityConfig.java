package com.newer.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Value("${spring.datasource.url}")
	String url;

	@Value("${spring.datasource.username}")
	String user;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Bean
	public DataSource getDS() {
		return DataSourceBuilder.create()
				.url(url)
				.username(user)
				.password(password)
				.build();
	}
	
	// 授权
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
			.antMatchers("/","/join","/login").permitAll()
			.antMatchers("/urse","/urse/*").hasRole("USER")
			.antMatchers("/admin","/admin/*").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		.formLogin().and()
		.httpBasic();
	}
	
	// 认证
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.passwordEncoder(new BCryptPasswordEncoder())
			.dataSource(getDS())
			.usersByUsernameQuery("select username,password,enabled from users where username = ?")
			.authoritiesByUsernameQuery("select username,authority from authorities where username = ?");
	}
}
