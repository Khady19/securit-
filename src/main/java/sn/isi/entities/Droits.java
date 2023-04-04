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
@Table(name = "droits")
public class Droits {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100, nullable = false, unique = true)
	private String name;
    @ManyToMany(mappedBy = "droits", fetch = FetchType.EAGER)
    private List<Comptes> Comptes= new ArrayList<Comptes>();

	public Droits() {
		super();
	}
	public Droits(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Comptes> getComptes() {
		return Comptes;
	}
	public void setComptes(List<Comptes> comptes) {
		Comptes = comptes;
	}
	
	
	

}
