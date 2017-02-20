package com.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.library.service.UserDetailsServiceImpl;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
//@ComponentScan("com.library")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}
	 
    @Override
    protected void configure(HttpSecurity http) throws Exception {       
        http.csrf()
                .disable()
                
                .authorizeRequests()
                .antMatchers("/resources/**", "/**").permitAll()
                .anyRequest().permitAll()
                .and();
 
        http.formLogin()
               
                .loginPage("/login")
  
                .loginProcessingUrl("/login")

                .failureUrl("/login?error")

                .usernameParameter("username")
                .passwordParameter("password")
  
                .permitAll();
        http.logout()

                .permitAll()

                .logoutUrl("/logout")

                .logoutSuccessUrl("/login?logout")

                .invalidateHttpSession(true);
    }    

//    @Bean
//    public PasswordEncoder getPasswordHelper(){
//        return new PasswordHelper();
//    }
    
    @Bean
    public BCryptPasswordEncoder encoder(){
    	return new BCryptPasswordEncoder(11);
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
