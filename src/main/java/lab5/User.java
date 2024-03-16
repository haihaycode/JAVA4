package lab5;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "ID")
	private String ID;
	@Column(name = "Fullname")
	private String fullname;
	@Column(name = "Email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "Admin")
	private boolean admin = false;

	public User() {

	}

	public User(String iD, String fullname, String email, String password, boolean admin) {
		super();
		ID = iD;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
