package poly.sof306.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.sof306.dao.AccountDao;
import poly.sof306.dao.AuthoritiesDao;
import poly.sof306.entity.Account;
import poly.sof306.entity.Authorities;
import poly.sof306.service.AuthService;

@Service
public class AuthImpl implements AuthService {
	@Autowired
	AuthoritiesDao authdao;

	@Autowired
	AccountDao accdao;

	@Override
	public List<Authorities> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accdao.getAdministrators();
		return authdao.authorritiesOf(accounts);
	}

	@Override
	public List<Authorities> findAll() {
		return authdao.findAll();
	}

}
