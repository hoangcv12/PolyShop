package poly.sof306.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import poly.sof306.entity.Account;
import poly.sof306.entity.Authorities;

public interface AuthoritiesDao extends JpaRepository< Authorities, Integer>{
	@Query("SELECT DISTINCT a FROM Authorities a Where a.Account IN ?1" )
	List<Authorities> authorritiesOf(List<Account> accounts);
}
