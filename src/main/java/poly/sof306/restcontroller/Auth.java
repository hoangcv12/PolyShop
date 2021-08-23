package poly.sof306.restcontroller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.sof306.dao.AccountDao;
import poly.sof306.dao.AuthoritiesDao;
import poly.sof306.entity.Account;
import poly.sof306.entity.Authorities;
import poly.sof306.entity.jwtresponse;
import poly.sof306.service.AuthService;
import poly.sof306.service.impl.MyUserDetailService;
import poly.sof306.untils.Jwt_utilty;


@CrossOrigin("*")
@RestController
@RequestMapping("/jwt")
public class Auth {
	@Autowired
	MyUserDetailService userdetailservice;
	
	@Autowired
	private Jwt_utilty jwtunltity;
	
	@Autowired
	private AuthenticationManager AuthenManager;
	
	@Autowired
	AccountDao accdao;
	
	@Autowired 
	AuthoritiesDao authservice;
@GetMapping("")
public List<Authorities> home(HttpServletRequest request) {
	String authorizationHeader = request.getHeader("Authorization");
	 String jwtToken = authorizationHeader.substring(7);
	 String username = jwtunltity.getUsernameFromToken(jwtToken);
	 Account account = accdao.findById(username).get();
	return account.getAuth();
}

@PostMapping("/authenticate")
public jwtresponse authenticate(@RequestBody poly.sof306.entity.jwtrequest jwtrequest) throws Exception{
	try{
		AuthenManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		jwtrequest.getUsername(),
                		jwtrequest.getPassword()
                )
        );
    } catch (BadCredentialsException e) {
        throw new Exception("Invalid Credentials", e);
    }

    final UserDetails userDetails
            = userdetailservice.loadUserByUsername(jwtrequest.getUsername());
System.out.println(userDetails);
    final String token =
    		jwtunltity.generateToken(userDetails);

    return new jwtresponse(token);
}
}

