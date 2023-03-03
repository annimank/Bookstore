package fi.haagahelia.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import fi.haagahelia.bookstore.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	/*Anni tässä kommenteissa ne millä saa esim h2 db näkyviin*/
	/*private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
            new AntPathRequestMatcher("/api/**"),
            new AntPathRequestMatcher("/h2-console/**"),
            new AntPathRequestMatcher("/books/**")
    };
	
	private static final AntPathRequestMatcher[] ADMIN_LIST_URLS = {
            new AntPathRequestMatcher("/admin/**"),
            new AntPathRequestMatcher("/user/**")
    };*/
	
	/*@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests().requestMatchers(ADMIN_LIST_URLS).hasAuthority("ADMIN")
		.and()
		.authorizeHttpRequests().requestMatchers(WHITE_LIST_URLS).permitAll()
		.and()
		.authorizeHttpRequests().anyRequest().authenticated()
		//for h2 console
		.and()
		.headers().frameOptions().disable()			
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/booklist", true)
		.and()
		.logout().permitAll();
		
		http.cors().and().csrf().disable();
		
		//Ohjelmistoprojekti1:n matskuun tämä
		//.addFilterAfter(new CsrfLoggerFilter(), CsrfFilter.class); 
		
		return http.build();

		
	}*/
	
		@Bean
	    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	        
		 http
	        .authorizeRequests()
	        	.antMatchers("/css/**").permitAll() // Enable css when logged out
	        	.anyRequest().authenticated()
	        	.and()
	      .formLogin()
	      	.loginPage("/login")
	        .defaultSuccessUrl("/booklist", true)
	        .permitAll()
	        .and()
	      .logout()
	         .permitAll()
	         .and()
	       .httpBasic();
	      return http.build();
	    }
	 
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	 }


	   /*@Bean
	    public UserDetailsService userDetailsService() {
	        List<UserDetails> users = new ArrayList<UserDetails>();

	        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	        UserDetails user1 = User
	        		.withUsername("user")
	        		.password(passwordEncoder.encode("user"))
	        		.roles("USER")
	        		.build();

	        users.add(user1);

	        UserDetails user2 = User
	        		.withUsername("admin")
	        		.password(passwordEncoder.encode("admin"))
	        		.roles("USER", "ADMIN")
	        		.build();

	    	users.add(user2);

	        return new InMemoryUserDetailsManager(users);
	    }*/
	 
	 

}
