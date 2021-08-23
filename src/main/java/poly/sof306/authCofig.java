package poly.sof306;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import poly.sof306.entity.Account;
import poly.sof306.service.AccountService;
import poly.sof306.service.impl.MyUserDetailService;
import poly.sof306.service.impl.jwtFilters;
import poly.sof306.untils.AuthEntryPointJwt;




@Configuration
@EnableWebSecurity
public class authCofig extends WebSecurityConfigurerAdapter {
	@Autowired
	MyUserDetailService userdetailservice;
	
	@Autowired
	AccountService accService;
	

	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	@Autowired
	private jwtFilters jwtfilter;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

// Quản lý người sử dụng dữ liệu 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
			auth.userDetailsService(userdetailservice);
			
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
// phân quyền sử dụng đăng nhập
	@Override
	protected void configure(HttpSecurity http) throws Exception {

//CSRF,CORS
http.csrf().disable().cors()
.and();

//phan quyen
http.authorizeRequests()
.antMatchers("/cart/**").authenticated()
.anyRequest().permitAll();
//.and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//.and().sessionManagement()
//.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);


//không đúng vai trò
http.exceptionHandling()
	.accessDeniedPage("/auth/access/denied");
//giaodiendannhap
http.formLogin()
.loginPage("/login/form")
.loginProcessingUrl("/security/login")
.defaultSuccessUrl("/product/list",false)
.failureUrl("/login/error");
http.rememberMe()
	.tokenValiditySeconds(86400);

http.logout()
 .logoutUrl("/logoff")
 .logoutSuccessUrl("/login/form");
	}
	

}
