package sn.isi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "comptes")
public class Comptes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(length = 100, nullable = false, unique = true)
	private String username;
    @Column(length = 150, nullable = false)
	private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Droits> droits = new ArrayList<Droits>();
	
	
	public Comptes() {
		super();
	}
	public Comptes(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Droits> getDroits() {
		return droits;
	}
	public void setDroits(List<Droits> droits) {
		this.droits = droits;
	}
	
	
}
