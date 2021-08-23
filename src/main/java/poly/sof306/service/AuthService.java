package poly.sof306.service;

import java.util.List;

import poly.sof306.entity.Account;
import poly.sof306.entity.Authorities;

public interface AuthService {

	List<Authorities> findAuthoritiesOfAdministrators();

	List<Authorities> findAll();

	

}
