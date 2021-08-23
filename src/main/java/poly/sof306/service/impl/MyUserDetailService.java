package poly.sof306.service.impl;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import poly.sof306.dao.AccountDao;
import poly.sof306.entity.Account;






@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	AccountDao accdao;
	@Autowired
    PasswordEncoder pe;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account account = accdao.findById(username).get();
			String password = pe.encode(account.getPassword());
			String[] roles = account.getAuth().stream()
					.map(er -> er.getRoles().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username).password(password).roles(roles).build();
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found! " + username);
		}
		
	}

}
