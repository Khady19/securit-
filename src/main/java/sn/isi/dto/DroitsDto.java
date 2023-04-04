package sn.isi.dto;

import java.util.ArrayList;
import java.util.List;

public class DroitsDto {
	private int id;
	private String name;
	private List<String> Comptes = new ArrayList<String>();
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
	public List<String> getComptes() {
		return Comptes;
	}
	public void setComptes(List<String> comptes) {
		Comptes = comptes;
	}
	
	

}
