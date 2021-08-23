package poly.sof306.service;

import java.util.List;


import poly.sof306.entity.Account;

public interface AccountService {

	Account findById(String username);

	List<Account> getAdministrators();

	List<Account> findAll();

}
