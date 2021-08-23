package poly.sof306.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.sof306.dao.RolesDao;

@CrossOrigin("*")
@RestController
@RequestMapping("roles")
public class Roles {
@Autowired
RolesDao roles;

@GetMapping()
public List<poly.sof306.entity.Roles> getAll(){
	return roles.findAll();
}
}
