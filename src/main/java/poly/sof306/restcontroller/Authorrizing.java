package poly.sof306.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import poly.sof306.entity.Authorities;
import poly.sof306.service.AuthService;

@CrossOrigin("*")
@RestController
@RequestMapping("authorizing")
public class Authorrizing {
@Autowired 
AuthService authoService;

@GetMapping("getall")
public List<Authorities> findAll(@RequestParam("admin") Optional<Boolean> admin){
	if(admin.orElse(false)) {
		return authoService.findAuthoritiesOfAdministrators();
	}
	return authoService.findAll();
}
}
