/**
 * 
 */
package com.spring.rest.springrest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author omnitya.jha
 *
 */

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Value("${security.enable-csrf}")
    private boolean csrfEnabled;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("admin")
			.roles("USER");
		
	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	       super.configure(http);

	       if(!csrfEnabled)
	       {
	         http.csrf().disable();
	       }
	    }
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
