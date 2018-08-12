package com.venkat.teamtemp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.venkat.teamtemp.security.JWTAuthenticationFilter;;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	

	
	 @Override
	    public void configure(final AuthenticationManagerBuilder auth) throws Exception
	    {
		 
//		 	AuthenticationProvider provider = new CustomAuthenticationProvider();  
//		 	
		 	auth.authenticationProvider(authenticationProvider);
	    }
 
    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {

        http.csrf().disable();
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
    	.authorizeRequests().antMatchers(HttpMethod.POST, "/comments/**").permitAll()
    	.and()
    	.authorizeRequests().antMatchers(HttpMethod.GET, "/locations").permitAll()
    	.and()
    	.authorizeRequests().anyRequest().authenticated();
    	
        //Implementing Token based authentication in this filter
        final JWTAuthenticationFilter tokenFilter = new JWTAuthenticationFilter();
        http.addFilterBefore(tokenFilter, BasicAuthenticationFilter.class);
        

    }
}