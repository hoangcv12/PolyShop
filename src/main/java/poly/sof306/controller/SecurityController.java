package poly.sof306.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.sof306.dao.AccountDao;
import poly.sof306.entity.Account;
import poly.sof306.service.AccountService;


@Controller
public class SecurityController {
	@RequestMapping("login/form")
public String login() {
	return "security/login";
}
	
@RequestMapping("login/error")
public String loginerror(Model model) {

	
	model.addAttribute("message","Sai thông tin đăng nhập");
	return "security/login";
}
@Autowired
AccountService accService;
@Autowired
AccountDao accdao;
@RequestMapping("test")
public String test(Model model) {
	Account account = accdao.findById("AROUT").get();
	String [] roles = account.getAuth().stream()
			.map(er -> er.getRoles().getId())
			.collect(Collectors.toList()).toArray(new String[0]);
	System.out.println(roles);
	model.addAttribute("ac",account);
	return "security/test";
}
}
