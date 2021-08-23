package poly.sof306.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.sof306.dao.AccountDao;
import poly.sof306.entity.Account;
import poly.sof306.service.AccountService;

@Service
public class AccountServiceimpl implements AccountService{
@Autowired
AccountDao accDao;

@Override
public Account findById(String username) {
	
	return accDao.findById(username).get();
}

@Override
public List<Account> getAdministrators() {
	return accDao.getAdministrators();
}

@Override
public List<Account> findAll() {
	return accDao.findAll();
}

}
