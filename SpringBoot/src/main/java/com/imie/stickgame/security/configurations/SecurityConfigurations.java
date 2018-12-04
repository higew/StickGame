package com.imie.stickgame.security.configurations;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.imie.stickgame.security.controllers.LoginController;

@Configuration
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	@Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private DataSource dataSource;

  @Value("${spring.queries.users-query}")
  private String usersQuery;

  @Value("${spring.queries.roles-query}")
  private String rolesQuery;

  @Override
  protected void configure(AuthenticationManagerBuilder auth)
          throws Exception {
      auth.
              jdbcAuthentication()
              .usersByUsernameQuery(usersQuery)
              .authoritiesByUsernameQuery(rolesQuery)
              .dataSource(dataSource)
              .passwordEncoder(bCryptPasswordEncoder);
  }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/index", "/registration", "/css/**", "/javascript/**", "/media/**")
					.permitAll()
				//.antMatchers("/users/edit/**").access("hasRole('ROLE_ADMIN')")	
				.anyRequest()
					.authenticated()
			.and()
				.formLogin()
					.loginPage(LoginController.LOGIN)
					.usernameParameter(LoginController.FORM_USERNAME)
					.passwordParameter(LoginController.FORM_PASSWORD)
					.permitAll()
			.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login")
			.and()
				.httpBasic()
		;
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
//	@Bean
//	GrantedAuthorityDefaults grantedAuthorityDefaults() {
//	    return new GrantedAuthorityDefaults("ROLE_");
//	}

}
