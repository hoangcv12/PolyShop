package poly.sof306.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Accounts")
public class Account implements Serializable{
	@Id
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String photo;
	@JsonIgnore
	@OneToMany(mappedBy = "Account", fetch = FetchType.EAGER)
	List<Authorities> auth;
	
	
	
}
