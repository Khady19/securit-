package sn.isi.dao;


import java.util.ArrayList;
import java.util.List;

import sn.isi.dto.DroitsDto;
import sn.isi.entities.Comptes;
import sn.isi.entities.Droits;

public class DroitsImpl extends RepositoryImpl<Droits> implements IDroits{

	public Droits getByName(String name) {
		return (Droits) session.createQuery("FROM Droits droits WHERE droits.name = :droits_name")
				.setParameter("droits_name", name).uniqueResult();
	}
	
	 public Droits DroitsDtoToDroitsEntity (DroitsDto droitsDto) {
	        Droits droits = new Droits();
	        droits.setId(droitsDto.getId());
	        droits.setName(droitsDto.getName());
	        if (droitsDto.getComptes() != null) {
	            List<Comptes> comptes = new ArrayList<Comptes>();
	            droitsDto.getComptes().forEach(username->{
	                Comptes compte = new ComptesImpl().getByUsername(username);
	                comptes.add(compte);
	            });
	            droits.setComptes(comptes);
	        }
	        return droits;
	    }
	 public DroitsDto DroitsEntityToDroitsDto (Droits droits) {
		 DroitsDto droitsDto = new DroitsDto();
		 droitsDto.setId(droits.getId());
	        droitsDto.setName(droits.getName());
	        if (droits.getComptes() != null) {
	            List<String> usernameComptes = new ArrayList<String>();
	            droits.getComptes().forEach(comptes->{
	            	usernameComptes.add(comptes.getUsername());
	            });
	            droitsDto.setComptes(usernameComptes);
	        }
	        return droitsDto;
	    }
}
