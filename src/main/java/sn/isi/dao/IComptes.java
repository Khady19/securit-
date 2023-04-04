package sn.isi.dao;

import sn.isi.entities.Comptes;

public interface IComptes extends Repository<Comptes> {
	public Comptes login(String username, String password);
	
	public Comptes getByUsername(String username);


}
