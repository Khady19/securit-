package sn.isi.dao;

import sn.isi.entities.Droits;

public interface IDroits extends Repository<Droits> {
	
	public Droits getByName(String name);

}
