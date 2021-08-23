package poly.sof306.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.sof306.entity.Account;

public interface AccountDao extends JpaRepository<Account, String > {
	@Query("SELECT DISTINCT ar.Account FROM Authorities ar WHERE ar.Roles.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();

}
